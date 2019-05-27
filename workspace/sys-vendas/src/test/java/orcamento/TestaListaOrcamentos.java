package orcamento;

import java.util.List;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.Orcamento;

/**
 * TestaLista.java
 * 
 * Busca orçamentos pelo id do cliente
 * @author Aluizio Monteiro
 * 6 de mar de 2019
 */

public class TestaListaOrcamentos {

	public static void main(String[] args) {
		//id buscado
		Cliente cliente = new Cliente();
		cliente.setId(1); //1, 2 e 8.
		
		List<Orcamento> list = (List<Orcamento>) new OrcamentoDao().getList(cliente);
		
		for (Orcamento orcamento : list) {
			System.out.println(orcamento);
		}
		
	}
}
