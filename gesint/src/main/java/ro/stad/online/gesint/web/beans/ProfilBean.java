package ro.stad.online.gesint.web.beans;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.Utilitati;

/**
 * Controlator de operatii relationate cu profilul utilizatorului. Schimbare parola.
 *
 * @author STAD
 */
@Getter
@Setter
@Controller("miPerfilBean")
@Scope(Constante.SESSION)
@Slf4j
public class ProfilBean implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Constanta patron parola.
         */
        private static final String PASSPATTERN = "^(?=.*?[A-Z])(?=.*?[0-9]).{2,}$";

        /**
         * Parola actuala.
         */
        private String parolaCurenta;

        /**
         * Parola noua.
         */
        private String parolaNoua;

        /**
         * Confirmarea parolei.
         */
        private String parolaConfirmata;

        /**
         * Utilizator.
         */
        private Utilizator user;

        /**
         * Serviciul de user.
         */
        @Autowired
        private transient UtilizatorService utilizatorService;

        /**
         * Serviciul de înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateService regActividadService;

        /**
         * Componente de utilidades.
         */
        @Autowired
        private transient Utilitati utilitati;

        /**
         * Metodă folosită pentru schimbarea parolei.
         */
        public void schimbareParola() {
                if (this.getParolaNoua().equals(this.getParolaConfirmata()) == Boolean.FALSE) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        "Parolele introduse nu se potrivesc", null);
                }
                else {
                        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                        if (passwordEncoder.matches(this.getParolaCurenta(), user.getPassword())) {
                                try {
                                        if (validaPass(this.parolaNoua)) {
                                                this.user.setPassword(passwordEncoder.encode(this.getParolaNoua()));
                                                utilizatorService.save(user);
                                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                                                "Parola a fost modificată cu succes", "dialogMessage");
                                                log.info("Parola a fost modificată cu succes");
                                        }
                                        else {
                                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                                "Noua parolă trebuie să aibă cel puțin un număr și o literă mare. Încercați din nou",
                                                                null);
                                        }
                                }
                                catch (final DataAccessException e) {
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                                        final String descriere = "A apărut o eroare la modificarea parolei";
                                        this.regActividadService.salveazaRegistruEroare(descriere,
                                                        SectiuniEnum.USERS.getDescriere(), e);
                                        log.error(descriere);
                                }
                        }
                        else {
                                FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
                                                "Parola curentă introdusă nu este validă. Încercați din nou",
                                                Constante.SPATIU, null);
                        }
                }

        }

        /**
         * Metodă folosită pentru a eliminarea utilizatorului.
         * @param usu Utilizator
         * @return pagina login
         */
        public String eliminareUser(final Utilizator usu) {
                return "/login?faces-redirect=true";
        }

        /**
         * Metodă folosită pentru a inițializa ProilBean.
         * @PostConstruct
         */
        @PostConstruct
        public void init() {
                this.user = utilitati.getUtilizatorLogat();
        }

        /**
         * Metodă folosită pentru a deschide dialogul pentru schimbarea parolei.
         */
        public void deschideDialogParola() {
                final RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dialogParola').show();");
        }

        /**
         * Metodă folosită pentru a arata daca parola indeplineste sau nu conditiile de validare.
         * @param password String pentru validare
         * @return boolean Valideaza?
         */
        private boolean validaPass(final String password) {
                final Pattern pattern = Pattern.compile(PASSPATTERN);
                final Matcher matcher = pattern.matcher(password);

                return matcher.matches();
        }
}
