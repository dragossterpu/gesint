package ro.stad.online.gesint.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter.XFrameOptionsMode;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import ro.stad.online.gesint.constante.Constante;
import ro.stad.online.gesint.services.LoginService;

/**
 * Controler al operațiunilor legate de conectarea utilizatorului și securitatea aplicației.
 * @author STAD
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        /**
         * Numărul maxim de utilizatori care se pot autentifica cu același nume de utilizator.
         */
        private static final int MAXCONCURRENTUSERSESSIONS = 1;

        /**
         * Controlează sesiunea unui utilizator. Declanșator folosit atunci când un utilizator își anulează sesiunea.
         * Este necesar să fie definit pentru a valida sesiunile deschise de un utilizator.
         * @return HttpSessionEventPublisher
         */
        @Bean
        public static HttpSessionEventPublisher httpSessionEventPublisher() {
                return new HttpSessionEventPublisher();
        }

        /**
         * Implementarea UserDetailsService de care Spring Security are nevoie.
         */
        @Autowired
        private transient LoginService loginService;

        /**
         * Implementarea a ce face Spring Security atunci când un utilizator se conectează cu succes. Folosit pentru
         * auditul de acces al aplicației.
         */
        @Autowired
        private transient AuthenticationSuccessHandlerPersonalizado authenticationSuccessHandlerPersonalizado;

        /**
         * Manager de conectare incorectA în sistem.
         */
        @Autowired
        private transient AuthenticationFailureHandler authenticationFailureHandlerPersonalizado;

        /**
         * Configurăm UserDetailsService și PasswordEncoder pe care le vom folosi.
         * @param auth constructor de autentificare
         * @throws Exception excepție generică
         */
        @Override
        protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(loginService).passwordEncoder(passwordEncoder());
        }

        /**
         * Setări de securitate pentru a nu permite accesul la pagini de către utilizatorii care nu au permisiunile
         * corespunzătoare. Definiția redirecției aplicației la logare și ieșire din aplicație.
         */
        @Override
        protected void configure(final HttpSecurity http) throws Exception {
                // Protecția dintre site-uri este dezactivată, incompatibilă cu implementarea actuală a sistemului
                http.csrf().disable();
                http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsMode.SAMEORIGIN));
                // Gestionarea cererilor HTTP la resursele sistemului bazate pe sesiunea utilizatorului
                http.authorizeRequests()
                                // Reurse comune
                                .antMatchers("/css/**", "/images/**", "/js/**", "/javax.faces.resource/**").permitAll()

                                // Acces in sistema
                                .antMatchers(Constante.LOGINROUTE + "/**").anonymous().antMatchers(Constante.ACCES)
                                .anonymous().antMatchers(Constante.INDEX).authenticated().antMatchers(Constante.ACCES)
                                .anonymous()
                                // Acces in administrarea aplicatiei numai pentru rolul ADMIN
                                .antMatchers("/userLost/**").hasAnyRole("ADMIN", "ADMIN").and().formLogin()
                                .loginPage(Constante.LOGINROUTE).loginProcessingUrl(Constante.LOGINROUTE)
                                .defaultSuccessUrl(Constante.INDEX).failureUrl(Constante.LOGINROUTE).and().logout()
                                .logoutUrl("/login/logout").logoutSuccessUrl(Constante.LOGINROUTE);
                http.logout().logoutUrl(Constante.LOGOUTROUTE).logoutSuccessUrl(Constante.LOGINROUTE);

                // Inceput de sesiune
                http.formLogin().loginPage(Constante.LOGINROUTE).permitAll()
                                .successHandler(authenticationSuccessHandlerPersonalizado)
                                .failureHandler(authenticationFailureHandlerPersonalizado);

                // Sfarsit de sesiune
                http.logout().invalidateHttpSession(true).logoutUrl(Constante.LOGOUTROUTE)
                                .logoutSuccessUrl(Constante.LOGINROUTE).deleteCookies("JSESSIONID");

                // configurație pentru gestionarea sesiunilor de utilizator
                http.sessionManagement().invalidSessionUrl(Constante.LOGINROUTE)
                                .maximumSessions(MAXCONCURRENTUSERSESSIONS).maxSessionsPreventsLogin(false)
                                .sessionRegistry(sessionRegistry()).expiredUrl(Constante.LOGINROUTE);

        }

        /**
         * Configurație de codare a parolei folosind BCrypt.
         * @return PasswordEncoder
         */
        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        /**
         * Folosit de spring security pentru a cunoaște utilizatorii (Main) care s-au autentificat.
         * @return SessionRegistry
         */
        public SessionRegistry sessionRegistry() {
                return new SessionRegistryImpl();
        }

}
