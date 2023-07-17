package com.example.movieTicketBooking.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {

   /* @Value("${admin.authority}")
    private String ADMIN_AUTH;*/

    private final String ADMIN_AUTH="ADMIN";
    private final String USER_AUTH="USER";

    @Bean
    public PasswordEncoder getMyPasswordEncoder(){
        return  NoOpPasswordEncoder.getInstance();
    }



    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
/*
*CSRF -> Cross-Site request forgery
* XSS -> Cross-site Script
*
*
* */
        httpSecurity
                .csrf().disable() //***csrf needs to be disabled if directly hitting POST api from unknown sources
                .authorizeRequests()
                //.antMatchers("/movie/add").hasAuthority(ADMIN_AUTH)
                .antMatchers("/**").permitAll();
        return httpSecurity.build();
    }


}




