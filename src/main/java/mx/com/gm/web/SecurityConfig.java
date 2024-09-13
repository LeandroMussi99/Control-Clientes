package mx.com.gm.web;

import mx.com.gm.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UsuarioService usuarioService;

    
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
   


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests -> authorizeRequests
                // Permitir acceso a recursos estáticos a todos los usuarios
                .requestMatchers("/webjars/**", "/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/editar/**", "/agregar/**", "/eliminar/**").hasRole("ADMIN")
                .requestMatchers("/").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                .loginPage("/login")
                .defaultSuccessUrl("/", true) // Redirige al inicio después del login exitoso
                .permitAll()
                )
                .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                .accessDeniedPage("/errores/403")
                );
        return http.build();
    }

}
