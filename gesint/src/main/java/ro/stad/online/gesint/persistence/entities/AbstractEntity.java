package ro.stad.online.gesint.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import ro.stad.online.gesint.constante.NumarMagic;

/**
 * Clasa abstracta para a evita duplicitatea in cod si in resltado.
 * @author STAD
 *
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = -5041785485043966367L;

        /**
         *
         * userCreate
         */
        @CreatedBy
        @Column(name = "USER_CREATE", length = NumarMagic.NUMBERTWOHUNDREDANDFIFTY)
        private String userCreate;

        /**
         * Data de creatie.
         */
        @CreatedDate
        @Column(name = "DATE_CREATE", nullable = false)
        private Date dateCreate;

        /**
         * Utilizator care elimina un registru
         */
        @Column(name = "USER_DELETED", length = NumarMagic.NUMBERTWOHUNDREDANDFIFTY)
        private String userDeleted;

        /**
         * Data eliminarii.
         */
        @Column(name = "DATE_DELETED")
        private Date dateDeleted;

        /**
         * Utilizator care modifica un registru
         */
        @LastModifiedBy
        @Column(name = "USER_UPDATED", length = NumarMagic.NUMBERTWOHUNDREDANDFIFTY)
        private String userUpdated;

        /**
         * Data ultimei modificari
         */
        @LastModifiedDate
        @Column(name = "DATE_UPDATED")
        private Date dateUpdated;

}
