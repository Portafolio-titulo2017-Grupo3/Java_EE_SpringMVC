package com.orion.portafolio2017.model;

public class TipoModel {

	private int idTipo;
	private String nombreTipo;
	private String descripcionTipo;

	public TipoModel() {
	}

	public TipoModel(int idTipo, String nombreTipo, String descripcionTipo) {
		this.idTipo = idTipo;
		this.nombreTipo = nombreTipo;
		this.descripcionTipo = descripcionTipo;
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

}
