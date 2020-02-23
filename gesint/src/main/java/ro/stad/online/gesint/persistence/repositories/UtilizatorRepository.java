package ro.stad.online.gesint.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Localitate;
import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.entities.Utilizator;

/**
 * Repositoriu pentru entitatea Utilizator.
 * @author STAD
 */
public interface UtilizatorRepository extends CrudRepository<Utilizator, String> {

        /**
         * Căutați o listă de utilizatori prin e-mail sau document de identitate, ignorând majuscule..
         *
         * @param email e-mail utilizator pentru căutare
         * @param cnp document de utilizator pentru a căuta
         * @return List<Utilizator> rezultatul căutării
         *
         */
        List<Utilizator> findByEmailIgnoreCaseOrIdCardIgnoreCase(String email, String cnp);

        /**
         * Căutați un utilizator cu CNP.
         * @param cnp String - cnp-ul utilizatorului
         * @return Utilizator
         */
        Utilizator findByIdCard(String cnp);

        /**
         * Returnează o listă de utilizatori într-o localitate
         * @param nume dupa care se face cautarea in baza de date
         * @return List<Utilizator> Lista numelor de utilizatori prezente în baza de date
         */
        List<Utilizator> findByLocalitate(Localitate loca);

        /**
         * Returnează o listă cu numele utilizatorilor prezenți în listă și în BBDD.
         * @param nume dupa care se face cautarea in baza de date
         * @return List<Utilizator> Lista numelor de utilizatori prezente în baza de date
         */
        List<Utilizator> findByNume(String nume);

        /**
         * Caută un utilizator cu rolul si judetul.
         * @param listaTeam List<Functie>
         * @param prov Judet
         * @return Utilizator
         */

        List<Utilizator> findByCodJudetAndTeamIn(Judet prov, List<Functie> listaTeam);

        /**
         * Cauta un utilizator cu functia.
         * @param team
         * @return Utilizator user
         *
         */
        Utilizator findByTeam(Functie team);

        /**
         * Cauta un utilizator cu rolul si judetul.
         * @param echipa Functie
         * @param judet Judet
         * @return Utilizator
         */
        Utilizator findByTeamAndCodJudet(Functie echipa, Judet judet);

        /**
         * Returnează o listă de utilizatori care se potrivesc cu numele de utilizator furnizate.
         * @param listaUsernames lista de nume de utilizator
         * @return List<Utilizator> lista utilizatorilor găsiți
         */
        List<Utilizator> findByUsernameIn(final List<String> listaUsernames);

        /**
         * Returnează o listă cu numele utilizatorilor prezenți în listă și în BBDD.
         * @param listaNume lista numelor care trebuie căutate în bbdd
         * @return List<String> Lista numelor de utilizatori prezente în baza de date
         */
        @Query("SELECT u.username FROM Utilizator u where u.username in (:listaNume)")
        List<String> findUsernamesByUsername(@Param("listaNume") List<String> listaNume);

        /**
         * Returnează categoriile din care fac parte utilizatorii..
         *
         * @param sex tipul de sex
         * @param de data de cand
         * @param pana pana cand
         * @return Lista categoriilor din care face parte.
         */
        @Query(value = "select count(*) from utilizator where sex=?1 date_create between date=?2 and date'=?3", nativeQuery = true)
        Integer findUsersBySex(String sex, String de, String pana);
}
