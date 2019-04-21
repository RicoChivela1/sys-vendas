package paineladm;

import java.math.BigDecimal;
import java.util.List;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Pagamentos;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * TestaPainelAdmin.java
 * 
 * @author Aluizio Monteiro 21 de abr de 2019
 */

public class TestaPainelAdmin {
	public static void main(String[] args) {
		System.out.println("Vis�o Geral");
		System.out.println("Total Investido");
		System.out.println("Total Lucro ");
		System.out.println("Lucro extimado");

	//Dividas	
		System.out.println("* D�vidas");
		PagamentoDao pagamentoDao = new PagamentoDao();
		
		// Total D�vidas
		System.out.println("- Total D�vidas ");
		List<Pagamentos> buscaDividas = pagamentoDao.buscaDividas();
		
		
		BigDecimal valorTotal = buscaDividas.stream()
				.map(Pagamentos::getValorParcela)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	
		System.out.println(valorTotal);
		
		
		System.out.println("Total em atraso");
		System.out.println("Total � receber");
		System.out.println("Total a receber hoje/ m�s/ semana ");

		
	//Produtos
		System.out.println("Produtos ");
		ProdutoDao produtoDao = new ProdutoDao();

		// Top List
		System.out.println("* Os cinco mais vendidos");
		List<Produto> topList = produtoDao.topList();
		topList.forEach(p -> System.out.println(p));

		// Na Reserva
		System.out.println("* Est�o na reserva");
		List<Produto> reservaList = produtoDao.reservaList();
		reservaList.forEach(p -> System.out.println(p));

		// Esgotado
		System.out.println("* Esgotados");
		List<Produto> esgotadoList = produtoDao.esgotadoList();
		esgotadoList.forEach(p -> System.out.println(p));
	}

}
