package ro.stad.online.gesint.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.primefaces.model.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mitchellbosecke.pebble.error.PebbleException;

import lombok.NoArgsConstructor;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.model.filters.FiltruCorespondenta;
import ro.stad.online.gesint.persistence.entities.Corespondenta;
import ro.stad.online.gesint.persistence.entities.Documentul;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.repositories.CorespondentaRepository;
import ro.stad.online.gesint.services.CorespondentaService;
import ro.stad.online.gesint.util.EMail;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.UtilitatiCriteria;

/**
 * Implementarea metodelor definite în interfața CorespondentaService.
 * @author STAD
 *
 */
@NoArgsConstructor
@Service
@Transactional
public class CorespondentaServiceImpl implements CorespondentaService, Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Session de criteria.
         */
        @Autowired
        private transient SessionFactory sessionFactory;

        /**
         * Repository de corespondente.
         */
        @Autowired
        private transient CorespondentaRepository corespondentaRepository;

        /**
         * Clase para el envío de mails.
         */
        @Autowired
        private transient EMail mailCorespondentaSender;

        /**
         * Session.
         */
        private Session session;

        /**
         * Constructor usado para el test.
         *
         * @param sessionFact Factoría de sesiones
         */
        public CorespondentaServiceImpl(final SessionFactory sessionFact) {
                sessionFactory = sessionFact;
        }

        /**
         * Metoda care caută Corespondenta cu parametrii din filtru.
         * @param filtruCorespondenta FiltruCorespondenta
         * @param sortOrder SortOrder
         * @param sortField String
         * @param pageSize int
         * @param first int
         * @return List<Corespondenta>
         */
        @Override
        public List<Corespondenta> cautareCorespondenteCriteria(final int first, final int pageSize,
                        final String sortField, final SortOrder sortOrder,
                        final FiltruCorespondenta filtruCorespondenta) {
                try {
                        session = sessionFactory.openSession();
                        final Criteria criteria = session.createCriteria(Corespondenta.class);
                        creaCriteria(filtruCorespondenta, criteria);
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
                        @SuppressWarnings(Constante.UNCHECKED)
                        final List<Corespondenta> corespondenteList = criteria.list();

                        return corespondenteList;
                }
                finally {
                        if ((session != null) && session.isOpen()) {
                                try {
                                        session.close();
                                }
                                catch (final DataAccessException e) {
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                                }
                        }
                }

        }

        /**
         * Metoda care verifica criteriile pentru căutarea corespondentelor.
         *
         * @param criteria consulta criteria
         * @param filtruCorespondenta Obiect care conține parametrii de căutare
         */
        private void creaCriteria(final FiltruCorespondenta filtruCorespondenta, final Criteria criteria) {
                UtilitatiCriteria.setConditieCriteriaTextLike(filtruCorespondenta.getDestinatar(), criteria,
                                "destinatari");
                UtilitatiCriteria.setConditieCriteriaTextLike(filtruCorespondenta.getTitlu(), criteria,
                                Constante.TITLU);
                UtilitatiCriteria.setConditieCriteriaEgalitateLong(filtruCorespondenta.getId(), criteria, Constante.ID);
                UtilitatiCriteria.setConditieCriteriaDataMaiMare(filtruCorespondenta.getDateFromSend(), criteria,
                                Constante.SENDDATE);
                UtilitatiCriteria.setConditieCriteriaDataMaiMicaSauEgala(filtruCorespondenta.getDateUntilSend(),
                                criteria, Constante.SENDDATE);
                UtilitatiCriteria.setConditieCriteriaDataMaiMare(filtruCorespondenta.getDateFromCreated(), criteria,
                                Constante.DATECREATE);
                UtilitatiCriteria.setConditieCriteriaDataMaiMicaSauEgala(filtruCorespondenta.getDateUntilCreated(),
                                criteria, Constante.DATECREATE);
                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruCorespondenta.getTipCorespondenta(), criteria,
                                "tipCorespondenta");

        }

        /**
         * Metoda care trimite corespondenta în mod individual.
         * @param corespondenta Corespondenta
         * @param documenteIncarcate List<Documentul>
         * @param sablon String
         * @param paramSablon Map<String, String>
         * @throws PebbleException
         */
        @Override
        public void trimitereCorespondenta(final Corespondenta corespondenta,
                        final List<Utilizator> utilizatoriSelectionati, final List<Documentul> documenteIncarcate,
                        final String sablon, final Map<String, String> paramSablon) throws PebbleException {
                final Corespondenta corespondentaLocal = new Corespondenta();
                BeanUtils.copyProperties(corespondenta, corespondentaLocal);
                mailCorespondentaSender.send(corespondentaLocal, utilizatoriSelectionati, documenteIncarcate, sablon,
                                paramSablon);
        }

        /**
         * Metoda care obținețe numărul de registre dinbaza de date
         * @param filtruCorespondenta FiltruCorespondenta
         * @return int
         */
        @Override

        public int getCounCriteria(final FiltruCorespondenta filtruCorespondenta) {
                try {
                        session = sessionFactory.openSession();
                        final Criteria crite = session.createCriteria(Corespondenta.class);
                        creaCriteria(filtruCorespondenta, crite);
                        crite.setProjection(Projections.rowCount());
                        final Long count = (Long) crite.uniqueResult();

                        return Math.toIntExact(count);
                }
                finally {
                        if ((session != null) && session.isOpen()) {
                                try {
                                        session.close();
                                }
                                catch (final DataAccessException e) {
                                        FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                        RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                                }
                        }
                }

        }

        /**
         * Metoda care inregistreaza o corespondent
         * @param corespondenta Corespondenta
         * @return Corespondenta
         */
        @Override
        @Transactional(readOnly = false)
        public Corespondenta save(final Corespondenta corespondenta) {
                return corespondentaRepository.save(corespondenta);
        }

        /**
         * Eliminarea unei corespondente
         * @param id corespondenta
         */
        @Override
        @Transactional(readOnly = false)
        public void delete(final Long id) {
                this.corespondentaRepository.delete(id);
        }

        /**
         * Cauta o corespondenta
         * @param corespondenta Corespondenta
         * @return corespondenta Corespondenta
         */
        @Override
        public Corespondenta fiindOne(final Corespondenta corespondenta) {
                corespondentaRepository.findOne(corespondenta.getId());
                return corespondenta;
        }

}
