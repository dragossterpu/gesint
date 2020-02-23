package ro.stad.online.gesint.model.filters;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Obiect de filtrare.
 *
 * @author STAD
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiltruStatisticaJudete implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 7637962187780804682L;

        /**
         * Data minima ale rezultatelor
         */
        private Date dataIncepand;

        /**
         * codul judetului.
         */
        private String codJudet;

        /**
         * descendent.
         */
        private String descendent;

        /**
         * procentaj general judet.
         */
        private String generalJudetProcentaj;

}
