package com.orion.portafolio2017.model;

import java.util.HashSet;
import java.util.Set;

public class PerfilModel {

	private int idPerfil;
	private String nombrePerfil;
	private String descripcionPerfil;
	private Set<UsuarioModel> usuarioModels = new HashSet<UsuarioModel>();

	public PerfilModel() {
	}

	public PerfilModel(int idPerfil, String nombrePerfil, String descripcionPerfil) {
		this.idPerfil = idPerfil;
		this.nombrePerfil = nombrePerfil;
		this.descripcionPerfil = descripcionPerfil;
	}

	public PerfilModel(int idPerfil, String nombrePerfil, String descripcionPerfil, Set<UsuarioModel> usuarioModels) {
		super();
		this.idPerfil = idPerfil;
		this.nombrePerfil = nombrePerfil;
		this.descripcionPerfil = descripcionPerfil;
		this.usuarioModels = usuarioModels;
	}

	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombrePerfil() {
		return this.nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	public String getDescripcionPerfil() {
		return this.descripcionPerfil;
	}

	public void setDescripcionPerfil(String descripcionPerfil) {
		this.descripcionPerfil = descripcionPerfil;
	}

	public Set<UsuarioModel> getUsuarios() {
		return usuarioModels;
	}

	public void setUsuarios(Set<UsuarioModel> usuarioModels) {
		this.usuarioModels = usuarioModels;
	}

}
