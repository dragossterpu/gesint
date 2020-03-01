package ro.stad.online.gesint.lazydata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.model.filters.FiltruProiect;
import ro.stad.online.gesint.persistence.entities.Proiect;
import ro.stad.online.gesint.services.ProiectService;

/**
 * 
 * Model pentru paginarea de pe server care extinde modelul LazyDataModel al Primefaces.
 * @author STAD
 *
 */

@Setter
@Getter
public class LazyDataProiecte extends LazyDataModel<Proiect> implements Serializable {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        /**
         * Obiect care conține parametrii de căutare.
         */
        private transient FiltruProiect filtruProiect;

        /**
         * Listă care servește modelul ca sursă de date.
         */
        private transient List<Proiect> datasource;

        /**
         * Serviciu de utilizat.
         */
        private transient ProiectService proiectService;

        /**
         * Constructor de model care primește serviciul ca parametru.
         * @param serviciu ProiectService Serviciu de utilizat
         */
        public LazyDataProiecte(final ProiectService serviciu) {
                proiectService = serviciu;
        }

        /**
         * Suprascriea metoda getRowKey.
         * @param proiect Proiect Obiect de la care se doreste obținerea cheia
         * @return Object Cheia obiectului trecut ca parametru
         */
        @Override
        public Object getRowKey(final Proiect proiect) {
                return proiect.getId();
        }

        /**
         * Suprascrierea metodei de încărcare pentru a lucra cu un criteriu și a returna strict numărul de proiecte
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
        public List<Proiect> load(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder, final Map<String, Object> filters) {
                List<Proiect> listaProiecte = new ArrayList<>();
                if (filtruProiect == null) {
                        this.setRowCount(0);
                }
                else {

                        this.setRowCount(proiectService.getCounCriteria(filtruProiect));
                        listaProiecte = proiectService.cautareProiecteCriteria(first, pageSize, sortField, sortOrder,
                                        filtruProiect);
                }
                return listaProiecte;

        }

}
