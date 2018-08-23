package cliente;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Cliente;

/**
 * TestaListaCliente.java
 * @author Aluizio Monteiro
 * 22 de ago de 2018
 */

public class TestaListaCliente {

	public static void main(String[] args) {
		ClienteDao dao = new ClienteDao();
		List<Cliente> clientes = dao.getList();
		clientes.forEach(c -> System.out.println(c));
		System.out.println("Fim da listagem");
	}
}
