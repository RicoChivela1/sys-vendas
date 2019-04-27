package br.com.aluizio.sysvendas.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * TotalDividas.java
 * 
 * @author Aluizio Monteiro 
 * @date 25 de abr de 2019
 */

public class TotalDividas {
	/**
	 * Valor total dívidas
	 * 
	 * @return BigDecimal valorTotal
	 */
	public static BigDecimal getListDividas(List<Pagamentos> buscaDividas) {
		BigDecimal valorTotal = buscaDividas.stream().map(Pagamentos::getValorParcela).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		return valorTotal;
	}

	/**
	 * Listar todas as dívidas
	 * 
	 * @return BigDecimal valorAtraso
	 */
	public static List<Pagamentos> getTotalDividas() {
		PagamentoDao pagamentoDao = new PagamentoDao();
		List<Pagamentos> buscaDividas = pagamentoDao.buscaDividas();
		return buscaDividas;
	}

}
