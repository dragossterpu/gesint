package ro.stad.online.gesint.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Localitate;

/**
 * Repositoriu pentru entitatea Localitate.
 * @author STAD
 */
public interface LocalitateRepository extends CrudRepository<Localitate, Long> {
        /**
         * Verifică dacă există o localitate cu același nume in judet.
         *
         * @param nume numele localitatii.
         * @param judet Judet
         * @return Boolean existe?
         */
        boolean existsByNumeIgnoreCaseAndJudet(String nume, Judet judet);

        /**
         * Cauta toate localitatile unei provincii
         * @param judet Judet
         * @return lista de localitati.
         */
        List<Localitate> findAllByJudet(Judet judet);

        /**
         * Cauta o lista de localitati ale unui judet.
         * @param idJudet id-ul judetului
         * @return List<Localidad> Lista de localitati din judet.
         */
        List<Localitate> findByJudetOrderByNume(Long idJudet);

        /**
         * Cauta o localitate dupa nume si judet
         * @param nume String
         * @param judet Judet
         * @return localitate Localitate
         *
         */
        Localitate findByNumeIgnoreCaseAndJudet(String name, Judet judet);

        /**
         * Cauta o localitate dupa numele acestuia
         * @param descriere String
         * @return Localitate
         *
         */
        Localitate findByNume(String descriere);

        /**
         * Cauta o localitate dupa numele acestuia si importanta
         * @param judet Judet
         * @param nivel Long
         * @return List<Localitate>
         *
         */
        List<Localitate> findAllByJudetAndNivel(Judet judet, Long nivel);
}
