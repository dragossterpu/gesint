package ro.stad.online.gesint.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.Visibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.lazydata.LazyDataRegistre;
import ro.stad.online.gesint.model.filters.FiltruRegistru;
import ro.stad.online.gesint.persistence.entities.RegistruActivitate;
import ro.stad.online.gesint.services.RegistruActivitateService;

/**
 * Controller pentru managementul registrului de activitate
 *
 * @author STAD
 *
 */

@Setter
@Getter
@Controller("registruBean")
@Scope(Constante.SESSION)
public class RegistruActivitateBean implements Serializable {

        /**
        	 *
        	 */
        private static final long serialVersionUID = 1L;

        /**
         * Numărul de coloane din pagină.
         */
        private static final Integer NUMCOLSREGISTRU = NumarMagic.NUMBERFIFTEEN;

        /**
         * Lista booleanilor pentru a controla afișarea coloanelor din pagină.
         */
        private List<Boolean> list;

        /**
         * Obiect care se utilizeaza pentru afișarea înregistrărilor.
         */
        private RegistruActivitate registruActivitate;

        /**
         * Obiect cu parametri de căutare.
         */
        private FiltruRegistru filtruRegistru;

        /**
         * LazyModel pentru afișarea paginată a datelor din pagină.
         */
        private LazyDataRegistre model;

        /**
         * Service registru de activitate.
         */
        @Autowired
        private transient RegistruActivitateService regActividadService;

        /**
         * Metodă care returnează o listă de nume de utilizator care conțin șirul de text care este primit ca parametru.
         * @param infoUser Utilizator pentru care se face consultarea
         * @return Lista de resulte
         *
         */
        public List<String> autocompletareUtilizator(final String infoUser) {
                return this.regActividadService.cautareUtilizatorDupaRegistru(
                                Constante.PORCENTAJ.concat(infoUser).concat(Constante.PORCENTAJ));
        }

        /**
         * Metodă care caută în registrul de activități conform criteriilor alese de utilizator în pagina și încărca
         * rezultatele într-o listă pentru vizualizare.
         */
        public void cautareRegActivitate() {
                this.model.setFiltruRegistru(this.filtruRegistru);
                this.model.load(0, NumarMagic.NUMBERFIFTEEN, Constante.DATAINREGISTRARII, SortOrder.DESCENDING, null);

        }

        /**
         * @PostConstruct Metodă folosită pentru a inițializa RegistruActivitateBean.
         *
         */
        @PostConstruct
        public void init() {
                this.list = new ArrayList<>();
                for (int i = 0; i < NUMCOLSREGISTRU; i++) {
                        this.list.add(Boolean.TRUE);
                }
                this.filtruRegistru = new FiltruRegistru();
                this.model = new LazyDataRegistre(this.regActividadService);
                this.registruActivitate = new RegistruActivitate();
        }

        /**
         * Metodă care curăță parametrii de căutare și rezultatul.
         */
        public void curatareCautare() {
                this.filtruRegistru = new FiltruRegistru();
                this.model = new LazyDataRegistre(this.regActividadService);
                this.model.setDatasource(new ArrayList<>());
        }

        /**
         * Metodă care controlează coloanele vizibile din lista de rezultate ale cautatorului.
         * @param toggle ToggleEvent
         */
        public void onToggle(final ToggleEvent toggle) {
                this.list.set((Integer) toggle.getData(), toggle.getVisibility() == Visibility.VISIBLE);
        }

        /**
         * Metoda care deschide dialogul pentru a vedea detaliul registrului de activitate.
         * @param regAct RegistruActivitate
         */
        public void getFormDetaliuRegistru(RegistruActivitate regAct) {
                final RequestContext context = RequestContext.getCurrentInstance();
                this.registruActivitate = regAct;
                context.execute("PF('dialogDetaliuRegistru').show();");

        }
}
