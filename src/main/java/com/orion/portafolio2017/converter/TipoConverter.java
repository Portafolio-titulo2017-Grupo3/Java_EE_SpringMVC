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
import com.orion.portafolio2017.entity.Tipo;
import com.orion.portafolio2017.entity.Usuario;
import com.orion.portafolio2017.model.CargoModel;
import com.orion.portafolio2017.model.DepartamentoModel;
import com.orion.portafolio2017.model.MotivoModel;
import com.orion.portafolio2017.model.PerfilModel;
import com.orion.portafolio2017.model.PermisoModel;
import com.orion.portafolio2017.model.TipoModel;
import com.orion.portafolio2017.model.UsuarioModel;


@Component("tipoConverter")
public class TipoConverter {

	@Autowired
	@Qualifier("permisoConverter")
	private PermisoConverter permisoConverter;
	
	public Tipo convertTipoModel2Tipo(TipoModel tipoModel) {

		Tipo tipo = new Tipo();
		tipo.setIdTipo(tipoModel.getIdTipo());
		tipo.setNombreTipo(tipoModel.getNombreTipo());
		tipo.setDescripcionTipo(tipoModel.getDescripcionTipo());
		tipo.setPermisos((Set<Permiso>) permisoConverter.convertPermisoModel2Permiso((PermisoModel) tipoModel.getPermisos()));
		return tipo;
		
	}
	

	public TipoModel convertTipo2TipoModel(Tipo tipo) {
		
		TipoModel tipoModel = new TipoModel();
		tipoModel.setIdTipo(tipo.getIdTipo());
		tipoModel.setNombreTipo(tipo.getNombreTipo());
		tipoModel.setDescripcionTipo(tipo.getDescripcionTipo());
		tipoModel.setPermisos((Set<PermisoModel>) permisoConverter.convertPermiso2PermisoModel((Permiso) tipoModel.getPermisos()));
		return tipoModel;
		
	}
}
