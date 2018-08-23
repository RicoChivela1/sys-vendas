package orcamento;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.Orcamento;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * TestaInsereOrcamento.java
 * @author Aluizio Monteiro
 * 22 de ago de 2018
 */

public class TestaInsereOrcamento {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		
		Usuario usuario = new Usuario();
		usuario.setId(2);
		
		Orcamento orcamento = new Orcamento();
		orcamento.setSubTotal(1000);
		orcamento.setDesconto(100);
		orcamento.setTotal(900);
		
		Calendar dataLancamento = new GregorianCalendar(2018,11,10);
		orcamento.setDataLancamento(dataLancamento);
		
		orcamento.setConfirmado(true);
		
		orcamento.setCliente(cliente);
		orcamento.setUsuario(usuario);
		
		OrcamentoDao dao = new OrcamentoDao();
		dao.adicionar(orcamento);
		
		System.out.println("Orcamento salvo com sucesso");

	}

}
