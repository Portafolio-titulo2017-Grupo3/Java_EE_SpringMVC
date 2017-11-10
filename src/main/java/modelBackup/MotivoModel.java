package modelBackup;

import java.util.ArrayList;
import java.util.List;

public class MotivoModel {

	private int idMotivo;
	private String descripcionMotivo;
	private List<PermisoModel> permisoModels = new ArrayList<PermisoModel>();

	public MotivoModel() {
	}

	public MotivoModel(int idMotivo, String descripcionMotivo) {
		this.idMotivo = idMotivo;
		this.descripcionMotivo = descripcionMotivo;
	}

	public MotivoModel(int idMotivo, String descripcionMotivo, List<PermisoModel> permisoModels) {
		super();
		this.idMotivo = idMotivo;
		this.descripcionMotivo = descripcionMotivo;
		this.permisoModels = permisoModels;
	}

	public int getIdMotivo() {
		return this.idMotivo;
	}

	public void setIdMotivo(int idMotivo) {
		this.idMotivo = idMotivo;
	}

	public String getDescripcionMotivo() {
		return this.descripcionMotivo;
	}

	public void setDescripcionMotivo(String descripcionMotivo) {
		this.descripcionMotivo = descripcionMotivo;
	}

	public List<PermisoModel> getPermisos() {
		return permisoModels;
	}

	public void setPermisos(List<PermisoModel> permisoModels) {
		this.permisoModels = permisoModels;
	}

}
