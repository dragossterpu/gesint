package ro.stad.online.gesint.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.persistence.entities.Partid;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.services.PartidService;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.services.impl.RegistruActivitateServiceImpl;
import ro.stad.online.gesint.util.FacesUtilities;

/**
 * Controlorul operațiunilor legate de gestionarea partidelor.
 *
 * @author STAD
 */
@Setter
@Getter
@Controller("partidBean")
@Scope(Constante.SESSION)
public class PartidBean implements Serializable {

        /**
         * Serial ID.
         */
        private static final long serialVersionUID = NumarMagic.NUMBERONELONG;

        /**
         * Partid.
         */
        private transient Partid partid;

        /**
         * Variala utilizata pentru injectarea serviciului de partid.
         */
        @Autowired
        private transient PartidService partidService;

        /**
         * Serviciul de înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateService regActividadService;

        /**
         * Serviciu de utilizatori.
         */
        @Autowired
        private UtilizatorService utilizatorService;

        /**
         * Listă de Partide.
         */
        private List<Partid> listaPartide;

        /**
         * r Utilizator user
         */

        private Utilizator user;

        /**
         * Variala utilizata pentru injectarea serviciului înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateServiceImpl registruActivitateService;

        /**
         * Metodă folosită pentru a crea un nou partid.
         * @param numePartid String numele partidului
         * @param sigla String sigla partidului
         */

        public void inregistrarePartid(final String numePartid, final String sigla) {
                try {
                        partid = new Partid();
                        partid.setName(numePartid);
                        partid.setSigla(sigla);
                        partidService.save(partid);
                        listaPartide.add(partid);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO, Constante.INREGISTRARE,
                                        "Noul partid a fost înregistrat cu succes");
                        final String descriere = "Noul partid a fost înregistrat cu succes";
                        this.regActividadService.inregistrareRegistruActivitate(descriere, Constante.INREGISTRARE,
                                        SectiuniEnum.PARTID.getDescriere(), user);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        "A apărut o eroare la înregistrarea partidului. "
                                                        .concat(Constante.DESCEROAREMESAJ));
                        final String descriere = "A apărut o eroare la înregistrarea partidului";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.PARTID.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă folosită pentru a eliminarea unui partidului.
         * @param partid care se elimina
         */
        public void eliminaPartid(final Partid partid) {
                try {
                        partidService.delete(partid);
                        listaPartide.remove(partid);
                        FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO, Constante.ELIMINAREMESAJ,
                                        partid.getName(), Constante.OKELIMINAREMESAJ);
                        final String descriere = "Partidul a fost eliminat cu succes";
                        this.regActividadService.inregistrareRegistruActivitate(descriere, Constante.ELIMINARE,
                                        SectiuniEnum.PARTID.getDescriere(), user);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la eliminarea partidului";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.PARTID.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă folosită pentru a inițializa PartidBean.
         * @PostConstruct
         */
        @PostConstruct
        public void init() {
                listaPartide = partidService.fiindAll();
                obtinemUtilizatorSesiune();
        }

        /**
         * Metodă folosită pentru a obtine utilizatorul din sesiune
         */
        private void obtinemUtilizatorSesiune() {
                try {
                        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
                        user = utilizatorService.fiindOne(username);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la obținerea utilizatorului";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.PARTID.getDescriere(),
                                        e);
                }
        }

        /**
         * Metodă folosită pentru modificarea unei functii
         * @param event RowEditEvent event care se recupereaza din pagina
         */
        public void onRowEdit(final RowEditEvent event) {
                final Partid partid = (Partid) event.getObject();
                try {
                        partidService.save(partid);
                        FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO, Constante.MODIFICAREMESAJ,
                                        partid.getName(), null);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR, Constante.EROAREMESAJ,
                                        Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la modificarea partidului";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.PARTID.getDescriere(),
                                        e);
                }

        }

}
