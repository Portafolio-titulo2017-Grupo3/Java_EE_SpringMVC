package com.orion.portafolio2017.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.orion.portafolio2017.converter.MotivoConverter;
import com.orion.portafolio2017.entity.Motivo;
import com.orion.portafolio2017.model.MotivoModel;
import com.orion.portafolio2017.repository.MotivoRepository;
import com.orion.portafolio2017.service.MotivoService;

@Service("motivoService")
public class MotivoServiceImpl implements MotivoService {

	@Autowired
	@Qualifier("motivoConverter")
	private MotivoConverter motivoConverter;

	@Autowired
	@Qualifier("motivoRepository")
	private MotivoRepository motivoRepository;

	@Override
	public Motivo findMotivoById(int id) {
		// TODO Auto-generated method stub
		return motivoRepository.findByIdMotivo(id);
	}

	@Override
	public List<Motivo> findAllMotivo() {
		List<Motivo> motivos = motivoRepository.findAll();
		List<Motivo> motivoModel = new ArrayList<Motivo>();
		for (Motivo motivo : motivos) {
			motivoModel.add(motivo);
		}
		return motivoModel;
	}

	@Override
	public List<MotivoModel> findAllMotivoModel() {
		List<Motivo> motivos = motivoRepository.findAll();
		List<MotivoModel> motivoModel = new ArrayList<MotivoModel>();
		for (Motivo motivo : motivos) {
			motivoModel.add(motivoConverter.convertMotivo2MotivoModel(motivo));
		}
		return motivoModel;
	}

	@Override
	public Motivo addMotivo(String motivo) {
		Motivo motivoO = new Motivo(0,motivo,null);
		Motivo motivoO2 = motivoRepository.save(motivoO);
		return motivoO2;
	}
	
	

}


