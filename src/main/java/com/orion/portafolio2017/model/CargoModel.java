package com.orion.portafolio2017.model;

import java.util.HashSet;
import java.util.Set;

public class CargoModel {

	private int idCargo;
	private String nombreCargo;
	private long salario;
	private Set<FuncionarioModel> funcionarioModels = new HashSet<FuncionarioModel>();
	private Set<HistorialCargoModel> historialCargoModels = new HashSet<HistorialCargoModel>();

	public CargoModel() {
	}

	public CargoModel(int idCargo, String nombreCargo, long salario) {
		this.idCargo = idCargo;
		this.nombreCargo = nombreCargo;
		this.salario = salario;
	}

	public CargoModel(int idCargo, String nombreCargo, long salario, Set<FuncionarioModel> funcionarioModels,
			Set<HistorialCargoModel> historialCargoModels) {
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

	public Set<FuncionarioModel> getFuncionarios() {
		return funcionarioModels;
	}

	public void setFuncionarios(Set<FuncionarioModel> funcionarioModels) {
		this.funcionarioModels = funcionarioModels;
	}

	public Set<HistorialCargoModel> getHistorialCargos() {
		return historialCargoModels;
	}

	public void setHistorialCargos(Set<HistorialCargoModel> historialCargoModels) {
		this.historialCargoModels = historialCargoModels;
	}

}
