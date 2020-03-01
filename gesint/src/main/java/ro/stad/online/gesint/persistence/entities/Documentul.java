package ro.stad.online.gesint.persistence.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.stad.online.gesint.constante.NumarMagic;

/**
 * Entitatea documentului. Orice fișier încărcat în aplicație este stocata în acesta tabla.
 *
 * @author STAD
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "DOCUMENT")
public class Documentul extends AbstractEntity implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * Identificatorul entității, generat prin secvență.
         */
        @Id
        @SequenceGenerator(name = "SEQ_DOCUMENT", sequenceName = "SEQ_DOCUMENT", allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DOCUMENT")
        @Column(name = "ID", nullable = false)
        private Long id;

        /**
         * Fișier legat de document.
         */
        @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "ID_FISIER", foreignKey = @ForeignKey(name = "FK_D_FICHERO"))
        private DocumentBlob fisier;

        /**
         * ContentType din fișierul atașat.
         */
        @Column(name = "TIP_CONTINUT", nullable = false)
        private String tipContinut;

        /**
         * Numele documentului
         */
        @Column(name = "NUME")
        private String nume;

        /**
         * Descriere.
         */
        @Column(name = "DESCRIERE", length = NumarMagic.NUMBERTWOTHOUSAND)
        private String descriere;

        /**
         * Cuvinte cheie ale documentului.
         */
        @Column(name = "MATERIA_INDEXATA", length = NumarMagic.NUMBERTWOTHOUSAND)
        private String materiaIndexada;

        /**
         * Tipul documentului
         */
        @ManyToOne
        @JoinColumn(name = "TIP_DOCUMENT")
        private TipDocument tipDocument;

        /**
         * Utilizatorul care publica proiectul
         */
        @ManyToOne
        @JoinColumn(name = "USERNAME")
        private Utilizator utilizator;

        /**
         * Document validat sau nu.
         */
        @Column(name = "VALIDAT")
        private Boolean validat;

        /**
         * Proiectul la care este atribuit documentul.
         */
        @ManyToMany
        @JoinTable(name = "DOCUMENTE_PROIECT", joinColumns = {
                        @JoinColumn(name = "ID_DOCUMENT") }, inverseJoinColumns = { @JoinColumn(name = "ID_PROIECT") })
        private List<Proiect> proiect;

        /** The job instance. */
        @ManyToOne
        @JoinColumn(name = "CORESPONDENTA", nullable = true, unique = false)
        private Corespondenta corespondenta;

        /**
         * Sondaje asociate documentelor.
         */
        /** The job instance. */
        @ManyToOne
        @JoinColumn(name = "SONDAJ", nullable = true, unique = false)
        private Sondaj sondaj;

}
