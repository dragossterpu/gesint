package ro.stad.online.gesint.model.filters;

import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.persistence.entities.enums.CategorieEnum;

/**
 * Controler al operațiunilor legate de căutarea corespondentelor. Reseteaza valorile de căutare.
 *
 * @author STAD
 *
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Controller("cautareCorespondentaBean")
@Scope(Constante.SESSION)
public class FiltruCorespondenta implements Serializable {

        /**
         * Serial ID.
         */
        private static final long serialVersionUID = 1L;

        /**
         * ID de corespondenta.
         */
        private String id;

        /**
         * TitluL corespondentei.
         */
        private String titlu;

        /**
         * Destinatarul corespondentei.
         */
        private String destinatar;

        /**
         * Data de la trimiterea corespondentei.
         */
        private Date dateFromSend;

        /**
         * Data până la trimiterea corespondentei.
         */
        private Date dateUntilSend;

        /**
         * Data de la crearea corespondentei.
         */
        private Date dateFromCreated;

        /**
         * Data până la crearea corespondentei.
         */
        private Date dateUntilCreated;

        /**
         * Filtru tip corespondenta.
         */
        private CategorieEnum tipCorespondenta;

}
