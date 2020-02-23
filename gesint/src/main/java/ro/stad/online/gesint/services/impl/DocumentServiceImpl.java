package ro.stad.online.gesint.services.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.exceptions.GesintException;
import ro.stad.online.gesint.model.filters.FiltruDocument;
import ro.stad.online.gesint.persistence.entities.Corespondenta;
import ro.stad.online.gesint.persistence.entities.DocumentBlob;
import ro.stad.online.gesint.persistence.entities.Documentul;
import ro.stad.online.gesint.persistence.entities.Sondaj;
import ro.stad.online.gesint.persistence.entities.TipDocument;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.repositories.DocumentRepository;
import ro.stad.online.gesint.persistence.repositories.TipDocumentRepository;
import ro.stad.online.gesint.services.DocumentService;

/**
 *
 * Implementarea serviciului de documente.
 *
 * @author STAD
 *
 */

@Service("documentService")
@Transactional
public class DocumentServiceImpl implements DocumentService {

        /**
         * SessionFactory
         */
        @Autowired
        private SessionFactory sessionFactory;

        /**
         * Repository de documente.
         */
        @Autowired
        private DocumentRepository documentRepository;

        /**
         * Repository de tip document.
         */
        @Autowired
        private TipDocumentRepository tipDocumentRepository;

        /**
         * Metoda care returnează documentele care corespund unui tip de document.
         * @param tipDocument Numele tipului de document
         * @return lista List<Documentul>
         */
        @Override
        public List<Documentul> cautaNumeTipDocument(final String tipDocument) {
                return documentRepository.cautaNumeTipDocument(tipDocument);
        }

        /**
         * Returnează documentele care corespund sondajului.
         * @param sondaj Identificator sondaj
         * @return Lista documentelor
         */
        @Override
        public List<Documentul> cautaDocumenteSondaj(final Sondaj sondaj) {
                return documentRepository.findBySondaj(sondaj);
        }

        /**
         * Metoda care cauta în baza de date pe baza parametrilor primiți. Cautarea este paginată in server.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul dupa care sunt sortate rezultatele
         * @param sortOrder direcția de ordonare (ascendent / descendent)
         * @param filtruDocument FiltruDocument Obiect care conține criteriile de căutare
         * @return Lista de documente List<Documentul>
         *
         */
        @Override
        public List<Documentul> cautareDocumentCriteria(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder, final FiltruDocument filtruDocument) {
                final Session session = sessionFactory.openSession();
                final Criteria criteriaDocument = session.createCriteria(Documentul.class, "documento");
                creaCriteria(filtruDocument, criteriaDocument);
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                if (filtruDocument.getUtilizator() != null) {
                        criteriaDocument.createAlias("inspeccion", "inspecciones");
                        criteriaDocument.add(Restrictions.eq("inspecciones.id",
                                        filtruDocument.getUtilizator().getUsername()));
                }
                pregatestePaginareOrdonareCriteria(criteriaDocument, first, pageSize, sortField, sortOrder, "id");
                @SuppressWarnings("unchecked")
                final List<Documentul> lista = criteriaDocument.list();
                session.close();
                return lista;
        }

        /**
         * Metoda care obține un tip de document cu numele său.
         * @param nume numele tipului de document
         * @return tipul de document TipDocument
         */
        @Override
        public TipDocument cautareTipDocumentNume(final String nume) {
                return tipDocumentRepository.findByNume(nume);
        }

        /**
         * Metoda care verifica criteriile pentru căutarea documentelor.
         * @param criteria consulta criteria
         * @param filtruDocument Obiect care conține parametrii de căutare
         */
        private void creaCriteria(final FiltruDocument filtruDocument, final Criteria criteria) {

                if (filtruDocument.getDataIncepand() != null) {
                        criteria.add(Restrictions.ge(Constante.DATECREATE, filtruDocument.getDataIncepand()));
                }
                if (filtruDocument.getDataPana() != null) {
                        final Date dataPana = new Date(
                                        filtruDocument.getDataPana().getTime() + TimeUnit.DAYS.toMillis(1));
                        criteria.add(Restrictions.le(Constante.DATECREATE, dataPana));
                }
                if (filtruDocument.getNume() != null) {
                        criteria.add(Restrictions.ilike("nume", filtruDocument.getNume(), MatchMode.ANYWHERE));
                }
                if (filtruDocument.getTipDocument() != null) {
                        criteria.add(Restrictions.eq("tipDocument", filtruDocument.getTipDocument()));
                }
                if (filtruDocument.isEliminat()) {
                        criteria.add(Restrictions.isNotNull(Constante.DATEDELETED));
                }
                else {
                        criteria.add(Restrictions.isNull(Constante.DATEDELETED));
                }
                if (filtruDocument.getDescriere() != null) {
                        criteria.add(Restrictions.ilike("descriere", filtruDocument.getDescriere(),
                                        MatchMode.ANYWHERE));
                }
                criteriaMateriaIndexada(criteria, filtruDocument.getMateriaIndexada());
        }

