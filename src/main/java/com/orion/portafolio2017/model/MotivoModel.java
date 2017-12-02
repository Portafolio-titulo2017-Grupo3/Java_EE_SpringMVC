package com.orion.portafolio2017.model;

public class MotivoModel {

	private int idMotivo;
	private String descripcionMotivo;

	public MotivoModel() {
	}

	public MotivoModel(int idMotivo, String descripcionMotivo) {
		this.idMotivo = idMotivo;
		this.descripcionMotivo = descripcionMotivo;
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

}
