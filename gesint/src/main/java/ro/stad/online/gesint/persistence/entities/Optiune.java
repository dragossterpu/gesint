package ro.stad.online.gesint.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * Entitate parametrica pentru optiuni.
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
@Table(name = "OPTIUNI_ALEGERI")
public class Optiune implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 8133415273601486902L;

        /**
         * id optiuni
         */
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_OPTIUNI")
        @SequenceGenerator(name = "SEQ_OPTIUNI", sequenceName = "SEQ_OPTIUNI", allocationSize = 1)
        @Column(name = "ID", length = NumarMagic.NUMBERFIVE)
        private Long id;

        /**
         * Numele optiunii.
         */
        @Column(name = "NUME", length = NumarMagic.NUMBERONEHUNDREDFIFTY)
        private String nume;

        /**
         * Voturi optinute
         */
        @Column(name = "VOTURI_OBTINUTE")
        private Long voturiOptinute;

        /**
         * Judetul optiunii.
         */
        @ManyToOne
        @JoinColumn(name = "COD_JUDET", foreignKey = @ForeignKey(name = "FK_PROVINCE_OPT"), nullable = false)
        private Judet judet;

        /**
         * 
         * Localitatate optiune.
         */
        @ManyToOne
        @JoinColumn(name = "LOCALITY_ID", foreignKey = @ForeignKey(name = "FK_LOCALITATE_OPT"), nullable = false)
        private Localitate localitate;

}
