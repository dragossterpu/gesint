package ro.stad.online.gesint.services.impl;

import java.io.IOException;
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

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.model.filters.FiltruEchipa;
import ro.stad.online.gesint.model.filters.FiltruUtilizator;
import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Localitate;
import ro.stad.online.gesint.persistence.entities.Utilizator;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.pojo.AnNumarPojo;
import ro.stad.online.gesint.persistence.repositories.UtilizatorRepository;
import ro.stad.online.gesint.services.JudetService;
import ro.stad.online.gesint.services.LocalitateService;
import ro.stad.online.gesint.services.ParamEchipaService;
import ro.stad.online.gesint.services.UtilizatorService;
import ro.stad.online.gesint.util.FacesUtilities;
import ro.stad.online.gesint.util.Utilitati;
import ro.stad.online.gesint.util.UtilitatiCriteria;

/**
 * Implementarea serviciului de utilizatori.
 *
 * @author STAD
 *
 */

@Transactional
@Service
public class UtilizatorServiceImpl implements UtilizatorService {

        /**
         * Repository de Utilizator.
         */
        @Autowired
        private UtilizatorRepository utilizatorRepository;

        /**
         * SessionFactory.
         */
        @Autowired
        private SessionFactory sessionFactory;

        /**
         * Session.
         */

        private Session session;

        /**
         * Variabila utilizata pentru a injecta serviciul judetului.
         *
         */
        @Autowired
        private JudetService judetService;

        /**
         * Variabila utilizata pentru a injecta serviciul functilor.
         *
         */
        @Autowired
        private ParamEchipaService paramEchipaService;

        /**
         * Variabila utilizata pentru a injecta serviciul localitatilor.
         *
         */
        @Autowired
        private LocalitateService localitateService;

        /**
         * Utilidades.
         */
        @Autowired
        private Utilitati utilitati;

        /**
         * Metoda care stabileste o lista de utilizatori pentru eliminarea logica.
         * @param listaUtilizatori Lista de utilizatori
         * @return lista de utilizatori
         */
        @Override
        public List<Utilizator> bajaLogica(final List<String> listaUtilizatori) {
                final Date fecha = new Date();
                final List<Utilizator> listaSalvare = utilizatorRepository.findByUsernameIn(listaUtilizatori);
                for (final Utilizator utilizator : listaSalvare) {
                        utilizator.setDateDeleted(fecha);
                        utilizator.setUserDeleted(utilitati.getUtilizatorLogat().getUsername());
                }
                return (List<Utilizator>) utilizatorRepository.save(listaSalvare);
        }

        /**
         * Metoda care returneaza o lista cu numele utilizatorilor care sunt in baza de date.
         * @param listaNume lista cu numele utilizatorilor
         * @return lista cu numele utilizatorilor List<String>
         */
        @Override
        public List<String> cautareListaNumeUtilizator(final List<String> listaNume) {
                return utilizatorRepository.findUsernamesByUsername(listaNume);
        }

        /**
         * Metoda care cauta utilizatori cu criteria fara paginare.
         * @param filtruUtilizator FiltruUtilizator
         * @return lista de utilizatori
         */
        @SuppressWarnings(Constante.UNCHECKED)
        @Override
        public List<Utilizator> cautareUtilizator(final FiltruUtilizator filtruUtilizator) {
                try {
                        session = sessionFactory.openSession();
                        final Criteria criteria = session.createCriteria(Utilizator.class);
                        creaCriteria(filtruUtilizator, criteria);
                        return criteria.list();
                }
                finally {
                        session.close();
                }
        }

        /**
         * Metoda care cauta în baza de date pe baza parametrilor primiți. Cautarea este paginată in server.
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul dupa care sunt sortate rezultatele
         * @param sortOrder direcția de ordonare (ascendent / descendent)
         * @param filtruUtilizator FiltruUtilizator Obiect care conține criteriile de căutare
         * @return Lista de utilizatori List<Utilizator>
         *
         */
        @SuppressWarnings(Constante.UNCHECKED)
        @Override
        public List<Utilizator> cautareUtilizatorCriteria(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder, final FiltruUtilizator filtruUtilizator) {
                try {
                        this.session = this.sessionFactory.openSession();
                        final Criteria criteria = this.session.createCriteria(Utilizator.class, "utilizator");
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
                        creaCriteria(filtruUtilizator, criteria);

                        return criteria.list();
                }
                finally {
                        closeSession();
                }
        }

