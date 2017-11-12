package converterBackup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.orion.portafolio2017.entity.Usuario;
import modelBackup.UsuarioModel;


@Component("usuarioConverter")
public class UsuarioConverter {
	
	@Autowired
	@Qualifier("funcionarioConverter")
	private FuncionarioConverter funcionarioConverter;
	

	public Usuario convertUsuarioModel2Usuario(UsuarioModel usuarioModel) {

		Usuario usuario = new Usuario();
		usuario.setIdUsuario(usuarioModel.getIdUsuario());
		usuario.setUsername(usuarioModel.getUsername());
		usuario.setPassword(usuarioModel.getPassword());
		usuario.setFuncionario(funcionarioConverter.convertFuncionarioModel2Funcionario(usuarioModel.getFuncionario()));
		return usuario;
		
	}
	

	public UsuarioModel convertUsuario2UsuarioModel(Usuario usuario) {
		
		UsuarioModel usuarioModel = new UsuarioModel();
		usuarioModel.setIdUsuario(usuario.getIdUsuario());
		usuarioModel.setUsername(usuario.getUsername());
		usuarioModel.setPassword(usuario.getPassword());
		usuarioModel.setFuncionario(funcionarioConverter.convertFuncionario2FuncionarioModel(usuario.getFuncionario()));
		return usuarioModel;
		
	}
}
