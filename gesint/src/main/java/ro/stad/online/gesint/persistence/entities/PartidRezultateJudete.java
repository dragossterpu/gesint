package ro.stad.online.gesint.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.persistence.entities.enums.TipAlegeriEnum;

/**
 *
 * Entitate pentru rezultate alegeri pe judet ale partidelor.
 *
 * @author STAD
 *
 */
@TypeDefs({ @TypeDef(name = "double precision", typeClass = java.lang.Float.class) })
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "id")
@Builder
@Getter
@Setter
@Entity
@Table(name = "PARTID_REZULTAT_JUDET")
public class PartidRezultateJudete implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 8133415273601486902L;

        /**
         * ID
         */
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PARTID_JUDET")
        @SequenceGenerator(name = "SEQ_PARTID_JUDET", sequenceName = "SEQ_PARTID_JUDET", allocationSize = 1)
        @Column(name = "ID", length = NumarMagic.NUMBERFIVE)
        private Long id;

        /**
         * Data alegerilor.
         */
        @Column(name = "DATA_ALEGERILOR")
        private Date dataAlegerilor;

        /**
         * Procentaj total de voturi.
         */
        @Column(name = "PROCENTAJ_TOTAL_VOTURI")
        private Float procentajTotalVoturi;

        /**
         * Tipul de alegeri.
         */
        @Column(name = "TIP_ALEGERI")
        @Enumerated(EnumType.STRING)
        private TipAlegeriEnum tipAlegeri;

        /**
         * Numarul total de voturi.
         */
        @Column(name = "TOTAL_VOTURI_JUDET")
        private Long totalVoturi;

        /**
         * Judetul.
         */
        @OneToOne
        @JoinColumn(name = "ID_JUDET", referencedColumnName = "COD_JUDET", foreignKey = @ForeignKey(name = "FK_U_PROVINCE"))
        private Judet judetul;

        /**
         * Procentaj total de voturi.
         */
        @ManyToOne

        @JoinColumn(name = "PARTID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_U_PARTID"))
        private Partid partid;

        /**
         * Numarul total de mandate.
         */
        @Column(name = "NUMAR_MANDATE")
        private Long numarMandate;

        /**
         * Numarul total de voturi ale partidului.
         */
        @Column(name = "TOTAL_VOTURI_PARTID")
        private Long totalVoturiPartid;

        /**
         * Procentaj total mandate judet.
         */
        @Column(name = "PROCENTAJ_MANDATE_JUDET")
        private Float procentajMandateJudet;

        /**
         * Anul alegerilor.
         */
        @Column(name = "AN_ALEGERI")
        private Integer anAlegeri;

}
