package ro.stad.online.gesint.services;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import com.mitchellbosecke.pebble.error.PebbleException;

import ro.stad.online.gesint.model.filters.FiltruCorespondenta;
import ro.stad.online.gesint.persistence.entities.Corespondenta;
import ro.stad.online.gesint.persistence.entities.Documentul;
import ro.stad.online.gesint.persistence.entities.Utilizator;

/**
 * Declarația metodelor care vor fi utilizate pentru persistența corespondentelor.
 * @author STAD
 *
 */
public interface CorespondentaService {

        /**
         * Metoda care caută Corespondenta cu parametrii din filtru.
         * @param filtruCorespondenta FiltruCorespondenta
         * @param sortOrder SortOrder
         * @param sortField String
         * @param pageSize int
         * @param first int
         * @return List<Corespondenta>
         */
        List<Corespondenta> cautareCorespondenteCriteria(int first, int pageSize, String sortField, SortOrder sortOrder,
                        FiltruCorespondenta filtruCorespondenta);

        /**
         * Eliminarea unei corespondente
         * @param id corespondenta
         */
        void delete(Long id);

        /**
         * Metoda care obținețe numărul de registre dinbaza de date
         * @param filtruCorespondenta FiltruCorespondenta
         * @return int
         */
        int getCounCriteria(FiltruCorespondenta filtruCorespondenta);

        /**
         * Metoda care inregistreaza o corespondent
         * @param corespondenta Corespondenta
         * @return Corespondenta
         */
        Corespondenta save(Corespondenta corespondenta);

        /**
         * Metoda care trimite corespondenta în mod individual.
         * @param corespondenta Corespondenta
         * @param documenteIncarcate List<Documentul>
         * @param sablon String
         * @param paramSablon Map<String, String>
         * @throws PebbleException
         */
        void trimitereCorespondenta(Corespondenta corespondenta, List<Utilizator> utilizatoriSelectionati,
                        List<Documentul> documenteIncarcate, String sablon, Map<String, String> paramSablon)
                        throws PebbleException;

        /**
         * Cauta o corespondenta
         * @param corespondenta Corespondenta
         * @return corespondenta Corespondenta
         */
        Corespondenta fiindOne(Corespondenta corespondenta);

}
