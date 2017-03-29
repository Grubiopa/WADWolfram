package com.mycompany.mavenproject1.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration

public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Public pages
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/register").permitAll();
		http.authorizeRequests().antMatchers("/contact").permitAll();
		http.authorizeRequests().antMatchers("/about").permitAll();
		http.authorizeRequests().antMatchers("/projects").permitAll();
		http.authorizeRequests().antMatchers("/blog").permitAll();
		http.authorizeRequests().antMatchers("/error").permitAll();

		// Private pages (all other pages)
		http.authorizeRequests().antMatchers("/pay").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/admin/").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/admin/AddBlog").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/admin/AddProject").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/admin/Donations").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/admin/Profile").hasAnyRole("ADMIN");

		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("email");
		http.formLogin().passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/users/login");
		http.formLogin().failureUrl("/login");
		// Logout
		http.logout().logoutUrl("/user/close");
		http.logout().logoutSuccessUrl("/");
		
		//http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider);
	}

}


