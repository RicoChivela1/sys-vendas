package br.com.aluizio.sysvendas.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.EnumStatus;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * TestaTotalAtraso.java
 * 
 * @author Aluizio Monteiro 24 de abr de 2019
 */

public class TotalAtraso {

	/**
	 * Valor total Atraso
	 * 
	 * @return BigDecimal valorAtraso
	 */
	public static BigDecimal getTotalAtraso(List<Pagamentos> listaAtrasos) {
		BigDecimal valorAtraso = listaAtrasos.stream().map(Pagamentos::getValorParcela).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		return valorAtraso;
	}

	/**
	 * Lista de pagamentos em Atraso
	 * 
	 * @return List<Pagamentos> totalAReceberSemana
	 */
	public static List<Pagamentos> getListaAtraso() {
		PagamentoDao pagamentoDao = new PagamentoDao();

		List<Pagamentos> listaAtrasos = pagamentoDao.buscaDividas().stream()
				.filter(pagamento -> pagamento.getStatus().equals(EnumStatus.EM_ATRASO)).collect(Collectors.toList());
		return listaAtrasos;
	}

}
