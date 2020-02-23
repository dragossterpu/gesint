package ro.stad.online.gesint.persistence.entities.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Mapa implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * id.
         */
        private String id;

        /**
         * eticheta.
         */
        private String eticheta;

}
