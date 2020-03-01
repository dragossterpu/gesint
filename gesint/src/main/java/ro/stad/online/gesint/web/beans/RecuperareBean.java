package ro.stad.online.gesint.web.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.exceptions.EMailException;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.util.EMail;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.Utilitati;

/**
 * Gestioneaza restaurarea accesului la sistem de către un utilizator care nu-și amintește aliasul sau parola.
 *
 * @author STAD
 */
@Setter
@Getter
@Controller("recoverBean")
@Scope("request")
@Slf4j
public class RecuperareBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * Service de utilizator.
         */
        @Autowired
        private transient UtilizatorService utilizatorService;

        /**
         * Serviciul de înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateService regActividadService;

        /**
         * Trimiterea de e-mailuri.
         */
        @Autowired
        private transient EMail eMail;

        /**
         * Encryptor pentru parola
         */
        @Autowired
        private transient PasswordEncoder passwordEncoder;

        /**
         * Metodă care caută un utilizator pe baza adresei de e-mail sau a CNP-ului și, dacă este găsit, generați o nouă
         * parolă și o trimite cu numele de utilizator la e-mailul asociat contului.
         * @param email
         * @param cnp cod numeric personal
         * @return pagina recover
         */
        public String parolaUitata(final String email, final String cnp) {
                String retur = Constante.SPATIU;
                if (Constante.SPATIU.equals(cnp) && Constante.SPATIU.equals(email)) {
                        final String descriere = "Trebuie să furnizați e-mailul sau CNP-ul pentru a vă putea identifica";
                        FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), descriere, null);
                        log.error(descriere);
                }
                else {
                        // Recuperăm o listă de utilizatori deoarece pot exista mai mulți cu același e-mail în acest caz
                        // utilizatori temporali
                        final List<Utilizator> listaUser = this.utilizatorService
                                        .findByEmailIgnoreCaseOrDocIdentitateIgnoreCase(email, cnp);
                        if (listaUser != null && !listaUser.isEmpty()) {
                                try {
                                        final String password = Utilitati.getPassword();
                                        final String passCod = this.passwordEncoder.encode(password);
                                        final Map<String, String> paramSablon = new HashMap<>();
                                        paramSablon.put("password", password);
                                        if (listaUser.size() > NumarMagic.NUMBERONE) {
                                                paramSablon.put(Constante.LOGIN, listaUser.get(0).getEmail());
                                        }
                                        else {
                                                paramSablon.put(Constante.LOGIN, listaUser.get(0).getUsername());
                                        }
                                        listaUser.forEach((final Utilizator user) -> user.setPassword(passCod));
                                        this.utilizatorService.save(listaUser);
                                        this.eMail.trimitereEmail(listaUser.get(0).getEmail(),
                                                        "Acces restabilit in aplicația GESINT",
                                                        Constante.TEMPLATECORREORESTABLECERPAS, paramSablon);
                                        final String descriere = "Accesul dvs. la sistem a fost restaurat, noile dvs. credențiale v-au fost trimise prin e-mail";
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                                        RegistruEnum.ACTIVARE.getDescriere(), descriere);
                                        log.info(descriere);

                                }
                                catch (DataAccessException | EMailException e) {
                                        final String descriere = "A apărut o eroare la regenerarea sau la trimiterea parolei";
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        RegistruEnum.EROARE.getDescriere(), descriere);
                                        this.regActividadService.salveazaRegistruEroare(descriere,
                                                        SectiuniEnum.LOGIN.getDescriere(), e);
                                        log.error(descriere);
                                }

                                retur = "/acces/recuperarPassword";
                        }
                        else {
                                final String descriere = "Utilizatorul nu există în sistem. Contactați administratorul";
                                FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
                                                RegistruEnum.EROARE.getDescriere(), descriere, null);
                                log.error(descriere);
                        }

                }
                return retur;
        }

}
