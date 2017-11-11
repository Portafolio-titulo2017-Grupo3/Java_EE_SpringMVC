package com.orion.portafolio2017.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion.portafolio2017.entity.Motivo;
import com.orion.portafolio2017.repository.MotivoRepository;
import com.orion.portafolio2017.service.MotivoService;

@Service("motivoServiceImpl")
public class MotivoServiceImpl implements MotivoService{

	@Autowired
	@Qualifier("motivoRepository")
	private MotivoRepository motivoRepository;
	
	@Override
	public Motivo findMotivoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Motivo> findAllMotivo() {
		List<Motivo> motivos= motivoRepository.findAll();
		for(Motivo motivo : motivos) {
			motivos.add(motivo);
		}
		return motivos;
	}

}
