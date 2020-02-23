package ro.stad.online.gesint.services.impl;

import java.io.Serializable;
import java.util.Date;
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
import ro.stad.online.gesint.model.filters.FiltruSondaj;
import ro.stad.online.gesint.persistence.entities.Sondaj;
import ro.stad.online.gesint.persistence.repositories.SondajRepository;
import ro.stad.online.gesint.services.SondajService;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.UtilitatiCriteria;

/**
 * Implementarea metodelor definite în interfața SondajService.
 * @author STAD
 *
 */
@NoArgsConstructor
@Service
@Transactional
public class SondajServiceImpl implements SondajService, Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * sessionFactory.
         */
        @Autowired
        private transient SessionFactory sessionFactory;

        /**
         * Repository de sondaje.
         */
        @Autowired
        private transient SondajRepository sondajRepository;

        /**
         * Session.
         */
        private Session session;

        /**
         * @param sessionFact Factoría de sesiones
         */
        public SondajServiceImpl(final SessionFactory sessionFact) {
                sessionFactory = sessionFact;
        }

        /**
         * Metoda care cauta în baza de date pe baza parametrilor primiți. Cautarea este paginată in server.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul dupa care sunt sortate rezultatele
         * @param sortOrder direcția de ordonare (ascendent / descendent)
         * @param filtruDocument FiltruDocument Obiect care conține criteriile de căutare
         * @return Lista de sondajeList<Sondaj>
         *
         */
        @SuppressWarnings(Constante.UNCHECKED)
        @Override
        public List<Sondaj> cautareSondajeCriteria(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder, final FiltruSondaj filtruSondaj) {
                try {

                        session = sessionFactory.openSession();
                        final Criteria criteria = session.createCriteria(Sondaj.class, "sondaj");
                        creaCriteria(filtruSondaj, criteria);
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
                                criteria.addOrder(Order.desc(Constante.DATECREATE));
                        }
                        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
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
         * Metoda care verifica criteriile pentru căutarea sondajelor.
         * @param criteria consulta criteria
         * @param filtruSondaj Obiect care conține parametrii de căutare
         */
        private void creaCriteria(final FiltruSondaj filtruSondaj, final Criteria criteria) {
                UtilitatiCriteria.setConditieCriteriaTextLike(filtruSondaj.getDescriere(), criteria, "descriere");
                UtilitatiCriteria.setConditieCriteriaTextLike(filtruSondaj.getIntrebare(), criteria, "intrebare");
                UtilitatiCriteria.setConditieCriteriaEgalitateLong(filtruSondaj.getId(), criteria, Constante.ID);
                UtilitatiCriteria.setConditieCriteriaDataMaiMare(filtruSondaj.getDataDinSondaj(), criteria,
                                Constante.DATAINCEPÈRE);
                UtilitatiCriteria.setConditieCriteriaDataMaiMicaSauEgala(filtruSondaj.getDataPanaSondaj(), criteria,
                                Constante.DATAINCEPÈRE);
                UtilitatiCriteria.setConditieCriteriaEgalitateBoolean(filtruSondaj.getActiv(), criteria, "activ");
                UtilitatiCriteria.setConditieCriteriaDataMaiMare(filtruSondaj.getDateFromCreated(), criteria,
                                Constante.DATECREATE);
                UtilitatiCriteria.setConditieCriteriaDataMaiMicaSauEgala(filtruSondaj.getDateUntilCreated(), criteria,
                                Constante.DATECREATE);
                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruSondaj.getTipSondaj(), criteria, "tipSondaj");
                // daca este null nu a fst selectrata situatia sondajului

                if (filtruSondaj.getValidat() != null) {
                        if (filtruSondaj.getValidat()) {
                                criteria.add(Restrictions.isNull(Constante.DATEDELETED));
                        }
                        else {
                                criteria.add(Restrictions.isNotNull(Constante.DATEDELETED));
                        }
                }
        }

        /**
         * Metoda care cauta un sondaj
         * @param sondaj Sondaj
         * @return sondaj Sondaj
         */
        @Override
        public Sondaj fiindOne(final Sondaj sondaj) {
                return sondajRepository.findOne(sondaj.getId());
        }

        /**
         * Metoda care obține numărul de registre din baza de date
         * @param filtruSondaj FiltruSondaj
         * @return int
         */
        @Override
        public int getCounCriteria(final FiltruSondaj filtruSondaj) {
                try {
                        session = sessionFactory.openSession();
                        final Criteria crit = session.createCriteria(Sondaj.class);
                        creaCriteria(filtruSondaj, crit);
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
         * Metoda care salveaza sau actualizeaza un sondaj
         * @param sondaj Sondaj
         * @return sondaj Sondaj
         */
        @Override
        @Transactional(readOnly = false)
        public Sondaj save(final Sondaj sondaj) {
                return sondajRepository.save(sondaj);
        }

        /**
         * Metoda care obține numărul de registre din baza de date
         * @param filtruSondaj FiltruSondaj
         * @return List<Sondaj>
         */
        @SuppressWarnings("unchecked")
        @Override
        public List<Sondaj> cautareSondajeFinalizate() {
                try {
                        session = sessionFactory.openSession();
                        final Criteria crit = session.createCriteria(Sondaj.class);
                        UtilitatiCriteria.setConditieCriteriaDataMaiMicaSauEgala(new Date(), crit, "dataFinalizare");
                        UtilitatiCriteria.setConditieCriteriaEgalitateBoolean(true, crit, "activ");
                        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                        return crit.list();
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

}
