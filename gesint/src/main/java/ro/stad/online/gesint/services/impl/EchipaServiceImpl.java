package ro.stad.online.gesint.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.stad.online.gesint.persistence.entities.Echipa;
import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.repositories.EchipaRepository;
import ro.stad.online.gesint.persistence.repositories.ParamEchipaRepository;
import ro.stad.online.gesint.services.EchipaService;

/**
 * Implementare pentru serviciul de Echipa.
 *
 * @author STAD
 *
 */
@Service
public class EchipaServiceImpl implements EchipaService {

        /**
         * Repository de Echipa.
         */
        @Autowired
        private EchipaRepository echipaRepository;

        /**
         * Repository de tip de echipa.
         */
        @Autowired
        private ParamEchipaRepository pEchipaRepository;

        /**
         * Metoda care elimina un membru al echipei de conducere
         * @param echipa membru al echipei de conducere
         */
        @Override
        public void delete(final Echipa echipa) {
                echipaRepository.delete(echipa);
        }

        /**
         * Metoda care cauta o functie dupa id
         * @param functieId Long Functie
         * @return int
         */
        @Override
        public int existsByTeam(final Long functieId) {
                return echipaRepository.existsByTeam(functieId);
        }

        /**
         * Metoda care cauta o functie dupa utilizator
         * @param user Utilizator
         * @return boolean
         */
        @Override
        public boolean existsByUser(final Utilizator user) {
                return echipaRepository.existsByUser(user);
        }

        /**
         * Metoda care cauta toti membrii cu functii
         * @return lista List<Echipa> .
         */
        @Override
        public List<Echipa> fiindByTeam() {
                return (ArrayList<Echipa>) echipaRepository.findAllByOrderByRankAsc();
        }

        /**
         * Metoda care obtine o lista ordonata dupa nivelul cel mai mare
         * @return lista List<Echipa> lista ordonata
         */
        @Override
        public List<Echipa> findAllByOrderByRankDesc() {
                return (ArrayList<Echipa>) echipaRepository.findAllByOrderByRankDesc();
        }

        /**
         * Metoda care cauta un registru in baza de date primind ca parametru membrul echipei
         * @param utilizator Utilizator
         * @return utilizator Utilizator
         */
        @Override
        public Echipa findByUser(final Utilizator utilizator) {
                return echipaRepository.findByUser(utilizator);
        }

        /**
         * Metoda care salveaza sau actualizeaza o echipa.
         * @param echipa
         * @return Echipa actualizata
         */
        @Override
        public Echipa save(final Echipa echipa) {
                final Echipa echipaActualizata = echipaRepository.save(echipa);
                return echipaActualizata;
        }

        /**
         * Metoda care cauta un tip de echipa dupa id
         * @param idEchipa
         * @return paranEchipa Functie tipu de echipa
         *
         */
        @Override
        public Functie findOne(final Long idEchipa) {
                return pEchipaRepository.findOne(idEchipa);
        }
}
