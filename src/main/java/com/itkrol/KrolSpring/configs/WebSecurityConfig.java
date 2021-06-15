package com.itkrol.KrolSpring.configs;

import com.itkrol.KrolSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().
                disable()
                .authorizeRequests()
                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers("/blog/{id}").authenticated()
                .antMatchers("/blog/add").hasRole("ADMIN")
                .antMatchers("/blog/{id}/edit").hasRole("ADMIN")
                .antMatchers("/blog/{id}/remove").hasRole("ADMIN")
                .antMatchers("/", "/about/**").permitAll()
                .and()
                .formLogin()
                .and()
                .logout().logoutSuccessUrl("/");

    }

    @Autowired
   protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
   }

}
