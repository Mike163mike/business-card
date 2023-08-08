package org.technosoft.businesscard.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.technosoft.businesscard.service.SecurityUserService;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
//@AllArgsConstructor
public class SecurityConfig {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private SecurityUserService securityUserService;
//    private  SecurityUserRepository securityUserRepository;
//    private  AuthenticationManager authenticationManager;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests
                                .requestMatchers("/admin").hasRole("ADMIN")
                                .requestMatchers("/**").permitAll()
                                .anyRequest().authenticated())
                .formLogin(withDefaults());

        //   .httpBasic(withDefaults());
        //  .formLogin(withDefaults());
        //  .addFilterBefore((Filter) authUser(), UsernamePasswordAuthenticationFilter.class);
//                .csrf().disable()
//                .cors().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/").permitAll()
//                .requestMatchers("/home_page/**").hasAnyRole("USER", "ADMIN")
//                .requestMatchers("/home_page/admin").hasRole("ADMIN")
//                .anyRequest().permitAll();
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
        return http.build();
    }

    @Bean   public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        authenticationProvider.setUserDetailsService(securityUserService);
        return authenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


//    public void authUser(String username) {
//        var securityUser = securityUserRepository.findSecurityUsersByUsername(username)
//                .orElseThrow(NoSuchElementException::new);
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(securityUser.getUsername(),
//                securityUser.getPassword()));
//        var userDetails = securityUserService.loadUserByUsername(securityUser.getUsername());
//    }

}

