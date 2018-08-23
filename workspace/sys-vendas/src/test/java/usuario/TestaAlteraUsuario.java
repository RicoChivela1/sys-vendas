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
		usuario.setId(2);
		usuario.setSenha("junior");
		
		UsuarioDao dao = new UsuarioDao();
		dao.alterar(usuario);
		
		System.out.println("Usuário alterado com sucesso.");
		
	}
}
