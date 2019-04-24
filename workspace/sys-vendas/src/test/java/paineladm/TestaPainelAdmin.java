package paineladm;

import java.math.BigDecimal;
import java.util.List;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * TestaPainelAdmin.java
 * 
 * @author Aluizio Monteiro 21 de abr de 2019
 */

public class TestaPainelAdmin {
	static BigDecimal totalInvestido = new BigDecimal("00.00");

	public static void main(String[] args) {

		// Produtos
		System.out.println("Produtos");
		ProdutoDao produtoDao = new ProdutoDao();

		// Na Reserva
		System.out.println("* Estão na reserva");
		List<Produto> reservaList = produtoDao.reservaList();
		reservaList.forEach(p -> System.out.println(p));
		/*
		 * // Esgotado System.out.println("* Esgotados"); List<Produto> esgotadoList =
		 * produtoDao.esgotadoList(); esgotadoList.forEach(p -> System.out.println(p));
		 */
	}

}
