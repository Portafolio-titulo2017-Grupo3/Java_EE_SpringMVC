package com.orion.portafolio2017.converter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.orion.portafolio2017.entity.Cargo;
import com.orion.portafolio2017.entity.Departamento;
import com.orion.portafolio2017.entity.Perfil;
import com.orion.portafolio2017.entity.Permiso;
import com.orion.portafolio2017.entity.Usuario;
import com.orion.portafolio2017.model.CargoModel;
import com.orion.portafolio2017.model.DepartamentoModel;
import com.orion.portafolio2017.model.PerfilModel;
import com.orion.portafolio2017.model.PermisoModel;
import com.orion.portafolio2017.model.UsuarioModel;


@Component("perfilConverter")
public class PerfilConverter {

	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	public Perfil convertPerfilModel2Perfil(PerfilModel perfilModel) {

		Perfil perfil = new Perfil();
		perfil.setIdPerfil(perfilModel.getIdPerfil());
		perfil.setDescripcionPerfil(perfilModel.getDescripcionPerfil());
		perfil.setNombrePerfil(perfilModel.getNombrePerfil());
		perfil.setUsuarios((Set<Usuario>) usuarioConverter.convertUsuarioModel2Usuario((UsuarioModel) perfilModel.getUsuarios()));
		return perfil;
		
	}
	

	public PerfilModel convertPerfil2PerfilModel(Perfil perfil) {
		PerfilModel perfilModel = new PerfilModel();
		perfilModel.setIdPerfil(perfil.getIdPerfil());
		perfilModel.setDescripcionPerfil(perfil.getDescripcionPerfil());
		perfilModel.setNombrePerfil(perfil.getNombrePerfil());
		perfilModel.setUsuarios((List<UsuarioModel>) usuarioConverter.convertUsuario2UsuarioModel((Usuario) perfilModel.getUsuarios()));
		return perfilModel;
		
	}
}
