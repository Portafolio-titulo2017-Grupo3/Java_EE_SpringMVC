package com.orion.portafolio2017.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion.portafolio2017.entity.Funcionario;
import com.orion.portafolio2017.repository.FuncionarioRepository;
import com.orion.portafolio2017.service.FuncionarioService;

@Service("funcionarioService")
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	@Qualifier("funcionarioRepository")
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public Funcionario findFuncionarioByRut(String rut) {
		// TODO Auto-generated method stub
		return funcionarioRepository.findByRutFuncionario(rut);
	}

}
