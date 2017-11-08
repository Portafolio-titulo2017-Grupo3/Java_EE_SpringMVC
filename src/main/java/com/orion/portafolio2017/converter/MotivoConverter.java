package com.orion.portafolio2017.converter;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.orion.portafolio2017.entity.Cargo;
import com.orion.portafolio2017.entity.Departamento;
import com.orion.portafolio2017.entity.Motivo;
import com.orion.portafolio2017.entity.Perfil;
import com.orion.portafolio2017.entity.Permiso;
import com.orion.portafolio2017.entity.Usuario;
import com.orion.portafolio2017.model.CargoModel;
import com.orion.portafolio2017.model.DepartamentoModel;
import com.orion.portafolio2017.model.MotivoModel;
import com.orion.portafolio2017.model.PerfilModel;
import com.orion.portafolio2017.model.PermisoModel;
import com.orion.portafolio2017.model.UsuarioModel;


@Component("motivoConverter")
public class MotivoConverter {

	@Autowired
	@Qualifier("permisoConverter")
	private PermisoConverter permisoConverter;
	
	public Motivo convertMotivoModel2Motivo(MotivoModel motivoModel) {

		Motivo motivo = new Motivo();
		motivo.setIdMotivo(motivoModel.getIdMotivo());
		motivo.setDescripcionMotivo(motivoModel.getDescripcionMotivo());
		motivo.setPermisos((Set<Permiso>) permisoConverter.convertPermisoModel2Permiso((PermisoModel) motivoModel.getPermisos()));
		return motivo;
		
	}
	

	public MotivoModel convertMotivo2MotivoModel(Motivo motivo) {
		
		MotivoModel motivoModel = new MotivoModel();
		motivoModel.setIdMotivo(motivo.getIdMotivo());
		motivoModel.setDescripcionMotivo(motivo.getDescripcionMotivo());
		motivoModel.setPermisos((Set<PermisoModel>) permisoConverter.convertPermiso2PermisoModel((Permiso) motivo.getPermisos()));
		return motivoModel;
		
	}
}
