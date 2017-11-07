package com.orion.portafolio2017.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UsuarioModel {

	private int idUsuario;
	private FuncionarioModel funcionarioModel;
	private PerfilModel perfilModel;
	private String username;
	private String password;

	public UsuarioModel() {
	}

	public UsuarioModel(int idUsuario, FuncionarioModel funcionarioModel, PerfilModel perfilModel, String nombreUsuario,
			String claveUsuario) {
		this.idUsuario = idUsuario;
		this.funcionarioModel = funcionarioModel;
		this.perfilModel = perfilModel;
		this.username = nombreUsuario;
		this.password = claveUsuario;
	}

	public UsuarioModel(String username2, String password2, SimpleGrantedAuthority authorities) {
		// TODO Auto-generated constructor stub
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public FuncionarioModel getFuncionario() {
		return this.funcionarioModel;
	}

	public void setFuncionario(FuncionarioModel funcionarioModel) {
		this.funcionarioModel = funcionarioModel;
	}

	public PerfilModel getPerfil() {
		return this.perfilModel;
	}

	public void setPerfil(PerfilModel perfilModel) {
		this.perfilModel = perfilModel;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String nombreUsuario) {
		this.username = nombreUsuario;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String claveUsuario) {
		this.password = claveUsuario;
	}

}
