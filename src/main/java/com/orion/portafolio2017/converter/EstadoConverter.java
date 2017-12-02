package com.orion.portafolio2017.converter;

import org.springframework.stereotype.Component;
import com.orion.portafolio2017.entity.Estado;
import com.orion.portafolio2017.model.EstadoModel;

@Component("estadoConverter")
public class EstadoConverter {

	public Estado convertEstadoModel2Estado(EstadoModel estadoModel) {

		Estado estado = new Estado();
		estado.setIdEstado(estadoModel.getIdEstado());
		estado.setNombreEstado(estadoModel.getNombreEstado());
		return estado;

	}

	public EstadoModel convertEstado2EstadoModel(Estado estado) {

		EstadoModel estadoModel = new EstadoModel();
		estadoModel.setIdEstado(estado.getIdEstado());
		estadoModel.setNombreEstado(estado.getNombreEstado());
		return estadoModel;

	}
}
