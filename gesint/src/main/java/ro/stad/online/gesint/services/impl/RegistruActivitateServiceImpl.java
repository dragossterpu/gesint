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

import com.google.common.base.Throwables;

import lombok.NoArgsConstructor;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.model.filters.FiltruRegistru;
import ro.stad.online.gesint.persistence.entities.RegistruActivitate;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;
import ro.stad.online.gesint.persistence.repositories.RegistruActivitateRepository;
import ro.stad.online.gesint.services.RegistruActivitateService;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.UtilitatiCriteria;

/**
 *
 * Implementarea serviciului de RegistruActivitateService
 *
 * @author STAD
 *
 */

@NoArgsConstructor
@Service("registruActivitateService")
public class RegistruActivitateServiceImpl implements RegistruActivitateService, Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Session.
         */
        private Session session;

        /**
         * Repository de registru de activitate.
         */
        @Autowired
        private transient RegistruActivitateRepository regActividadRepository;

        /**
         * SessionFactory.
         */
        @Autowired
        private transient SessionFactory sessionFactory;

        /**
         * Constructor folosit pentru test.
         * @param sessionFact SessionFactory
         */
        public RegistruActivitateServiceImpl(final SessionFactory sessionFact) {
                this.sessionFactory = sessionFact;
        }

        /**
         * Metoda care înregistrează un jurnal de activitate.
         * @param sectiune String
         * @param tipReg String
         * @param descriere String
         * @param utilizator Utilizator
         */
        @Override
        public void inregistrareRegistruActivitate(final String descriere, final String tipReg, final String sectiune,
                        final Utilizator utilizator) {
                try {
                        final RegistruActivitate registruActivitate = new RegistruActivitate();
                        registruActivitate.setTipRegActivitate(RegistruEnum.valueOf(tipReg));
                        registruActivitate.setDataInregistrari(new Date());
                        registruActivitate.setDescriere(descriere);
                        registruActivitate.setNumeSectiune(SectiuniEnum.valueOf(sectiune));
                        if (utilizator.getUsername() != null) {
                                registruActivitate.setUsernameRegActividad(utilizator.getUsername());
                        }
                        else {
                                registruActivitate.setUsernameRegActividad(Constante.SYSTEM);
                        }
                        this.regActividadRepository.save(registruActivitate);
                }
                catch (final DataAccessException e) {
                        salveazaRegistruEroare(sectiune, "RegistruActivitateService", e);
                }

        }

        /**
         * Metoda care inregitraza un jurnal de activitate de tip eliminare.
         * @param infoUtilizator String
         * @return List<String>
         */
        @Override
        public List<String> cautareUtilizatorDupaRegistru(final String infoUtilizator) {
                return this.regActividadRepository.cautareUtilizatorDupaRegistru(
                                Constante.PORCENTAJ.concat(infoUtilizator).concat(Constante.PORCENTAJ));
        }

        /**
         * Metoda care cauta în baza de date pe baza parametrilor primiți. Cautarea este paginată in server.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul dupa care sunt sortate rezultatele
         * @param sortOrder direcția de ordonare (ascendent / descendent)
         * @param filtruRegistru FiltruRegistru Obiect care conține criteriile de căutare
         * @return Lista List<RegistruActivitate>
         *
         */
        @SuppressWarnings(Constante.UNCHECKED)
        @Override
        public List<RegistruActivitate> cautareRegistruActivitateCriteria(final int first, final int pageSize,
                        final String sortField, final SortOrder sortOrder, final FiltruRegistru filtruRegistru) {
                try {
                        this.session = this.sessionFactory.openSession();
                        final Criteria criteria = this.session.createCriteria(RegistruActivitate.class);
                        creaCriteria(filtruRegistru, criteria);

                        criteria.setFirstResult(first);
                        criteria.setMaxResults(pageSize);

                        if (sortField != null && sortOrder.equals(SortOrder.ASCENDING)) {
                                criteria.addOrder(Order.asc(sortField));
                        }
                        else if (sortField != null && sortOrder.equals(SortOrder.DESCENDING)) {
                                criteria.addOrder(Order.desc(sortField));
                        }
                        else if (sortField == null) {

                                criteria.addOrder(Order.asc(Constante.DATAINREGISTRARII));
                        }
                        return criteria.list();
                }
                finally {
                        if (this.session != null) {
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
         * Metoda care verifica criteriile pentru căutarea registrelos de activitate.
         * @param criteria consulta criteria
         * @param filtruRegistru Obiect care conține parametrii de căutare
         */
        private void creaCriteria(final FiltruRegistru filtruRegistru, final Criteria criteria) {

                UtilitatiCriteria.setConditieCriteriaDataMaiMare(filtruRegistru.getDataIncepand(), criteria,
                                Constante.DATAINREGISTRARII);
                UtilitatiCriteria.setConditieCriteriaDataMaiMicaSauEgala(filtruRegistru.getDataPana(), criteria,
                                Constante.DATAINREGISTRARII);
                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruRegistru.getNumeSectiune(), criteria,
                                Constante.NUMESECTIUNE);
                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruRegistru.getTipRegActivitate(), criteria,
                                Constante.TIPREGACTIVITATE);
                UtilitatiCriteria.setConditieCriteriaTextLike(filtruRegistru.getIdUtilizator(), criteria,
                                "usernameRegActividad");

        }

        /**
         * Metoda care obține numărul de registre din baza de date
         * @param filtruRegistru FiltruRegistru
         * @return int
         */
        @Override
        public int getCounCriteria(final FiltruRegistru filtruRegistru) {
                try {
                        this.session = this.sessionFactory.openSession();
                        final Criteria criteria = this.session.createCriteria(RegistruActivitate.class);
                        creaCriteria(filtruRegistru, criteria);
                        criteria.setProjection(Projections.rowCount());
                        final Long cnt = (Long) criteria.uniqueResult();

                        return Math.toIntExact(cnt);
                }
                finally {
                        if (this.session != null) {
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
         * Metoda care inregitraza un jurnal de activitate de tip eroare.
         * @param ambitul String
         * @param obiect String
         * @param e Exception
         */
        @Override
        public void salveazaRegistruEroare(final String descriere, final String sectiune, final Exception e) {
                inregistrareRegistruActivitate(Throwables.getStackTraceAsString(e).concat(Constante.BARAOBLICADREAPTA)
                                .concat(descriere), RegistruEnum.EROARE.name(), sectiune, null);
        }

        /**
         * Metoda care inregitraza un jurnal de activitate de tip login ok.
         * @param utilizator Utilizator
         */
        @Override
        public void salveazaRegistruLoginOK(final Utilizator utilizator) {
                inregistrareRegistruActivitate("Logare utilizator: ".concat(utilizator.getUsername()),
                                RegistruEnum.INREGISTRARE.name(), SectiuniEnum.LOGIN.name(), utilizator);
        }

        /**
         * Metoda care inregitraza un jurnal de activitate de tip login ko.
         * @param utilizator String
         */
        @Override
        public void salveazaRegistruLoginKO(final String utilizator) {
                inregistrareRegistruActivitate("Autentificare eronată a utilizatorului : ".concat(utilizator),
                                RegistruEnum.EROARE.name(), "LOGIN", null);
        }

        /**
         * Metoda care inregistreaza un jurnal de activitate
         * @param entity RegistruActivitate
         */
        @Override
        public void save(final RegistruActivitate entity) {
                this.regActividadRepository.save(entity);
        }

}
