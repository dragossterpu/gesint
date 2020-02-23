package ro.stad.online.gesint.services;

import java.util.List;

import ro.stad.online.gesint.persistence.entities.Functie;

/**
 * Interfață pentru serviciul de Functie.
 *
 * @author STAD
 *
 */
public interface ParamEchipaService {

        /**
         * Metodă care returnează toate fuctiile din baza de date
         * @return lista List<Functie>
         */
        List<Functie> fiindAll();

        /**
         * Metodă care returnează toate registrele din baza de date
         * @param String "Conducerea Locală"
         * @return lista List<Functie>
         */
        List<Functie> fiindAllByParam();

        /**
         * Metodă care cauta o functie după id
         * @param Long idTeam
         * @return Functie functia
         */
        Functie findById(Long idTeam);

        /**
         * Metodă care cauta o functie după id si dupa nume
         * @param Long idTeam
         * @param String organizatie
         * @return Functie functia
         */
        Functie findByIdAndOrganization(Long id, String organizatia);

        /**
         * Metodă care cauta o functie după nume
         * @param String organizatie
         * @return Functie functia
         */
        List<Functie> findByOrganization(String organizatia);
}
