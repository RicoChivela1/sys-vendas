package cliente;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.EnumPessoa;
import br.com.aluizio.sysvendas.model.EnumSexo;
import br.com.aluizio.sysvendas.model.EnumSituacao;

/**
 * TestaInsereCliente.java
 * @author Aluizio Monteiro
 * 20 de ago de 2018
 */

public class TestaInsereCliente {

	public static void main(String[] args) {
			
		Cliente cliente = new Cliente();
		
		cliente.setSituacao(EnumSituacao.ATIVO);
		cliente.setPessoa(EnumPessoa.FISICA);
		cliente.setSexo(EnumSexo.M);
		cliente.setNome("Aluizio");
		cliente.setSobreNome("Monteiro");
		
		Calendar nascimento = new GregorianCalendar(1990, 12, 30);
        
		cliente.setNascimento(nascimento);
		cliente.setObservacao("Conta de teste");
		cliente.setEmail("insejunior@gemail.com");
		cliente.setCelular("61-99349-5309");

	}

}
