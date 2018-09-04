package endereco;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Endereco;

/**
 * TestaListaId.java
 * 
 * @author Aluizio Monteiro 3 de set de 2018
 */

public class TestaListaId {
	public static void main(String[] args) {
		ClienteDao dao = new ClienteDao();
		List<Endereco> lista = dao.populaListaDeEnderecos(1);
		lista.forEach(l -> System.out.println(l+"\n"));	
	}
}
