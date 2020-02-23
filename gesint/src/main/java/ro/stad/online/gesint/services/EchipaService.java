package ro.stad.online.gesint.services;

import java.util.List;

import ro.stad.online.gesint.persistence.entities.Echipa;
import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.entities.Utilizator;

/**
 * Interfață pentru serviciul de Echipa.
 *
 * @author STAD
 *
 */
public interface EchipaService {

        /**
         * Elimina un membru al echipei de conducere
         * @param echipa Echipa membru al echipei de conducere
         */
        void delete(Echipa echipa);

        /**
         * Metoda care cauta o functie dupa id
         * @param functieId Long Functie
         * @return int
         */
        int existsByTeam(Long functieId);

        /**
         * Metoda care cauta o functie dupa utilizator
         * @param user Utilizator
         * @return boolean
         */
        boolean existsByUser(Utilizator user);

        /**
         * Metoda care cauta toti membrii cu functii
         * @return lista List<Echipa> .
         */
        List<Echipa> fiindByTeam();

        /**
         * Metoda care obtine o lista ordonata dupa nivelul cel mai mare
         * @return lista List<Echipa> lista ordonata
         */
        List<Echipa> findAllByOrderByRankDesc();

        /**
         * Metoda care cauta un registru in baza de date primind ca parametru membrul echipei
         * @param utilizator Utilizator
         * @return utilizator Utilizator
         */
        Echipa findByUser(Utilizator utilizator);

        /**
         * Metoda care salveaza sau actualizeaza o echipa.
         * @param echipa
         * @return Echipa actualizata
         */
        Echipa save(Echipa echipa);

        /**
         * Metoda care cauta un tip de echipa dupa id
         * @param idEchipa
         * @return paranEchipa Functie tipu de echipa
         *
         */
        Functie findOne(Long idEchipa);

}
