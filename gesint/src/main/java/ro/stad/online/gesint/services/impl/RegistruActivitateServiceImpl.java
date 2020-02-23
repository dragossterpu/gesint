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
import org.springframework.security.core.context.SecurityContextHolder;
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
import ro.stad.online.gesint.util.Utilitati;
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
                        registruActivitate.setTipRegActivitate(RegistruEnum.INREGISTRARE.toString());
                        registruActivitate.setDataInregistrari(new Date());
                        registruActivitate.setDescriere(descriere);
                        registruActivitate.setNumeSectiune(sectiune);
                        registruActivitate.setUsernameRegActividad(utilizator.getUsername());
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
                return this.regActividadRepository.cautareUtilizatorDupaRegistru("%" + infoUtilizator + "%");
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
                                criteria.addOrder(Order.asc(Constante.DATECREATE));
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
                                                        Constante.EROAREMESAJ, Constante.DESCEROAREMESAJ);
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
                                Constante.DATECREATE);

                UtilitatiCriteria.setConditieCriteriaDataMaiMicaSauEgala(filtruRegistru.getDataPana(), criteria,
                                Constante.DATECREATE);

                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruRegistru.getNumeSectiune(), criteria,
                                Constante.NUMESECTIUNE);

                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruRegistru.getTipRegActivitate(), criteria,
                                Constante.TIPREGACTIVITATE);

                UtilitatiCriteria.setConditieCriteriaTextLike(filtruRegistru.getUsernameRegActividad(), criteria,
                                Constante.USERCREATE);

                UtilitatiCriteria.setConditieCriteriaEgalitateLong(filtruRegistru.getIdUtilizator(), criteria,
                                Constante.IDUTILIZATOR);
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
                                                        Constante.EROAREMESAJ, Constante.DESCEROAREMESAJ);
                                }
                        }
                }

        }

        /**
         * Metoda care inregitraza un jurnal de activitate.
         * @param idObiect Long
         * @param descriere String
         * @param ambitul String
         * @param obiect String
         * @param eliminat boolean
         */
        private void inregistrareRegistru(final Long idObiect, final String descriere, final String ambitul,
                        final String obiect, final boolean eliminat) {
                final RegistruEnum operatie = Utilitati.procesarOperacion(idObiect, eliminat);

                final StringBuilder descriereReg = new StringBuilder(operatie.toString());
                descriereReg.append(obiect);
                if (!operatie.equals(RegistruEnum.INREGISTRARE)) {
                        descriereReg.append(idObiect);
                }
                descriereReg.append(" (" + descriere + ") s-a terminat cu succes.");
                inregistrareRegistruActivitate(descriereReg.toString(), operatie.name(), ambitul, null);
        }

        /**
         * Metoda care inregitraza sau actualizeaza un jurnal de activitate.
         * @param idObiect Long
         * @param descriere String
         * @param ambitul String
         * @param obiect String
         */
        @Override
        public void salveazaRegistruInregistrareModificare(final Long idObiect, final String descriere,
                        final String ambitul, final String obiect) {
                inregistrareRegistru(idObiect, descriere, ambitul, obiect, false);
        }

        /**
         * Metoda care inregitraza un jurnal de activitate de tip eliminare.
         * @param idObiect Long
         * @param descriere String
         * @param ambitul String
         * @param obiect String
         */
        @Override
        public void salveazaRegistruEliminare(final Long idObiect, final String descriere, final String ambitul,
                        final String obiect) {
                inregistrareRegistru(idObiect, descriere, ambitul, obiect, true);
        }

        /**
         * Metoda care inregitraza un jurnal de activitate de tip eroare.
         * @param ambitul String
         * @param obiect String
         * @param e Exception
         */
        @Override
        public void salveazaRegistruEroare(final String ambitul, final String obiect, final Exception e) {
                inregistrareRegistruActivitate(
                                Throwables.getStackTraceAsString(e) + Constante.BARAOBLICADREAPTA + obiect,
                                RegistruEnum.EROARE.name(), ambitul, null);
        }

        /**
         * Metoda care inregitraza un jurnal de activitate de tip login ok.
         * @param utilizator Utilizator
         */
        @Override
        public void salveazaRegistruLoginOK(final Utilizator utilizator) {
                inregistrareRegistruActivitate("Logare utilizator: " + utilizator.getUsername(),
                                RegistruEnum.INREGISTRARE.name(), SectiuniEnum.LOGIN.name(), utilizator);
        }

        /**
         * Metoda care inregitraza un jurnal de activitate de tip login ko.
         * @param utilizator String
         */
        @Override
        public void salveazaRegistruLoginKO(final String utilizator) {
                inregistrareRegistruActivitate("Autentificare eronată a utilizatorului : " + utilizator,
                                RegistruEnum.EROARE.name(), "LOGIN", null);
        }

        /**
         * Metoda care inregistreaza un jurnal de actiovitate
         * @param sectiune SectiuniEnum
         * @param tip String
         * @param descriere String
         */
        @Override
        public void inregistrareActivitate(final String sectiune, final String tip, final String descriere) {
                final RegistruActivitate reg = new RegistruActivitate();
                final Utilizator utilizator = (Utilizator) SecurityContextHolder.getContext().getAuthentication()
                                .getPrincipal();
                reg.setDataInregistrari(new Date());
                reg.setNumeSectiune(sectiune);
                reg.setTipRegActivitate(RegistruEnum.INREGISTRARE.name());
                reg.setUsernameRegActividad(utilizator.getUsername());
                this.regActividadRepository.save(reg);

        }

        /**
         * Metoda care inregistreaza un jurnal de activitate de tip eroare
         * @param sectiune SectiuniEnum
         * @param tip String
         * @param descriere String
         */
        @Override
        public void inregistrareEroare(final String seccion, final Exception exception) {
                final RegistruActivitate reg = new RegistruActivitate();
                final Utilizator utilizator = (Utilizator) SecurityContextHolder.getContext().getAuthentication()
                                .getPrincipal();
                reg.setDataInregistrari(new Date());
                reg.setNumeSectiune(seccion);
                reg.setTipRegActivitate(RegistruEnum.EROARE.name());
                reg.setUsernameRegActividad(utilizator.getUsername());
                this.regActividadRepository.save(reg);

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
