package ro.stad.online.gesint.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.model.filters.FiltruLocalitate;
import ro.stad.online.gesint.persistence.entities.Judet;
import ro.stad.online.gesint.persistence.entities.Localitate;
import ro.stad.online.gesint.persistence.entities.enums.TipLocalitateEnum;
import ro.stad.online.gesint.persistence.repositories.LocalitateRepository;
import ro.stad.online.gesint.services.CriteriaService;
import ro.stad.online.gesint.services.JudetService;
import ro.stad.online.gesint.services.LocalitateService;
import ro.stad.online.gesint.util.UtilitatiCriteria;

/**
 * Implementarea serviciului de localitati.
 *
 * @author STAD
 *
 */
@Service
public class LocalitateServiceImpl implements LocalitateService {

        /**
         * Repository de Localitate.
         */
        @Autowired
        private LocalitateRepository localitateRepository;

        /**
         * Session.
         */
        private Session session;

        /**
         * Session. SessionFactory
         */
        @Autowired
        private SessionFactory sessionFactory;

        /**
         * Serviciu pentru a utiliza metodele utilizate împreună cu criteria.
         */
        @Autowired
        private CriteriaService criteriaService;

        /**
         * Variabila utilizata pentru injectarea serviciului de judete
         */
        @Autowired
        private JudetService judetService;

        /**
         * Metodă care caută orașele care aparțin unei judet.
         * @param idJudet Judet pe care vrem să o consultăm.
         * @return lista List<Localitate> Lista de localitati ale judetului.
         */
        @Override
        public List<Localitate> cautareDupaJudet(final Long idJudet) {
                return localitateRepository.findByJudetOrderByNume(idJudet);
        }

        /**
         * Metodă care salveaza o localitate nouă
         * @param nume localitatii
         * @param judet din care face parte localitatea
         * @return localitate Localitate localitate creata
         */
        @Override
        @Transactional(readOnly = false)
        public Localitate inregistrareLocalitate(final String nume, final Judet judet,
                        final TipLocalitateEnum tipLoclalitate) {
                final Localitate nouaLocalitate = new Localitate();
                nouaLocalitate.setNume(nume);
                nouaLocalitate.setJudet(judet);
                nouaLocalitate.setResedinta(false);
                nouaLocalitate.setSector(null);
                nouaLocalitate.setTipLocalitate(tipLoclalitate);
                localitateRepository.save(nouaLocalitate);
                return nouaLocalitate;

        }

        /**
         * Metodă care verifică dacă există o localitate cu același nume..
         * @param name numele localitatii
         * @param judet din care face parte localitatea
         * @return valor booleano
         */
        @Override
        public boolean existeByNumeIgnoreCaseAndJudet(final String name, final Judet judet) {
                return localitateRepository.existsByNumeIgnoreCaseAndJudet(name, judet);
        }

        /**
         * Metodă care verifică dacă există o localitate cu același nume.
         * @param name numele localitatii
         * @param judet din care face parte localitatea
         * @return localitatea Localitate Localitate
         */
        @Override
        public Localitate localidadByNumeIgnoreCaseAndJudet(final String name, final Judet judet) {
                return localitateRepository.findByNumeIgnoreCaseAndJudet(name, judet);
        }

        /**
         * Metodă care cauta toate localitatile
         * @return lista de localitati.
         */
        @Override
        public List<Localitate> fiindAll() {
                return (ArrayList<Localitate>) localitateRepository.findAll();
        }

        /**
         * Metodă care cauta o localitate dupa id acestuia
         * @param localidadId Long
         * @return localitate Localitate
         *
         */
        @Override
        public Localitate findById(final Long localidadId) {
                return localitateRepository.findOne(localidadId);
        }

        /**
         * Metodă care cauta o localitate dupa numele acestuia
         * @param local numele localitatii
         * @return localitate Localitate
         *
         */
        @Override
        public Localitate findByNume(final String local) {
                return localitateRepository.findByNume(local);
        }

        /**
         * Metodă care cauta toate localitatile unui judet
         * @param judet Judet
         * @return lista List<Localitate> lista de localitati.
         */
        @Override
        public List<Localitate> findByJudet(final Judet judet) {
                return localitateRepository.findAllByJudet(judet);
        }

        /**
         * Metodă care cauta toate localitatile unui judet
         * @param Long nivel identificator de nivel(importanta) al localitatii
         * @param judet Judet
         * @return lista de localitati.
         */
        @Override
        public List<Localitate> findByJudetAndNivel(final Judet judet, final Long nivel) {
                return localitateRepository.findAllByJudetAndNivel(judet, nivel);
        }

