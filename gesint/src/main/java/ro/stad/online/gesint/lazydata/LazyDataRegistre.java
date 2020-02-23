package ro.stad.online.gesint.lazydata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.model.filters.FiltruRegistru;
import ro.stad.online.gesint.persistence.entities.RegistruActivitate;
import ro.stad.online.gesint.services.RegistruActivitateService;

/**
 * 
 * Model pentru paginarea de pe server care extinde modelul LazyDataModel de Primefaces.
 * @author STAD
 *
 */

@Setter
@Getter
public class LazyDataRegistre extends LazyDataModel<RegistruActivitate> implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * Obiect care conține parametrii de căutare.
         */
        private transient FiltruRegistru filtruRegistru;

        /**
         * Lista care servește modelului ca sursă de date.
         */
        private transient List<RegistruActivitate> datasource;

        /**
         * Serviciu de utilizat.
         */
        private transient RegistruActivitateService registruActivitateService;

        /**
         * Constructor de model care primește serviciul ca parametru.
         * @param serviciu RegistruActivitateService Serviciu de utilizat
         */
        public LazyDataRegistre(final RegistruActivitateService serviciu) {
                this.registruActivitateService = serviciu;
        }

        /**
         * Suprascrierea metodei getRowData pentru a functiona cu obiecte de tip registru de activitate.
         * @param rowKey String Cheia rândului pe care s-a făcut clic in pagina
         * @return reg RegistruActivitate care corespunde cheii primite prin parametru
         *
         */
        @Override
        public RegistruActivitate getRowData(final String rowKey) {
                RegistruActivitate reg = new RegistruActivitate();
                for (final RegistruActivitate registru : datasource) {
                        if (registru.getIdRegActividad().toString().equals(rowKey)) {
                                reg = registru;
                        }
                }
                return reg;
        }

        /**
         * Suprascriea metoda getRowKey.
         * @param registruActivitate RegistruActivitate Obiect de la care se doreste obținerea cheia
         * @return Object Cheia obiectului trecut ca parametru
         */
        @Override
        public Object getRowKey(final RegistruActivitate registruActivitate) {
                return registruActivitate.getIdRegActividad();
        }

        /**
         * Suprascrierea metodei de încărcare pentru a lucra cu un criteriu și a returna strict numărul de jurnale de
         * activitate solicitate.
         * @param first primul element de recuperat
         * @param pageSize numărul maxim de registre pe care dorim in pagină
         * @param sortField coloana prin care vor fi sortate rezultatele. Corespunde proprietății „sortBy” a coloanei
         * din pagina
         * @param sortOrder ordinea prin care se doreste sortarea rezultatelor
         * @param filters mapa filtrului. Această valoare nu este utilizată în această suprascriere.
         * @return lista registrelor care corespund criteriilor de căutare
         *
         */
        @Override
        public List<RegistruActivitate> load(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder, final Map<String, Object> filters) {
                List<RegistruActivitate> listaJurnale = new ArrayList<>();
                if (filtruRegistru == null) {
                        this.setRowCount(0);
                }
                else {
                        this.setRowCount(registruActivitateService.getCounCriteria(filtruRegistru));
                        listaJurnale = registruActivitateService.cautareRegistruActivitateCriteria(first, pageSize,
                                        sortField, sortOrder, filtruRegistru);
                        this.datasource = listaJurnale;
                }
                return listaJurnale;

        }
}
