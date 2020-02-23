package ro.stad.online.gesint.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.mitchellbosecke.pebble.error.PebbleException;

import ro.stad.online.gesint.persistence.entities.Corespondenta;
import ro.stad.online.gesint.persistence.entities.Documentul;
import ro.stad.online.gesint.persistence.entities.Utilizator;

/**
 *
 * Interfata pentru trimiterea de e-mailuri.
 *
 * @author STAD
 *
 */
public interface EMail {

        /**
         * Metodă folosită pentru trimiterea corespondenței
         * @param paramDestinnatar String
         * @param paramtitlu String
         * @param sablonEmailParola String
         * @param paramSablon String
         */
        void trimitereEmail(String email, String string, String sablonEmailParola, Map<String, String> paramSablon);

        /**
         * Metodă folosită pentru trimiterea corespondenței
         * @param corespondenta Corespondenta
         * @param utilizatoriSelectionati Utilizator
         * @return dataTrimiteri Date
         */
        Date send(final Corespondenta corespondenta, List<Utilizator> utilizatoriSelectionati,
                        List<Documentul> documenteIncarcate, String plantilla, Map<String, String> paramPlantilla)
                        throws PebbleException;
}
