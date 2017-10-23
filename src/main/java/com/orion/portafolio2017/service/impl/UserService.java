package com.orion.portafolio2017.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;


import com.orion.portafolio2017.entity.Perfil;
import com.orion.portafolio2017.entity.Usuario;
import com.orion.portafolio2017.repository.UserRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserService.
 */
@Service("userService")
public class UserService implements UserDetailsService{

	/** The user repository. */
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.orion.portafolio2017.entity.Usuario usuario = userRepository.findByUsername(username);
		SimpleGrantedAuthority authorities = buildAuthorities(usuario.getPerfil());
		return (UserDetails) buildUser(usuario, authorities);
	}
	
	/**
	 * Builds the user.
	 *
	 * @param usuario the user
	 * @param authorities the authorities
	 * @return the user
	 */
	private Usuario buildUser(com.orion.portafolio2017.entity.Usuario usuario, SimpleGrantedAuthority authorities) {
		return new Usuario(usuario.getUsername(), usuario.getPassword(),authorities);
	}
	
	/**
	 * Builds the authorities.
	 *
	 * @param perfils the user roles
	 * @return the list
	 */
	private SimpleGrantedAuthority buildAuthorities(Perfil perfils){
		
		return new SimpleGrantedAuthority(perfils.getRole());
	}
	
	

}
