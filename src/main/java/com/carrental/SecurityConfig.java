package com.carrental;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.carrental.security.model.CustomAuthenticationProvider;
import com.carrental.security.model.OtpAuthenticationProvider;
import com.carrental.security.model.OtpFilter;
import com.carrental.security.model.UserNamePassWordFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserNamePassWordFilter firstFactorAuthFilter;
    private final OtpFilter secondFactorAuthFilter;
    private final CustomAuthenticationProvider usernamePasswordAuthProvider;
    private final OtpAuthenticationProvider mfaAuthProvider;
    
    SecurityConfig(UserNamePassWordFilter firstFactorAuthFilter,
    		OtpFilter secondFactorAuthFilter,
    		CustomAuthenticationProvider usernamePasswordAuthProvider,
    		OtpAuthenticationProvider mfaAuthProvider){
    	this.firstFactorAuthFilter =firstFactorAuthFilter;
    	this.secondFactorAuthFilter = secondFactorAuthFilter;
    	this.usernamePasswordAuthProvider = usernamePasswordAuthProvider;
    	this.mfaAuthProvider = mfaAuthProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeHttpRequests()
            .requestMatchers("/auth/**").permitAll()
            .anyRequest().authenticated();

        http.addFilterBefore(firstFactorAuthFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterAfter(secondFactorAuthFilter, UserNamePassWordFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(List.of(usernamePasswordAuthProvider, mfaAuthProvider));
    }
}

