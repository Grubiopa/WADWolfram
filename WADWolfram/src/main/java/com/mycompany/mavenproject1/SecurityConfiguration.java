package com.mycompany.mavenproject1;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import org.springframework.security.authentication.AuthenticationProvider;


@Configuration

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
@Autowired
public UserRepositoryAuthenticationProvider authenticationProvider;

@Override
protected void configure(HttpSecurity http) throws Exception {
// Public pages
http.authorizeRequests().antMatchers("/").permitAll();
http.authorizeRequests().antMatchers("/login").permitAll();
http.authorizeRequests().antMatchers("/register").permitAll();
http.authorizeRequests().antMatchers("/contact").permitAll();
http.authorizeRequests().antMatchers("/aboutUs").permitAll();
//http.authorizeRequests().antMatchers("/loginerror").permitAll();
http.authorizeRequestsp.antMatchers("/logout").permitAll();

// Private pages (all other pages)
http.authorizeRequests().antMatchers("/home").hasAnyRole("USER");
http.authorizeRequests().antMatchers("/pay").hasAnyRole("USER");
http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");
http.authorizeRequests().antMatchers("/adminBlog").hasAnyRole("ADMIN");
http.authorizeRequests().antMatchers("/adminProjects").hasAnyRole("ADMIN");
http.authorizeRequests().antMatchers("/adminDonations").hasAnyRole("ADMIN");
http.authorizeRequests().antMatchers("/adminProfile").hasAnyRole("ADMIN");

// Login form
http.formLogin().loginPage(/login");
http.formLogin().usernameParameter("userName");
http.formLogin().passwordParameter("newPassword");
http.formLogin().defaultSuccessUrl("/home");
//http.formLogin().failureUrl("/loginerror");

// Logout
http.logout().logoutUrl("/logout");
http.logout().logoutSuccessUrl("/");
}

protected void configure(AuthenticationManagerBuilder auth) throws Exception {
auth.authenticationProvider(authenticationProvider);
}
}	