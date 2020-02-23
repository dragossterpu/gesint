package ro.stad.online.gesint.services;

import java.util.List;

import ro.stad.online.gesint.persistence.entities.Partid;

/**
 * Interfață pentru serviciul de Partid.
 *
 * @author STAD
 *
 */
public interface PartidService {

        /**
         * Metoda care elimina un partid
         * @param partid Partid
         */
        void delete(Partid partid);

        /**
         * Metoda care cauta toate partidele inregistrate
         * @return lista List<Partid>
         */
        List<Partid> fiindAll();

        /**
         * Metoda care inregistreaza un nou partid
         * @param partid Partid
         * @return partid
         */
        Partid save(Partid partid);

        /**
         * Metoda care cauta un partid dupa id
         * @param idPartid Long
         * @return partid Partid
         */
        Partid fiindOne(Long idPartid);

        /**
         * Cauta toate partidele inregistrate dupa judet
         * @return lista List<Partid>
         */
        List<Partid> fiindPartidJudet();
}
