package ro.stad.online.gesint.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.persistence.entities.enums.TipSondajEnum;

/**
 * Entitate pentru sondaje.
 * @author STAD
 */
@TypeDefs({ @TypeDef(name = "double precision", typeClass = java.lang.Float.class) })
@AllArgsConstructor

@EqualsAndHashCode(callSuper = false, of = "id")
@Builder
@ToString
@Getter
@Setter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "SONDAJ")
public class Sondaj extends AbstractEntity implements Serializable {

        /**
         * Serial ID.
         */
        private static final long serialVersionUID = 1L;

        /**
         * Identificator.
         */
        @Id
        @SequenceGenerator(allocationSize = 1, name = "SEQ_SONDAJ", sequenceName = "SEQ_SONDAJ")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SONDAJ")
        @Column(name = "ID", nullable = false, columnDefinition = Constante.NUMERIC, length = NumarMagic.NUMBERFIVE)
        private Long id;

        /**
         * Descriere sondaj.
         */
        @Lob
        @Type(type = "org.hibernate.type.TextType")
        @Column(name = "DESCRIERE", nullable = false)
        private String descriere;

        /**
         * Intrebarea
         */

        @Column(name = "INTREBARE", nullable = false, length = NumarMagic.NUMBERTHOUSAND)
        private String intrebare;

        /**
         * Tip de sondaj.
         */
        @Column(name = "TIPSONDAJ", nullable = false)
        @Enumerated(EnumType.STRING)
        private TipSondajEnum tipSondaj;

        /**
         * Data Inceperii
         */
        @Column(name = "DATA_INCEPERE", length = NumarMagic.NUMBERNINETEEN)
        private Date dataIncepere;

        /**
         * Data finalizarii.
         */
        @Column(name = "DATA_FINALIZARE", length = NumarMagic.NUMBERNINETEEN)
        private Date dataFinalizare;

        /**
         * Tabla unde salvam voturile unui sondaj
         */
        @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
        @JoinTable(name = "UTILIZATOR_SONDAJ", joinColumns = { @JoinColumn(name = "ID_SONDAJ") }, inverseJoinColumns = {
                        @JoinColumn(name = "USERNAME") })
        private List<Utilizator> utilizatori;

        /**
         * Sondaj activ.
         */
        @Column(name = "ACTIV")
        private Boolean activ;

        /**
         * Raspunsurile sondajului.
         */
        @OneToMany(mappedBy = "sondaj", fetch = FetchType.LAZY)
        private List<Raspuns> raspunsuri;

        /**
         * Procentaj de voturi DA.
         */
        @Column(name = "PROCENTAJ_DA")
        private Float procentajDa;

        /**
         * Procentaj de voturi NU.
         */
        @Column(name = "PROCENTAJ_NU")
        private Float procentajNu;

        /**
         * Procentaj de voturi ABTINERI.
         */
        @Column(name = "PROCENTAJ_ABT")
        private Float procentajAbt;

        /**
         * Numarul total de voturi DA.
         */
        @Column(name = "TOTAL_VOTURI_DA")
        private Integer totalVoturiDa;

        /**
         * Numarul total de voturi NU .
         */
        @Column(name = "TOTAL_VOTURI_NU")
        private Integer totalVoturiNu;

        /**
         * Numarul total de voturi ABTINERI.
         */
        @Column(name = "TOTAL_VOTURI_ABT")
        private Integer totalVoturiAbt;

        /**
         * Numarul total de voturi.
         */
        @Column(name = "TOTAL_VOTURI")
        private Integer totalVoturi;

}
