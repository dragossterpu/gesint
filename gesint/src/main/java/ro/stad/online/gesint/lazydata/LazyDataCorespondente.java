package ro.stad.online.gesint.lazydata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.model.filters.FiltruCorespondenta;
import ro.stad.online.gesint.persistence.entities.Corespondenta;
import ro.stad.online.gesint.services.CorespondentaService;

/**
 * Model pentru paginarea de pe server care extinde modelul LazyDataModel de Primefaces.
 * @author STAD
 */

@Setter
@Getter
public class LazyDataCorespondente extends LazyDataModel<Corespondenta> implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Obiect care conține parametrii de căutare.
         */
        private transient FiltruCorespondenta filtruCorespondenta;

        /**
         * Lista care servește modelului ca sursă de date.
         */
        private transient List<Corespondenta> datasource;

        /**
         * Serviciu de utilizat.
         */
        private transient CorespondentaService corespondentaService;

        /**
         * Constructor de model care primește serviciul ca parametru.
         * @param serviciu CorespondentaService Serviciu de utilizat
         */
        public LazyDataCorespondente(final CorespondentaService serviciu) {
                this.corespondentaService = serviciu;
        }

        /**
         * Suprascrierea metodei getRowData pentru a functiona cu obiecte de tip Corespondenta.
         * @param rowKey String Cheia rândului pe care s-a făcut clic in pagina
         * @return coresponden Corespondenta care corespunde cheii primite prin parametru
         *
         */
        @Override
        public Corespondenta getRowData(final String rowKey) {
                Corespondenta coresponden = null;
                for (final Corespondenta corespondenta : datasource) {
                        if (corespondenta.getId().toString().equals(rowKey)) {
                                coresponden = corespondenta;
                        }
                }
                return coresponden;
        }

        /**
         * Suprascriea metoda getRowKey.
         * @param corespondenta Corespondenta Obiect de la care se doreste obținerea cheia
         * @return Object Cheia obiectului trecut ca parametru
         */
        @Override
        public Object getRowKey(final Corespondenta corespondenta) {
                return corespondenta.getId();
        }

        /**
         * Suprascrierea metodei de încărcare pentru a lucra cu un criteriu și a returna strict numărul de corespondente
         * solicitate.
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
        public List<Corespondenta> load(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder, final Map<String, Object> filters) {
                List<Corespondenta> lista = new ArrayList<>();
                if (filtruCorespondenta == null) {
                        this.setRowCount(0);
                }
                else {
                        this.setRowCount(corespondentaService.getCounCriteria(filtruCorespondenta));
                        lista = corespondentaService.cautareCorespondenteCriteria(first, pageSize, sortField, sortOrder,
                                        filtruCorespondenta);
                        this.datasource = lista;
                }
                return lista;

        }

}
