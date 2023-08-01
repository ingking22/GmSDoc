package com.gmission.doc.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
        http.csrf(a -> a.disable()).cors(f -> f.disable())
                .authorizeHttpRequests(b -> 
                				b.requestMatchers("/superAdminDTC", "/adminDTC").hasRole("SUPERADMIN")
                                .requestMatchers("/adminDTC").hasRole("ADMIN")
                                .requestMatchers("/dtc/**").hasRole("USER")
                                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                                .anyRequest().permitAll()
                )
                .formLogin(c -> c.loginPage("/login/loginDTC")
                                .loginProcessingUrl("/loginSecurity")
                                .defaultSuccessUrl("/dtc/indexDTC")
                                .usernameParameter("loginid")
                                .passwordParameter("password")
                                .failureUrl("/login/loginDTC?error=AccessFail")
                )
                .logout(d -> d.logoutSuccessUrl("/logoutDTC")
                                .invalidateHttpSession(true)
                );
             

    	/*
    	b.requestMatchers("/login/**"
                											,"/resources/**","/static/**"
                											,"/static/css/**","/static/js/**"
                											,"/static/img/**","/static/fonts/**").permitAll()
    	*/
		
        return http.getOrBuild();
    }
	
    /*
    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
    	return (a) -> a.ignoring().requestMatchers(
    										"/login/**",
    										"/static/css/**","/static/js/**"
    										,"/static/img/**","/static/fonts");
    }
    */
    
    @Bean
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }

    @Bean
    HttpFirewall getHttpFirewall() {
        return new DefaultHttpFirewall();
    }
	
	
}
