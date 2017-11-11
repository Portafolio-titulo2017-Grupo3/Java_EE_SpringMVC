package com.orion.portafolio2017.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion.portafolio2017.entity.Estado;
import com.orion.portafolio2017.repository.EstadoRepository;
import com.orion.portafolio2017.service.EstadoService;

@Service("estadoServiceImpl")
public class EstadoServiceImpl implements EstadoService {
	
	@Autowired
	@Qualifier("estadoRepository")
	private EstadoRepository estadoRepository;

	@Override
	public Estado findEstadoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estado> findAllEstado() {
		List<Estado> estados= estadoRepository.findAll();
		for(Estado estado : estados) {
			estados.add(estado);
		}
		return estados;
	}

}
