package com.orion.portafolio2017.converter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.orion.portafolio2017.entity.Tipo;
import modelBackup.TipoModel;


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
		return tipo;
		
	}
	

	public TipoModel convertTipo2TipoModel(Tipo tipo) {
		
		TipoModel tipoModel = new TipoModel();
		tipoModel.setIdTipo(tipo.getIdTipo());
		tipoModel.setNombreTipo(tipo.getNombreTipo());
		tipoModel.setDescripcionTipo(tipo.getDescripcionTipo());
		return tipoModel;
		
	}
}
