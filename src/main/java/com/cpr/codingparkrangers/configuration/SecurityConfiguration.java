package com.cpr.codingparkrangers.configuration;

import com.cpr.codingparkrangers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  @Autowired
  private DataSource dataSource;
//  @Autowired
//  private UserService userService;
  @Value("${spring.queries.users-query}")
  private String usersQuery;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth
            .jdbcAuthentication()
            .usersByUsernameQuery(usersQuery)
            .dataSource(dataSource)
            .passwordEncoder(bCryptPasswordEncoder);
//    auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception{
    System.out.println("A");

    http
            .authorizeRequests()
            .antMatchers("/profile").authenticated()
            .antMatchers("/profile/*").authenticated()
            .and()
//            .antMatchers("/console/**").permitAll()
//            .antMatchers("/").permitAll()
//            .antMatchers("/login").permitAll()
//            .antMatchers("/signup").permitAll()
//            .antMatchers().hasAnyAuthority().anyRequest()
//            .authenticated().and().csrf().disable()
            .formLogin()
            .loginPage("/signin").failureUrl("/login?error=true")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login").and().exceptionHandling();
    System.out.println("B");

    http.headers().frameOptions().disable();
    System.out.println("C");

  }
  @Override
  public void configure(WebSecurity web) throws Exception{
    web
            .ignoring()
            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
  }

}
