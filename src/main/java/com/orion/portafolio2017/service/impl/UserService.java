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

import com.orion.portafolio2017.converter.FuncionarioConverter;
import com.orion.portafolio2017.entity.Cargo;
import com.orion.portafolio2017.entity.Departamento;
import com.orion.portafolio2017.entity.Funcionario;
import com.orion.portafolio2017.entity.Perfil;
import com.orion.portafolio2017.entity.Permiso;
import com.orion.portafolio2017.entity.Usuario;
import com.orion.portafolio2017.model.FuncionarioInfoModel;
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
	
	
	/** Converters */
	
	
	@Autowired
	@Qualifier("funcionarioConverter")
	private FuncionarioConverter funcionarioConverter;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.orion.portafolio2017.entity.Usuario usuario = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(usuario.getPerfil());
		return buildUser(usuario, authorities);	
	}
	
	//Obtiene el nombre de PerfilModel según Nombre de UsuarioModel
	public String obtenerPerfilByUsuario(String username) {
		com.orion.portafolio2017.entity.Usuario usuario = userRepository.findByUsername(username);
		return usuario.getPerfil().getNombrePerfil().toString();
	}
	
	//Obtiene el rut del FuncionarioModel según Nombre de UsuarioModel
	public String obtenerRutFuncionarioByUsuario(String username) {
		com.orion.portafolio2017.entity.Usuario usuario = userRepository.findByUsername(username);
		return usuario.getFuncionario().getRutFuncionario().toString();
	}
	
	
	//Obtiene los datos del FuncionarioModel según Nombre de Usuario
	public FuncionarioInfoModel obtenerFuncionarioByUsuario(String username) {
		com.orion.portafolio2017.entity.Usuario usuario = userRepository.findByUsername(username);
		FuncionarioInfoModel funcionarioModel = funcionarioConverter.convertFuncionario2FuncionarioModel(usuario.getFuncionario());
		return funcionarioModel;
	}
	
	/**
	 * Builds the user.
	 *
	 * @param usuario the user
	 * @param authorities the authorities
	 * @return the user
	 */
	private User buildUser(com.orion.portafolio2017.entity.Usuario usuario, List<GrantedAuthority> authorities) {
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, authorities);
	}
	
	/**
	 * Builds the authorities.
	 *
	 * @param perfils the user roles
	 * @return the list
	 */
	private List<GrantedAuthority> buildAuthorities(Perfil perfils){
		
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		auths.add(new SimpleGrantedAuthority(perfils.getNombrePerfil()));
		return new ArrayList<GrantedAuthority>(auths);
	}
	
	

}
