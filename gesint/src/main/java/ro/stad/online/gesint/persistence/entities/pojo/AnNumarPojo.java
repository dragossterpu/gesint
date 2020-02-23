package ro.stad.online.gesint.persistence.entities.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.stad.online.gesint.persistence.entities.enums.SexEnum;

/**
 * Controlorul operațiunilor legate de statistici
 *
 * @author STAD
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnNumarPojo implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * An.
         */
        private String an;

        /**
         * Numar.
         */
        private Integer numar;

        /**
         * dataIncepand
         */
        private Date dataIncepand;

        /**
         * dataPana
         */
        private Date dataPana;

        /**
         * Filtru sex utilizator.
         */
        private SexEnum sex;

}
