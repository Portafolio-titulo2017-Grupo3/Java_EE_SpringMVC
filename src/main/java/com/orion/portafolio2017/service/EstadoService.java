package com.orion.portafolio2017.service;

import java.util.List;

import com.orion.portafolio2017.entity.Estado;

public interface EstadoService {

	public abstract Estado findEstadoById(int id);
	
	public abstract List<Estado> findAllEstado();
	
}
