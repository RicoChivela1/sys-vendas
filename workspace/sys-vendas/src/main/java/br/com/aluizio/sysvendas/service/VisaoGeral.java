package br.com.aluizio.sysvendas.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * VisaoGeral.java
 * 
 * @author Aluizio Monteiro 25 de abr de 2019
 */

public class VisaoGeral {

	/**
	 * Extimativa de Lucro Bruto
	 * 
	 * @return BigDecimal totalVendas
	 */
	public static BigDecimal getExtimativaBruta() {
		System.out.println("Extimativa de Lucro");
		BigDecimal extimativaBruta = new PagamentoDao().buscaExtimativas();
		return extimativaBruta;

	}

	/**
	 * Extimativa de Lucro Liquida
	 * 
	 * @return BigDecimal totalVendas - totalInvestido
	 */
	public static BigDecimal getExtimativaLiquida() {
		BigDecimal extimativaLiquida = new PagamentoDao().buscaExtimativas();
		return extimativaLiquida.subtract(getTotalInvestido());
	}

	/**
	 * Total Lucro Bruto
	 * 
	 * @return BigDecimal totalVendas
	 */
	public static BigDecimal getLucroBruto() {
		// Total Vendas ( vendasBrutas - totalInvestido)
		BigDecimal totalVendas = new PagamentoDao().buscaLucro();
		return totalVendas;
	}

	/**
	 * Total Lucro Liquido
	 * 
	 * @return BigDecimal totalVendas - totalInvestido
	 */
	public static BigDecimal getLucroLiquido() {
		// Total Lucro ( vendasBrutas - totalInvestido)
		BigDecimal totalVendas = new PagamentoDao().buscaLucro();
		return totalVendas.subtract(getTotalInvestido());
	}

	/**
	 * Total Investido
	 * 
	 * @return BigDecimal totalInvestido
	 */
	public static BigDecimal getTotalInvestido() {
		BigDecimal totalInvestido = new BigDecimal("00.00");
		ProdutoDao produtoDao = new ProdutoDao();
		List<Object> list = produtoDao.getList();
		for (Object object : list) {
			Produto produto = (Produto) object;
			totalInvestido = totalInvestido.add(produto.getCustoUnid());

		}
		return totalInvestido;
	}

}
