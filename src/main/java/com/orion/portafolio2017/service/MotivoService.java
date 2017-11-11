package com.orion.portafolio2017.service;

import java.util.List;

import com.orion.portafolio2017.entity.Motivo;

public interface MotivoService {
	
	public abstract Motivo findMotivoById(int id);
	
	public abstract List<Motivo> findAllMotivo();

}
