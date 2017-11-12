package com.orion.portafolio2017.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion.portafolio2017.entity.Motivo;
import com.orion.portafolio2017.entity.Tipo;
import com.orion.portafolio2017.repository.TipoRepository;
import com.orion.portafolio2017.service.TipoService;

@Service("tipoService")
public class TipoServiceImpl implements TipoService {

	@Autowired
	@Qualifier("tipoRepository")
	private TipoRepository tipoRepository;
	
	@Override
	public Tipo findTipoById(int id) {
		// TODO Auto-generated method stub
		return tipoRepository.findByIdTipo(id);
	}

	@Override
	public List<Tipo> findAllTipo() {
		List<Tipo> tipos= tipoRepository.findAll();
		List<Tipo> motivoModel = new ArrayList<Tipo>();
		for(Tipo tipo : tipos) {
			motivoModel.add(tipo);
		}
		return motivoModel;
	}
	
	

}
