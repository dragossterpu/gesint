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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.util.FacesUtilities;

/**
 * Controlator de operatii relationate cu profilul utilizatorului. Schimbare parola.
 *
 * @author STAD
 */
@Getter
@Setter
@Controller("miPerfilBean")
@Scope(Constante.SESSION)
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
        private UtilizatorService utilizatorService;

        /**
         * Serviciul de înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateService regActividadService;

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
                                                user.setPassword(passwordEncoder.encode(this.getParolaNoua()));
                                                utilizatorService.save(user);
                                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                                                "Parola a fost modificată cu succes", "dialogMessage");
                                        }
                                        else {
                                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                                "Noua parolă trebuie să aibă cel puțin un număr și o literă mare. Încercați din nou",
                                                                null);
                                        }
                                }
                                catch (final DataAccessException e) {
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        Constante.EROAREMESAJ, Constante.DESCEROAREMESAJ);
                                        final String descriere = "A apărut o eroare la modificarea parolei";
                                        this.regActividadService.salveazaRegistruEroare(descriere,
                                                        SectiuniEnum.USERS.getDescriere(), e);
                                }
                        }
                        else {
                                FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
                                                "Parola curentă introdusă nu este validă. Încercați din nou", "", null);
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
                try {
                        user = utilizatorService
                                        .fiindOne(SecurityContextHolder.getContext().getAuthentication().getName());
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                }
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
