package com.orion.portafolio2017.converter;

import org.springframework.stereotype.Component;
import com.orion.portafolio2017.entity.Motivo;
import com.orion.portafolio2017.model.MotivoModel;



@Component("motivoConverter")
public class MotivoConverter {

	
	public Motivo convertMotivoModel2Motivo(MotivoModel motivoModel) {

		Motivo motivo = new Motivo();
		motivo.setIdMotivo(motivoModel.getIdMotivo());
		motivo.setDescripcionMotivo(motivoModel.getDescripcionMotivo());
		return motivo;
		
	}
	

	public MotivoModel convertMotivo2MotivoModel(Motivo motivo) {
		
		MotivoModel motivoModel = new MotivoModel();
		motivoModel.setIdMotivo(motivo.getIdMotivo());
		motivoModel.setDescripcionMotivo(motivo.getDescripcionMotivo());
		return motivoModel;
		
	}
}
