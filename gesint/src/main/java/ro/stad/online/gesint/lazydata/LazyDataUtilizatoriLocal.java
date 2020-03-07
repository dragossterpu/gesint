package ro.stad.online.gesint.lazydata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.model.filters.FiltruUtilizator;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.services.UtilizatorService;

/**
 *
 * Model pentru paginarea de pe server care extinde modelul LazyDataModel al Primefaces.
 * @author STAD
 *
 */

@Setter
@Getter
public class LazyDataUtilizatoriLocal extends LazyDataModel<Utilizator> implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Obiect care conține parametrii de căutare.
         */
        private transient FiltruUtilizator filtruUtilizatorLocal;

        /**
         * Serviciu de utilizat.
         */
        private transient UtilizatorService utilizatorService;

        /**
         * Sursa de date cu lista de utilizatori.
         */
        private List<Utilizator> dataSource;

        /**
         * Constructor de model care primește serviciul ca parametru.
         * @param serviciu UtilizatorService Serviciu de utilizat
         */
        public LazyDataUtilizatoriLocal(final UtilizatorService serviciu) {
                utilizatorService = serviciu;
        }

        /**
         * Suprascrierea metodei getRowData pentru a functiona cu obiecte de tip Utilizator.
         * @param rowKey String Cheia rândului pe care s-a făcut clic in pagina
         * @return us Utilizator care corespunde cheii primite prin parametru
         *
         */
        @SuppressWarnings(Constante.UNCHECKED)
        @Override
        public Utilizator getRowData(final String rowKey) {
                Utilizator us = new Utilizator();

                final List<Utilizator> listaWrapped = (List<Utilizator>) getWrappedData();
                final Set<Utilizator> setUtilizatori = new HashSet<>();
                setUtilizatori.addAll(listaWrapped);
                if (getDataSource() != null) {
                        setUtilizatori.addAll(getDataSource());
                }
                final Iterator<Utilizator> iteratorUtilizatori = setUtilizatori.iterator();
                boolean encontrat = false;
                while (iteratorUtilizatori.hasNext() && !encontrat) {
                        final Utilizator utilizat = iteratorUtilizatori.next();
                        if (rowKey.equals(utilizat.getUsername())) {
                                us = utilizat;
                                encontrat = true;
                        }
                }
                return us;
        }

        /**
         * Suprascriea metoda getRowKey.
         * @param user Utilizator Obiect de la care se doreste obținerea cheia
         * @return Object Cheia obiectului trecut ca parametru
         */
        @Override
        public Object getRowKey(final Utilizator user) {
                return user.getUsername();
        }

        /**
         * Suprascrierea metodei de încărcare pentru a lucra cu un criteriu și a returna strict numărul de utilizatori
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
        public List<Utilizator> load(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder, final Map<String, Object> filters) {
                List<Utilizator> listaUtilizatori = new ArrayList<>();
                if (filtruUtilizatorLocal == null) {
                        this.setRowCount(0);
                }
                else {
                        this.setRowCount(utilizatorService.getCounCriteriaCentral(filtruUtilizatorLocal));
                        listaUtilizatori = utilizatorService.cautareUtilizatorCentralCriteria(first, pageSize,
                                        sortField, sortOrder, filtruUtilizatorLocal);
                        setDataSource(listaUtilizatori);

                }
                return listaUtilizatori;

        }

}
