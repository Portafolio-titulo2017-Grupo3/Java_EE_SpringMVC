package converterBackup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.orion.portafolio2017.entity.Cargo;
import com.orion.portafolio2017.entity.Departamento;
import com.orion.portafolio2017.entity.Permiso;

import modelBackup.CargoModel;
import modelBackup.DepartamentoModel;
import modelBackup.PermisoModel;


@Component("permisoConverter")
public class PermisoConverter {
	
	@Autowired
	@Qualifier("tipoConverter")
	private TipoConverter tipoConverter;
	
	@Autowired
	@Qualifier("motivoConverter")
	private MotivoConverter motivoConverter;
	
	@Autowired
	@Qualifier("estadoConverter")
	private EstadoConverter estadoConverter;
	
	@Autowired
	@Qualifier("funcionarioConverter")
	private FuncionarioConverter funcionarioConverter;

	public Permiso convertPermisoModel2Permiso(PermisoModel permisoModel) {

		Permiso permiso = new Permiso();
		permiso.setIdPermiso(permisoModel.getIdPermiso());
		permiso.setFechaInicio(permisoModel.getFechaInicio());
		permiso.setFechaSolicitud(permisoModel.getFechaSolicitud());
		permiso.setFechaTermino(permisoModel.getFechaTermino());
		permiso.setResolucionPermiso(permisoModel.getResolucionPermiso());
		permiso.setFuncionario(funcionarioConverter.convertFuncionarioModel2Funcionario(permisoModel.getFuncionario()));
		permiso.setEstado(estadoConverter.convertEstadoModel2Estado(permisoModel.getEstado()));
		permiso.setMotivo(motivoConverter.convertMotivoModel2Motivo(permisoModel.getMotivo()));
		permiso.setTipo(tipoConverter.convertTipoModel2Tipo(permisoModel.getTipo()));
		return permiso;
		
	}
	

	public PermisoModel convertPermiso2PermisoModel(Permiso permiso) {
		
		PermisoModel permisoModel = new PermisoModel();
		permisoModel.setIdPermiso(permiso.getIdPermiso());
		permisoModel.setFechaInicio(permiso.getFechaInicio());
		permisoModel.setFechaSolicitud(permiso.getFechaSolicitud());
		permisoModel.setFechaTermino(permiso.getFechaTermino());
		permisoModel.setResolucionPermiso(permiso.getResolucionPermiso());
		permisoModel.setFuncionario(funcionarioConverter.convertFuncionario2FuncionarioModel(permiso.getFuncionario()));
		permisoModel.setEstado(estadoConverter.convertEstado2EstadoModel(permiso.getEstado()));
		permisoModel.setMotivo(motivoConverter.convertMotivo2MotivoModel(permiso.getMotivo()));
		permisoModel.setTipo(tipoConverter.convertTipo2TipoModel(permiso.getTipo()));
		return permisoModel;
		
	}
}
