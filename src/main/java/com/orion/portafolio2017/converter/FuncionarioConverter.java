package com.orion.portafolio2017.converter;

import org.springframework.stereotype.Component;

import com.orion.portafolio2017.entity.Departamento;
import com.orion.portafolio2017.entity.Funcionario;
import com.orion.portafolio2017.model.DepartamentoModel;
import com.orion.portafolio2017.model.FuncionarioModel;


@Component("funcionarioConverter")
public class FuncionarioConverter {

	public Funcionario convertFuncionarioModel2Funcionario(FuncionarioModel funcionarioModel) {

		Funcionario funcionario = new Funcionario();
		return funcionario;
		
	}
	

	public FuncionarioModel convertFuncionario2FuncionarioModel(Funcionario funcionario) {
		
		FuncionarioModel funcionarioModel = new FuncionarioModel();
		return funcionarioModel;
		
	}
}
