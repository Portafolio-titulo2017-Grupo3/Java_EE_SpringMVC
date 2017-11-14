package com.orion.portafolio2017.service;

import java.util.List;

import com.orion.portafolio2017.entity.Departamento;
import com.orion.portafolio2017.model.DepartamentoModel;

public interface DepartamentoService {

	public abstract Departamento findDepartamentoByIdDepto(int idDepto);
	
	public abstract DepartamentoModel findDepartamentoModelByIdDepto(int idDepto);
	
	public abstract List<DepartamentoModel> findAllDepartamentoModel();
	
	
}
