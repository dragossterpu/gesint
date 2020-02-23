package ro.stad.online.gesint.lazydata;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.services.JudetService;

/**
 *
 * Model pentru paginarea de pe server care extinde modelul LazyDataModel al Primefaces.
 *
 * @author STAD
 *
 */

@Setter
@Getter
public class LazyDataJudete extends LazyDataModel<Judet> implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * Serviciu de utilizat.
         */
        @Autowired
        private transient JudetService serviciu;

        /**
         * Lista care servește modelului ca sursă de date.
         */
        private List<Judet> datasource;

        /**
         * Constructor de model care primește serviciul ca parametru.
         * @param service judetervice Serviciu de utilizat
         */
        public LazyDataJudete(final JudetService service) {
                this.serviciu = service;
        }

        /**
         * Suprascrierea metodei getRowData pentru a functiona cu obiecte de tip judet.
         * @param rowKey String Cheia rândului pe care s-a făcut clic in pagina
         * @return judet Judet care corespunde cheii primite prin parametru
         *
         */
        @Override
        public Judet getRowData(final String rowKey) {
                Judet judet = new Judet();
                for (final Judet local : this.datasource) {
                        if (local != null && local.getIndicator().equals(rowKey)) {
                                judet = local;
                        }
                }
                return judet;
        }

        /**
         * Suprascriea metodei getRowKey.
         * @param Judet judet Obiect de la care se doreste obținerea cheia
         * @return Object Cheia obiectului trecut ca parametru
         */

        @Override
        public Object getRowKey(final Judet judet) {
                return judet.getIndicator();
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
        public List<Judet> load(final int first, final int pageSize, final String sortField, final SortOrder sortOrder,
                        final Map<String, Object> filters) {
                List<Judet> listaJudete = null;
                setRowCount(this.serviciu.getCounCriteria());
                listaJudete = this.serviciu.cautareJudeteCriteria(first, pageSize, sortField, sortOrder);
                setDatasource(listaJudete);
                return listaJudete;

        }

}