        /**
         * Creare document
         * @param file Fisier incarcat de utilizator.
         * @param tip Tipul de document.
         * @param utilizator Utilizator
         * @return Document generat
         * @throws DataAccessException Excepción SQL
         * @throws IOException Excepción entrada/salida
         */
        private Documentul creareDocument(final UploadedFile file, final TipDocument tip, final Utilizator utilizator)
                        throws IOException {
                final Documentul docu = new Documentul();
                docu.setNume(file.getFileName());
                docu.setTipDocument(tip);
                final byte[] fileBlob = StreamUtils.copyToByteArray(file.getInputstream());
                final DocumentBlob doc = new DocumentBlob();
                doc.setFisier(fileBlob);
                docu.setFisier(doc);
                docu.setTipContinut(file.getContentType());
                return docu;
        }

        /**
         * Metoda care adăuga in criteriile filtrului materia indexat introdusa în formular.
         * @param criteria Criteria
         * @param materiaIndexada materia indexată introdusă în filtru (separată prin virgule)
         */
        private void criteriaMateriaIndexada(final Criteria criteria, final String materiaIndexada) {
                if (materiaIndexada != null) {
                        final String[] cheie = materiaIndexada.split(",");
                        final Criterion[] cheieOr = new Criterion[cheie.length];
                        for (int i = 0; i < cheie.length; i++) {
                                cheieOr[i] = Restrictions.ilike("materiaIndexada", cheie[i].trim(), MatchMode.ANYWHERE);
                        }
                        criteria.add(Restrictions.or(cheieOr));
                }
        }

        /**
         * Ștergeți o serie de documente din baza de date. Documentul care trebuie șters este trecut ca parametru.
         * @param entity Documentul care trebuie șters
         *
         */
        @Override
        public void delete(final Documentul entity) {
                documentRepository.delete(entity);
        }

        /**
         * Metoda care primeste un document ca parametru și returneaza un stream(flux) pentru a efectua descărcarea.
         * 
         * @param entity Document pentru descărcare.
         * @return DefaultStreamedContent Descărcați fluxul
         * @throws GesintException Excepție posibilă
         */
        @Override
        public DefaultStreamedContent descarcareDocument(final Documentul entity) throws GesintException {
                final Documentul docu = documentRepository.findOne(entity.getId());
                DefaultStreamedContent streamDocument;
                if (docu != null) {
                        final InputStream stream = new ByteArrayInputStream(docu.getFisier().getFisier());
                        streamDocument = new DefaultStreamedContent(stream, entity.getTipContinut(), docu.getNume());
                }
                else {
                        throw new GesintException(new Exception("A apărut o eroare la descărcarea documentului"));
                }
                return streamDocument;
        }

        /**
         * Metoda care primeste id-ul unui document ca parametru și returnează un flux pentru efectuarea descărcării.
         * @param id Document pentru descărcare.
         * @return DefaultStreamedContent Descărcați fluxul
         * @throws GesintException Excepție posibilă
         */
        @Override
        public DefaultStreamedContent descarcareDocument(final Long id) throws GesintException {
                final Documentul entity = documentRepository.findById(id);
                DefaultStreamedContent streamDocument;
                if (entity != null) {
                        final InputStream stream = new ByteArrayInputStream(entity.getFisier().getFisier());
                        streamDocument = new DefaultStreamedContent(stream, entity.getTipContinut(), entity.getNume());
                }
                else {
                        throw new GesintException(new Exception("A apărut o eroare la descărcarea documentului"));
                }
                return streamDocument;

        }

        /**
         * Metoda care returnează documentele care corespund corespondentei.
         * @param corespondenta Corespondenta
         * @return Lista documentelor
         */
        @Override
        public List<Documentul> findByCorespondenta(final Corespondenta corespondenta) {
                final List<Documentul> listaEliminar = documentRepository.findByCorespondenta(corespondenta);
                documentRepository.delete(listaEliminar);
                return listaEliminar;
        }

        /**
         * Metoda care caută toate documentele care au fost eliminate logic.
         * @return Lista documentelor selectate
         */
        @Override
        public List<Documentul> findByDataEliminariNuEsteNula() {
                return documentRepository.findByDateDeletedIsNotNull();
        }

        /**
         * Metoda care caută toate documentele care nu au eliminare logică.
         * @return Lista documentelor selectate
         */
        @Override
        public List<Documentul> findByDataEliminariEsteNula() {
                return documentRepository.findByDateDeletedIsNull();
        }

        /**
         * Metoda care returnează un cautat după id-ul său.
         * @param id Identificatorul documentului
         * @return Documentul
         */
        @Override
        public Documentul findOne(final Long id) {
                return documentRepository.findOne(id);
        }

