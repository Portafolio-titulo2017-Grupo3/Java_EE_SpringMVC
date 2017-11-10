package com.orion.portafolio2017.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orion.portafolio2017.converter.PermisoConverter;
import com.orion.portafolio2017.entity.Permiso;
import com.orion.portafolio2017.model.PermisoModel;
import com.orion.portafolio2017.repository.PermisoRepository;
import com.orion.portafolio2017.service.PermisoService;


@Service("permisoServiceImpl")
public class PermisoServiceImpl implements PermisoService {

	@Autowired
	@Qualifier("permisoRepository")
	private PermisoRepository permisoRepository;
	
	@Autowired
	@Qualifier("permisoConverter")
	private PermisoConverter permisoConverter;

	@Override
	public PermisoModel addPermiso(PermisoModel permisoModel) {
		// TODO Auto-generated method stub
		return null;
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


	


}
