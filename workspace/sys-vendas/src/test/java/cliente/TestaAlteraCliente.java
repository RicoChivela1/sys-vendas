package cliente;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.EnumPessoa;
import br.com.aluizio.sysvendas.model.EnumSexo;
import br.com.aluizio.sysvendas.model.EnumSituacao;

/**
 * TestaAlteraCliente.java
 * 
 * @author Aluizio Monteiro 22 de ago de 2018
 */

public class TestaAlteraCliente {

	public static void main(String[] args) {

		Cliente cliente = new Cliente();

		cliente.setSituacao(EnumSituacao.BLOQUEADO);
		cliente.setPessoa(EnumPessoa.JURIDICA);
		cliente.setSexo(EnumSexo.F);
		cliente.setNome("Antônia");
		cliente.setSobreNome("Morgado");

		Calendar nascimento = new GregorianCalendar(2000, 11, 12);
		cliente.setNascimento(nascimento);

		cliente.setObservacao("Conta de teste");
		cliente.setEmail("flavinha9090@gemail.com");
		cliente.setCelular("61-99349-5309");
		
		cliente.setId(2);

		ClienteDao dao = new ClienteDao();
		dao.alterar(cliente);
		System.out.println("Cliente alterado com sucesso");

	}
}