        /**
         * Metoda care obține numărul de registre din baza de date
         * @param filtruDocument FiltruDocument
         * @return int
         */
        @Override
        public int getCounCriteria(final FiltruDocument filtruDocument) {
                final Session session = sessionFactory.openSession();
                final Criteria criteria = session.createCriteria(Documentul.class, "document");
                creaCriteria(filtruDocument, criteria);
                criteria.setProjection(Projections.rowCount());
                final Long cnt = (Long) criteria.uniqueResult();
                session.close();
                return Math.toIntExact(cnt);
        }

        /**
         * Elimina toate documentele stocate in cosul de gunoi.
         */
        @Override
        public List<Documentul> golesteCosulGunoi() {
                final List<Documentul> listaEliminar = documentRepository.findByDateDeletedIsNotNull();
                documentRepository.delete(listaEliminar);
                return listaEliminar;
        }

        /**
         * Metoda care primeste un fișier UploadedFile din care se recupereaza datele pentru a genera un Document care
         * va fi stocat în baza de date. Returnează documentul inregistrat.
         * @param file fisier care se va stoca in BBDD
         * @param tip tipul de document
         * @return Document document stocat in bbdd
         * @throws GesintException Excepție posibilă
         *
         */
        @Override
        public Documentul incarcareDocument(final UploadedFile file, final TipDocument tip, final Utilizator utilizator)
                        throws GesintException {
                try {
                        final Documentul documentul = documentRepository.save(creareDocument(file, tip, utilizator));
                        documentul.getNume();
                        utilizator.getUsername();
                        return documentul;
                }
                catch (DataAccessException | IOException ex) {
                        throw new GesintException(ex);
                }
        }

        /**
         * Metoda care primeste un fișier UploadedFile din care se recupereaza datele pentru a genera un Document care
         * va fi stocat în baza de date. Lasă obiectul pregatit pentru salvare.
         * @param file fisier care se va stoca in BBDD
         * @param tip tipul de document
         * @param utilizator Utilizator
         * @return Document document stocat in bbdd
         * @throws GesintException Excepție posibilă
         */
        @Override
        public Documentul incarcareDocumentFaraSalvare(final UploadedFile file, final TipDocument tip,
                        final Utilizator utilizator) throws GesintException {
                try {
                        return creareDocument(file, tip, utilizator);
                }
                catch (final IOException ex) {
                        throw new GesintException(ex);
                }
        }

        /**
         * Metoda care returnează lista tipurilor de documente.
         * @return lista List<TipDocument> lista tipurilor de documente
         */
        @Override
        public List<TipDocument> listaTipuriDocumente() {
                return (List<TipDocument>) tipDocumentRepository.findAll();
        }

        /**
         * Metoda care returnează numele fișierului conținut în obiectul Documentul.
         * @param document Documentul
         * @return numele fisierului
         */
        @Override
        public String obtieneNumeFisier(final Documentul document) {
                final Documentul docu = documentRepository.findById(document.getId());
                return docu.getNume();
        }

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
        @Override
        public void pregatestePaginareOrdonareCriteria(final Criteria criteria, final int first, final int pageSize,
                        final String sortField, final SortOrder sortOrder, final String defaultField) {
                criteria.setFirstResult(first);
                criteria.setMaxResults(pageSize);

                if ((sortField != null) && sortOrder.equals(SortOrder.ASCENDING)) {
                        criteria.addOrder(Order.asc(sortField));
                }
                else if ((sortField != null) && sortOrder.equals(SortOrder.DESCENDING)) {
                        criteria.addOrder(Order.desc(sortField));
                }
                else if (sortField == null) {
                        criteria.addOrder(Order.asc(defaultField));
                }
        }

        /**
         * Metoda care recupereaza un document din coșul de gunoi.
         * @param document Documentul
         */
        @Override
        public void recupereazaDocument(final Documentul document) {
                document.setDateDeleted(null);
                document.setUserDeleted(null);
                save(document);
        }

        /**
         * Metoda care salveaza un document în baza de date. Ca parametru, primește documentul care trebuie salvat și
         * returnează documentul salvat.
         * @param entity Documentul Document pentru salvare
         * @return document documentul salvat
         */
        @Override
        @Transactional(readOnly = false)
        public Documentul save(final Documentul entity) {
                return documentRepository.save(entity);
        }

        /**
         * Metoda care Salveaza o serie de documente în baza de date. Ca parametru, primește documentele care trebuie
         * salvate și returnează documentele salvate.
         * @param entities Documente de salvat
         * @return lista documentelor salvate
         *
         */
        @Override
        public Iterable<Documentul> save(final Iterable<Documentul> entities) {
                return documentRepository.save(entities);
        }
}