package paineladm;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * TestaPainelAdmin.java
 * 
 * @author Aluizio Monteiro 21 de abr de 2019
 */

public class TestaPainelAdmin {
	static BigDecimal totalInvestido = new BigDecimal("00.00");

	public static void main(String[] args) {

		// Lista á receber mês
		System.out.println("- Total a receber mês");
		LocalDate hoje = LocalDate.now();
		PagamentoDao pagamentoDao = new PagamentoDao();
		List<Pagamentos> listaAReceberMes = pagamentoDao.buscaDividas().stream()
				.filter(pagamento -> pagamento.getParcelaData().getMonth().compareTo(hoje.getMonth()) == 0)
				.collect(Collectors.toList());
		listaAReceberMes.forEach(e -> System.out.println(e));

		// Valor total a receber mês
		BigDecimal totalAReceberMes = listaAReceberMes.stream().map(Pagamentos::getValorParcela).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		System.out.println("- Total à receber mês");
		System.out.println(totalAReceberMes);

		/*
		 * // Lista á receber semana System.out.println("- Lista a receber semana");
		 * //LocalDate hoje = LocalDate.now();
		 * 
		 * List<Pagamentos> listaAReceberSemana = new
		 * PagamentoDao().buscaDividasSemana(); listaAReceberSemana.forEach(e
		 * ->System.out.println(e));
		 * 
		 * // Valor total a receber semana BigDecimal totalAReceberSemana =
		 * listaAReceberSemana.stream().map(Pagamentos::getValorParcela)
		 * .reduce(BigDecimal.ZERO, BigDecimal::add);
		 * System.out.println("- Total à receber semana");
		 * System.out.println(totalAReceberSemana);
		 * 
		 * 
		 * //Produtos System.out.println("Produtos"); ProdutoDao produtoDao = new
		 * ProdutoDao();
		 * 
		 * // Top List System.out.println("* Os cinco mais vendidos"); List<Produto>
		 * topList = produtoDao.topList(); topList.forEach(p -> System.out.println(p));
		 * 
		 * // Na Reserva System.out.println("* Estão na reserva"); List<Produto>
		 * reservaList = produtoDao.reservaList(); reservaList.forEach(p ->
		 * System.out.println(p));
		 * 
		 * // Esgotado System.out.println("* Esgotados"); List<Produto> esgotadoList =
		 * produtoDao.esgotadoList(); esgotadoList.forEach(p -> System.out.println(p));
		 */
	}

}
