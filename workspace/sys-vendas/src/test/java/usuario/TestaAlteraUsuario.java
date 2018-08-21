/**
 * 
 */
package usuario;

import br.com.aluizio.sysvendas.dao.UsuarioDao;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * @author Aluizio Monteiro
 *
 */
public class TestaAlteraUsuario {
	
	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		usuario.setNome("Aluizio Junior");
		usuario.setLogin("junior");
		usuario.setSenha("junior");
		usuario.setId(1);
		UsuarioDao dao = new UsuarioDao();
		//dao.altera(usuario);
	}

}
