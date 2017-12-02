package com.orion.portafolio2017.service;

import java.util.List;

import com.orion.portafolio2017.entity.Tipo;
import com.orion.portafolio2017.model.TipoModel;

public interface TipoService {

	public abstract Tipo findTipoById(int id);

	public abstract List<Tipo> findAllTipo();

	public abstract List<TipoModel> findAllTipoModel();

}
