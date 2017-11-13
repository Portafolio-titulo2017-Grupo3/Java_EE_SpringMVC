package com.orion.portafolio2017.model;


public class DepartamentoModel {

	private int idDepto;
	private String nombreDepto;

	public DepartamentoModel() {
	}


	public DepartamentoModel(int idDepto, String nombreDepto) {
		super();
		this.idDepto = idDepto;
		this.nombreDepto = nombreDepto;
	}


	public int getIdDepto() {
		return idDepto;
	}


	public void setIdDepto(int idDepto) {
		this.idDepto = idDepto;
	}


	public String getNombreDepto() {
		return nombreDepto;
	}


	public void setNombreDepto(String nombreDepto) {
		this.nombreDepto = nombreDepto;
	}


	@Override
	public String toString() {
		return "DepartamentoModel [idDepto=" + idDepto + ", nombreDepto=" + nombreDepto + "]";
	}

	

}
