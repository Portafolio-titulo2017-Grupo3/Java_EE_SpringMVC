package com.orion.portafolio2017.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion.portafolio2017.converter.FuncionarioConverter;
import com.orion.portafolio2017.entity.Funcionario;
import com.orion.portafolio2017.model.FuncionarioInfoModel;
import com.orion.portafolio2017.repository.FuncionarioRepository;
import com.orion.portafolio2017.service.FuncionarioService;

@Service("funcionarioService")
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	@Qualifier("funcionarioRepository")
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	@Qualifier("funcionarioConverter")
	private FuncionarioConverter funcionarioConverter;
	
	@Override
	public Funcionario findFuncionarioByRut(String rut) {
		// TODO Auto-generated method stub
		return funcionarioRepository.findByRutFuncionario(rut);
	}

	@Override
	public FuncionarioInfoModel findFuncionarioModelByRut(String rut) {
		// TODO Auto-generated method stub
		return funcionarioConverter.convertFuncionario2FuncionarioModel(funcionarioRepository.findByRutFuncionario(rut));
	}

}
