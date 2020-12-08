package aulas.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
   @Override
    protected void configure(HttpSecurity http) throws Exception { 
        http
        .cors().and()
        .csrf().disable().authorizeRequests()
        
        .antMatchers("/home").permitAll()
        .antMatchers("/admin").hasAnyRole("manager","admin")
        
        .anyRequest().authenticated()
        .and()
        .formLogin();
    }
   
}