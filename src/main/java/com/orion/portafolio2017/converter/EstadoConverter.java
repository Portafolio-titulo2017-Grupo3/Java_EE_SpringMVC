package com.orion.portafolio2017.converter;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.orion.portafolio2017.entity.Cargo;
import com.orion.portafolio2017.entity.Departamento;
import com.orion.portafolio2017.entity.Estado;
import com.orion.portafolio2017.entity.Motivo;
import com.orion.portafolio2017.entity.Perfil;
import com.orion.portafolio2017.entity.Permiso;
import com.orion.portafolio2017.entity.Usuario;
import com.orion.portafolio2017.model.CargoModel;
import com.orion.portafolio2017.model.DepartamentoModel;
import com.orion.portafolio2017.model.EstadoModel;
import com.orion.portafolio2017.model.MotivoModel;
import com.orion.portafolio2017.model.PerfilModel;
import com.orion.portafolio2017.model.PermisoModel;
import com.orion.portafolio2017.model.UsuarioModel;


@Component("estadoConverter")
public class EstadoConverter {

	@Autowired
	@Qualifier("permisoConverter")
	private PermisoConverter permisoConverter;
	
	public Estado convertEstadoModel2Estado(EstadoModel estadoModel) {

		Estado estado = new Estado();
		estado.setIdEstado(estadoModel.getIdEstado());
		estado.setNombreEstado(estadoModel.getNombreEstado());
		estado.setPermisos((Set<Permiso>) permisoConverter.convertPermisoModel2Permiso((PermisoModel) estadoModel.getPermisos()));
		return estado;
		
	}
	

	public EstadoModel convertEstado2EstadoModel(Estado estado) {
		
		EstadoModel estadoModel = new EstadoModel();
		estadoModel.setIdEstado(estado.getIdEstado());
		estadoModel.setNombreEstado(estado.getNombreEstado());
		estadoModel.setPermisos((List<PermisoModel>) permisoConverter.convertPermiso2PermisoModel((Permiso) estado.getPermisos()));
		return estadoModel;
		
	}
}
