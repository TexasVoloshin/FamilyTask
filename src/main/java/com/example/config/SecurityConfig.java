package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired

    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
         auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email as principal, password as cridentials, true from user where email =?")
                .usersByUsernameQuery("select user_email as principal, user_name as role from user_roles  where email =?")
                .passwordEncoder(passwordEncoder()).rolePrefix("ROLE_");

    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }


    @Override
    protected void configure(HttpSecurity http) throws  Exception{

        http.authorizeRequests().antMatchers("/register","/","/about","login","/css/**","/webjars/**").permitAll().anyRequest()
                .authenticated().and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/profile").and().logout().logoutSuccessUrl("/login");

    }
}
