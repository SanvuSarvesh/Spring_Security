package com.example.SpringSecurity.Configuration;

import com.example.SpringSecurity.Services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/allUser/**").permitAll()
                //.antMatchers("/home", "/login/,"/etc").permitAll()
                .antMatchers("/public/**").hasRole("NORMAL")// only user will be
                .antMatchers("/signin").permitAll()// making singin url public
                // able to access with public end point
                .anyRequest()
                .authenticated()
                .and()
                //.httpBasic(); // basic authentication
                .formLogin()
                .loginPage("/signin") // login will happen by "/signin" url
                .loginProcessingUrl("/doLogin")
                .defaultSuccessUrl("/user/");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("sanvu01")
//                .password(this.passwordEncoder().encode("Sanvu@01"))
//                //.password("Sanvu@01")
//                .roles("NORMAL");
//        auth
//                .inMemoryAuthentication()
//                .withUser("ritu01")
//                .password(passwordEncoder().encode("ritu@098"))
//                .roles("ADMIN");

        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());


    }

    /*
    * Role based authentication
    * Role :- NORMAL -> Can read only
    * Authority -> Permission
    * Role :- ADMIN -> Can read,write and update
    *
    * */

    @Bean
    public PasswordEncoder passwordEncoder(){
        // for plan password
        //return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder(10); // this will encode our password
    }
}
