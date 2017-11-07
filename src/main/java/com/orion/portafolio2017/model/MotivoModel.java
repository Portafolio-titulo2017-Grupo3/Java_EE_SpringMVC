package com.orion.portafolio2017.model;

import java.util.HashSet;
import java.util.Set;

public class MotivoModel {

	private int idMotivo;
	private String descripcionMotivo;
	private Set<PermisoModel> permisoModels = new HashSet<PermisoModel>();

	public MotivoModel() {
	}

	public MotivoModel(int idMotivo, String descripcionMotivo) {
		this.idMotivo = idMotivo;
		this.descripcionMotivo = descripcionMotivo;
	}

	public MotivoModel(int idMotivo, String descripcionMotivo, Set<PermisoModel> permisoModels) {
		super();
		this.idMotivo = idMotivo;
		this.descripcionMotivo = descripcionMotivo;
		this.permisoModels = permisoModels;
	}

	public int getIdMotivo() {
		return this.idMotivo;
	}

	public void setIdMotivo(int idMotivo) {
		this.idMotivo = idMotivo;
	}

	public String getDescripcionMotivo() {
		return this.descripcionMotivo;
	}

	public void setDescripcionMotivo(String descripcionMotivo) {
		this.descripcionMotivo = descripcionMotivo;
	}

	public Set<PermisoModel> getPermisos() {
		return permisoModels;
	}

	public void setPermisos(Set<PermisoModel> permisoModels) {
		this.permisoModels = permisoModels;
	}

}
