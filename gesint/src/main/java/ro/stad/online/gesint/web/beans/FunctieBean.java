package ro.stad.online.gesint.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.lazydata.LazyDataFunctii;
import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.services.EchipaService;
import ro.stad.online.gesint.services.FunctieService;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.impl.RegistruActivitateServiceImpl;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.Utilitati;

/**
 * Controlorul operațiunilor legate de gestionarea functiilor.
 *
 * @author STAD
 */
@Setter
@Getter
@Controller("functieBean")
@Scope(Constante.SESSION)
@Slf4j
public class FunctieBean implements Serializable {

        /**
         * Serial ID.
         */
        private static final long serialVersionUID = NumarMagic.NUMBERONELONG;

        /**
         * Functie.
         */
        private transient Functie functie;

        /**
         * Variala utilizata pentru injectarea serviciului de functii.
         */
        @Autowired
        private transient FunctieService functieService;

        /**
         * Variala utilizata pentru injectarea serviciului de utilizatori.
         */
        @Autowired
        private transient EchipaService echipaService;

        /**
         * Serviciul de înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateService regActividadService;

        /**
         * Listă de functii.
         */
        private List<Functie> listaFunctii;

        /**
         * LazyModel pentru afișarea paginată a datelor din pagina.
         */
        private LazyDataFunctii model;

        /**
         * Variala utilizata pentru injectarea serviciului înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateServiceImpl registruActivitateService;

        /**
         * Componente de utilidades.
         */
        @Autowired
        private transient Utilitati utilitati;

        /**
         * Metoda care Inregistreaza o noua functie.
         * @param numeFunctie String numele functiei
         * @param descriereFunctie String descrierea functiei
         * @param organizatie String
         */

        public void inregistrareFunctie(final String numeFunctie, final String descriereFunctie,
                        final String organizatie) {
                Utilizator user = utilitati.getUtilizatorLogat();
                try {
                        this.functie = new Functie();
                        functie.setDescriere(descriereFunctie);
                        functie.setOrganizatie(organizatie);
                        functie.setNume(numeFunctie);
                        this.functieService.save(functie);
                        this.listaFunctii.add(functie);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                        RegistruEnum.INREGISTRARE.getDescriere(),
                                        "Noua funcție a fost înregistrată cu succes");
                        final String descriere = "Noua funcție a fost înregistrată cu succes";
                        this.regActividadService.inregistrareRegistruActivitate(descriere,
                                        RegistruEnum.INREGISTRARE.getName(), SectiuniEnum.FUNCTIE.getName(), user);
                        log.info(descriere);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        "A apărut o eroare la înregistrarea registrului. "
                                                        .concat(Constante.DESCEROAREMESAJ));
                        final String descriere = "A apărut o eroare la înregistrarea funcției";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.FUNCTIE.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * Eliminarea totala a functiei.
         * @param functia care se elimina
         */
        public void eliminaFunctia(final Functie func) {
                this.functie = func;
                Utilizator user = utilitati.getUtilizatorLogat();
                try {
                        final int tieneUtilizatori = this.echipaService.existsByTeam(this.functie.getId());
                        if (tieneUtilizatori > 0) {
                                FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
                                                "Nu se poate elimina funcția '".concat(this.functie.getNume())
                                                                .concat("' deoarece sunt persoane care o dețin."),
                                                Constante.SPATIU, null);
                        }
                        else {
                                // eliminam functia din lista
                                this.listaFunctii.remove(this.functie);
                                // eliminam functia
                                this.functieService.delete(this.functie);
                                this.model.setDatasource(this.listaFunctii);
                                FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO,
                                                RegistruEnum.ELIMINARE.getDescriere(), functie.getDescriere(),
                                                Constante.OKELIMINAREMESAJ);
                                final String descriere = Constante.UTILIZATORUL.concat(user.getNumeComplet())
                                                .concat(" a eliminat cu succes funcția ").concat(func.getNume());
                                this.regActividadService.inregistrareRegistruActivitate(descriere,
                                                RegistruEnum.ELIMINARE.getName(), SectiuniEnum.FUNCTIE.getName(), user);
                                log.info(descriere);
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la eliminarea funcției";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.FUNCTIE.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă folosită pentru a inițializa lista functilor care vor fi afișate pe pagină.
         * @PostConstruct
         */
        @PostConstruct
        public void init() {
                cautareFunctii();
                this.listaFunctii = this.model.getDatasource();
        }

        /**
         * Metodă folosită pentru căutarea functilor.
         *
         */

        public void cautareFunctii() {
                this.model = new LazyDataFunctii(this.functieService);
                this.model.load(0, NumarMagic.NUMBERTEN, Constante.ID, SortOrder.DESCENDING, null);
        }

        /**
         * Metodă folosită pentru modificarea unei functii
         * @param event RowEditEvent event care se recupereaza din pagină
         */
        public void onRowEdit(final RowEditEvent event) {
                final Functie functia = (Functie) event.getObject();
                try {
                        this.functieService.save(functia);
                        FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO,
                                        RegistruEnum.MODIFICARE.getDescriere(), functia.getDescriere(), null);
                        log.info("S-a modificat corect funcția");
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la modificarea funcției";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.FUNCTIE.getDescriere(),
                                        e);
                        log.error(descriere);
                }

        }

}
