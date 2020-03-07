package ro.stad.online.gesint.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.NoArgsConstructor;
import ro.stad.online.gesint.persistence.entities.Sondaj;
import ro.stad.online.gesint.persistence.entities.UtilizatorSondaj;
import ro.stad.online.gesint.persistence.repositories.SondajVotRepository;
import ro.stad.online.gesint.services.SondajVotService;

/**
 * Implementarea metodelor definite în interfața SondajVotService.
 * @author STAD
 *
 */
@NoArgsConstructor
@Service
@Transactional
public class SondajVotServiceImpl implements SondajVotService, Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Repository de sondaje.
         */
        @Autowired
        private transient SondajVotRepository sondajVotRepository;

        /**
         * Metoda care salveaza sau actualizeaza un sondaj
         * @param sondaj Sondaj
         * @return sondaj Sondaj
         */
        @Override
        @Transactional(readOnly = false)
        public UtilizatorSondaj save(final UtilizatorSondaj userSondaj) {
                return sondajVotRepository.save(userSondaj);
        }

        /**
         * Metoda care returneaza totii votanti unui sondaj
         * @return lista List<UtilizatorSondaj>
         */
        @Override
        public List<UtilizatorSondaj> findAllBySondaj(Sondaj sondaj) {
                return sondajVotRepository.findAllBySondaj(sondaj);
        }

        /**
         * Metoda care dupa finalizarea unui sondajelimina toti utilizatorii care au votat
         * @param Sondaj sond
         */
        @Override
        public void deleteBySondaj(Sondaj sonda) {
                sondajVotRepository.deleteBySondaj(sonda);

        }
}
