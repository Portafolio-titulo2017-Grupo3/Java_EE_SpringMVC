package com.orion.portafolio2017.converter;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.orion.portafolio2017.entity.Departamento;
import com.orion.portafolio2017.entity.Funcionario;
import com.orion.portafolio2017.model.DepartamentoModel;
import com.orion.portafolio2017.model.FuncionarioModel;


@Component("departamentoConverter")
public class DepartamentoConverter {
	
	@Autowired
	@Qualifier("funcionarioConverter")
	private FuncionarioConverter funcionarioConverter;

	public Departamento convertDepartamentoModel2Departamento(DepartamentoModel departamentoModel) {

		Departamento departamento = new Departamento();
		departamento.setIdDepto(departamentoModel.getIdDepto());
		departamento.setNombreDepto(departamentoModel.getNombreDepto());
		departamento.setFuncionarios((Set<Funcionario>) funcionarioConverter.convertFuncionarioModel2Funcionario((FuncionarioModel) departamentoModel.getFuncionarios()));
		return departamento;
		
	}
	

	public DepartamentoModel convertDepartamento2DepartamentoModel(Departamento departamento) {
		
		DepartamentoModel departamentoModel = new DepartamentoModel();
		departamentoModel.setIdDepto(departamento.getIdDepto());
		departamentoModel.setNombreDepto(departamento.getNombreDepto());
		departamentoModel.setFuncionarios((Set<FuncionarioModel>) funcionarioConverter.convertFuncionario2FuncionarioModel((Funcionario) departamentoModel.getFuncionarios()));
		return departamentoModel;
		
	}
}
