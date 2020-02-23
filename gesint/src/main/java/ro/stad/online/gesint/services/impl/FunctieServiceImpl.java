package ro.stad.online.gesint.services.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.NoArgsConstructor;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.repositories.FunctieRepository;
import ro.stad.online.gesint.services.CriteriaService;
import ro.stad.online.gesint.services.FunctieService;

/**
 * Implementarea metodelor definite în interfața FunctieService.
 * @author STAD
 *
 */
@NoArgsConstructor
@Service
@Transactional
public class FunctieServiceImpl implements FunctieService, Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Repository de pteam.
         */
        @Autowired
        private transient FunctieRepository functieRepository;

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
         * Eliminarea unei functii
         * @param functie
         */
        @Override
        @Transactional(readOnly = false)
        public void delete(final Functie functie) {
                this.functieRepository.delete(functie);
        }

        /**
         * Cauta toate functiile inregistrate
         */
        @Override
        public List<Functie> fiindAll() {
                return (List<Functie>) functieRepository.findAll();
        }

        /**
         * Salveaza o functie
         * @param functie Functie
         * @return functie
         */
        @Override
        @Transactional(readOnly = false)
        public Functie save(final Functie functie) {
                return functieRepository.save(functie);
        }

        /**
         * Metoda care returnează numărul de functii.
         * @return returnează numărul de registre din consultare.
         */
        @Override
        public int getCounCriteria() {
                this.session = this.sessionFactory.openSession();
                final Criteria criteria = this.session.createCriteria(Functie.class, "functie");
                criteria.setProjection(Projections.rowCount());
                final Long cnt = (Long) criteria.uniqueResult();
                this.session.close();
                return Math.toIntExact(cnt);
        }

        /**
         * Metoda care caută de toate functiile.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul în care sunt sortate rezultatele
         * @param sortOrder ordine de sortare (crescator / descrescator)
         * @return lista List<Functie> lista de functii.
         */
        @Override
        public List<Functie> cautareFunctiiCriteria(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder) {
                this.session = this.sessionFactory.openSession();
                final Criteria criteria = this.session.createCriteria(Functie.class, "functie");
                this.criteriaService.pregatirePaginareOrdenareCriteria(criteria, first, pageSize, sortField, sortOrder,
                                Constante.ID);
                @SuppressWarnings(Constante.UNCHECKED)
                final List<Functie> lista = criteria.list();
                this.session.close();
                return lista;
        }
}
