package ro.stad.online.gesint.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.stad.online.gesint.persistence.entities.Functie;
import ro.stad.online.gesint.persistence.repositories.ParamEchipaRepository;
import ro.stad.online.gesint.services.ParamEchipaService;

/**
 * Implementación del servicio de pechipaService.
 *
 * @author STAD
 *
 */
@Service
public class ParamEchipaServiceImpl implements ParamEchipaService {

        /**
         * Repositoriu de Functie.
         */
        @Autowired
        private ParamEchipaRepository pEchipaRepository;

        /**
         * Metodă care returnează toate fuctiile din baza de date
         * @return lista List<Functie>
         */
        @Override
        public List<Functie> fiindAll() {
                return (ArrayList<Functie>) pEchipaRepository.findAll();
        }

        /**
         * Metodă care returnează toate registrele din baza de date
         * @param String "Conducerea Locală"
         * @return lista List<Functie>
         */
        @Override
        public List<Functie> fiindAllByParam() {
                return pEchipaRepository.findByOrganizatie("Conducerea Locală");
        }

        /**
         * Metodă care cauta o functie după id
         * @param Long idTeam
         * @return Functie functia
         */
        @Override
        public Functie findById(final Long idTeam) {
                return pEchipaRepository.findOne(idTeam);
        }

        /**
         * Metodă care cauta o functie după id si dupa nume
         * @param Long idTeam
         * @param String organizatie
         * @return Functie functia
         */
        @Override
        public Functie findByIdAndOrganization(final Long idFunctie, final String organizatie) {
                return pEchipaRepository.findByIdAndOrganizatie(idFunctie, organizatie);
        }

        /**
         * Metodă care cauta o functie după nume
         * @param String organizatie
         * @return Functie functia
         */
        @Override
        public List<Functie> findByOrganization(final String organizatie) {
                return pEchipaRepository.findByOrganizatie(organizatie);
        }
}
