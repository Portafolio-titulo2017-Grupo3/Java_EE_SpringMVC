package com.orion.portafolio2017.service;

import java.util.List;

import com.orion.portafolio2017.entity.Tipo;

public interface TipoService {

	public abstract Tipo findTipoById(int id);
	
	public abstract List<Tipo> findAllTipo();
}
