package ro.stad.online.gesint.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.persistence.entities.Proprietate;
import ro.stad.online.gesint.persistence.repositories.ProprietateRepository;
import ro.stad.online.gesint.services.ProprietateService;

/**
 * Implementarea metodelor definite în interfața ProprietateService.
 * 
 * @author STAD
 */

@Service
public class ProprietateServiceImpl implements ProprietateService {

        /**
         * Variabila utilizata pentru a injecta serviciul de proprietati.
         */
        @Autowired
        private ProprietateRepository propriedadesRepository;

        /**
         * Metoda care returnează toți parametrii de conectare la serverul de email.
         * @param filename String
         * @return List<Proprietate>
         */
        @Override
        public List<Proprietate> findByFilename(final String filename) {
                return propriedadesRepository.findByFilename(filename);
        }

        /**
         * Metoda care returnează parametrul dupa numele care a fost cautat.
         * @param numeParametru String
         * @return String
         */
        @Override
        public String findOneByName(final String numeParametru) {
                String valoare = Constante.SPATIU;
                if (propriedadesRepository.findOneByNume(numeParametru) != null) {
                        valoare = propriedadesRepository.findOneByNume(numeParametru).getValor();
                }
                return valoare;
        }
}
