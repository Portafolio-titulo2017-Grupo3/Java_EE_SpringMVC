package com.orion.portafolio2017.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion.portafolio2017.converter.DepartamentoConverter;
import com.orion.portafolio2017.entity.Departamento;
import com.orion.portafolio2017.entity.Permiso;
import com.orion.portafolio2017.model.DepartamentoModel;
import com.orion.portafolio2017.model.PermisoModel;
import com.orion.portafolio2017.repository.DepartamentoRepository;
import com.orion.portafolio2017.service.DepartamentoService;

@Service("departamentoService")
public class DeparatamentoServiceImpl implements DepartamentoService{

	@Autowired
	@Qualifier("departamentoRepository")
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	@Qualifier("departamentoConverter")
	private DepartamentoConverter departamentoConverter;
	
	@Override
	public Departamento findDepartamentoByIdDepto(int idDepto) {
		return departamentoRepository.findByIdDepto(idDepto);
	}

	@Override
	public DepartamentoModel findDepartamentoModelByIdDepto(int idDepto) {
		return departamentoConverter.convertDepartamento2DepartamentoModel(departamentoRepository.findByIdDepto(idDepto));
	}

	@Override
	public List<DepartamentoModel> findAllDepartamentoModel() {
		List<Departamento> departamentos = departamentoRepository.findAll();
		List<DepartamentoModel> departamentoModel = new ArrayList<DepartamentoModel>();
		
		for(Departamento departamento : departamentos) {
			departamentoModel.add(departamentoConverter.convertDepartamento2DepartamentoModel(departamento));
		}
		return departamentoModel;
	}

	
}
