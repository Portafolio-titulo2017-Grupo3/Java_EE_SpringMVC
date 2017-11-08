package com.orion.portafolio2017.model;

import java.util.ArrayList;
import java.util.List;

public class CargoModel {

	private int idCargo;
	private String nombreCargo;
	private long salario;
	private List<FuncionarioModel> funcionarioModels = new ArrayList<FuncionarioModel>();
	private List<HistorialCargoModel> historialCargoModels = new ArrayList<HistorialCargoModel>();

	public CargoModel() {
	}

	public CargoModel(int idCargo, String nombreCargo, long salario) {
		this.idCargo = idCargo;
		this.nombreCargo = nombreCargo;
		this.salario = salario;
	}

	public CargoModel(int idCargo, String nombreCargo, long salario, List<FuncionarioModel> funcionarioModels,
			List<HistorialCargoModel> historialCargoModels) {
		super();
		this.idCargo = idCargo;
		this.nombreCargo = nombreCargo;
		this.salario = salario;
		this.funcionarioModels = funcionarioModels;
		this.historialCargoModels = historialCargoModels;
	}

	public int getIdCargo() {
		return this.idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getNombreCargo() {
		return this.nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}

	public long getSalario() {
		return this.salario;
	}

	public void setSalario(long salario) {
		this.salario = salario;
	}

	public List<FuncionarioModel> getFuncionarios() {
		return funcionarioModels;
	}

	public void setFuncionarios(List<FuncionarioModel> funcionarioModels) {
		this.funcionarioModels = funcionarioModels;
	}

	public List<HistorialCargoModel> getHistorialCargos() {
		return historialCargoModels;
	}

	public void setHistorialCargos(List<HistorialCargoModel> historialCargoModels) {
		this.historialCargoModels = historialCargoModels;
	}

}