        /**
         * Metodă care salveaza o localitate noua
         * @param localitate Localitate
         * @return localitate actualizata
         */
        @Override
        @Transactional(readOnly = false)
        public Localitate save(final Localitate localitate) {
                return localitateRepository.save(localitate);
        }

        /**
         * Metoda care primește un fișier UploadedFile și datele necesare pentru a genera un document, dar nu îl
         * stochează într-o bază de date. Lăsați obiectul gata să îl salveze.
         * @param file fisier pentru stocare in baza de date
         * @param localitate localitate
         * @return document stocat in baza de date
         * @throws IOException
         */
        @Override
        public Localitate incarcareImaginaFaraStocare(final byte[] file, final Localitate localitate)
                        throws IOException {
                return creareImagine(file, localitate);
        }

        /**
         * Metoda care incarca imaginea localitatii.
         * @param file Fisier incarcat de utilizator
         * @param localitatea caruia se asociaza imaginea.
         * @return localitate Localitate
         * @throws IOException Exceptie intrare/iesire
         */
        private Localitate creareImagine(final byte[] file, final Localitate localitate) {
                incarcareDatePersonaleUser(file, localitate);
                localitateRepository.save(localitate);
                return localitate;
        }

        /**
         * Metoda care incarca imaginea localitatii.
         * @param localitate Localitate
         * @return localitate Localitate
         */
        private void incarcareDatePersonaleUser(final byte[] fileBlob, final Localitate localitate) {
                localitate.setPhoto(fileBlob);
        }

        /**
         * Metoda care returnează numărul de localitati într-o consultare bazată pe criterii.
         * @param filtruLocalitate obiect cu parametri de căutare
         * @return returnează numărul de registre din consultarea criteria.
         */
        @Override
        public int getCounCriteria(final FiltruLocalitate filtruLocalitate) {
                this.session = this.sessionFactory.openSession();
                final Criteria criteria = this.session.createCriteria(Localitate.class, Constante.LOCALITATE);
                cautareCriteria(filtruLocalitate, criteria);
                criteria.setProjection(Projections.rowCount());
                final Long cnt = (Long) criteria.uniqueResult();
                this.session.close();
                return Math.toIntExact(cnt);
        }

        /**
         * Metoda care caută de toate localițatile care îndeplinesc condițiile introduse în FiltruLocalitate.
         * @param filtruLocalitate FiltruLocalitate
         * @param criteria Criteria
         */
        private void cautareCriteria(final FiltruLocalitate filtruLocalitate, final Criteria criteria) {
                UtilitatiCriteria.setConditieCriteriaTextLike(filtruLocalitate.getNume(), criteria, Constante.NUME);
                UtilitatiCriteria.setConditieCriteriaEgalitateEnum(filtruLocalitate.getTip(), criteria,
                                "tipLocalitate");
                if (filtruLocalitate.getIdJudet() != null && !Constante.SPATIU.equals(filtruLocalitate.getIdJudet())) {
                        criteria.add(Restrictions.eq("judet", judetService.findById(filtruLocalitate.getIdJudet())));
                }
        }

        /**
         * Metoda care caută de toate localițatile care îndeplinesc condițiile introduse în FiltruLocalitate.
         * @param filtruLocalitate obiect cu parametri de căutare
         * @param first primul element
         * @param pageSize dimensiunea fiecărei pagini de rezultate
         * @param sortField câmpul în care sunt sortate rezultatele
         * @param sortOrder ordine de sortare (crescator / descrescator)
         * @return lista List<Localitate> lista de localitati.
         */
        @Override
        public List<Localitate> cautareLocalitateCriteria(final int first, final int pageSize, final String sortField,
                        final SortOrder sortOrder, final FiltruLocalitate filtruLocalitate) {
                this.session = this.sessionFactory.openSession();
                final Criteria criteria = this.session.createCriteria(Localitate.class, Constante.LOCALITATE);
                cautareCriteria(filtruLocalitate, criteria);
                this.criteriaService.pregatirePaginareOrdenareCriteria(criteria, first, pageSize, sortField, sortOrder,
                                Constante.ID);
                @SuppressWarnings(Constante.UNCHECKED)
                final List<Localitate> lista = criteria.list();
                this.session.close();
                return lista;
        }

        /**
         * Metoda care elimina o localitate
         * @param localitate Localitate
         */
        @Override
        @Transactional(readOnly = false)
        public void delete(Localitate localitate) {
                localitateRepository.delete(localitate.getId());
        }
}
