package com.orion.portafolio2017.service;

import java.util.List;

import com.orion.portafolio2017.entity.Estado;
import com.orion.portafolio2017.model.EstadoModel;

public interface EstadoService {

	public abstract Estado findEstadoById(int id);

	public abstract EstadoModel findEstadoByIdModel(int id);

	public abstract List<EstadoModel> findAllEstadoModel();

	public abstract List<Estado> findAllEstado();

}
