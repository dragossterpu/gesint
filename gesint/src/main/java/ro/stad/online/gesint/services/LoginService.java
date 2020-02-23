package ro.stad.online.gesint.services;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ro.stad.online.gesint.persistence.entities.Utilizator;

/**
 * Implementación del Service de Login.
 * @author STAD
 *
 */
@Service
public class LoginService implements UserDetailsService, Serializable {

        /**
         * Clasa UserRepositoryUserDetails.
         */
        private static final class UserRepositoryUserDetails extends Utilizator implements UserDetails {

                private static final long serialVersionUID = 1L;

                /**
                 * Setați detaliile conexiunii utilizatorului.
                 * @param user User
                 */
                public UserRepositoryUserDetails(final Utilizator user) {
                        super();
                        this.setUsername(user.getUsername());
                        this.setPassword(user.getPassword());
                        this.setRole(user.getRole());
                        this.setAdresa(user.getAdresa());
                        this.setCanalCorespondenta(user.getCanalCorespondenta());
                        this.setDataNasterii(user.getDataNasterii());
                        this.setStatutCivil(user.getStatutCivil());
                        this.setDateCreate(user.getDateCreate());
                        this.setDateDeleted(user.getDateDeleted());
                        this.setEducatie(user.getEducatie());
                        this.setEmail(user.getEmail());
                        this.setIdCard(user.getIdCard());
                        this.setPrenume(user.getPrenume());
                        this.setLocalitate(user.getLocalitate());
                        this.setNume(user.getNume());
                        this.setNumarCard(user.getNumarCard());
                        this.setPersonalEmail(user.getPersonalEmail());
                        this.setPhone(user.getPhone());
                        this.setPhoto(user.getPhoto());
                        this.setCodJudet(user.getCodJudet());
                        this.setSex(user.getSex());
                        this.setValidat(user.getValidat());
                        this.setLocMunca(user.getLocMunca());
                }

                /**
                 * Clasa GrantedAuthority.
                 */
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                        final Set<GrantedAuthority> authorities = new HashSet<>();
                        authorities.add(new SimpleGrantedAuthority(getRole().name()));

                        return authorities;
                }

                /**
                 *
                 * Metoda care indică faptul că utilizatorul nu este expirat.
                 */
                @Override
                public boolean isAccountNonExpired() {
                        // Falta implementar las condiciones
                        // Ej return getFechaBaja() == null;
                        return true;
                }

                /**
                 * Metoda care indică faptul că utilizatorul nu este blocat.
                 */
                @Override
                public boolean isAccountNonLocked() {
                        boolean isAccountNonLocked = false;
                        if (this.getValidat()) {
                                isAccountNonLocked = true;
                        }
                        return isAccountNonLocked;
                }

                /**
                 * Metoda care indică faptul că utilizatorul nu are parola expirata.
                 */
                @Override
                public boolean isCredentialsNonExpired() {
                        return true;
                }

                /**
                 * Metoda care indică faptul că utilizatorul este activ
                 */
                @Override
                public boolean isEnabled() {
                        boolean isEnabled = false;
                        if (this.getDateDeleted() == null) {
                                isEnabled = true;
                        }
                        return isEnabled;
                }

        }

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        /**
         * Service de utilizator.
         */
        @Autowired
        private transient UtilizatorService utilizatorService;

        /**
         * Metoda care incarcă detaliile după nume de utilizator.
         * @param username String
         * @return UserDetails
         * @throws UsernameNotFoundException numele de utilizator nu a fost găsit
         */
        @Override
        public UserDetails loadUserByUsername(final String username) {
                final Utilizator user = this.utilizatorService.fiindOne(username);
                if (null == user) {
                        throw new UsernameNotFoundException("Utilizatorul nu există.");
                }

                return new UserRepositoryUserDetails(user);
        }

}
