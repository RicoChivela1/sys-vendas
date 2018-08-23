package orcamento;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.Orcamento;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * TestaAtualizaOrcamento.java
 * @author Aluizio Monteiro
 * 23 de ago de 2018
 */

public class TestaAtualizaOrcamento {

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
		
		orcamento.setConfirmado(false);
		
		orcamento.setCliente(cliente);
		orcamento.setUsuario(usuario);
		orcamento.setId(3);
		
		OrcamentoDao dao = new OrcamentoDao();
		dao.alterar(orcamento);
		
		System.out.println("Orcamento atualizado com sucesso");

	}

}
