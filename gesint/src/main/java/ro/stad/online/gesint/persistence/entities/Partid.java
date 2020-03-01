package ro.stad.online.gesint.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.persistence.entities.enums.DaNuEnum;
import ro.stad.online.gesint.util.Utilitati;

/**
 *
 * Entitate parametrica pentru partide.
 *
 * @author STAD
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "id")
@Builder
@Getter
@Setter
@Entity
@Table(name = "PARTID")
public class Partid implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 8133415273601486902L;

        /**
         * ID PARTID.
         */
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PARTID")
        @SequenceGenerator(name = "SEQ_PARTID", sequenceName = "SEQ_PARTID", allocationSize = 1)
        @Column(name = "ID", length = NumarMagic.NUMBERFIVE)
        private Long id;

        /**
         * Sigla formatiunii politice.
         */
        @Column(name = "SIGLA", length = NumarMagic.NUMBERSEVEN)
        private String sigla;

        /**
         * Numele formatiunii politice.
         */
        @Column(name = "NUME", length = NumarMagic.NUMBERHUNDRED)
        private String name;

        /**
         * Independent.
         */
        @Column(name = "INDEPENDENT")
        @Enumerated(EnumType.STRING)
        private DaNuEnum independent;

        /**
         * @return the name
         */
        public String getName() {
                return Utilitati.convertNumePartid(name);
        }

}