        /**
         * Metoda care cauta utilizatori folosind parametrii din filtru.
         * @param filtruUtilizator FiltruUtilizator
         * @return lista List<Utilizator>
         */
        @Override
        public List<Utilizator> cautareUtilizatorCriteria(final FiltruUtilizator filtruUtilizator) {
                try {
                        this.session = this.sessionFactory.openSession();
                        final Criteria criteria = this.session.createCriteria(Utilizator.class);
                        return gestionareCriteriaUtilizatori(filtruUtilizator, criteria);
                }
                finally {
                        closeSession();
                }
        }

        /**
         * Metoda care cauta utilizatori conducere locala folosind parametrii din filtru.
         * @param filtruEchipa FiltruEchipa
         * @return lista List<Utilizator>
         */
        @Override
        public List<Utilizator> cautareUtilizatorCriteriaLocal(final FiltruEchipa filtruEchipa) {
                try {
                        this.session = this.sessionFactory.openSession();
                        final Criteria criteria = this.session.createCriteria(Utilizator.class);
                        criteria.addOrder(Order.asc("rank"));
                        return gestionareCriteriaUtilizatoriLocal(filtruEchipa, criteria);
                }
                finally {
                        closeSession();
                }
        }

        /**
         * Metodă care primeste un fișier din care se recupereaza datele pentru a genera un Document care va fi stocat
         * în baza de date. Lasă obiectul pregatit pentru salvare.
         * @param file byte[] fisier care se va stoca in baza de date
         * @param utilizator Utilizator
         * @return Document document stocat in bbdd
         */
        @Override
        public Utilizator incarcareImaginaFaraStocare(final byte[] file, final Utilizator user) throws IOException {
                return creareImagine(file, user);
        }

        /**
         * Metoda care incarca datele personale ale utilizatorului
         * @param fileBlob byte[] fisier care se va stoca in baza de date
         * @param utilizator Utilizator
         * @return usuario
         */
        private void incarcareDatePersonaleUser(final byte[] fileBlob, final Utilizator utilizator) {
                utilizator.setPhoto(fileBlob);
        }

        /**
         * Metodă care inchide sesiunea.
         */
        private void closeSession() {
                if (this.session != null && this.session.isOpen()) {
                        try {
                                this.session.close();
                        }
                        catch (final DataAccessException e) {
                                FacesUtilities.setMesajConfirmareDialog(FacesMessage.SEVERITY_ERROR,
                                                RegistruEnum.EROARE.getDescriere(), Constante.DESCEROAREMESAJ);
                        }
                }
        }

