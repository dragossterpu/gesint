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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.lazydata.LazyDataFunctii;
import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.services.EchipaService;
import ro.stad.online.gesint.services.FunctieService;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.impl.RegistruActivitateServiceImpl;
import ro.stad.online.gesint.util.FacesUtilities;

/**
 * Controlorul operațiunilor legate de gestionarea functiilor.
 *
 * @author STAD
 */
@Setter
@Getter
@Controller("functieBean")
@Scope(Constante.SESSION)
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
         * Metoda care Inregistreaza o noua functie.
         * @param numeFunctie String numele functiei
         * @param descriereFunctie String descrierea functiei
         * @param organizatie String
         */

        public void inregistrareFunctie(final String numeFunctie, final String descriereFunctie,
                        final String organizatie) {
                try {
                        functie = new Functie();
                        SecurityContextHolder.getContext().getAuthentication().getName();
                        functie.setDescriere(descriereFunctie);
                        functie.setOrganizatie(organizatie);
                        functie.setNume(numeFunctie);
                        functieService.save(functie);
                        listaFunctii.add(functie);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.INREGISTRARE,
                                        "Noua funcție a fost înregistrată cu succes");
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroare la înregistrarea registrului. "
                                                        .concat(Constante.DESCEROAREMESAJ));
                        final String descriere = "A apărut o eroare la înregistrarea funcției";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.FUNCTIE.getDescriere(),
                                        e);
                }
        }

        /**
         * Eliminarea totala a functiei.
         * @param functia care se elimina
         */
        public void eliminaFunctia(final Functie func) {
                this.functie = func;
                try {
                        final int tieneUtilizatori = echipaService.existsByTeam(functie.getId());
                        if (tieneUtilizatori > 0) {
                                FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_ERROR,
                                                "Nu se poate elimina funcția '".concat(functie.getNume())
                                                                .concat("' deoarece sunt persoane care o dețin."),
                                                Constante.SPATIU, null);
                        }
                        else {
                                // eliminam functia din lista
                                listaFunctii.remove(functie);
                                // eliminam functia
                                functieService.delete(functie);
                                model.setDatasource(listaFunctii);

                                FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO,
                                                Constante.ELIMINAREMESAJ, functie.getDescriere(),
                                                Constante.OKELIMINAREMESAJ);
                        }
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
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
                listaFunctii = model.getDatasource();
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
                        functieService.save(functia);
                        FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO, Constante.MODIFICAREMESAJ,
                                        functia.getDescriere(), null);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la modificarea funcției";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.FUNCTIE.getDescriere(),
                                        e);
                }

        }

}
