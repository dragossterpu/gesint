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
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.model.filters.FiltruSondaj;
import ro.stad.online.gesint.persistence.entities.Sondaj;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.enums.SituatieSondajEnum;
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
@Slf4j
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
        @Transactional
        public List<Sondaj> cautareSondajeCriteria(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder, final FiltruSondaj filtruSondaj) {
                try {

                        this.session = this.sessionFactory.openSession();
                        final Criteria criteria = this.session.createCriteria(Sondaj.class);
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
                        if ((this.session != null) && this.session.isOpen()) {
                                try {
                                        this.session.close();
                                }
                                catch (final DataAccessException e) {
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
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
                                Constante.DATAINCEPERE);
                UtilitatiCriteria.setConditieCriteriaDataMaiMicaSauEgala(filtruSondaj.getDataPanaSondaj(), criteria,
                                Constante.DATAINCEPERE);
                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruSondaj.getActiv(), criteria, Constante.ACTIV);
                UtilitatiCriteria.setConditieCriteriaDataMaiMare(filtruSondaj.getDateFromCreated(), criteria,
                                Constante.DATECREATE);
                UtilitatiCriteria.setConditieCriteriaDataMaiMicaSauEgala(filtruSondaj.getDateUntilCreated(), criteria,
                                Constante.DATECREATE);
                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruSondaj.getTipSondaj(), criteria, "tipSondaj");

        }

        /**
         * Metoda care cauta un sondaj
         * @param sondaj Sondaj
         * @return sondaj Sondaj
         */
        @Override
        public Sondaj fiindOne(final Sondaj sond) {
                return this.sondajRepository.findOne(sond.getId());
        }

        /**
         * Metodă care obține numărul de registre din baza de date
         * @param filtruSondaj FiltruSondaj
         * @return cnt Long
         */
        @Override
        public int getCounCriteria(final FiltruSondaj filtruSondaj) {
                try {
                        this.session = this.sessionFactory.openSession();
                        final Criteria crit = this.session.createCriteria(Sondaj.class);
                        creaCriteria(filtruSondaj, crit);
                        crit.setProjection(Projections.rowCount());
                        final Long cnt = (Long) crit.uniqueResult();
                        return Math.toIntExact(cnt);
                }
                finally {
                        if ((this.session != null) && this.session.isOpen()) {
                                try {
                                        this.session.close();
                                }
                                catch (final DataAccessException e) {
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                                        log.error(RegistruEnum.EROARE.getDescriere()
                                                        .concat(" a aparut o eroare la accesarea bazei de date"));
                                }
                        }
                }

        }

        /**
         * Metodă care salvează sau actualizează un sondaj
         * @param sondaj Sondaj
         * @return sondaj Sondaj
         */
        @Override
        @Transactional(readOnly = false)
        public Sondaj save(final Sondaj sond) {
                return this.sondajRepository.save(sond);
        }

        /**
         * Metodă care obține numărul de registre din baza de date
         * @return List<Sondaj>
         */
        @SuppressWarnings("unchecked")
        @Override
        public List<Sondaj> cautareSondajeFinalizate() {
                try {
                        this.session = this.sessionFactory.openSession();
                        final Criteria crit = this.session.createCriteria(Sondaj.class);
                        UtilitatiCriteria.setConditieCriteriaDataMaiMicaSauEgala(new Date(), crit, "dataFinalizare");
                        UtilitatiCriteria.setConditieCriteriaEgalitateEnum(SituatieSondajEnum.ACTIV, crit,
                                        Constante.ACTIV);
                        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                        return crit.list();
                }
                finally {
                        if ((this.session != null) && this.session.isOpen()) {
                                try {
                                        this.session.close();
                                }
                                catch (final DataAccessException e) {
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                                        log.error(RegistruEnum.EROARE.getDescriere()
                                                        .concat(" a aparut o eroare la accesarea bazei de date"));
                                }
                        }
                }
        }

        /**
         * Metodă care se folosește pentru a căuta sondaje programate pentru a le activa.
         * @return List<Sondaj>
         */
        @SuppressWarnings("unchecked")
        @Override
        public List<Sondaj> cautareSondajePentruActivare() {
                try {
                        this.session = this.sessionFactory.openSession();
                        final Criteria crit = this.session.createCriteria(Sondaj.class);
                        UtilitatiCriteria.setConditieCriteriaDataMaiMicaSauEgala(new Date(), crit, "dataIncepere");
                        UtilitatiCriteria.setConditieCriteriaEgalitateEnum(SituatieSondajEnum.NEINCEPUT, crit,
                                        Constante.ACTIV);
                        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                        return crit.list();
                }
                finally {
                        if ((this.session != null) && this.session.isOpen()) {
                                try {
                                        this.session.close();
                                }
                                catch (final DataAccessException e) {
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                                        log.error(RegistruEnum.EROARE.getDescriere()
                                                        .concat(" a apărut o eroare la accesarea bazei de date"));
                                }
                        }
                }
        }

}
