package com.orion.portafolio2017.converter;

import org.springframework.stereotype.Component;
import com.orion.portafolio2017.entity.Departamento;
import com.orion.portafolio2017.model.DepartamentoModel;

@Component("departamentoConverter")
public class DepartamentoConverter {

	public Departamento convertDepartamentoModel2Departamento(DepartamentoModel departamentoModel) {

		Departamento departamento = new Departamento();
		departamento.setIdDepto(departamentoModel.getIdDepto());
		departamento.setNombreDepto(departamentoModel.getNombreDepto());
		return departamento;

	}

	public DepartamentoModel convertDepartamento2DepartamentoModel(Departamento departamento) {

		DepartamentoModel departamentoModel = new DepartamentoModel();
		departamentoModel.setIdDepto(departamento.getIdDepto());
		departamentoModel.setNombreDepto(departamento.getNombreDepto());
		return departamentoModel;

	}
}
