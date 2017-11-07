package com.orion.portafolio2017.model;

import java.util.HashSet;
import java.util.Set;

public class EstadoModel {

	private int idEstado;
	private String nombreEstado;
	private Set<PermisoModel> permisoModels = new HashSet<PermisoModel>();

	public EstadoModel() {
	}

	public EstadoModel(int idEstado, String nombreEstado) {
		this.idEstado = idEstado;
		this.nombreEstado = nombreEstado;
	}

	public EstadoModel(int idEstado, String nombreEstado, Set<PermisoModel> permisoModels) {
		super();
		this.idEstado = idEstado;
		this.nombreEstado = nombreEstado;
		this.permisoModels = permisoModels;
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombreEstado() {
		return this.nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public Set<PermisoModel> getPermisos() {
		return permisoModels;
	}

	public void setPermisos(Set<PermisoModel> permisoModels) {
		this.permisoModels = permisoModels;
	}

}
