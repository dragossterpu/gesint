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
import ro.stad.online.gesint.persistence.entities.PartidRezultateJudete;
import ro.stad.online.gesint.services.RezultatService;

/**
 * Model pentru paginarea de pe server care extinde modelul LazyDataModel de Primefaces.
 * @author STAD
 */

@Setter
@Getter
public class LazyDataRezultate extends LazyDataModel<PartidRezultateJudete> implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Obiect care conține parametrii de căutare.
         */
        private transient FiltruRezultat filtruRezultat;

        /**
         * Lista care servește modelului ca sursă de date
         */
        private transient List<PartidRezultateJudete> datasource;

        /**
         * Serviciu de utilizat.
         */
        private transient RezultatService rezultatService;

        /**
         * Constructor de model care primește serviciul ca parametru.
         * @param rezultatService RezultatService Serviciu de utilizat
         */
        public LazyDataRezultate(final RezultatService rezultatService) {
                this.rezultatService = rezultatService;
        }

        /**
         * Suprascrierea metodei getRowData pentru a functiona cu obiecte de tip PartidRezultateJudete.
         * @param rowKey String Cheia rândului pe care s-a făcut clic in pagina
         * @return rezultate PartidRezultateJudete care corespunde cheii primite prin parametru
         *
         */
        @Override
        public PartidRezultateJudete getRowData(final String rowKey) {
                PartidRezultateJudete rezultate = new PartidRezultateJudete();
                for (final PartidRezultateJudete rezultat : datasource) {
                        if (rezultat.getId().toString().equals(rowKey)) {
                                rezultate = rezultat;
                        }
                }
                return rezultate;
        }

        /**
         * Suprascriea metoda getRowKey.
         * @param rezultat PartidRezultateJudete Obiect de la care se doreste obținerea cheia
         * @return Object Cheia obiectului trecut ca parametru
         */
        @Override
        public Object getRowKey(final PartidRezultateJudete rezultat) {
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
        public List<PartidRezultateJudete> load(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder, final Map<String, Object> filters) {
                List<PartidRezultateJudete> lista = new ArrayList<>();
                if (filtruRezultat == null) {
                        this.setRowCount(0);
                }
                else {
                        this.setRowCount(rezultatService.getCounCriteria(filtruRezultat));
                        lista = rezultatService.cautareRezultatCriteria(first, pageSize, sortField, sortOrder,
                                        filtruRezultat);
                        this.datasource = lista;
                }
                return lista;

        }

}
