package ro.per.online.services;

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

import ro.per.online.persistence.entities.Users;
import ro.per.online.persistence.entities.enums.RoleEnum;

/**
 * Implementación del Service de Login.
 * @author STAD
 *
 */
@Service
public class LoginService implements UserDetailsService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Service de usuario.
	 */
	@Autowired
	private transient UserService userService;

	/**
	 * Carga los detalles por nombre de usuario.
	 * @param username String
	 * @return UserDetails
	 * @throws UsernameNotFoundException nombre de usuario no encontrado.
	 */
	@Override
	public UserDetails loadUserByUsername(final String username) {
		final Users user = this.userService.fiindOne(username);
		if (null == user) {
			throw new UsernameNotFoundException("El usuario no existe.");
		}

		return new UserRepositoryUserDetails(user);
	}

	/**
	 * Clase UserRepositoryUserDetails.
	 */
	private static final class UserRepositoryUserDetails extends Users implements UserDetails {

		private static final long serialVersionUID = 1L;

		/**
		 * Establece los detalles de conexión del usuario.
		 * @param user User
		 */
		public UserRepositoryUserDetails(Users user) {
			super();
			setUsername(user.getUsername());
			setPassword(user.getPassword());
			setRole(user.getRole());
		}

		/**
		 * Clase GrantedAuthority.
		 */
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			Set<GrantedAuthority> authorities = new HashSet<>();
			authorities.add(new SimpleGrantedAuthority(getRole().name()));

			return authorities;
		}

		/**
		 * Metodo que indica que el usuario no esta inactivo.
		 */
		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		/**
		 * Metodo que indica que el usuario no esta inactivo.
		 */
		@Override
		public boolean isAccountNonLocked() {
			boolean isAccountNonLocked = false;
			if (getRole() != null && (getRole().equals(RoleEnum.ROLE_ADMIN))) {
				isAccountNonLocked = true;
			}
			return isAccountNonLocked;
		}

		/**
		 * Metodo que indica que el usuario no tiene el passpord expirado.
		 */
		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		/**
		 * Metodo que indica que el usuario esta activo.
		 */
		@Override
		public boolean isEnabled() {
			return true;
		}

	}

}
