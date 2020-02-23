package ro.stad.online.gesint.lazydata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.model.filters.FiltruSondaj;
import ro.stad.online.gesint.persistence.entities.Sondaj;
import ro.stad.online.gesint.services.SondajService;

/**
 * Model pentru paginarea de pe server care extinde modelul LazyDataModel de Primefaces.
 * @author STAD
 */

@Setter
@Getter
public class LazyDataSondaje extends LazyDataModel<Sondaj> implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Obiect care conține parametrii de căutare.
         */
        private transient FiltruSondaj cautare;

        /**
         * Lista care servește modelului ca sursă de date.
         */
        private transient List<Sondaj> datasource;

        /**
         * Serviciu de utilizat.
         */
        private transient SondajService sondajService;

        /**
         * Constructor de model care primește serviciul ca parametru.
         * @param serviciu SondajService Serviciu de utilizat
         */
        public LazyDataSondaje(final SondajService serviciu) {
                this.sondajService = serviciu;
        }

        /**
         * Suprascrierea metodei getRowData pentru a functiona cu obiecte de tip Sondaj.
         * @param rowKey String Cheia rândului pe care s-a făcut clic in pagina
         * @return sondaj Sondaj care corespunde cheii primite prin parametru
         *
         */
        @Override
        public Sondaj getRowData(final String rowKey) {
                Sondaj sonda = new Sondaj();
                for (final Sondaj sondaj : datasource) {
                        if (sondaj.getId().toString().equals(rowKey)) {
                                sonda = sondaj;
                        }
                }
                return sonda;
        }

        /**
         * Suprascriea metoda getRowKey.
         * @param sonda Sondaj Obiect de la care se doreste obținerea cheia
         * @return Object Cheia obiectului trecut ca parametru
         */
        @Override
        public Object getRowKey(final Sondaj sonda) {
                return sonda.getId();
        }

        /**
         * Suprascrierea metodei de încărcare pentru a lucra cu un criteriu și a returna strict numărul de sondaje
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
        public List<Sondaj> load(final int first, final int pageSize, final String sortField, final SortOrder sortOrder,
                        final Map<String, Object> filters) {
                List<Sondaj> lista = new ArrayList<>();
                if (cautare == null) {
                        this.setRowCount(0);
                }
                else {
                        this.setRowCount(sondajService.getCounCriteria(cautare));
                        lista = sondajService.cautareSondajeCriteria(first, pageSize, sortField, sortOrder, cautare);
                        this.datasource = lista;
                }
                return lista;

        }

}
