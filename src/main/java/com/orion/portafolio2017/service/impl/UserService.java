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

import com.orion.portafolio2017.converter.CargoConverter;
import com.orion.portafolio2017.converter.DepartamentoConverter;
import com.orion.portafolio2017.converter.PermisoConverter;
import com.orion.portafolio2017.converter.UsuarioConverter;
import com.orion.portafolio2017.entity.Perfil;
import com.orion.portafolio2017.entity.Permiso;
import com.orion.portafolio2017.entity.Usuario;
import com.orion.portafolio2017.model.CargoModel;
import com.orion.portafolio2017.model.DepartamentoModel;
import com.orion.portafolio2017.model.FuncionarioModel;
import com.orion.portafolio2017.model.PermisoModel;
import com.orion.portafolio2017.model.UsuarioModel;
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
	@Qualifier("departamentoConverter")
	private DepartamentoConverter departamentoConverter;
	
	@Autowired
	@Qualifier("cargoConverter")
	private CargoConverter cargoConverter;
	
	@Autowired
	@Qualifier("permisoConverter")
	private PermisoConverter permisoConverter;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
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
	public FuncionarioModel obtenerFuncionarioByUsuario(String username) {
		com.orion.portafolio2017.entity.Usuario usuario = userRepository.findByUsername(username);
		UsuarioModel usuarios = usuarioConverter.convertUsuario2UsuarioModel((Usuario) usuario);
	/*	
		String rut = usuario.getFuncionario().getRutFuncionario();
		DepartamentoModel departamento = departamentoConverter.convertDepartamento2DepartamentoModel(usuario.getFuncionario().getDepartamento());
		CargoModel cargo = cargoConverter.convertCargo2CargoModel(usuario.getFuncionario().getCargo());
		String primerNombre = usuario.getFuncionario().getPrimerNombre();
		String segundoNombre = usuario.getFuncionario().getSegundoNombre();
		String primerApellido = usuario.getFuncionario().getPrimerApellido();
		String segundoApellido = usuario.getFuncionario().getSegundoApellido();
		long telefonoFunionario =usuario.getFuncionario().getTelefonoFunionario();
		String sexoFunionario = usuario.getFuncionario().getSexoFunionario();
		String correoFuncionario = usuario.getFuncionario().getCorreoFuncionario();
		Set<PermisoModel> permisos = (Set<PermisoModel>) permisoConverter.convertPermiso2PermisoModel((Permiso) usuario.getFuncionario().getPermisos());
		Set<UsuarioModel> usuarios = (Set<UsuarioModel>) usuarioConverter.convertUsuario2UsuarioModel((Usuario) usuario.getFuncionario().getUsuarios());
	*/
		String rut = usuarios.getFuncionario().getRutFuncionario();
		DepartamentoModel departamento = usuarios.getFuncionario().getDepartamento();
		CargoModel cargo = usuarios.getFuncionario().getCargo();
		String primerNombre = usuarios.getFuncionario().getPrimerNombre();
		String segundoNombre = usuarios.getFuncionario().getSegundoNombre();
		String primerApellido = usuarios.getFuncionario().getPrimerApellido();
		String segundoApellido = usuarios.getFuncionario().getSegundoApellido();
		long telefonoFunionario =usuarios.getFuncionario().getTelefonoFunionario();
		String sexoFunionario = usuarios.getFuncionario().getSexoFunionario();
		String correoFuncionario = usuarios.getFuncionario().getCorreoFuncionario();
		Set<PermisoModel> permisos = usuarios.getFuncionario().getPermisos();
		Set<UsuarioModel> usuarioss = usuarios.getFuncionario().getUsuarios();
		
		FuncionarioModel funcionary= new FuncionarioModel(rut,departamento,cargo,primerNombre,segundoNombre,
				primerApellido,segundoApellido,telefonoFunionario,sexoFunionario,correoFuncionario,permisos,usuarioss);
		return funcionary;
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
