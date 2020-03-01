package ro.stad.online.gesint.persistence.entities;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.persistence.entities.enums.TipLocalitateEnum;

/**
 *
 * Entitate parametrica pentru localitatile unui judet.
 *
 * @author STAD
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode()
@Builder
@Getter
@Setter
@Entity
@Table(name = "LOCALITATE")
public class Localitate implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 8133415273601486902L;

        /**
         * ID.
         */
        @Id
        @SequenceGenerator(name = "SEQ_LOCALITY", sequenceName = "SEQ_LOCALITY", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOCALITY")
        @Column(name = "ID")
        private Long id;

        /**
         * Numele localitatii.
         */
        @Column(name = "NUME", length = NumarMagic.NUMBERHUNDRED, nullable = false)
        private String nume;

        /**
         * Tipul localitatii.
         */
        @Column(name = "TIP_LOCALITATE", length = NumarMagic.NUMBERFIFTY, nullable = false)
        @Enumerated(EnumType.STRING)
        private TipLocalitateEnum tipLocalitate;

        /**
         * Indicator.
         */
        @Column(name = "RESEDINTA")
        private Boolean resedinta;

        /**
         * Judetul localitatii.
         */
        @ManyToOne
        @JoinColumn(name = "COD_JUDET", foreignKey = @ForeignKey(name = "FK_PROVINCE"), nullable = false)
        private Judet judet;

        /**
         * Sectorul localitatii.
         */
        @Column(name = "SECTOR", length = NumarMagic.NUMBERTEN)
        private String sector;

        /**
         * Nivel.
         */
        @Column(name = "NIVEL")
        private Long nivel;

        /**
         * Populatie.
         */
        @Column(name = "LOCUITORI")
        private Long locuitori;

        /**
         * Voturi minim.
         */
        @Column(name = "VOTURI_MINIM")
        private Long voturiMinim;

        /**
         * Membrii minim.
         */
        @Column(name = "MEMBRII_MINIM")
        private Long membriiMinim;

        /**
         * Fotoografia localitate.
         */
        private byte[] photo;

        /**
         * Metoda care obține imaginea pentru previzualizare în cazul în care documentul este un tip de imagine..
         * @return StreamedContent
         */
        public StreamedContent getImageLocalitate() {
                return new DefaultStreamedContent(new ByteArrayInputStream(this.photo));
        }
}
