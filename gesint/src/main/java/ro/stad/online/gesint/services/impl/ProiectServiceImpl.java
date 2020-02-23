package ro.stad.online.gesint.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.model.filters.FiltruProiect;
import ro.stad.online.gesint.persistence.entities.Proiect;
import ro.stad.online.gesint.persistence.repositories.ProiectRepository;
import ro.stad.online.gesint.services.ProiectService;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.UtilitatiCriteria;

/**
 * Implementarea metodelor definite în interfața ProiectService.
 *
 * @author STAD
 */

@Service
@Transactional
public class ProiectServiceImpl implements ProiectService {

        /**
         * Variabilă utilizată pentru a injecta repository de proprietăți.
         */
        @Autowired
        private ProiectRepository proiectRepository;

        /**
         * SessionFactory.
         */
        @Autowired
        private transient SessionFactory sessionFactory;

        /**
         * Session.
         */

        private Session session;

        /**
         * Metodă care caută în baza de date pe baza parametrilor primiți. Cautarea este paginată in server.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul dupa care sunt sortate rezultatele
         * @param sortOrder direcția de ordonare (ascendent / descendent)
         * @param filtruProiect FiltruProiect Obiect care conține criteriile de căutare
         * @return Lista de proiecte List<Proiect>
         *
         */
        @SuppressWarnings("unchecked")
        @Override
        public List<Proiect> cautareProiecteCriteria(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder, final FiltruProiect filtruProiect) {
                try {
                        session = sessionFactory.openSession();
                        final Criteria criteria = session.createCriteria(Proiect.class, Constante.PROIECTE);
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
                                criteria.addOrder(Order.asc("rank"));
                        }
                        List<Proiect> proiecteList;
                        creaCriteria(filtruProiect, criteria);

                        proiecteList = criteria.list();
                        session.close();
                        return proiecteList;
                }
                finally {
                        closeSession();
                }
        }

        /**
         * Managementul și închiderea sesiunii.
         */
        private void closeSession() {
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

        /**
         * Metoda care verifica criteriile pentru căutarea.
         * @param criteria consulta criteria
         * @param filtruProiect Obiect care conține parametrii de căutare
         */
        private void creaCriteria(final FiltruProiect filtruProiect, final Criteria criteria) {
                UtilitatiCriteria.setConditieCriteriaDataMaiMare(filtruProiect.getDateFrom(), criteria,
                                Constante.DATECREATE);
                UtilitatiCriteria.setConditieCriteriaDataMaiMicaSauEgala(filtruProiect.getDateUntil(), criteria,
                                Constante.DATECREATE);
                UtilitatiCriteria.setConditieCriteriaTextLike(filtruProiect.getNume(), criteria, "titlu");
                UtilitatiCriteria.setConditieCriteriaTextLike(filtruProiect.getUsername(), criteria, "usuario");
                criteriaMateriaIndexada(criteria, filtruProiect.getMateriaIndexata());
                UtilitatiCriteria.setConditieCriteriaEgalitateBoolean(filtruProiect.getValidat(), criteria,
                                Constante.VALIDAT);
                criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        }

        /**
         * Metoda care adăuga in criteriile filtrului materia indexat introdusa în formular.
         * @param criteria Criteria
         * @param materiaIndexada materia indexată introdusă în filtru (separată prin virgule)
         */
        private void criteriaMateriaIndexada(final Criteria criteria, final String materiaIndexada) {
                if (materiaIndexada != null) {
                        final String[] chei = materiaIndexada.split(Constante.VIRGULA);
                        final Criterion[] cheiOr = new Criterion[chei.length];
                        for (int i = 0; i < chei.length; i++) {
                                cheiOr[i] = Restrictions.ilike("materiaIndexata", chei[i].trim(), MatchMode.ANYWHERE);
                        }
                        criteria.add(Restrictions.or(cheiOr));
                }
        }

        /**
         * Metoda care elimina un proiect
         * @param proiect Proiect
         */
        @Override
        public void delete(final Proiect proiect) {
                proiectRepository.delete(proiect);
        }

        /**
         * Metoda care returneaza toate proiectele inregistrate
         * @return lista List<Proiect>
         */
        @Override
        public List<Proiect> findAll() {
                return (List<Proiect>) proiectRepository.findAll();
        }

        /**
         * Metoda care obținețe numărul de registre din baza de date
         * @param filtruProiect FiltruProiect
         * @return int
         */
        @Override
        public int getCounCriteria(final FiltruProiect filtruProiect) {
                try {
                        session = sessionFactory.openSession();
                        final Criteria teria = session.createCriteria(Proiect.class, Constante.PROIECTE);
                        creaCriteria(filtruProiect, teria);
                        teria.setProjection(Projections.rowCount());
                        final Long cnt = (Long) teria.uniqueResult();
                        return Math.toIntExact(cnt);
                }
                finally {
                        closeSession();
                }
        }

        /**
         * Metoda care salveaza sau actualizeaza un proiect.
         * @param proiect Proiect
         * @return Proiect actualizat
         */
        @Override
        public Proiect save(final Proiect proiect) {
                final Proiect proiectActualizado = proiectRepository.save(proiect);
                return proiectActualizado;

        }

        /**
         * Metoda care cauta toate proiectele ordonate dupa nivel de la mare la mic
         * @return lista List<Proiect>
         */
        @Override
        public List<Proiect> findAllByOrderByRankDesc() {
                return (ArrayList<Proiect>) proiectRepository.findAllByOrderByRankAsc();
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
        public void pregatirePaginareOrdenareCriteria(final Criteria criteria, final int first, final int pageSize,
                        final String sortField, final SortOrder sortOrder, final String defaultField) {
                criteria.setFirstResult(first);
                criteria.setMaxResults(pageSize);

                if (sortField != null && sortOrder.equals(SortOrder.ASCENDING)) {
                        criteria.addOrder(Order.asc(sortField));
                }
                else if (sortField != null && sortOrder.equals(SortOrder.DESCENDING)) {
                        criteria.addOrder(Order.desc(sortField));
                }
                else if (sortField == null) {
                        criteria.addOrder(Order.asc(defaultField));
                }
        }
}
