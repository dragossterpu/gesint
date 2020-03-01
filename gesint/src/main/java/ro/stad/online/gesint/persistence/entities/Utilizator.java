package ro.stad.online.gesint.persistence.entities;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ro.stad.online.gesint.constante.NumarMagic;
import ro.stad.online.gesint.persistence.entities.enums.CanalAlertaEnum;
import ro.stad.online.gesint.persistence.entities.enums.EducatieEnum;
import ro.stad.online.gesint.persistence.entities.enums.RolEnum;
import ro.stad.online.gesint.persistence.entities.enums.SexEnum;
import ro.stad.online.gesint.persistence.entities.enums.StatutCivilEnum;

/**
 *
 * Entidad para el almacenamiento de un Utilizator.
 * @author STAD
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "username")
@Builder

@Getter
@Setter
@Entity
@ToString
@EntityListeners(AuditingEntityListener.class)
@Table(name = "UTILIZATOR")
public class Utilizator extends AbstractEntity implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = -7888266252869220306L;

        /**
         * Login (ID).
         */
        @Id
        @Column(name = "USERNAME", length = NumarMagic.NUMBERONEHUNDREDFIFTY, nullable = false)
        private String username;

        /**
         * Parola utilizatorlui.
         */
        @Column(name = "PASSWORD", length = NumarMagic.NUMBERHUNDRED, nullable = false)
        private String password;

        /**
         * Rolul utilizatorlui.
         */
        @Column(name = "ROLE", length = NumarMagic.NUMBERFIFTY, nullable = false)
        @Enumerated(EnumType.STRING)
        private RolEnum role;

        /**
         * Numele utilizatorlui.
         */
        @Column(name = "NUME", length = NumarMagic.NUMBERHUNDRED, nullable = false)
        private String nume;

        /**
         * Prenumele utilizatorlui.
         */
        @Column(name = "PRENUME", length = NumarMagic.NUMBERHUNDRED, nullable = false)
        private String prenume;

        /**
         * Email.
         */
        @Column(name = "EMAIL", length = NumarMagic.NUMBERHUNDRED, nullable = false)
        private String email;

        /**
         * Email personal.
         */
        private String personalEmail;

        /**
         * Judetul.
         */
        @ManyToOne
        @JoinColumn(name = "COD_JUDET")
        private Judet codJudet;

        /**
         * Localitatea.
         */
        @ManyToOne
        @JoinColumn(name = "LOCALITATE_ID", foreignKey = @ForeignKey(name = "FK_U_LOCALITY"))
        private Localitate localitate;

        /**
         * Telefonul.
         */
        private String phone;

        /**
         * Adresa.
         */
        private String adresa;

        /**
         * CNP utilizator.
         */
        private String idCard;

        /**
         * Numar buletin de identitate utilizator.
         */
        private String numarCard;

        /**
         * Data nasterii utilizator.
         */
        private Date dataNasterii;

        /**
         * Educatie utilizator.
         */
        @Column(name = "EDUCATIE")
        @Enumerated(EnumType.STRING)
        private EducatieEnum educatie;

        /**
         * Canal de alertas del usuario.
         */
        @Column(name = "CANAL_CORESPONDENTA", length = NumarMagic.NUMBERTEN)
        @Enumerated(EnumType.STRING)
        private CanalAlertaEnum canalCorespondenta;

        /**
         * Loc de munca utilizator.
         */
        private String locMunca;

        /**
         * Sex utilizator.
         */
        @Column(name = "SEX")
        @Enumerated(EnumType.STRING)
        private SexEnum sex;

        /**
         * Stare civila utilizator.
         */
        @Column(name = "STATUT_CIVIL")
        @Enumerated(EnumType.STRING)
        private StatutCivilEnum statutCivil;

        /**
         * Fotoografia utilizator.
         */
        private byte[] photo;

        /**
         * Utilizator validat.
         */
        private Boolean validat;

        /**
         * Functia
         */
        @ManyToOne
        @JoinColumn(name = "TEAM_ID", foreignKey = @ForeignKey(name = "FK_U_PTEAM"))
        private Functie team;

        /**
         * Destinatar Extern.
         */
        private Boolean destinatarExtern;

        /**
         * Ordinea de aparitie.
         */
        @Column(name = "RANK", length = NumarMagic.NUMBERTWO)
        private Long rank;

        /**
         * Metoda care obține imaginea pentru previzualizare în cazul în care documentul este un tip de imagine..
         * @return StreamedContent
         */
        public StreamedContent getImageUser() {
                return new DefaultStreamedContent(new ByteArrayInputStream(this.photo));
        }

        /**
         * Devuelve el nombre completo del usuario.
         *
         * @return Cadena formada por la concatenación de nombre y apellidos del usuario
         */
        public String getNumeComplet() {
                final StringBuilder numeComplet = new StringBuilder();
                return numeComplet.append(nume).append(' ').append(prenume).toString();
        }
}
