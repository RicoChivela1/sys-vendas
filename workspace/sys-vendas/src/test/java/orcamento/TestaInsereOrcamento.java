package orcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.Orcamento;
import br.com.aluizio.sysvendas.model.OrcamentoProduto;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * TestaInsereOrcamento.java
 * @author Aluizio Monteiro
 * 22 de ago de 2018
 */

public class TestaInsereOrcamento {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setId(2);
		
		Usuario usuario = new Usuario();
		usuario.setId(6);
		
		Orcamento orcamento = new Orcamento();

		orcamento.setTotal(new BigDecimal("10.00"));
		orcamento.setDescontos(new BigDecimal("0.50"));
		
		Calendar dataLancamento = new GregorianCalendar(2018,11,10);
		orcamento.setDataLancamento(dataLancamento);
		
		orcamento.setConfirmado(true);
		
		orcamento.setCliente(cliente);
		orcamento.setUsuario(usuario);
		
		OrcamentoDao dao = new OrcamentoDao();
		dao.salvarOrcamento(orcamento);
		
		System.out.println("Orcamento salvo com sucesso");
			
		
		
		OrcamentoProduto oP1 = new OrcamentoProduto();
		oP1.setProdutoNome("teste orçamento 1");
		oP1.setQtd(2);
		oP1.setValorUnid(new BigDecimal("12.00"));
		oP1.setSubTotal(new BigDecimal("24.00"));
		
		OrcamentoProduto oP2 = new OrcamentoProduto();
		oP2.setProdutoNome("teste orçamento 2");
		oP2.setQtd(2);
		oP2.setValorUnid(new BigDecimal("12.00"));
		oP2.setSubTotal(new BigDecimal("24.00"));
		
		OrcamentoProduto oP3 = new OrcamentoProduto();
		oP3.setProdutoNome("teste orçamento 3");
		oP3.setQtd(2);
		oP3.setValorUnid(new BigDecimal("12.00"));
		oP3.setSubTotal(new BigDecimal("24.00"));
		
		List<OrcamentoProduto> list = new ArrayList<>();
		list.add(oP1);
		list.add(oP2);
		list.add(oP3);
		
		dao.salvarOrcametoProduto(list);
		
		System.out.println("Produtos do orçamento salvos com sucesso.");		
	}
}
