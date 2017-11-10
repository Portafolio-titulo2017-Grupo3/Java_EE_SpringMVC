package modelBackup;

import java.util.ArrayList;
import java.util.List;

public class PerfilModel {

	private int idPerfil;
	private String nombrePerfil;
	private String descripcionPerfil;
	private List<UsuarioModel> usuarioModels = new ArrayList<UsuarioModel>();

	public PerfilModel() {
	}

	public PerfilModel(int idPerfil, String nombrePerfil, String descripcionPerfil) {
		this.idPerfil = idPerfil;
		this.nombrePerfil = nombrePerfil;
		this.descripcionPerfil = descripcionPerfil;
	}

	public PerfilModel(int idPerfil, String nombrePerfil, String descripcionPerfil, List<UsuarioModel> usuarioModels) {
		super();
		this.idPerfil = idPerfil;
		this.nombrePerfil = nombrePerfil;
		this.descripcionPerfil = descripcionPerfil;
		this.usuarioModels = usuarioModels;
	}

	public int getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombrePerfil() {
		return this.nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	public String getDescripcionPerfil() {
		return this.descripcionPerfil;
	}

	public void setDescripcionPerfil(String descripcionPerfil) {
		this.descripcionPerfil = descripcionPerfil;
	}

	public List<UsuarioModel> getUsuarios() {
		return usuarioModels;
	}

	public void setUsuarios(List<UsuarioModel> usuarioModels) {
		this.usuarioModels = usuarioModels;
	}

}
