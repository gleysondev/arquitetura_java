	package aulas.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/user").hasAnyRole("ADMIN","USER")
        .anyRequest().authenticated()
        .and()
        .formLogin();
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
      builder
          .inMemoryAuthentication()
          .withUser("admin").password("{noop}admin")
              .roles("ADMIN")
          .and()
          .withUser("user").password("{noop}user")
              .roles("USER");
    }
   
}