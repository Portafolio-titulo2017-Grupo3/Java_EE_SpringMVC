package com.orion.portafolio2017.model;

import java.util.ArrayList;
import java.util.List;

public class TipoModel {

	private int idTipo;
	private String nombreTipo;
	private String descripcionTipo;
	private List<PermisoModel> permisoModels = new ArrayList<PermisoModel>();

	public TipoModel() {
	}

	public TipoModel(int idTipo, String nombreTipo, String descripcionTipo) {
		this.idTipo = idTipo;
		this.nombreTipo = nombreTipo;
		this.descripcionTipo = descripcionTipo;
	}

	public TipoModel(int idTipo, String nombreTipo, String descripcionTipo, List<PermisoModel> permisoModels) {
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

	public List<PermisoModel> getPermisos() {
		return permisoModels;
	}

	public void setPermisos(List<PermisoModel> permisoModels) {
		this.permisoModels = permisoModels;
	}

}
