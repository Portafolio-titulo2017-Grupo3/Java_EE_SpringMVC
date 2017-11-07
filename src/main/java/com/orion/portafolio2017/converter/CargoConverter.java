package com.orion.portafolio2017.converter;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.orion.portafolio2017.entity.Cargo;
import com.orion.portafolio2017.entity.Departamento;
import com.orion.portafolio2017.entity.HistorialCargo;
import com.orion.portafolio2017.model.CargoModel;
import com.orion.portafolio2017.model.DepartamentoModel;
import com.orion.portafolio2017.model.HistorialCargoModel;


@Component("cargoConverter")
public class CargoConverter {
	
	@Autowired
	@Qualifier("historialcargoConverter")
	private HistorialCargoConverter historialcargoConverter;

	public Cargo convertCargoModel2Cargo(CargoModel cargoModel) {

		Cargo cargo = new Cargo();
		cargo.setIdCargo(cargoModel.getIdCargo());
		cargo.setNombreCargo(cargoModel.getNombreCargo());
		cargo.setSalario(cargoModel.getSalario());
		cargo.setHistorialCargos((Set<HistorialCargo>) historialcargoConverter.convertHistorialCargoModel2HistorialCargo((HistorialCargoModel) cargoModel.getHistorialCargos()));
		return cargo;
		
	}
	

	public CargoModel convertCargo2CargoModel(Cargo cargo) {
		
		CargoModel cargoModel = new CargoModel();
		cargoModel.setIdCargo(cargo.getIdCargo());
		cargoModel.setNombreCargo(cargo.getNombreCargo());
		cargoModel.setSalario(cargo.getSalario());
		cargoModel.setHistorialCargos((Set<HistorialCargoModel>) historialcargoConverter.convertHistorialCargo2HistorialCargoModel((HistorialCargo) cargo.getHistorialCargos()));
		return cargoModel;
		
	}
}
