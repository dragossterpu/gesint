package ro.stad.online.gesint.services;

import java.util.List;

import ro.stad.online.gesint.persistence.entities.Intrebare;

/**
 * Interfață de service pentru managementul de intrebari.
 *
 * @author STAD
 *
 */
public interface IntrebareService {

        /**
         * Metodă care returnează o lista cu toate intrebarile.
         * @return List<Intrebari>
         */
        List<Intrebare> findAll();

        /**
         * Metodă care returnează Intrebarea căutată dupa id
         * @param id Lond Id intrebarii
         * @return Intrebare
         */
        Intrebare findById(Long id);

}
