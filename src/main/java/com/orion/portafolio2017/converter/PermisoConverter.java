package com.orion.portafolio2017.converter;

import org.springframework.stereotype.Component;

import com.orion.portafolio2017.entity.Estado;
import com.orion.portafolio2017.entity.Funcionario;
import com.orion.portafolio2017.entity.Motivo;
import com.orion.portafolio2017.entity.Permiso;
import com.orion.portafolio2017.entity.Tipo;
import com.orion.portafolio2017.model.PermisoModel;



@Component("permisoConverter")
public class PermisoConverter {
	

	public Permiso convertPermisoModel2Permiso(PermisoModel permisoModel) {

		Permiso permiso = new Permiso();
		permiso.setIdPermiso(permisoModel.getIdPermiso());
		permiso.setFechaInicio(permisoModel.getFechaInicio());
		permiso.setFechaSolicitud(permisoModel.getFechaSolicitud());
		permiso.setFechaTermino(permisoModel.getFechaTermino());
		permiso.setResolucionPermiso(permisoModel.getResolucionPermiso());
		permiso.setFuncionario(new Funcionario(permisoModel.getRutFuncionario()));
		permiso.setEstado(new Estado(permisoModel.getIdEstado()));
		permiso.setMotivo(new Motivo(permisoModel.getIdMotivo()));
		permiso.setTipo(new Tipo(permisoModel.getIdTipo()));
		return permiso;
		
	}
	

	public PermisoModel convertPermiso2PermisoModel(Permiso permiso) {
		
		PermisoModel permisoModel = new PermisoModel();
		permisoModel.setIdPermiso(permiso.getIdPermiso());
		permisoModel.setFechaInicio(permiso.getFechaInicio());
		permisoModel.setFechaSolicitud(permiso.getFechaSolicitud());
		permisoModel.setFechaTermino(permiso.getFechaTermino());
		permisoModel.setResolucionPermiso(permiso.getResolucionPermiso());
		
		permisoModel.setRutFuncionario(permiso.getFuncionario().getRutFuncionario());
		
		permisoModel.setIdEstado(permiso.getEstado().getIdEstado());
		permisoModel.setNombreEstado(permiso.getEstado().getNombreEstado());
		
		permisoModel.setIdMotivo(permiso.getMotivo().getIdMotivo());
		permisoModel.setDescripcionMotivo(permiso.getMotivo().getDescripcionMotivo());
		
		permisoModel.setIdTipo(permiso.getTipo().getIdTipo());
		permisoModel.setNombreTipo(permiso.getTipo().getNombreTipo());
		permisoModel.setDescripcionTipo(permiso.getTipo().getDescripcionTipo());
		return permisoModel;
		
	}
}
