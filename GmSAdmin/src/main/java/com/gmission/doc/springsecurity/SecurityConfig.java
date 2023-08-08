package com.gmission.doc.springsecurity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyUtils;
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
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();

        Map<String,List<String>> roleHierarchyMap = new HashMap<>();
        roleHierarchyMap.put("ROLE_SYSADMIN", Arrays.asList("ROLE_ADMIN"));
        roleHierarchyMap.put("ROLE_ADMIN", Arrays.asList("ROLE_RECEAPPROVER"));
        roleHierarchyMap.put("ROLE_RECEAPPROVER", Arrays.asList("ROLE_DEFAPPROVER"));
        roleHierarchyMap.put("ROLE_DEFAPPROVER", Arrays.asList("ROLE_USER"));

        String roleStr = RoleHierarchyUtils.roleHierarchyFromMap(roleHierarchyMap);
        System.out.println(String.format("RoleHierarchyUtils.roleHierarchyFromMap(roleHierarchyMap)=[%s]", roleStr));
        roleHierarchy.setHierarchy(roleStr);

        return roleHierarchy;

    }


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(a -> a.disable()).cors(f -> f.disable())
                .authorizeHttpRequests(b ->
                                b.requestMatchers("/superAdminDTC", "/adminDTC").hasRole("SYSADMIN")
                                .requestMatchers("/adminDTC").hasRole("ADMIN")
                                .requestMatchers("/DTC/**").hasRole("USER")
                                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                                .anyRequest().permitAll()
                )
                .formLogin(c -> c.loginPage("/login/loginDTC")
                                .loginProcessingUrl("/loginSecurity")
                                .defaultSuccessUrl("/DTC/indexDTC")
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

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    HttpFirewall getHttpFirewall() {
        return new DefaultHttpFirewall();
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

}
