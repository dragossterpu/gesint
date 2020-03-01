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

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.persistence.entities.enums.RegistruEnum;
import ro.stad.online.gesint.persistence.entities.enums.SectiuniEnum;

/**
 * Entitate pentru stocarea jurnalelor de activitate în baza de date.
 * @author STAD
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Builder
@ToString
@Getter
@Setter
@Entity
@Table(name = "REG_ACTIVIDAD")
public class RegistruActivitate implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * Identificatorul jurnalului de activitate, este generat cu ajutorul unei secvențe.
         */
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_REGISTRU")
        @SequenceGenerator(name = "SEQ_REGISTRU", sequenceName = "SEQ_REGISTRU", allocationSize = 1)
        @Column(name = "REG_ACTIVIDAD", length = NumarMagic.NUMBERFIVE, columnDefinition = "NUMERIC")
        private Long idRegActividad;

        /**
         * Numele secțiunii
         */
        @Column(name = "NUME_SECTIUNE", length = NumarMagic.NUMBERTWENTY, nullable = false)
        @Enumerated(EnumType.STRING)
        private SectiuniEnum numeSectiune;

        /**
         * Descrierea.
         */
        @Column(name = "DESCRIERE")
        private String descriere;

        /**
         * Data la care este înregistrată înregistrarea.
         */
        @CreatedDate
        @Column(name = "DATA_INREGISTRARII", nullable = false)
        private Date dataInregistrari;

        /**
         * Numele de utilizator al utilizatorului care înregistrează registrul.
         */
        @CreatedBy
        @Column(name = "UTILIZATOR_REGISTRAT", nullable = false)
        private String usernameRegActividad;

        /**
         * Tip registru.
         */
        @Column(name = "TIP_REG_ACTIVIDAD", length = NumarMagic.NUMBERFIFTY, nullable = false)
        @Enumerated(EnumType.STRING)
        private RegistruEnum tipRegActivitate;

}
