package ro.stad.online.gesint.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 *
 * Entitate parametrica para el almacenamiento de o functie.
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
@Table(name = "PTEAM")
public class Functie implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 8133415273601486902L;

        /**
         * ID PTEAM.
         */
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PTEAM")
        @SequenceGenerator(name = "SEQ_PTEAM", sequenceName = "SEQ_PTEAM", allocationSize = 1)
        @Column(name = "ID", length = NumarMagic.NUMBERFIVE)
        private Long id;

        /**
         * Organizatia functiei.
         */
        @Column(name = "ORGANIZATIE", length = NumarMagic.NUMBERHUNDRED)
        private String organizatie;

        /**
         * Descrierea functiei.
         */
        @Column(name = "DESCRIERE", length = NumarMagic.NUMBERTWOHUNDREDFIFTYFIVE)
        private String descriere;

        /**
         * Numele functiei.
         */
        @Column(name = "NUME", length = NumarMagic.NUMBERTWOHUNDREDFIFTYFIVE, nullable = false)
        private String nume;

}
