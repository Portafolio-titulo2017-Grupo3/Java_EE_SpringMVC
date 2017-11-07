package com.orion.portafolio2017.model;

import java.util.Date;

public class HistorialCargoModel {

	private int id_historial;
	private Date fechaInicio;
	private CargoModel cargoModel;
	private Date fechaTermino;

	public HistorialCargoModel() {
	}

	public HistorialCargoModel(int id_historial, CargoModel cargoModel) {
		super();
		this.id_historial = id_historial;
		this.cargoModel = cargoModel;
	}

	public HistorialCargoModel(int id_historial, Date fechaInicio, CargoModel cargoModel, Date fechaTermino) {
		super();
		this.id_historial = id_historial;
		this.fechaInicio = fechaInicio;
		this.cargoModel = cargoModel;
		this.fechaTermino = fechaTermino;
	}

	public int getId_historial() {
		return id_historial;
	}

	public void setId_historial(int id_historial) {
		this.id_historial = id_historial;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public CargoModel getCargo() {
		return this.cargoModel;
	}

	public void setCargo(CargoModel cargoModel) {
		this.cargoModel = cargoModel;
	}

	public Date getFechaTermino() {
		return this.fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

}
