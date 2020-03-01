package ro.stad.online.gesint.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.persistence.entities.enums.RezultatEnum;
import ro.stad.online.gesint.persistence.entities.enums.TipStatisticaEnum;

/**
 * Entitate pentru stocarea înregistrărilor de statistica în baza de date.
 * @author STAD
 */
@TypeDefs({ @TypeDef(name = "double precision", typeClass = java.lang.Float.class) })
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Builder
@ToString
@Getter
@Setter
@Entity
@Table(name = "STATISTICA")
public class Statistica implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * Identificador del registro, se genera por medio de una secuencia.
         */
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STATISTICA")
        @SequenceGenerator(name = "SEQ_STATISTICA", sequenceName = "SEQ_STATISTICA", allocationSize = 1)
        @Column(name = "ID", length = NumarMagic.NUMBERFIVE, columnDefinition = "NUMERIC")
        private Long id;

        /**
         * Numele tipului de statistica.
         */
        @Column(name = "TIP_STATISTICA", length = NumarMagic.NUMBERTWENTY)
        @Enumerated(EnumType.STRING)
        private TipStatisticaEnum tipStatistica;

        /**
         * Descrierea registrului.
         */
        @Column(name = "DESCRIERE")
        private String descriere;

        /**
         * Data la care este înregistrata statistica.
         */
        @CreatedDate
        @Column(name = "DATA_INREGISTRARII", nullable = false)
        private Date datainregistrarii;

        /**
         * Marca registrului ex: Ianuarie 2019.
         */
        @Column(name = "MARCA")
        private String marca;

        /**
         * Numele registrului ex: Bacau.
         */
        @Column(name = "NUME")
        private String nume;

        /**
         * Numele registrului ex: BC.
         */
        @Column(name = "COD_JUDET")
        private String codeJudet;

        /**
         * populatie totala.
         */
        @Column(name = "POPULATIE_TOTALA")
        private Long populatieTotala;

        /**
         * populatie totala.
         */
        @Column(name = "MEMBRII")
        private Long membrii;

        /**
         * populatie cu drept de vot.
         */
        @Column(name = "POPULATIE_VOT")
        private Long populatieVot;

        /**
         * populatie cu drept de vot.
         */
        @Column(name = "PROCENTAJ")
        private Float procentaj;

        /**
         * Numele registrului ex: BC.
         */
        @Column(name = "VALOARE")
        @Enumerated(EnumType.STRING)
        private RezultatEnum valoare;

        /**
         * Judet boolean.
         */
        @Column(name = "isjudet")
        private Boolean isjudet;
}
