package ro.stad.online.gesint.services;

import java.util.List;

import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Optiune;

/**
 * Interfață pentru serviciul de optiuni.
 *
 * @author STAD
 *
 */
public interface OptiuneService {

        /**
         * Metoda care elimina o optiune
         * @param optiune
         */
        void delete(Optiune optiune);

        /**
         * Metoda care cauta toate optiunile inregistrate
         * @return lista List<Optiune>
         */
        List<Optiune> fiindAll();

        /**
         * Metoda care cauta toate optiunile inregistrate ale unui judet
         * @param judet Judet
         * @return List<Optiune>)
         */
        List<Optiune> findByCodJudet(Judet judet);

        /**
         * Metoda care inregistreaza o noua optiune
         * @param optiune Optiune
         * @return optiune
         */
        Optiune save(Optiune optiune);

}
