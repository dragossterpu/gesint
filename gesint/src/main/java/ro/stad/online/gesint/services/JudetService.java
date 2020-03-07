package ro.stad.online.gesint.services;

import java.io.IOException;
import java.util.List;

import org.primefaces.model.SortOrder;

import ro.stad.online.gesint.persistence.entities.Judet;

/**
 * Interfață pentru serviciul de Judet.
 *
 * @author STAD
 *
 */
public interface JudetService {

        /**
         * Cauta toate judetele
         *
         * @return lista de judete.
         */
        List<Judet> fiindAll();

        /**
         * Cauta un judet
         * @param judet Judetul
         * @return Judet judet
         */
        Judet fiindOne(Judet judet);

        /**
         * Cauta judete
         * @param List<String> string
         * @return List<Judet> judete
         */
        List<Judet> findById(List<String> string);

        /**
         * Cauta un judet
         * @param string Judetul
         * @return Judet judet
         */
        Judet findById(String string);

        /**
         * @param descriere
         * @return Judet judet
         *
         */
        Judet findByName(String descriere);

        /**
         * Inregistreaza un judet.
         * @param judetul Judet
         * @return judetulul actualizat
         */
        Judet save(Judet judetul);

        /**
         * Incarcam fotografia unui judet.
         * @param Judet judetul
         * @throws IOException
         */

        Judet incarcareImaginaFaraStocare(byte[] bs, Judet judetul) throws IOException;

        /**
         * Metoda care returnează numărul de judete într-o consultare bazată pe criterii.
         * @return returnează numărul de registre din consultarea criteria.
         */
        int getCounCriteria();

        /**
         * Metoda care caută de toate judetele.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul în care sunt sortate rezultatele
         * @param sortOrder ordine de sortare (crescator / descrescator)
         * @return lista List<Judet> lista de judete.
         */
        List<Judet> cautareJudeteCriteria(int first, int pageSize, String sortField, SortOrder sortOrder);
}
