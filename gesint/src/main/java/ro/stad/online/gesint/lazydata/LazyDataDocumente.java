package ro.stad.online.gesint.lazydata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.model.filters.FiltruDocument;
import ro.stad.online.gesint.persistence.entities.Documentul;
import ro.stad.online.gesint.services.DocumentService;

/**
 * Model pentru paginarea de pe server care extinde modelul LazyDataModel de Primefaces.
 * @author STAD
 *
 */
@Component
@Setter
@Getter
public class LazyDataDocumente extends LazyDataModel<Documentul> implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * Obiect care conține parametrii de căutare.
         */
        private FiltruDocument filtruDocument;

        /**
         * Service.
         */
        private transient DocumentService serviciu;

        /**
         * Lista care servește modelului ca sursă de date.
         */
        private List<Documentul> datasource;

        /**
         * Constructor.
         * 
         * @param service Serviciu de utilizat.
         */
        public LazyDataDocumente(DocumentService service) {
                this.serviciu = service;
                this.filtruDocument = new FiltruDocument();
        }

        /**
         * Suprascrierea metodei getRowData pentru a functiona cu obiecte de tip Documentul.
         * @param rowKey String Cheia rândului pe care s-a făcut clic in pagina
         * @return doc Documentul care corespunde cheii primite prin parametru
         *
         */
        @Override
        public Documentul getRowData(String rowKey) {
                Documentul doc = null;
                for (Documentul docu : datasource) {
                        if (docu.getId().toString().equals(rowKey))
                                doc = docu;
                }
                return doc;
        }

        /**
         * Suprascriea metoda getRowKey.
         * @param document Documentul Obiect de la care se doreste obținerea cheia
         * @return Object Cheia obiectului trecut ca parametru
         */
        @Override
        public Object getRowKey(Documentul document) {
                return document.getId();
        }

        /**
         * Suprascrierea metodei de încărcare pentru a lucra cu un criteriu și a returna strict numărul de documente
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
        public List<Documentul> load(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder, final Map<String, Object> filters) {
                List<Documentul> listaDocumente = new ArrayList<>();
                if (filtruDocument != null) {
                        this.setRowCount(serviciu.getCounCriteria(filtruDocument));
                        listaDocumente = serviciu.cautareDocumentCriteria(first, pageSize, sortField, sortOrder,
                                        filtruDocument);
                        this.setDatasource(listaDocumente);
                }
                else {
                        this.setRowCount(0);
                }
                return listaDocumente;

        }

}
