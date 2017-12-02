package com.orion.portafolio2017.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion.portafolio2017.converter.EstadoConverter;
import com.orion.portafolio2017.entity.Estado;
import com.orion.portafolio2017.model.EstadoModel;
import com.orion.portafolio2017.repository.EstadoRepository;
import com.orion.portafolio2017.service.EstadoService;

@Service("estadoService")
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	@Qualifier("estadoConverter")
	private EstadoConverter estadoConverter;

	@Autowired
	@Qualifier("estadoRepository")
	private EstadoRepository estadoRepository;

	@Override
	public Estado findEstadoById(int id) {
		// TODO Auto-generated method stub
		return estadoRepository.findByIdEstado(id);
	}

	@Override
	public EstadoModel findEstadoByIdModel(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estado> findAllEstado() {
		List<Estado> estados = estadoRepository.findAll();
		List<Estado> estadoModel = new ArrayList<Estado>();
		for (Estado estado : estados) {
			estadoModel.add(estado);
		}
		return estadoModel;
	}

	@Override
	public List<EstadoModel> findAllEstadoModel() {
		List<Estado> estados = estadoRepository.findAll();
		List<EstadoModel> estadoModel = new ArrayList<EstadoModel>();
		for (Estado estado : estados) {
			estadoModel.add(estadoConverter.convertEstado2EstadoModel(estado));
		}
		return estadoModel;
	}

}
