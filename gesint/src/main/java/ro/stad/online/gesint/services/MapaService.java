package ro.stad.online.gesint.services;

import java.util.List;

import ro.stad.online.gesint.persistence.entities.Mapa;

/**
 * Interfață pentru serviciul de Mapa.
 *
 * @author STAD
 *
 */
public interface MapaService {

        /**
         * Metoda care cauta toate registrele din baza de date.
         * @return lista List<Mapa> lista de registre
         */
        List<Mapa> fiindAll();

}
