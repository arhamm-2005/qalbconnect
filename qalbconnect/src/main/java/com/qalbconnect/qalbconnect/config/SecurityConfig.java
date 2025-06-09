package com.qalbconnect.qalbconnect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.qalbconnect.qalbconnect.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // --- REMOVE THIS CONSTRUCTOR INJECTION FOR UserService ---
    // private final UserService userService;
    // public SecurityConfig(UserService userService) {
    //     this.userService = userService;
    // }
    // --- END REMOVAL ---


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures the authentication provider that uses our UserService and passwordEncoder.
     * --- IMPORTANT CHANGE HERE: UserService is now injected as a method parameter ---
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService) { // Inject UserService here
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService); // Tell the provider to use our UserService
        auth.setPasswordEncoder(passwordEncoder()); // Uses the passwordEncoder bean defined above
        return auth;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/register", "/login", "/css/**", "/js/**", "/images/**").permitAll() // Add "/" here
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            );
        return http.build();
    }
}