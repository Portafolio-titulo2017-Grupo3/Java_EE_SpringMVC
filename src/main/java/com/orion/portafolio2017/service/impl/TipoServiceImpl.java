package com.orion.portafolio2017.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion.portafolio2017.converter.TipoConverter;
import com.orion.portafolio2017.entity.Tipo;
import com.orion.portafolio2017.model.TipoModel;
import com.orion.portafolio2017.repository.TipoRepository;
import com.orion.portafolio2017.service.TipoService;

@Service("tipoService")
public class TipoServiceImpl implements TipoService {

	@Autowired
	@Qualifier("tipoConverter")
	private TipoConverter tipoConverter;

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
		List<Tipo> tipos = tipoRepository.findAll();
		List<Tipo> motivoModel = new ArrayList<Tipo>();
		for (Tipo tipo : tipos) {
			motivoModel.add(tipo);
		}
		return motivoModel;
	}

	@Override
	public List<TipoModel> findAllTipoModel() {
		List<Tipo> tipos = tipoRepository.findAll();
		List<TipoModel> motivoModel = new ArrayList<TipoModel>();
		for (Tipo tipo : tipos) {
			motivoModel.add(tipoConverter.convertTipo2TipoModel(tipo));
		}
		return motivoModel;
	}

}
