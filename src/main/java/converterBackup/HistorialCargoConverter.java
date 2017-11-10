package converterBackup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.orion.portafolio2017.entity.Cargo;
import com.orion.portafolio2017.entity.Departamento;
import com.orion.portafolio2017.entity.HistorialCargo;

import modelBackup.CargoModel;
import modelBackup.DepartamentoModel;
import modelBackup.HistorialCargoModel;


@Component("historialcargoConverter")
public class HistorialCargoConverter {
	
	@Autowired
	@Qualifier("cargoConverter")
	private CargoConverter cargoConverter;

	public HistorialCargo convertHistorialCargoModel2HistorialCargo(HistorialCargoModel historialcargoModel) {

		HistorialCargo historialcargo = new HistorialCargo();
		historialcargo.setId_historial(historialcargoModel.getId_historial());
		historialcargo.setCargo(cargoConverter.convertCargoModel2Cargo(historialcargoModel.getCargo()));
		historialcargo.setFechaInicio(historialcargoModel.getFechaInicio());
		historialcargo.setFechaTermino(historialcargoModel.getFechaTermino());
		return historialcargo;
		
	}
	

	public HistorialCargoModel convertHistorialCargo2HistorialCargoModel(HistorialCargo historialcargo) {
		
		HistorialCargoModel historialcargoModel = new HistorialCargoModel();
		historialcargoModel.setId_historial(historialcargo.getId_historial());
		historialcargoModel.setCargo(cargoConverter.convertCargo2CargoModel(historialcargo.getCargo()));
		historialcargoModel.setFechaInicio(historialcargo.getFechaInicio());
		historialcargoModel.setFechaTermino(historialcargo.getFechaTermino());
		return historialcargoModel;
		
	}
}
