package com.orion.portafolio2017.converter;


import org.springframework.stereotype.Component;

import com.orion.portafolio2017.entity.Funcionario;
import com.orion.portafolio2017.model.FuncionarioInfoModel;


@Component("funcionarioConverter")
public class FuncionarioConverter {
	

	public Funcionario convertFuncionarioModel2Funcionario(FuncionarioInfoModel funcionarioModel) {

		Funcionario funcionario = new Funcionario();
		funcionario.setRutFuncionario(funcionarioModel.getRutFuncionario());
		funcionario.setCorreoFuncionario(funcionarioModel.getCorreoFuncionario());
		funcionario.setPrimerNombre(funcionarioModel.getPrimerNombre());
		funcionario.setPrimerApellido(funcionarioModel.getPrimerApellido());
		funcionario.setSegundoNombre(funcionarioModel.getSegundoNombre());
		funcionario.setSegundoApellido(funcionarioModel.getSegundoApellido());
		funcionario.setTelefonoFunionario(funcionarioModel.getTelefonoFunionario());
		funcionario.setSexoFunionario(funcionarioModel.getSexoFunionario());

		return funcionario;
		
	}
	

	public FuncionarioInfoModel convertFuncionario2FuncionarioModel(Funcionario funcionario) {
		
		FuncionarioInfoModel funcionarioModel = new FuncionarioInfoModel();
		funcionarioModel.setRutFuncionario(funcionario.getRutFuncionario());
		funcionarioModel.setCorreoFuncionario(funcionario.getCorreoFuncionario());
		funcionarioModel.setPrimerNombre(funcionario.getPrimerNombre());
		funcionarioModel.setPrimerApellido(funcionario.getPrimerApellido());
		funcionarioModel.setSegundoNombre(funcionario.getSegundoNombre());
		funcionarioModel.setSegundoApellido(funcionario.getSegundoApellido());
		funcionarioModel.setTelefonoFunionario(funcionario.getTelefonoFunionario());
		funcionarioModel.setSexoFunionario(funcionario.getSexoFunionario());
		
		funcionarioModel.setIdCargo(funcionario.getCargo().getIdCargo());
		funcionarioModel.setNombreCargo(funcionario.getCargo().getNombreCargo());
		funcionarioModel.setSalario(funcionario.getCargo().getSalario());
		
		funcionarioModel.setIdDepto(funcionario.getDepartamento().getIdDepto());
		funcionarioModel.setNombreDepto(funcionario.getDepartamento().getNombreDepto());

		return funcionarioModel;
		
	}
}
