package com.orion.portafolio2017.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion.portafolio2017.converter.PermisoConverter;
import com.orion.portafolio2017.entity.Estado;
import com.orion.portafolio2017.entity.Funcionario;
import com.orion.portafolio2017.entity.Motivo;
import com.orion.portafolio2017.entity.Permiso;
import com.orion.portafolio2017.entity.Tipo;
import com.orion.portafolio2017.model.PermisoModel;
import com.orion.portafolio2017.repository.PermisoRepository;
import com.orion.portafolio2017.service.PermisoService;


@Service("permisoService")
public class PermisoServiceImpl implements PermisoService {

	@Autowired
	@Qualifier("permisoRepository")
	private PermisoRepository permisoRepository;
	
	@Autowired
	@Qualifier("permisoConverter")
	private PermisoConverter permisoConverter;

	@Override
	public PermisoModel addPermiso(PermisoModel permisoModel, Funcionario funcionario, Estado estado, Motivo motivo, Tipo tipo) {
		Permiso permiso = permisoRepository.save(permisoConverter.convertPermisoModel2Permiso(permisoModel,funcionario,estado,motivo,tipo));
		return permisoConverter.convertPermiso2PermisoModel(permiso);
	}
	
	//No deberia ir este metodo, se implemento para trabajar sin Model (NO DEBERIA IR)
	public Permiso addPermiso2(Permiso permiso) {
		Permiso permiso2 = permisoRepository.save(permiso);
		return permiso2;
	}

	@Override
	public List<PermisoModel> findAllPermisoByRut(String rut) {
		List<Permiso> permisos = permisoRepository.findAll();
		List<PermisoModel> permisoModel = new ArrayList<PermisoModel>();
		
		for(Permiso permiso : permisos) {
			if(permiso.getFuncionario().getRutFuncionario().equals(rut))
			{
				permisoModel.add(permisoConverter.convertPermiso2PermisoModel(permiso));
			}
		}
		return permisoModel;
	}
	
	
	@Override
	public List<PermisoModel> findAllPermisoByDepartamento(int idDepartamento) {
		List<Permiso> permisos = permisoRepository.findAll();
		List<PermisoModel> permisoModel = new ArrayList<PermisoModel>();
		
		for(Permiso permiso : permisos) {
			if(permiso.getFuncionario().getDepartamento().getIdDepto() == idDepartamento)
			{
				permisoModel.add(permisoConverter.convertPermiso2PermisoModel(permiso));
			}
		}
		return permisoModel;
	}
	
	

	@Override
	public Permiso findPermisoByRut(String rut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermisoModel findPermisoModelByRut(String rut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePermiso(int rut) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PermisoModel findPermisoModelById(int id) {
		PermisoModel permisoModel = permisoConverter.convertPermiso2PermisoModel(findPermisoById(id));
		return permisoModel;
	}

	@Override
	public Permiso findPermisoById(int id) {
		return permisoRepository.findByIdPermiso(id);
	}






	


}
