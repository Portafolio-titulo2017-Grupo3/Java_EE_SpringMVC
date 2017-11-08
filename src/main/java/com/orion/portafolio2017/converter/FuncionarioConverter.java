package com.orion.portafolio2017.converter;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.orion.portafolio2017.entity.Departamento;
import com.orion.portafolio2017.entity.Funcionario;
import com.orion.portafolio2017.entity.Permiso;
import com.orion.portafolio2017.entity.Usuario;
import com.orion.portafolio2017.model.DepartamentoModel;
import com.orion.portafolio2017.model.FuncionarioModel;
import com.orion.portafolio2017.model.PermisoModel;
import com.orion.portafolio2017.model.UsuarioModel;


@Component("funcionarioConverter")
public class FuncionarioConverter {
	
	@Autowired
	@Qualifier("cargoConverter")
	private CargoConverter cargoConverter;
	
	@Autowired
	@Qualifier("departamentoConverter")
	private DepartamentoConverter departamentoConverter;
	
	@Autowired
	@Qualifier("permisoConverter")
	private PermisoConverter permisoConverter;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;

	public Funcionario convertFuncionarioModel2Funcionario(FuncionarioModel funcionarioModel) {

		Funcionario funcionario = new Funcionario();
		funcionario.setRutFuncionario(funcionarioModel.getRutFuncionario());
		funcionario.setCorreoFuncionario(funcionarioModel.getCorreoFuncionario());
		funcionario.setPrimerNombre(funcionarioModel.getPrimerNombre());
		funcionario.setPrimerApellido(funcionarioModel.getPrimerApellido());
		funcionario.setSegundoNombre(funcionarioModel.getSegundoNombre());
		funcionario.setSegundoApellido(funcionarioModel.getSegundoApellido());
		funcionario.setTelefonoFunionario(funcionarioModel.getTelefonoFunionario());
		funcionario.setSexoFunionario(funcionarioModel.getSexoFunionario());
		funcionario.setCargo(cargoConverter.convertCargoModel2Cargo(funcionarioModel.getCargo()));
		funcionario.setDepartamento(departamentoConverter.convertDepartamentoModel2Departamento(funcionarioModel.getDepartamento()));
		funcionario.setPermisos((Set<Permiso>) permisoConverter.convertPermisoModel2Permiso((PermisoModel) funcionarioModel.getPermisos()));
		funcionario.setUsuarios((Set<Usuario>) usuarioConverter.convertUsuarioModel2Usuario((UsuarioModel) funcionarioModel.getUsuarios()));
		return funcionario;
		
	}
	

	public FuncionarioModel convertFuncionario2FuncionarioModel(Funcionario funcionario) {
		
		FuncionarioModel funcionarioModel = new FuncionarioModel();
			funcionarioModel.setRutFuncionario(funcionario.getRutFuncionario());
			funcionarioModel.setCorreoFuncionario(funcionario.getCorreoFuncionario());
			funcionarioModel.setPrimerNombre(funcionario.getPrimerNombre());
			funcionarioModel.setPrimerApellido(funcionario.getPrimerApellido());
			funcionarioModel.setSegundoNombre(funcionario.getSegundoNombre());
			funcionarioModel.setSegundoApellido(funcionario.getSegundoApellido());
			funcionarioModel.setTelefonoFunionario(funcionario.getTelefonoFunionario());
			funcionarioModel.setSexoFunionario(funcionario.getSexoFunionario());
			funcionarioModel.setCargo(cargoConverter.convertCargo2CargoModel(funcionario.getCargo()));
			funcionarioModel.setDepartamento(departamentoConverter.convertDepartamento2DepartamentoModel(funcionario.getDepartamento()));
			funcionarioModel.setPermisos((Set<PermisoModel>) permisoConverter.convertPermiso2PermisoModel((Permiso) funcionarioModel.getPermisos()));
			funcionarioModel.setUsuarios((Set<UsuarioModel>) usuarioConverter.convertUsuario2UsuarioModel((Usuario) funcionarioModel.getUsuarios()));
		return funcionarioModel;
		
	}
}
