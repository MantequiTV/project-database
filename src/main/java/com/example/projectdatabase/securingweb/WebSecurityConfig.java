package com.example.projectdatabase.securingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    // get database information from Spring JPA
    @Autowired
    private DataSource dataSource;

    // use Spring's Value annotation to get data from application.properties
    @Value("${project-database.default-password}")
    private String default_password;
    @Value("${project-database.default-username}")
    private String default_username;

//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .requestMatchers(new AntPathRequestMatcher("/")).permitAll();
//
//        super.configure(http);
//        // if you decide to use Vaadin.
//        // setLoginView(http, LoginView.class);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        // for encoding our passwords.
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        // This is all we really need to do.
//        JdbcUserDetailsManager dbManager = new JdbcUserDetailsManager(dataSource);
//
//        // But we would like to have a default super-user, so let's create one:
//
//        dbManager.createUser(
//                User.withUsername(default_username)
//                    .password(passwordEncoder().encode(default_password))
//                    // give all the powers!
//                    .roles("USER", "ADMIN", "SUPER_ADMIN")
//                    .disabled(false)
//                    .build()
//        );
//        return dbManager;
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
