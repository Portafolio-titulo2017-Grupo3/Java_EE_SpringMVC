package com.orion.portafolio2017.model;

import java.util.HashSet;
import java.util.Set;

public class TipoModel {

	private int idTipo;
	private String nombreTipo;
	private String descripcionTipo;
	private Set<PermisoModel> permisoModels = new HashSet<PermisoModel>();

	public TipoModel() {
	}

	public TipoModel(int idTipo, String nombreTipo, String descripcionTipo) {
		this.idTipo = idTipo;
		this.nombreTipo = nombreTipo;
		this.descripcionTipo = descripcionTipo;
	}

	public TipoModel(int idTipo, String nombreTipo, String descripcionTipo, Set<PermisoModel> permisoModels) {
		super();
		this.idTipo = idTipo;
		this.nombreTipo = nombreTipo;
		this.descripcionTipo = descripcionTipo;
		this.permisoModels = permisoModels;
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getNombreTipo() {
		return this.nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	public String getDescripcionTipo() {
		return this.descripcionTipo;
	}

	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}

	public Set<PermisoModel> getPermisos() {
		return permisoModels;
	}

	public void setPermisos(Set<PermisoModel> permisoModels) {
		this.permisoModels = permisoModels;
	}

}
