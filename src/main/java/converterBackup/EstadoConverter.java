package converterBackup;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.orion.portafolio2017.entity.Cargo;
import com.orion.portafolio2017.entity.Departamento;
import com.orion.portafolio2017.entity.Estado;
import com.orion.portafolio2017.entity.Motivo;
import com.orion.portafolio2017.entity.Perfil;
import com.orion.portafolio2017.entity.Permiso;
import com.orion.portafolio2017.entity.Usuario;

import modelBackup.CargoModel;
import modelBackup.DepartamentoModel;
import modelBackup.EstadoModel;
import modelBackup.MotivoModel;
import modelBackup.PerfilModel;
import modelBackup.PermisoModel;
import modelBackup.UsuarioModel;


@Component("estadoConverter")
public class EstadoConverter {

	@Autowired
	@Qualifier("permisoConverter")
	private PermisoConverter permisoConverter;
	
	public Estado convertEstadoModel2Estado(EstadoModel estadoModel) {

		Estado estado = new Estado();
		estado.setIdEstado(estadoModel.getIdEstado());
		estado.setNombreEstado(estadoModel.getNombreEstado());
		estado.setPermisos((Set<Permiso>) permisoConverter.convertPermisoModel2Permiso((PermisoModel) estadoModel.getPermisos()));
		return estado;
		
	}
	

	public EstadoModel convertEstado2EstadoModel(Estado estado) {
		
		EstadoModel estadoModel = new EstadoModel();
		estadoModel.setIdEstado(estado.getIdEstado());
		estadoModel.setNombreEstado(estado.getNombreEstado());
		estadoModel.setPermisos((List<PermisoModel>) permisoConverter.convertPermiso2PermisoModel((Permiso) estado.getPermisos()));
		return estadoModel;
		
	}
}
