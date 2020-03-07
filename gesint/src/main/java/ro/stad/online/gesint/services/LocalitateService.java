package ro.stad.online.gesint.services;

import java.io.IOException;
import java.util.List;

import org.primefaces.model.SortOrder;

import ro.stad.online.gesint.model.filters.FiltruLocalitate;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Localitate;
import ro.stad.online.gesint.persistence.entities.enums.TipLocalitateEnum;

/**
 * Interfață pentru serviciul de Localitate.
 *
 * @author STAD
 *
 */
public interface LocalitateService {

        /**
         * Metodă care caută orașele care aparțin unei judet.
         * @param idJudet Judet pe care vrem să o consultăm.
         * @return lista List<Localitate> Lista de localitati ale judetului.
         */
        List<Localitate> cautareDupaJudet(Long idJudet);

        /**
         * Metodă care salveaza o localitate nouă
         * @param nume localitatii
         * @param judet din care face parte localitatea
         * @return localitate Localitate localitate creata
         */
        Localitate inregistrareLocalitate(String nombre, Judet judet, TipLocalitateEnum tipLocalitate);

        /**
         * Metodă care verifică dacă există o localitate cu același nume..
         * @param name numele localitatii
         * @param judet din care face parte localitatea
         * @return valor booleano
         */
        boolean existeByNumeIgnoreCaseAndJudet(String name, Judet judet);

        /**
         * Metodă care verifică dacă există o localitate cu același nume.
         * @param name numele localitatii
         * @param judet din care face parte localitatea
         * @return localitatea Localitate Localitate
         */
        Localitate localidadByNumeIgnoreCaseAndJudet(String name, Judet judet);

        /**
         * Metodă care cauta toate localitatile
         * @return lista de localitati.
         */
        List<Localitate> fiindAll();

        /**
         * Metodă care cauta toate localitatile
         * @param idsLocal List<String>
         * @return lista de localitati.
         */
        List<Localitate> findAllById(List<String> idsLocal);

        /**
         * Metodă care cauta o localitate dupa id acestuia
         * @param localidadId Long
         * @return localitate Localitate
         *
         */
        Localitate findById(Long localitiId);

        /**
         * Metodă care cauta o localitate dupa numele acestuia
         * @param local numele localitatii
         * @return localitate Localitate
         *
         */
        Localitate findByNume(String local);

        /**
         * Metodă care cauta toate localitatile unui judet
         * @param judet Judet
         * @return lista List<Localitate> lista de localitati.
         */
        List<Localitate> findByJudet(Judet judet);

        /**
         * Metodă care cauta toate localitatile judetelor trecuta ca parametru
         * @param judete List<Judet>
         * @return lista List<Localitate> lista de localitati.
         */
        List<Localitate> findByJudete(List<Judet> judete);

        /**
         * Metodă care cauta toate localitatile unui judet
         * @param Long nivel identificator de nivel(importanta) al localitatii
         * @param judet Judet
         * @return lista de localitati.
         */
        List<Localitate> findByJudetAndNivel(Judet judet, Long nivel);

        /**
         * Metodă care salveaza o localitate noua
         * @param localitate Localitate
         * @return localitate actualizata
         */
        Localitate save(Localitate localitate);

        /**
         * Metoda care primește un fișier UploadedFile și datele necesare pentru a genera un document, dar nu îl
         * stochează într-o bază de date. Lăsați obiectul gata să îl salveze.
         * @param file fisier pentru stocare in baza de date
         * @param localitate localitate
         * @return document stocat in baza de date
         * @throws IOException
         */
        Localitate incarcareImaginaFaraStocare(byte[] bs, Localitate localitate) throws IOException;

        /**
         * Metoda care returnează numărul de localitati într-o consultare bazată pe criterii.
         * @param filtruLocalitate obiect cu parametri de căutare
         * @return returnează numărul de registre din consultarea criteria.
         */
        int getCounCriteria(FiltruLocalitate filtruLocalitate);

        /**
         * Metoda care caută de toate localițatile care îndeplinesc condițiile introduse în FiltruLocalitate.
         * @param filtruLocalitate obiect cu parametri de căutare
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul în care sunt sortate rezultatele
         * @param sortOrder ordine de sortare (crescator / descrescator)
         * @return lista List<Localitate> lista de localitati.
         */
        List<Localitate> cautareLocalitateCriteria(int first, int pageSize, String sortField, SortOrder sortOrder,
                        FiltruLocalitate filtruLocalitate);

        /**
         * Metoda care elimina o localitate
         * @param localitate Localitate
         */
        void delete(Localitate localitate);
}
