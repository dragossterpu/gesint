package ro.stad.online.gesint.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.persistence.entities.Partid;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.services.PartidService;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.services.impl.RegistruActivitateServiceImpl;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.Utilitati;

/**
 * Controlorul operațiunilor legate de gestionarea partidelor.
 *
 * @author STAD
 */
@Setter
@Getter
@Controller("partidBean")
@Scope(Constante.SESSION)
@Slf4j
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
        private transient UtilizatorService utilizatorService;

        /**
         * Listă de Partide.
         */
        private List<Partid> listaPartide;

        /**
         * r Utilizator user
         */

        private Utilizator user;

        /**
         * Componente de utilidades.
         */
        @Autowired
        private transient Utilitati utilitati;

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
                        this.partid = new Partid();
                        partid.setName(numePartid);
                        partid.setSigla(sigla);
                        partidService.save(partid);
                        listaPartide.add(partid);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                        RegistruEnum.INREGISTRARE.getDescriere(),
                                        "Noul partid a fost înregistrat cu succes");
                        final String descriere = "Noul partid a fost înregistrat cu succes";
                        this.regActividadService.inregistrareRegistruActivitate(descriere,
                                        RegistruEnum.INREGISTRARE.getName(), SectiuniEnum.PARTID.getName(), user);
                        log.info(descriere);
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la înregistrarea partidului";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.PARTID.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * Metodă folosită pentru a eliminarea unui partidului.
         * @param partid care se elimina
         */
        public void eliminaPartid(final Partid part) {

                try {
                        this.partidService.delete(part);
                        this.listaPartide.remove(part);
                        FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO,
                                        RegistruEnum.ELIMINARE.getDescriere(), part.getName(),
                                        Constante.OKELIMINAREMESAJ);
                        final String descriere = "Partidul a fost eliminat cu succes";
                        this.regActividadService.inregistrareRegistruActivitate(descriere,
                                        RegistruEnum.ELIMINARE.getName(), SectiuniEnum.PARTID.getName(), user);
                        log.info(descriere);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la eliminarea partidului";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.PARTID.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * Metodă folosită pentru a inițializa PartidBean.
         * @PostConstruct
         */
        @PostConstruct
        public void init() {
                try {
                        this.listaPartide = partidService.fiindAll();
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la cautarea tuturor partidelor";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.PARTID.getDescriere(),
                                        e);
                        log.error(descriere);
                }
                this.user = utilitati.getUtilizatorLogat();

        }

        /**
         * Metodă folosită pentru modificarea unui partid
         * @param event RowEditEvent event care se recupereaza din pagina
         */
        public void onRowEdit(final RowEditEvent event) {
                final Partid part = (Partid) event.getObject();
                try {
                        this.partidService.save(part);
                        FacesUtilities.setMensajeInformativo(FacesMessage.SEVERITY_INFO,
                                        RegistruEnum.MODIFICARE.getDescriere(), part.getName(), null);
                        log.info("S-a modificat cu succes partidul");
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare la modificarea partidului";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.PARTID.getDescriere(),
                                        e);
                        log.error(descriere);
                }

        }

}
