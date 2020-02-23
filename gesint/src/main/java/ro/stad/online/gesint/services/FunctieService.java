package ro.stad.online.gesint.services;

import java.util.List;

import org.primefaces.model.SortOrder;

import ro.stad.online.gesint.persistence.entities.Functie;

/**
 * Interfață pentru serviciul de Functie.
 *
 * @author STAD
 *
 */
public interface FunctieService {

        /**
         * Eliminarea unei functii
         * @param functie
         */
        void delete(Functie functie);

        /**
         * Cauta toate functiile
         * @return lista de functii.
         */
        List<Functie> fiindAll();

        /**
         * Inregistreaza o functie.
         * @param functie Functie
         * @return functie actualizata
         */
        Functie save(Functie functie);

        /**
         * Metoda care returnează numărul de functii.
         * @return returnează numărul de registre din consultarea criteria.
         */
        int getCounCriteria();

        /**
         * Metoda care caută de toate functiile.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul în care sunt sortate rezultatele
         * @param sortOrder ordine de sortare (crescator / descrescator)
         * @return lista List<Functie> lista de functii.
         */
        List<Functie> cautareFunctiiCriteria(int first, int pageSize, String sortField, SortOrder sortOrder);
}
