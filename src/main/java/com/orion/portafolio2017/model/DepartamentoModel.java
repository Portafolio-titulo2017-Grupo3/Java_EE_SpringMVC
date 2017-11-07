package com.orion.portafolio2017.model;

import java.util.HashSet;
import java.util.Set;

public class DepartamentoModel {

	private int idDepto;
	private String nombreDepto;
	private Set<FuncionarioModel> funcionarioModels = new HashSet<FuncionarioModel>();

	public DepartamentoModel() {
	}

	public DepartamentoModel(int idDepto, String nombreDepto) {
		this.idDepto = idDepto;
		this.nombreDepto = nombreDepto;
	}

	public DepartamentoModel(int idDepto, String nombreDepto, Set<FuncionarioModel> funcionarioModels) {
		super();
		this.idDepto = idDepto;
		this.nombreDepto = nombreDepto;
		this.funcionarioModels = funcionarioModels;
	}

	public int getIdDepto() {
		return this.idDepto;
	}

	public void setIdDepto(int idDepto) {
		this.idDepto = idDepto;
	}

	public String getNombreDepto() {
		return this.nombreDepto;
	}

	public void setNombreDepto(String nombreDepto) {
		this.nombreDepto = nombreDepto;
	}

	public Set<FuncionarioModel> getFuncionarios() {
		return funcionarioModels;
	}

	public void setFuncionarios(Set<FuncionarioModel> funcionarioModels) {
		this.funcionarioModels = funcionarioModels;
	}

}
