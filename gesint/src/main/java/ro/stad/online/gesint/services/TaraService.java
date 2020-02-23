package ro.stad.online.gesint.services;

import java.util.List;

import ro.stad.online.gesint.persistence.entities.Tara;

/**
 * Interfață pentru serviciul de Tara.
 *
 * @author STAD
 *
 */
public interface TaraService {

        /**
         * Metoda care cauta toate tarile inregistrate in baza de date.
         * @return lista de tari
         */
        List<Tara> fiindAll();

}
