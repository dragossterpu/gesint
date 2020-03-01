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
 * Entitate pentru rezultate alegeri pe localitati ale partidelor.
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
@Table(name = "PARTID_REZULTAT_LOCALITATE")
public class PartidRezultateLocalitate implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 8133415273601486902L;

        /**
         * ID
         */
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PARTID_LOCALITATE")
        @SequenceGenerator(name = "SEQ_PARTID_LOCALITATE", sequenceName = "SEQ_PARTID_LOCALITATE", allocationSize = 1)
        @Column(name = "ID", length = NumarMagic.NUMBERFIVE)
        private Long id;

        /**
         * Data alegerilor.
         */
        @Column(name = "DATA_ALEGERILOR")
        private Date dataAlegerilor;

        /**
         * Tipul de alegeri.
         */
        @Column(name = "TIP_ALEGERI")
        @Enumerated(EnumType.STRING)
        private TipAlegeriEnum tipAlegeri;

        /**
         * Partid.
         */
        @ManyToOne

        @JoinColumn(name = "PARTID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_U_PARTID_LOC"))
        private Partid partid;

        /**
         * Numarul total de voturi.
         */
        @Column(name = "TOTAL_VOTURI_LOCALITATE")
        private Long totalVoturi;

        /**
         * Procentaj total de voturi.
         */
        @Column(name = "PROCENTAJ_TOTAL_VOTURI_LOCALITATE")
        private Float procentajTotalVoturi;

        /**
         * Numarul total de mandate.
         */
        @Column(name = "NUMAR_MANDATE")
        private Long numarMandate;

        /**
         * Procentaj total mandate localitate.
         */
        @Column(name = "PROCENTAJ_MANDATE_LOCALITATE")
        private Float procentajMandateLocalitate;

        /**
         * Judetul.
         */
        @OneToOne
        @JoinColumn(name = "ID_JUDET", referencedColumnName = "COD_JUDET", foreignKey = @ForeignKey(name = "FK_U_PROVINCE_LOC"))
        private Judet judetul;

        /**
         * Localiatea.
         */
        @OneToOne
        @JoinColumn(name = "ID_LOCALITATE", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_U_LOCALITATE"))
        private Localitate localitatea;

        /**
         * Numarul total de voturi ale partidului.
         */
        @Column(name = "TOTAL_VOTURI_JUDET")
        private Long totalVoturiJudet;

        /**
         * Numarul total de mandate.
         */
        @Column(name = "TOTAL_MANDATE_JUDET")
        private Long totalMandateJudet;

        /**
         * Anul alegerilor.
         */
        @Column(name = "AN_ALEGERI")
        private Integer anAlegeri;

}
