package ro.stad.online.gesint.services.impl;

import java.io.IOException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.repositories.JudetRepository;
import ro.stad.online.gesint.services.CriteriaService;
import ro.stad.online.gesint.services.JudetService;

/**
 * Implementarea serviciului de judete.
 *
 * @author STAD
 *
 */
@Service
public class JudetServiceImpl implements JudetService {

        /**
         * Repositoriu de Judet.
         */
        @Autowired
        private JudetRepository judetRepository;

        /**
         * Session.
         */
        private Session session;

        /**
         * Session. SessionFactory
         */
        @Autowired
        private transient SessionFactory sessionFactory;

        /**
         * Serviciu pentru a utiliza metodele utilizate împreună cu criteria.
         */
        @Autowired
        private transient CriteriaService criteriaService;

        /**
         * Acesta primește un fișier UploadedFile și datele necesare pentru a genera un Documentul, dar nu îl stochează
         * într-o bază de date. Lăsați obiectul gata să îl salveze.
         * @param file byte[] fișier de încărcat în bază de date
         * @param judet Judet
         * @return document incarcat în bază de date
         * @throws IOException
         */
        @Override
        public Judet incarcareImaginaFaraStocare(final byte[] file, final Judet judet) throws IOException {
                return creareImagine(file, judet);
        }

        /**
         * Incarcam fotografia judetului
         * @param fileBlob byte[]
         * @param judet
         * @return Judet judet
         */
        private void incarcareDatePersonaleUser(final byte[] fileBlob, final Judet judet) {
                judet.setPhoto(fileBlob);
        }

        /**
         * Incarcam imaginea provinciei.
         *
         * @param file Fichero subido por el usuario.
         * @param judetul caruia se asociaza imaginea.
         * @return judet
         * @throws DataAccessException Excepción SQL
         * @throws IOException Excepción entrada/salida
         */
        private Judet creareImagine(final byte[] file, final Judet judet) throws IOException {
                incarcareDatePersonaleUser(file, judet);
                judetRepository.save(judet);
                return judet;
        }

        /**
         * Metoda care returneaza toate judetele inregistrate in baza de date.
         * @return lista de judete
         */
        @Override
        public List<Judet> fiindAll() {
                return judetRepository.findAllByOrderByNumeAsc();
        }

        /**
         * Cauta un judet
         * @param judet Judetul
         * @return Judet judet
         */
        @Override
        public Judet fiindOne(final Judet judet) {
                judetRepository.findOne(judet.getIndicator());
                return judet;
        }

        /**
         * Cauta un judet dupa id
         * @param judet Judetul
         * @return Judet judet
         */
        @Override
        public Judet findById(final String judet) {
                return judetRepository.findOne(judet);
        }

        /**
         * Metoda care cauta un judet dupa nume
         * @param descriere String
         * @retur judet Judet
         */
        @Override
        public Judet findByName(final String descriere) {
                return judetRepository.findByNume(descriere);
        }

        /**
         * Salvați un judet
         * @param judet Judet
         * @return judetul actualizat
         */
        @Override
        @Transactional(readOnly = false)
        public Judet save(final Judet judet) {
                return judetRepository.save(judet);
        }

        /**
         * Metoda care returnează numărul de judete.
         * @return returnează numărul de registre din consultare.
         */
        @Override
        public int getCounCriteria() {
                this.session = this.sessionFactory.openSession();
                final Criteria criteria = this.session.createCriteria(Judet.class, "judet");
                criteria.setProjection(Projections.rowCount());
                final Long cnt = (Long) criteria.uniqueResult();
                this.session.close();
                return Math.toIntExact(cnt);
        }

        /**
         * Metoda care caută de toate județele.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul în care sunt sortate rezultatele
         * @param sortOrder ordine de sortare (crescator / descrescator)
         * @return lista List<Judet> lista de judete.
         */
        @Override
        public List<Judet> cautareJudeteCriteria(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder) {
                this.session = this.sessionFactory.openSession();
                final Criteria criteria = this.session.createCriteria(Judet.class, "judet");
                this.criteriaService.pregatirePaginareOrdenareCriteria(criteria, first, pageSize, sortField, sortOrder,
                                Constante.ID);
                @SuppressWarnings(Constante.UNCHECKED)
                final List<Judet> lista = criteria.list();
                this.session.close();
                return lista;
        }
}
