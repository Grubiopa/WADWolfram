package com.mycompany.mavenproject1.security;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationProvider;

import org.springframework.security.authentication.BadCredentialsException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;

import org.springframework.security.core.AuthenticationException;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Component;

import com.mycompany.mavenproject1.user.UserComponent;
import com.mycompany.mavenproject1.user.UserPersonalData;
import com.mycompany.mavenproject1.user.UserPersonalDataRepository;

@Component

public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {

	@Autowired

	private UserPersonalDataRepository userRepository;
	
	@Autowired
	
	private UserComponent userComponent;
	
	@Override

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		UserPersonalData user = userRepository.findByEmail(authentication.getName());

		if (user == null) {

			throw new BadCredentialsException("Usuario no encontrado");

		}
		String password = (String) authentication.getCredentials();		
		if (!new BCryptPasswordEncoder().matches(password, user.getPasswordHash())) {

			throw new BadCredentialsException("Contraseña incorrecta");

		} 
			userComponent.setLoggedUser(user);
			List<GrantedAuthority> roles = new ArrayList<>();

			for (String role : user.getRoles()) {

				roles.add(new SimpleGrantedAuthority(role));

			}

			return new UsernamePasswordAuthenticationToken( user.getEmail(),
				password, roles);

		}

	@Override
	public boolean supports(Class<?> authenticationObject) {

		return true;

	}

}
