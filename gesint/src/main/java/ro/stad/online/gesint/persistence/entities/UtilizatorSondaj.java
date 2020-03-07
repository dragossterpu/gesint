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
 * Entitate pentru datele rezultate din votarea sondajelor.
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
@Table(name = "UTILIZATOR_SONDAJ")
public class UtilizatorSondaj implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 8133415273601486902L;

        /**
         * id rezultate.
         */
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_UTILIZATOR_SONDAJ")
        @SequenceGenerator(name = "SEQ_UTILIZATOR_SONDAJ", sequenceName = "SEQ_UTILIZATOR_SONDAJ", allocationSize = 1)
        @Column(name = "ID", length = NumarMagic.NUMBERFIVE)
        private Long id;

        /**
         * Sondaj
         */
        @ManyToOne
        @JoinColumn(name = "ID_SONDAJ", foreignKey = @ForeignKey(name = "fkstgo5y86kkqq38f66yupq5bxa"))
        private Sondaj sondaj;

        /**
         * Utilizator
         */

        @Column(name = "USERNAME")
        private Utilizator username;

}
