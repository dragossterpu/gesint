package ro.stad.online.gesint.lazydata;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.model.filters.FiltruLocalitate;
import ro.stad.online.gesint.persistence.entities.Localitate;
import ro.stad.online.gesint.services.LocalitateService;

/**
 *
 * Model pentru paginarea de pe server care extinde modelul LazyDataModel al Primefaces.
 *
 * @author STAD
 *
 */

@Setter
@Getter
public class LazyDataLocalitati extends LazyDataModel<Localitate> implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * Obiect care conține parametrii de căutare.
         */
        private FiltruLocalitate filtruLocalitate;

        /**
         * Serviciu de utilizat.
         */
        @Autowired
        private transient LocalitateService serviciu;

        /**
         * Lista care servește modelului ca sursă de date.
         */
        private List<Localitate> datasource;

        /**
         * Constructor de model care primește serviciul ca parametru.
         * @param service LocalitateService Serviciu de utilizat
         */
        public LazyDataLocalitati(final LocalitateService service) {
                this.serviciu = service;
                this.filtruLocalitate = new FiltruLocalitate();
        }

        /**
         * Suprascrierea metodei getRowData pentru a functiona cu obiecte de tip Localitate.
         * @param rowKey String Cheia rândului pe care s-a făcut clic in pagina
         * @return localitate Localitate care corespunde cheii primite prin parametru
         *
         */
        @Override
        public Localitate getRowData(final String rowKey) {
                Localitate localitate = new Localitate();
                for (final Localitate local : this.datasource) {
                        if (local != null && local.getId().toString().equals(rowKey)) {
                                localitate = local;
                        }
                }
                return localitate;
        }

        /**
         * Suprascriea metodei getRowKey.
         * @param localitate Localitate Obiect de la care se doreste obținerea cheia
         * @return Object Cheia obiectului trecut ca parametru
         */

        @Override
        public Object getRowKey(final Localitate localitate) {
                return localitate.getId();
        }

        /**
         * Suprascrierea metodei de încărcare pentru a lucra cu un criteriu și a returna strict numărul de localitati
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
        public List<Localitate> load(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder, final Map<String, Object> filters) {
                List<Localitate> listaLocalitati = null;
                if (this.filtruLocalitate != null) {
                        setRowCount(this.serviciu.getCounCriteria(this.filtruLocalitate));
                        listaLocalitati = this.serviciu.cautareLocalitateCriteria(first, pageSize, sortField, sortOrder,
                                        this.filtruLocalitate);
                        setDatasource(listaLocalitati);
                }
                else {
                        setRowCount(0);
                }
                return listaLocalitati;

        }

}
