package modelBackup;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoModel {

	private int idDepto;
	private String nombreDepto;
	private List<FuncionarioModel> funcionarioModels = new ArrayList<FuncionarioModel>();

	public DepartamentoModel() {
	}

	public DepartamentoModel(int idDepto, String nombreDepto) {
		this.idDepto = idDepto;
		this.nombreDepto = nombreDepto;
	}

	public DepartamentoModel(int idDepto, String nombreDepto, List<FuncionarioModel> funcionarioModels) {
		super();
		this.idDepto = idDepto;
		this.nombreDepto = nombreDepto;
		this.funcionarioModels = funcionarioModels;
	}

	public int getIdDepto() {
		return this.idDepto;
	}

	public void setIdDepto(int idDepto) {
		this.idDepto = idDepto;
	}

	public String getNombreDepto() {
		return this.nombreDepto;
	}

	public void setNombreDepto(String nombreDepto) {
		this.nombreDepto = nombreDepto;
	}

	public List<FuncionarioModel> getFuncionarios() {
		return funcionarioModels;
	}

	public void setFuncionarios(List<FuncionarioModel> funcionarioModels) {
		this.funcionarioModels = funcionarioModels;
	}

}
