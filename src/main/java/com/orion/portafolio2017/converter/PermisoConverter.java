package com.orion.portafolio2017.converter;

import org.springframework.stereotype.Component;

import com.orion.portafolio2017.entity.Cargo;
import com.orion.portafolio2017.entity.Departamento;
import com.orion.portafolio2017.entity.Permiso;
import com.orion.portafolio2017.model.CargoModel;
import com.orion.portafolio2017.model.DepartamentoModel;
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
		return permiso;
		
	}
	

	public PermisoModel convertPermiso2PermisoModel(Permiso permiso) {
		
		PermisoModel permisoModel = new PermisoModel();
		permisoModel.setIdPermiso(permiso.getIdPermiso());
		permisoModel.setFechaInicio(permiso.getFechaInicio());
		permisoModel.setFechaSolicitud(permiso.getFechaSolicitud());
		permisoModel.setFechaTermino(permiso.getFechaTermino());
		permisoModel.setResolucionPermiso(permiso.getResolucionPermiso());
		return permisoModel;
		
	}
}
