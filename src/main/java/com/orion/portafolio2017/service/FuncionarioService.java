package com.orion.portafolio2017.service;

import com.orion.portafolio2017.entity.Funcionario;
import com.orion.portafolio2017.model.FuncionarioInfoModel;

public interface FuncionarioService {

	public abstract Funcionario findFuncionarioByRut(String rut);

	public abstract FuncionarioInfoModel findFuncionarioModelByRut(String rut);

}
