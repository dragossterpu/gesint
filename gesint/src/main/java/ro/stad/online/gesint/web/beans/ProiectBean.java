package ro.stad.online.gesint.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.Visibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.lazydata.LazyDataProiecte;
import ro.stad.online.gesint.model.filters.FiltruProiect;
import ro.stad.online.gesint.persistence.entities.Proiect;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.services.ProiectService;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.Utilitati;

/**
 * Clase utilizada pentru a incarca proiectele.
 *
 * @author STAD
 *
 */
@Component("proiectBean")
@Setter
@Getter
@NoArgsConstructor
@Scope(Constante.SESSION)
@Slf4j
public class ProiectBean implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * Lista de elemente vizibile.
         */
        private List<Boolean> list;

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
         * Variala utilizata pentru injectarea serviciului de proiecte.
         *
         */
        @Autowired
        private transient ProiectService proiectService;

        /**
         * Serviciul de înregistrare a activității.
         */
        @Autowired
        private transient RegistruActivitateService regActividadService;

        /**
         * Lazy model pentru a pagina in server proiectele
         */
        private transient LazyDataProiecte modelProiect;

        /**
         * Variabila pentru proiecte.
         */
        private transient Proiect proiect;

        /**
         * Clasa de căutare a proiectului.
         */
        private FiltruProiect filtruProiect;

        /**
         * Lista proiecte.
         */
        private List<Proiect> listaProiecte;

        /**
         * Lista pozitiilor proiectelor.
         */
        private List<Proiect> listaPozitie;

        /**
         * Fotografia.
         */
        private byte[] imagineSelectata;

        /**
         * Componente de utilidades.
         */
        @Autowired
        private transient Utilitati utilitati;

        /**
         * Metodă folosită pentru a deschide dialogul pentru pozitionarea membrilor.
         */
        public void deschideDialogOrdoneazaProiecte() {
                try {
                        this.listaProiecte = this.proiectService.findAll();
                        final RequestContext context = RequestContext.getCurrentInstance();
                        context.execute("PF('dlgOrdena').show();");
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la căutarea proiectelor";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.PROIECT.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * Metodă folosită pentru a căuta proiecte pe baza unui filtru.
         */
        @Transactional
        public void cautareProiecte() {
                this.modelProiect.setFiltruProiect(this.filtruProiect);
                this.modelProiect.load(0, NumarMagic.NUMBERFIFTEEN, Constante.DATECREATE, SortOrder.DESCENDING, null);
        }

        /**
         * Metodă folosită pentru a elimina un proiect.
         * @param proiect Proiect proiect candidat pentru eliminare
         */
        public void eliminareProiect(final Proiect proiect) {
                try {
                        this.proiectService.delete(proiect);
                        this.listaProiecte.remove(proiect);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                        RegistruEnum.ELIMINARE.getDescriere(), Constante.OKELIMINAREMESAJ);
                        final String descriere = "Proiectul a fost eliminat cu succes";
                        this.regActividadService.inregistrareRegistruActivitate(descriere,
                                        RegistruEnum.ELIMINARE.getName(), SectiuniEnum.PROIECT.getName(), user);
                        log.info(descriere);
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la eliminarea proiectului";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.PROIECT.getDescriere(),
                                        e);
                        log.error(descriere);
                }

        }

        /**
         * Metodă folosită pentru a prezenta datele proiectului pe care dorim să le modificăm.
         * @return URL-ul paginii de modificare a proiectului
         */
        public String getFormModificarProiect(final Proiect pr) {
                this.proiect = pr;
                this.imagineSelectata = null;
                return "/proiecte/modifyProiect?faces-redirect=true";
        }

        /**
         * Metodă folosită pentru a inițializa ProiectBean.
         * @PostConstruct
         */
        @PostConstruct
        public void init() {
                this.filtruProiect = new FiltruProiect();
                this.proiect = new Proiect();
                this.listaProiecte = new ArrayList<>();
                this.list = new ArrayList<>();
                for (int i = 0; i < NumarMagic.NUMBERFIVE; i++) {
                        this.list.add(Boolean.TRUE);
                }
                cautareCautare();
                Utilitati.cautareSesiune("proiectBean");
                this.user = utilitati.getUtilizatorLogat();
        }

        /**
         * Metodă folosită pentru a curăța filtrul de căutare al proiectelor
         */
        public void cautareCautare() {
                this.filtruProiect = new FiltruProiect();
                this.modelProiect = new LazyDataProiecte(proiectService);
                this.modelProiect.setRowCount(0);
        }

        /**
         * Metodă folosită pentru a modifica un proiect.
         * @param proie Proiect
         */
        public void modificaProiect(final Proiect proie) {
                this.proiect = new Proiect();
                try {
                        this.proiect = proie;
                        this.proiectService.save(this.proiect);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                        RegistruEnum.MODIFICARE.getDescriere(), Constante.OKMODIFICAREMESAJ);
                        final RequestContext context = RequestContext.getCurrentInstance();
                        log.info("S-a modificat corect proiectul");
                        context.execute("PF('dlgModifica').hide();");

                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la modificarea proiectului";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.PROIECT.getDescriere(),
                                        e);
                        log.error(descriere);
                }

        }

        /**
         * Metodă folosită pentru a reordeneaza proiectul
         */
        public void onReorder() {
                try {
                        reordeneazaProiecte();
                        final String descriere = "S-a ordonat corect proiectul";
                        final FacesContext facesContext = FacesContext.getCurrentInstance();
                        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, descriere, null));
                        log.info(descriere);
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare la reordonarea proiectului";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.PROIECT.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * Metodă folosită pentru a modifica descrierea unui proiect.
         * @param event eveniment care capturează proiectul de editat
         */
        public void onRowEdit(final RowEditEvent event) {
                try {
                        final Proiect proi = (Proiect) event.getObject();
                        this.proiectService.save(proi);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                        RegistruEnum.MODIFICARE.getDescriere(), proi.getTitlu());
                        log.info("S-a realizat corect modificarea proiectului");
                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare  în încercarea de a modifica proiectul.";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.PROIECT.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * Metodă folosită pentru selectarea unui proiect.
         * @param event SelectEvent
         */
        public void onSelect(final SelectEvent event) {
                this.proiect = (Proiect) event.getObject();
        }

        /**
         * Metodă folosită pentru a controla coloanele vizibile în lista rezultatelor motorului de căutare.
         * @param eve ToggleEvent
         */
        public void onToggle(final ToggleEvent eve) {
                this.list.set((Integer) eve.getData(), eve.getVisibility() == Visibility.VISIBLE);
        }

        /**
         * Metodă folosită pentru a inregistra un nou proiect.
         * @return String
         */
        public String proiectNou() {
                this.proiect = new Proiect();
                return "/proiecte/inregistrareProiect?faces-redirect=true";
        }

        /**
         * Metodă folosită pentru a reordona pozitia
         */
        private void reordeneazaProiecte() {
                try {
                        Proiect proi;
                        for (int i = 0; i < this.listaProiecte.size(); i++) {
                                proi = this.listaProiecte.get(i);
                                proi.setRank(i + NumarMagic.NUMBERONELONG);
                                this.proiectService.save(proi);
                                final RequestContext context = RequestContext.getCurrentInstance();
                                log.info("S-a ordonat corect proiectul");
                                context.execute("PF('dlgOrdena').hide();");
                        }

                }
                catch (final DataAccessException e) {
                        final String descriere = "A apărut o eroare  în încercarea de a reordona proiectul.";
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(),
                                        descriere.concat(Constante.DESCEROAREMESAJ));
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.PROIECT.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

        /**
         * Metodă folosită pentru a înregistra un proiect.
         * @param proi Proiect
         */
        public void inregistrareProiect(final Proiect proi) {
                try {
                        this.proiect = proi;
                        // Cautam cea mai mare pozitie din lista
                        this.listaPozitie = this.proiectService.findAllByOrderByRankDesc();
                        // Adaugam inca una
                        if (this.listaPozitie.isEmpty()) {
                                this.proiect.setRank(NumarMagic.NUMBERONELONG);
                        }
                        else {
                                final Long rank = this.listaPozitie.get(0).getRank() + NumarMagic.NUMBERONE;
                                this.proiect.setRank(rank);
                        }
                        // Salvam proiectul
                        this.proiectService.save(this.proiect);
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_INFO,
                                        RegistruEnum.INREGISTRARE.getDescriere(), Constante.OKINREGISTRAREMESAJ);
                        final String descriere = "Partidul a fost înregistrat cu succes";
                        this.regActividadService.inregistrareRegistruActivitate(descriere,
                                        RegistruEnum.INREGISTRARE.getName(), SectiuniEnum.PROIECT.getDescriere(), user);
                        log.info(descriere);
                }
                catch (final DataAccessException e) {
                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        final String descriere = "A apărut o eroare în încercarea de a înregistra un proiect.";
                        this.regActividadService.salveazaRegistruEroare(descriere, SectiuniEnum.PROIECT.getDescriere(),
                                        e);
                        log.error(descriere);
                }
        }

}
