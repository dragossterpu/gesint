package ro.stad.online.gesint.lazydata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.model.filters.FiltruRezultat;
import ro.stad.online.gesint.persistence.entities.PartidRezultateLocalitate;
import ro.stad.online.gesint.services.RezultatService;

/**
 * Model pentru paginarea de pe server care extinde modelul LazyDataModel de Primefaces.
 * @author STAD
 */

@Setter
@Getter
public class LazyDataRezultateLoc extends LazyDataModel<PartidRezultateLocalitate> implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Obiect care conține parametrii de căutare.
         */
        private transient FiltruRezultat filtruRezultat;

        /**
         * Lista care servește modelului ca sursă de date.
         */
        private transient List<PartidRezultateLocalitate> datasource;

        /**
         * Serviciu de utilizat.
         */
        private transient RezultatService rezultatService;

        /**
         * Constructor de model care primește serviciul ca parametru.
         * @param rezultatService RezultatService Serviciu de utilizat
         */
        public LazyDataRezultateLoc(final RezultatService rezultatService) {
                this.rezultatService = rezultatService;
        }

        /**
         * Suprascrierea metodei getRowData pentru a functiona cu obiecte de tip PartidRezultateLocalitate.
         * @param rowKey String Cheia rândului pe care s-a făcut clic in pagina
         * @return rezultate PartidRezultateLocalitate care corespunde cheii primite prin parametru
         *
         */
        @Override
        public PartidRezultateLocalitate getRowData(final String rowKey) {
                PartidRezultateLocalitate rezultate = new PartidRezultateLocalitate();
                for (final PartidRezultateLocalitate rezultat : datasource) {
                        if (rezultat.getId().toString().equals(rowKey)) {
                                rezultate = rezultat;
                        }
                }
                return rezultate;
        }

        /**
         * Suprascriea metoda getRowKey.
         * @param rezultat PartidRezultateLocalitate Obiect de la care se doreste obținerea cheia
         * @return Object Cheia obiectului trecut ca parametru
         */
        @Override
        public Object getRowKey(final PartidRezultateLocalitate rezultat) {
                return rezultat.getId();
        }

        /**
         * Suprascrierea metodei de încărcare pentru a lucra cu un criteriu și a returna strict numărul de rezultate
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
        public List<PartidRezultateLocalitate> load(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder, final Map<String, Object> filters) {
                List<PartidRezultateLocalitate> lista = new ArrayList<>();
                if (filtruRezultat == null) {
                        this.setRowCount(0);
                }
                else {
                        this.setRowCount(rezultatService.getCounCriteria(filtruRezultat));
                        lista = rezultatService.cautareRezultatCriteriaLoc(first, pageSize, sortField, sortOrder,
                                        filtruRezultat);
                        this.datasource = lista;
                }
                return lista;

        }

}
