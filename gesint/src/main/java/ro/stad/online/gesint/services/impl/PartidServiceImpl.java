package ro.stad.online.gesint.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.NoArgsConstructor;
import ro.stad.online.gesint.persistence.entities.Partid;
import ro.stad.online.gesint.persistence.repositories.PartidRepository;
import ro.stad.online.gesint.services.PartidService;

/**
 * Implementarea metodelor definite în interfața PartidService.
 * @author STAD
 *
 */
@NoArgsConstructor
@Service
@Transactional
public class PartidServiceImpl implements PartidService, Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Repository de Partid.
         */
        @Autowired
        private transient PartidRepository partidRepository;

        /**
         * Metoda care elimina un partid
         * @param partid Partid
         */
        @Override
        @Transactional(readOnly = false)
        public void delete(final Partid partid) {
                this.partidRepository.delete(partid);
        }

        /**
         * Metoda care cauta toate partidele inregistrate
         * @return lista List<Partid>
         */
        @Override
        public List<Partid> fiindAll() {
                return (List<Partid>) partidRepository.findAll();
        }

        /**
         * Metoda care inregistreaza un nou partid
         * @param partid Partid
         * @return partid
         */
        @Override
        @Transactional(readOnly = false)
        public Partid save(final Partid partid) {
                return partidRepository.save(partid);
        }

        /**
         * Metoda care cauta un partid dupa id
         * @param idPartid Long
         * @return partid Partid
         */
        @Override
        public Partid fiindOne(final Long idPartid) {
                return partidRepository.findOne(idPartid);
        }

        /**
         * Cauta toate partidele inregistrate dupa judet
         * @return lista List<Partid>
         */
        @Override
        public List<Partid> fiindPartidJudet() {
                return partidRepository.fiindPartidJudet();
        }
}
