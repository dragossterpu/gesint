package ro.stad.online.gesint.persistence.entities.raport;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.persistence.entities.Statistica;

/**
 * Entitate asociata unui raport.
 *
 * @author STAD
 */
@EqualsAndHashCode(callSuper = false, of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "RAPORT")
@NamedEntityGraph(name = "Raport.date", attributeNodes = @NamedAttributeNode("dateRaport"))
public class Raport implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * Id-ul raportului. Generadt prin secventa.
         */
        @Id
        @SequenceGenerator(name = "SEQ_RAPORT", sequenceName = "SEQ_RAPORT", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RAPORT")
        @Column(name = "ID", nullable = false)
        private Long id;

        /**
         * Statistica din care face parte raportul.
         */
        @OneToOne
        @JoinColumn(name = "STATISTICA_ID", foreignKey = @ForeignKey(name = "FK_RAP_STATISTICA"))
        private Statistica statistica;

        /**
         * Data de creatie.
         */
        @CreatedDate
        @Column(name = "DATE_CREATE", nullable = false)
        private Date dateCreate;

        /**
         * Datele corespunzatoare raportului.
         */
        @OneToMany(mappedBy = "raport", fetch = FetchType.LAZY)
        private List<DateRaport> dateRaport;

        /**
         * Utilizator care elimina un registru
         */
        @Column(name = "USER_DELETED", length = NumarMagic.NUMBERHUNDRED)
        private String userDeleted;

}
