package cliente;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Cliente;

/**
 * TestaBuscaPorNome.java
 * @author Aluizio Monteiro
 * 22 de ago de 2018
 */

public class TestaBuscaClientePorId {

	public static void main(String[] args) {
		//id buscado
		Cliente clienteBuscado = new Cliente();
		clienteBuscado.setId(1);
		
		//cria o dao
		ClienteDao dao = new ClienteDao();
		
		//retorna cliente e respectívos endereços
		Cliente cliente = dao.buscaPorId(clienteBuscado);
		
		//Imprime tudo
		System.out.println(cliente);
		
		//imprime um atributo do primeiro item
		System.out.println(cliente.getEnderecos().get(1).getCidade());
		
		//imprime só os enderecos
		System.out.println(cliente.getEnderecos());
		
		
	}
}
