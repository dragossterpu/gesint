package ro.stad.online.gesint.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
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

/**
 * Entitate asociata raspunsurilor suportului
 *
 * @author STAD
 *
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "id")
@Setter
@Builder
@ToString
@Getter

@EntityListeners(AuditingEntityListener.class)
@Table(name = "RASPUNS_SUPORT")
public class RaspunsSuport implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * Identificator.
         */
        @Id
        @SequenceGenerator(allocationSize = 1, name = "SEQ_RASPUNS_SUPORT", sequenceName = "SEQ_RASPUNS_SUPORT")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RASPUNS_SUPORT")
        @Column(name = "ID", nullable = false, columnDefinition = Constante.NUMERIC, length = NumarMagic.NUMBERFIVE)
        private Long id;

        /**
         * Sondaj caruia ii corespund datele.
         */
        @ManyToOne
        @JoinColumn(name = "ID_INTREBARE", foreignKey = @ForeignKey(name = "FK_INTREBARE"), nullable = false)
        private Intrebare intrebare;

        /**
         * Raspuns intrebare
         */
        @Lob
        @Type(type = "org.hibernate.type.TextType")
        @Column(name = "VALOARE", nullable = false)
        private String valoare;

}
