package com.orion.portafolio2017.model;

import java.util.ArrayList;
import java.util.List;

public class EstadoModel {

	private int idEstado;
	private String nombreEstado;

	public EstadoModel() {
	}

	public EstadoModel(int idEstado, String nombreEstado) {
		this.idEstado = idEstado;
		this.nombreEstado = nombreEstado;
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


}
