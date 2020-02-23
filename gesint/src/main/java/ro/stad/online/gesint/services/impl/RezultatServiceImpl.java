package ro.stad.online.gesint.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.NoArgsConstructor;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.model.filters.FiltruRezultat;
import ro.stad.online.gesint.persistence.entities.PartidRezultateJudete;
import ro.stad.online.gesint.persistence.entities.PartidRezultateLocalitate;
import ro.stad.online.gesint.persistence.repositories.RezultatRepository;
import ro.stad.online.gesint.services.JudetService;
import ro.stad.online.gesint.services.PartidService;
import ro.stad.online.gesint.services.RezultatService;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.UtilitatiCriteria;

/**
 * Implementarea metodelor definite în interfața RezultatService.
 * @author STAD
 *
 */
@NoArgsConstructor
@Service
@Transactional
public class RezultatServiceImpl implements RezultatService, Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Session criteria.
         */
        @Autowired
        private transient SessionFactory sessionFactory;

        /**
         * Repository de rezultate.
         */
        @Autowired
        private transient RezultatRepository rezultatRepository;

        /**
         * Variabila utilizata pentru a injecta serviciul de judete.
         *
         */
        @Autowired
        private JudetService judetService;

        /**
         * Variabila utilizata pentru a injecta serviciul partid.
         *
         */
        @Autowired
        private PartidService partidService;

        /**
         * Session.
         */
        private Session session;

        /**
         * Constructor folosit pentru test.
         * @param sessionFact SessionFactory
         */
        public RezultatServiceImpl(final SessionFactory sessionFact) {
                sessionFactory = sessionFact;
        }

        /**
         * Cautare în baza de date pe baza parametrilor primiți. Cautarea este paginată in server.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul dupa care sunt sortate rezultatele
         * @param sortOrder direcția de ordonare (ascendent / descendent)
         * @param filtruRezultat FiltruRezultat Obiect care conține criteriile de căutare
         * @return Lista de documente List<PartidRezultateJudete>
         *
         */
        @SuppressWarnings(Constante.UNCHECKED)
        @Override
        public List<PartidRezultateJudete> cautareRezultatCriteria(final int first, final int pageSize,
                        final String sortField, final SortOrder sortOrder, final FiltruRezultat filtruRezultat) {
                try {
                        session = sessionFactory.openSession();
                        final Criteria criteria = session.createCriteria(PartidRezultateJudete.class,
                                        "partid_rezultat_judet");
                        creaCriteria(filtruRezultat, criteria);
                        criteria.setFirstResult(first);
                        criteria.setMaxResults(pageSize);
                        if (sortField != null) {
                                if (sortOrder.equals(SortOrder.ASCENDING)) {
                                        criteria.addOrder(Order.asc(sortField));
                                }
                                else if (sortOrder.equals(SortOrder.DESCENDING)) {
                                        criteria.addOrder(Order.desc(sortField));
                                }
                        }
                        else {
                                criteria.addOrder(Order.asc("judetul"));
                                criteria.addOrder(Order.desc("procentajTotalVoturi"));
                        }
                        return criteria.list();
                }
                finally {
                        if ((session != null) && session.isOpen()) {
                                try {
                                        session.close();
                                }
                                catch (final DataAccessException e) {
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        Constante.EROAREMESAJ, Constante.DESCEROAREMESAJ);
                                }
                        }
                }

        }

        /**
         * Cautare în baza de date pe baza parametrilor primiți. Cautarea este paginată in server.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul dupa care sunt sortate rezultatele
         * @param sortOrder direcția de ordonare (ascendent / descendent)
         * @param filtruRezultat FiltruRezultat Obiect care conține criteriile de căutare
         * @return Lista de documente List<PartidRezultateJudete>
         *
         */
        @SuppressWarnings(Constante.UNCHECKED)
        @Override
        public List<PartidRezultateLocalitate> cautareRezultatCriteriaLoc(final int first, final int pageSize,
                        final String sortField, final SortOrder sortOrder, final FiltruRezultat filtruRezultat) {
                try {
                        session = sessionFactory.openSession();
                        final Criteria criteria = session.createCriteria(PartidRezultateLocalitate.class,
                                        "partid_rezultat_localitate");
                        creaCriteria(filtruRezultat, criteria);
                        criteria.setFirstResult(first);
                        criteria.setMaxResults(pageSize);
                        if (sortField != null) {
                                if (sortOrder.equals(SortOrder.ASCENDING)) {
                                        criteria.addOrder(Order.asc(sortField));
                                }
                                else if (sortOrder.equals(SortOrder.DESCENDING)) {
                                        criteria.addOrder(Order.desc(sortField));
                                }
                        }
                        else {
                                criteria.addOrder(Order.asc("judetul"));
                                criteria.addOrder(Order.desc("procentajTotalVoturi"));
                        }
                        return criteria.list();
                }
                finally {
                        if ((session != null) && session.isOpen()) {
                                try {
                                        session.close();
                                }
                                catch (final DataAccessException e) {
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        Constante.EROAREMESAJ, Constante.DESCEROAREMESAJ);
                                }
                        }
                }

        }

        /**
         * Metoda care cauta anii alegerilor
         * @return List<Integer>
         */
        @Override
        public List<Integer> cautaAni() {
                return rezultatRepository.cautaAni();

        }

        /**
         * Metoda care verifica criteriile pentru căutarea rezultatelor.
         * @param criteria consulta criteria
         * @param filtruRezultat Obiect care conține parametrii de căutare
         */
        @SuppressWarnings("unlikely-arg-type")
        private void creaCriteria(final FiltruRezultat filtruRezultat, final Criteria criteria) {
                if (filtruRezultat.getIdPartid() != null && !Constante.SPATIU.equals(filtruRezultat.getIdPartid())) {
                        criteria.add(Restrictions.eq("partid", partidService.fiindOne(filtruRezultat.getIdPartid())));
                }
                if (filtruRezultat.getIdProvincia() != null
                                && !filtruRezultat.getIdProvincia().equals(Constante.SPATIU)) {
                        criteria.add(Restrictions.eq("judetul",
                                        judetService.findById(filtruRezultat.getIdProvincia())));
                }
                UtilitatiCriteria.setConditieCriteriaEgalitateInt(filtruRezultat.getAnAlegeri(), criteria, "anAlegeri");
                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruRezultat.getTipAlegeri(), criteria,
                                "tipAlegeri");

        }

        /**
         * Metoda care obține numărul de registre din baza de date
         * @param filtruDocument FiltruDocument
         * @return int
         */
        @Override

        public int getCounCriteria(final FiltruRezultat filtruRezultat) {
                try {
                        session = sessionFactory.openSession();
                        final Criteria crit = session.createCriteria(PartidRezultateJudete.class);
                        creaCriteria(filtruRezultat, crit);
                        crit.setProjection(Projections.rowCount());
                        final Long cnt = (Long) crit.uniqueResult();

                        return Math.toIntExact(cnt);
                }
                finally {
                        if ((session != null) && session.isOpen()) {
                                try {
                                        session.close();
                                }
                                catch (final DataAccessException e) {
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        Constante.EROAREMESAJ, Constante.DESCEROAREMESAJ);
                                }
                        }
                }

        }

        /**
         * Metoda care salveaza sau actualizeaza un registru in baza dedate.
         * @param rezultat PartidRezultateJudete
         * @return PartidRezultateJudete
         */
        @Override
        @Transactional(readOnly = false)
        public PartidRezultateJudete save(final PartidRezultateJudete rezultat) {
                return rezultatRepository.save(rezultat);
        }

        /**
         * Metoda care cauta un partid dupa id
         * @param idPartid Long
         * @return partid PartidRezultateJudete
         */
        @Override
        public PartidRezultateJudete fiindOne(final Long idPartid) {
                return rezultatRepository.findOne(idPartid);
        }
}
