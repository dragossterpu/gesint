package ro.stad.online.gesint.services;

import ro.stad.online.gesint.persistence.entities.Intrebare;
import ro.stad.online.gesint.persistence.entities.RaspunsSuport;

/**
 * Interfață de service pentru managementul de intrebari.
 *
 * @author STAD
 *
 */
public interface RaspunsSuportService {

        /**
         * Metoda care returnează raspunsul cautat dupa intrebare
         * @param intrebare Intrebare
         * @return RaspunsSuport
         */
        RaspunsSuport findById(Intrebare intrebare);

}
