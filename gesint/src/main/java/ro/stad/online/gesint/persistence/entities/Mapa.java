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
 * Entitate parametrica pentru mapa.
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
@Table(name = "MAPA")
public class Mapa implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 8133415273601486902L;

        /**
         * ID mapa
         */
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MAPA")
        @SequenceGenerator(name = "SEQ_MAPA", sequenceName = "SEQ_MAPA", allocationSize = 1)
        @Column(name = "ID", length = NumarMagic.NUMBERTEN)
        private Long id;

        /**
         * Codul judetului.
         */
        @Column(name = "COD_JUDET", length = NumarMagic.NUMBERTHREE)
        private String codJudet;

        /**
         * Codul judetului.
         */
        @Column(name = "INDICATIV", length = NumarMagic.NUMBERTWENTY)

        private String indicativ;

        /**
         * Numele fregistrului.
         */
        @Column(name = "NUME", length = NumarMagic.NUMBERHUNDRED)
        private String nume;

        /**
         * Coordonatele registrului.
         */
        @Column(name = "COORDONATE", length = NumarMagic.NUMBERTHOUSAND)
        private String coordonate;

        /**
         * eticheta registrului.
         */
        @Column(name = "ETICHETA", length = NumarMagic.NUMBERTEN)
        private String eticheta;
}
