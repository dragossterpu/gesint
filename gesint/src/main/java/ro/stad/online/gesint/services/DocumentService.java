package ro.stad.online.gesint.services;

import java.util.List;

import org.hibernate.Criteria;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.UploadedFile;

import ro.stad.online.gesint.exceptions.GesintException;
import ro.stad.online.gesint.model.filters.FiltruDocument;
import ro.stad.online.gesint.persistence.entities.Corespondenta;
import ro.stad.online.gesint.persistence.entities.Documentul;
import ro.stad.online.gesint.persistence.entities.Sondaj;
import ro.stad.online.gesint.persistence.entities.TipDocument;
import ro.stad.online.gesint.persistence.entities.Utilizator;

/**
 * Interfața serviciului Documente.
 *
 * @author STAD
 *
 */
public interface DocumentService {

        /**
         * Returnează documentele care corespund tipului de document.
         * @param tipoDocumento Numele tipului de document
         * @return Lista documentelor
         */
        List<Documentul> cautaNumeTipDocument(String tipDocument);

        /**
         * Returnează documentele care corespund sondajului.
         * @param sondaj Identificator sondaj
         * @return Lista documentelor
         */
        List<Documentul> cautaDocumenteSondaj(Sondaj sondaj);

        /**
         * Returnează documentele care corespund alertei.
         * @param corespondenta Corespondenta
         * @return Lista documentelor
         */
        List<Documentul> findByCorespondenta(Corespondenta corespondenta);

        /**
         * Cautare în baza de date pe baza parametrilor primiți. Cautarea este paginată in server.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul dupa care sunt sortate rezultatele
         * @param sortOrder direcția de ordonare (ascendent / descendent)
         * @param filtruDocument FiltruDocument Obiect care conține criteriile de căutare
         * @return Lista de documente List<Documentul>
         *
         */
        List<Documentul> cautareDocumentCriteria(int first, int pageSize, String sortField, SortOrder sortOrder,
                        FiltruDocument filtruDocument);

        /**
         * Recupereaza un tip de document după numele său.
         * @param nume numele tipului
         * @return tipul documentului
         */
        TipDocument cautareTipDocumentNume(String nume);

        /**
         * Primește un fișier UploadedFile din care preia datele pentru a genera un document care va fi stocat în baza
         * de date. Returnează documentul stocat
         * @param file fișier pentru a încărca în DB
         * @param tip tipul de document
         * @param utilizator utilizator asociat cu documentul
         * @return Documentul documentul încărcat în baza de date
         * @throws GesintException Excepție posibilă
         *
         */

        Documentul incarcareDocument(UploadedFile file, TipDocument tip, Utilizator utilizator) throws GesintException;

        /**
         * Primeste un fisier UploadedFile si datele necesare unui document general, dar nu-l stocheaza in baza de date.
         * Doar lăsați obiectul gata să îl salveze.
         * @param file fișier pentru a încărca în DB
         * @param tip tipul de document
         * @param utilizator utilizator asociat cu documentul
         * @return documento documentul încărcat în baza de date
         * @throws GesintException Excepție posibilă
         */
        Documentul incarcareDocumentFaraSalvare(UploadedFile file, TipDocument tip, Utilizator utilizator)
                        throws GesintException;

        /**
         * Eliminare de documente din baza de date. Documentul care trebuie eliminat este primit ca parametru.
         * @param entity Documentul pentru eliminare
         *
         */

        void delete(Documentul entity);

        /**
         * Metoda care primește un document ca parametru și returneaza un stream(flux) pentru a efectua descărcarea.
         * @param entity Document pentru descărcare
         * @return DefaultStreamed Content Descărcați fluxul
         * @throws GesintException Excepție posibilă
         */

        DefaultStreamedContent descarcareDocument(Documentul entity) throws GesintException;

        /**
         * Metoda care primește id-ul unui document ca parametru și returnează un flux pentru efectuarea descărcării.
         * @param id Id document pentru descărcare
         * @return DefaultStreamedContent Descărcați fluxul
         * @throws GesintException Excepție posibilă
         */

        DefaultStreamedContent descarcareDocument(Long id) throws GesintException;

        /**
         * Metoda care caută toate documentele care au fost eliminate logic.
         * @return Lista documentelor selectate
         */

        List<Documentul> findByDataEliminariNuEsteNula();

        /**
         * Metoda care caută toate documentele care nu au fost eliminate logic.
         * @return Lista documentelor selectate
         */

        List<Documentul> findByDataEliminariEsteNula();

        /**
         * Metoda care returnează un document căutat după id-ul său.
         * @param id Identificatorul documentului
         * @return Documentul
         */
        Documentul findOne(Long id);

        /**
         * Metodă care verifică numărul de înregistrări din baza de date care corespund criteriilor de căutare.
         * @param filtruDocument Obiect care conține criteriile de căutare
         * @return int numărul de înregistrări corespunzătoare căutării
         */
        int getCounCriteria(FiltruDocument filtruDocument);

        /**
         * Metodă care returnează lista tipurilor de documente.
         * @return lista List<TipDocument> lista tipurilor de documente.
         */
        List<TipDocument> listaTipuriDocumente();

        /**
         * Metodă care returnează numele fișierului conținut în obiectul Document.
         * @param documentul din care doriți să extrageți numele fișierului conținut
         * @return numele fișierului
         */
        String obtieneNumeFisier(Documentul document);

        /**
         * Metoda care pregăteste ultimele criterii ca parametru pentru paginarea Primefaces.
         *
         * @param criteria Criteria
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul dupa care sunt sortate rezultatele
         * @param sortOrder direcția de ordonare (ascendent / descendent)
         * @param defaultField câmpul de ordonare prin defect
         */
        void pregatestePaginareOrdonareCriteria(Criteria criteria, int first, int pageSize, String sortField,
                        SortOrder sortOrder, String defaultField);

        /**
         * Metoda care recupereaza un document din coșul de gunoi.
         * @param document Documentul
         */
        void recupereazaDocument(Documentul document);

        /**
         * Metoda care salveaza un document în baza de date. Ca parametru, primește documentul care trebuie salvat și
         * returnează documentul salvat.
         * @param entity Documentul Document pentru salvare
         * @return document documentul salvat
         */
        Documentul save(Documentul entity);

        /**
         * Metoda care Salveaza o serie de documente în baza de date. Ca parametru, primește documentele care trebuie
         * salvate și returnează documentele salvate.
         * @param entities Documente de salvat
         * @return lista documentelor salvate
         *
         */
        Iterable<Documentul> save(Iterable<Documentul> entities);

        /**
         * Metoda care elimina toate documentele stocate în coșul de gunoi.
         * @return lista List<Documentul> Lista documentelor eliminate
         */
        List<Documentul> golesteCosulGunoi();

}