        /**
         * Metodă care verifică criteriile pentru căutarea utilizatorilor.
         * @param criteria consulta criteria
         * @param filtruUtilizator Obiect care conține parametrii de căutare
         */
        private void creaCriteria(final FiltruUtilizator filtruUtilizator, final Criteria criteria) {
                UtilitatiCriteria.setConditieCriteriaDataMaiMare(filtruUtilizator.getDateFrom(), criteria,
                                Constante.DATECREATE);
                UtilitatiCriteria.setConditieCriteriaDataMaiMicaSauEgala(filtruUtilizator.getDateUntil(), criteria,
                                Constante.DATECREATE);
                UtilitatiCriteria.setConditieCriteriaTextLike(filtruUtilizator.getNume(), criteria, Constante.NUME);
                UtilitatiCriteria.setConditieCriteriaTextLike(filtruUtilizator.getNume(), criteria, Constante.PRENUME);
                UtilitatiCriteria.setConditieCriteriaEgalitateBoolean(filtruUtilizator.getValidat(), criteria,
                                Constante.VALIDAT);
                UtilitatiCriteria.setConditieCriteriaEgalitateBoolean(false, criteria, "destinatarExtern");
                UtilitatiCriteria.setConditieCriteriaTextLike(filtruUtilizator.getIdCard(), criteria, "idCard");
                UtilitatiCriteria.setConditieCriteriaTextLike(filtruUtilizator.getEmail(), criteria, "email");
                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruUtilizator.getRole(), criteria, "role");
                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruUtilizator.getSex(), criteria, "sex");
                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruUtilizator.getStatutCivil(), criteria,
                                "statutCivil");
                if (filtruUtilizator.getTipLocalitate() != null) {
                        criteria.createAlias(Constante.LOCALITATE, Constante.LOCALITATE);
                        UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruUtilizator.getTipLocalitate(),
                                        criteria, "localitate.tipLocalitate");
                }
                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruUtilizator.getEducatie(), criteria,
                                "educatie");
                if (filtruUtilizator.getIdJudet() != null && !filtruUtilizator.getIdJudet().equals(Constante.SPATIU)) {
                        criteria.add(Restrictions.eq("codJudet", judetService.findById(filtruUtilizator.getIdJudet())));
                }
                if (filtruUtilizator.getIdFunctia() != null) {
                        criteria.add(Restrictions.eq(Constante.TEAM,
                                        paramEchipaService.findById(filtruUtilizator.getIdFunctia())));
                }
                if (filtruUtilizator.getIdLocalitate() != null) {
                        criteria.add(Restrictions.eq(Constante.LOCALITATE,
                                        localitateService.findById(filtruUtilizator.getIdLocalitate())));
                }
                final Functie functia = paramEchipaService.findById(30L);
                criteria.add(Restrictions.eq(Constante.TEAM, functia));
                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruUtilizator.getEducatie(), criteria,
                                "educatie");
                if (filtruUtilizator.getEliminat() != null) {
                        extragereUserEliminat(filtruUtilizator, criteria);
                }
        }

        /**
         * Metodă care verifică criteriile pentru căutarea utilizatorilor care aparţin conducerii.
         * @param criteria consulta criteria
         * @param filtruEchipa Obiect care conține parametrii de căutare
         */
        private void creaCriteriaLocal(final FiltruEchipa filtruEchipa, final Criteria criteria) {
                UtilitatiCriteria.setConditieCriteriaDataMaiMare(filtruEchipa.getDataIncepand(), criteria,
                                Constante.DATECREATE);
                UtilitatiCriteria.setConditieCriteriaDataMaiMicaSauEgala(filtruEchipa.getDataPana(), criteria,
                                Constante.DATECREATE);
                UtilitatiCriteria.setConditieCriteriaTextLike(filtruEchipa.getNume(), criteria, Constante.NUME);
                UtilitatiCriteria.setConditieCriteriaTextLike(filtruEchipa.getPrenume(), criteria, Constante.PRENUME);
                UtilitatiCriteria.setConditieCriteriaTextLike(filtruEchipa.getEmail(), criteria, "email");
                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruEchipa.getRole(), criteria, "role");

                if (filtruEchipa.getIdJudet() != null && !filtruEchipa.getIdJudet().equals(Constante.SPATIU)) {
                        criteria.add(Restrictions.eq("codJudet", judetService.findById(filtruEchipa.getIdJudet())));
                }
                if (filtruEchipa.getIdFunctia() != null) {
                        criteria.add(Restrictions.eq(Constante.TEAM,
                                        paramEchipaService.findById(filtruEchipa.getIdFunctia())));
                }
                // Daca nu sa ales o functie le cautam pe toate din conducerea locala

                if (filtruEchipa.getIdFunctia() == null) {
                        criteria.add(Restrictions.in(Constante.TEAM, filtruEchipa.getListaFunctii()));
                }

        }

        /**
         * Metodă care crează documentul.
         * @param file Document incarcat.
         * @param utilizator caruia se asocieaza fisierul.
         * @return utilizator
         * @throws IOException Exceptie intrare/iesire
         */
        private Utilizator creareImagine(final byte[] file, final Utilizator utilizat) {
                incarcareDatePersonaleUser(file, utilizat);
                return utilizatorRepository.save(utilizat);
        }

        /**
         * Metodă care elimină un utilizator.
         * @param username Utilizator
         */
        @Override
        @Transactional(readOnly = false)
        public void delete(final Utilizator username) {
                this.utilizatorRepository.delete(username);
        }

        /**
         * Metodă care modifică un utilizator în inactiv.
         * @param listaUtilizatori Lista de utilizatori pentru modificare
         * @return lista List<Utilizator> lista de utilizatori modificati
         */
        @Override
        public List<Utilizator> dezactivare(final List<String> listaUtilizatori) {
                final List<Utilizator> listaSalvare = utilizatorRepository.findByUsernameIn(listaUtilizatori);
                for (final Utilizator user : listaSalvare) {
                        user.setValidat(false);
                        user.setUserUpdated(utilitati.getUtilizatorLogat().getUsername());
                }
                return (List<Utilizator>) utilizatorRepository.save(listaSalvare);
        }

        /**
         * Metodă care extrage utilizatorii eliminaţi
         * @param filtruUtilizator FiltruUtilizator
         * @param criteria Criteria
         */
        private void extragereUserEliminat(final FiltruUtilizator filtruUtilizator, final Criteria criteria) {
                if (!filtruUtilizator.getEliminat().equals(Constante.SPATIU)) {
                        if (filtruUtilizator.getEliminat().equals(Constante.NO)) {
                                criteria.add(Restrictions.isNull(Constante.DATEDELETED));
                        }
                        else {
                                criteria.add(Restrictions.isNotNull(Constante.DATEDELETED));
                        }
                }
        }

        /**
         * Metodă care returnează toţi utilizatorii inregistraţi în baza de date.
         * @return lista List<Utilizator> lista de utilizatori
         */
        @Override
        public List<Utilizator> fiindAll() {
                return (List<Utilizator>) utilizatorRepository.findAll();
        }

        /**
         * Metodă care returnează utilizatorul inregistrat în baza de date.
         * @param id String
         * @return Utilizator user
         */
        @Override
        public Utilizator fiindOne(final String id) {
                return utilizatorRepository.findOne(id);
        }

        /**
         * Metodă care caută utilizatori dupa email sau documentul de identitate ignorând majuscule.
         * @param email String email dupa care se cauta
         * @param cnp documentul utilizatorului
         * @return lista List<Utilizator> lista cu resultatul cautari
         *
         */
        @Override
        public List<Utilizator> findByEmailIgnoreCaseOrDocIdentitateIgnoreCase(final String email, final String cnp) {
                return utilizatorRepository.findByEmailIgnoreCaseOrIdCardIgnoreCase(email, cnp);
        }

        /**
         * Metodă care caută un utilizator după CNP.
         * @param cnp String - cnp-ul utilizatorului
         * @return User
         */
        @Override
        public Utilizator findByIdCard(final String cnp) {
                return this.utilizatorRepository.findByIdCard(cnp);
        }

        /**
         * Metodă care caută utilizatori după localitate.
         * @param loca Localitate
         * @return lista List<Utilizator>
         */
        @Override
        public List<Utilizator> findByLocality(final Localitate loca) {
                return utilizatorRepository.findByLocalitate(loca);
        }

        /**
         * Metodă care caută utilizatori după nume.
         * @param "destinatar" String
         * @return lista List<Utilizator>
         */
        @Override
        public List<Utilizator> findByName() {
                final String nume = Constante.DESTINATAR;
                return utilizatorRepository.findByNume(nume);
        }

        /**
         * Metodă care caută utilizatori după județ și echipă.
         * @param jude Judet
         * @param listaEchipa List<Functie>
         * @return lista List<Utilizator>
         */
        @Override
        public List<Utilizator> findByJudetSiEchipa(final Judet jude, final List<Functie> listaEchipa) {
                return utilizatorRepository.findByCodJudetAndTeamIn(jude, listaEchipa);
        }

        /**
         * Metodă care caută utilizatori după tipul de echipă.
         * @param functie Functie
         * @return Utilizator utilizator
         */
        @Override
        public Utilizator findByTeam(final Functie functie) {
                return utilizatorRepository.findByTeam(functie);
        }

        /**
         * Metodă care caută utilizatori după tipul de echipa si judet
         * @param functie Functie
         * @param jud Judet
         * @return Utilizator utilizator
         */
        @Override
        public Utilizator findByTeamAndJudet(final Functie functie, final Judet jud) {
                return utilizatorRepository.findByTeamAndCodJudet(functie, jud);
        }

        /**
         * Metoda care obține numărul de registre din baza de date
         * @return Long
         */
        @Override
        public Long findCount() {
                return utilizatorRepository.count();
        }

        /**
         * Metodă care caută utilizatori după tipul de sex
         * @param membru
         * @return int
         */
        @Override
        public int findUsersBySex(final AnNumarPojo membru) {
                try {
                        this.session = this.sessionFactory.openSession();
                        final Criteria critteria = this.session.createCriteria(Utilizator.class, "user");
                        critteria.add(Restrictions.ge(Constante.DATECREATE, membru.getDataIncepand()));
                        critteria.add(Restrictions.le(Constante.DATECREATE, membru.getDataPana()));
                        UtilitatiCriteria.setConditieCriteriaEgalitateEnum(membru.getSex(), critteria, "sex");
                        critteria.setProjection(Projections.rowCount());
                        final Long cnt = (Long) critteria.uniqueResult();
                        return Math.toIntExact(cnt);
                }
                finally {
                        closeSession();
                }

        }

        /**
         * Metodă care obține lista de utilizatori din baza de date dupa filtrele din Criteria.
         * @param filtruUtilizator FiltruUtilizator
         * @param criteria Criteria
         * @return lista List<Utilizator> lista utilizatori returnati
         */
        private List<Utilizator> gestionareCriteriaUtilizatori(final FiltruUtilizator filtruUtilizator,
                        final Criteria criteria) {
                creaCriteria(filtruUtilizator, criteria);
                @SuppressWarnings(Constante.UNCHECKED)
                final List<Utilizator> listaUtilizatori = criteria.list();
                this.session.close();
                return listaUtilizatori;
        }

        /**
         * Metodă care obține o listă de utilizatori din echipa de conducere din baza de date după filtrele din
         * Criteria.
         * @param filtruUtilizator FiltruUtilizator
         * @param criteria Criteria
         * @return lista List<Utilizator> lista utilizatori returnati
         */
        private List<Utilizator> gestionareCriteriaUtilizatoriLocal(final FiltruEchipa filtruEchipa,
                        final Criteria criteria) {
                creaCriteriaLocal(filtruEchipa, criteria);
                @SuppressWarnings(Constante.UNCHECKED)
                final List<Utilizator> listaUtilizatori = criteria.list();
                this.session.close();
                return listaUtilizatori;
        }

        /**
         * Metodă care obține numărul de registre din baza de date
         * @param filtruUtilizator FiltruUtilizator
         * @return int
         */
        @Override
        public int getCounCriteria(final FiltruUtilizator filtruUtilizator) {
                try {
                        this.session = this.sessionFactory.openSession();
                        final Criteria teria = this.session.createCriteria(Utilizator.class, "user");
                        creaCriteria(filtruUtilizator, teria);
                        teria.setProjection(Projections.rowCount());
                        final Long cnt = (Long) teria.uniqueResult();

                        return Math.toIntExact(cnt);
                }
                finally {
                        closeSession();
                }

        }

        /**
         * Metodă care salveazîn o listîn de utilizatori în baza de date.
         * @param utilizatori List<Utilizator>
         * @return lista List<Utilizator> lista de utilizatori inregistrati
         */
        @Override
        public List<Utilizator> salvat(final List<Utilizator> utilizatori) {
                return (List<Utilizator>) utilizatorRepository.save(utilizatori);
        }

        /**
         * Metodă care salveazîn o listîn de utilizatori provizorii în baza de date.
         * @param listUsers List<Utilizator>
         * @return lista List<Utilizator> lista de utilizatori inregistrati
         *
         */
        @Override
        public List<Utilizator> save(final List<Utilizator> listUsers) {
                return (List<Utilizator>) utilizatorRepository.save(listUsers);
        }

        /**
         * Metodîn care salvează sau actualizează un utilizator în baza de date.
         * @param entity Utilizator
         * @return utilizator Utilizator
         */
        @Override
        @Transactional(readOnly = false)
        public Utilizator save(final Utilizator entity) {
                return utilizatorRepository.save(entity);
        }
}
