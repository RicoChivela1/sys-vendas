package orcamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Carrinho;
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
		cliente.setId(2);
		
		Usuario usuario = new Usuario();
		usuario.setId(6);
		
		
		Orcamento orcamento = new Orcamento();

		orcamento.setTotal(new BigDecimal("10.00"));
		orcamento.setDescontos(new BigDecimal("0.50"));
		
		LocalDate dataLancamento = LocalDate.now();
		orcamento.setDataLancamento(dataLancamento);
		
		orcamento.setConfirmado(true);
		
		orcamento.setCliente(cliente);
		orcamento.setUsuario(usuario);
		
		OrcamentoDao dao = new OrcamentoDao();
		dao.salvaOrcamento(orcamento);
		
		System.out.println("Orcamento salvo com sucesso");
			
		
		
		Carrinho car1 = new Carrinho();
		car1.setProdutoNome("produto 1");
		car1.setQtd(2);
		car1.setValorUnid(new BigDecimal("12.00"));
		car1.setSubTotal(new BigDecimal("24.00"));
		
		Carrinho car2 = new Carrinho();
		car2.setProdutoNome("produto 2");
		car2.setQtd(2);
		car2.setValorUnid(new BigDecimal("12.00"));
		car2.setSubTotal(new BigDecimal("24.00"));
		
		Carrinho car3 = new Carrinho();
		car3.setProdutoNome("produto 3");
		car3.setQtd(2);
		car3.setValorUnid(new BigDecimal("12.00"));
		car3.setSubTotal(new BigDecimal("24.00"));
		
		List<Carrinho> list = new ArrayList<>();
		list.add(car1);
		list.add(car2);
		list.add(car3);
		
		dao.salvaCarrinho(list);
		
		System.out.println("Produtos do orçamento salvos com sucesso.");		
	}
}
