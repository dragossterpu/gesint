package ro.stad.online.gesint.services;

import java.util.List;

import ro.stad.online.gesint.persistence.entities.Proprietate;

/**
 * Interfață pentru serviciul de ProprietateService.
 * 
 * @author STAD
 *
 */
public interface ProprietateService {

        /**
         * Metoda care returnează toți parametrii de conectare la serverul de email.
         * @param filename String
         * @return List<Proprietate>
         */
        List<Proprietate> findByFilename(String filename);

        /**
         * Metoda care returnează parametrul dupa numele care a fost cautat.
         * @param numeParametru String
         * @return String
         */
        String findOneByName(String numeParametru);
}
