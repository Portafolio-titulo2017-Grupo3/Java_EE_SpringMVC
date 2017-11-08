package com.orion.portafolio2017.model;

import java.util.ArrayList;
import java.util.List;

public class EstadoModel {

	private int idEstado;
	private String nombreEstado;
	private List<PermisoModel> permisoModels = new ArrayList<PermisoModel>();

	public EstadoModel() {
	}

	public EstadoModel(int idEstado, String nombreEstado) {
		this.idEstado = idEstado;
		this.nombreEstado = nombreEstado;
	}

	public EstadoModel(int idEstado, String nombreEstado, List<PermisoModel> permisoModels) {
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

	public List<PermisoModel> getPermisos() {
		return permisoModels;
	}

	public void setPermisos(List<PermisoModel> permisoModels) {
		this.permisoModels = permisoModels;
	}

}
