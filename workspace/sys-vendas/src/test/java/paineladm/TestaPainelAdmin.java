package paineladm;

import java.math.BigDecimal;
import java.util.List;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
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
		System.out.println("Visão Geral");

		// Total Investido
		System.out.println("Total Investido");
		ProdutoDao produtoDao = new ProdutoDao();
		List<Object> list = produtoDao.getList();
		for (Object object : list) {
			Produto produto = (Produto) object;
			totalInvestido = totalInvestido.add(produto.getCustoUnid());

		}

		System.out.println(" - Total: " + totalInvestido);

		// Total Lucro ( vendasBrutas - totalInvestido)
		System.out.println("Total Lucro");

		PagamentoDao pagamentoDao = new PagamentoDao();
		BigDecimal totalVendas = pagamentoDao.buscaLucro();
		System.out.println(" - Bruto: " + totalVendas);
		System.out.println(" - Líquido: " + totalVendas.subtract(totalInvestido));

		// Extimativa de Lucro
		// Total Lucro ( soma QUITADO, ATRASADO E A_PAGAR e subtrai pelo totalInvestido)
		System.out.println("Extimativa de Lucro");
		BigDecimal extimativaLucro = pagamentoDao.buscaExtimativas();
		System.out.println(" - Bruto: " + (extimativaLucro));
		System.out.println(" - Líquido: " + (extimativaLucro.subtract(totalInvestido)));

		// BigDecimal totalInvestido =
		// list.stream().map(Produto::getCustoUnid).reduce(BigDecimal.ZERO,
		// BigDecimal::add);
		// System.out.println(totalInvestido);

		// list.forEach(e -> System.out.println(e));
		/*
		 * BigDecimal totalInvestido = list.stream(). .map(Object::getCustoUnid)
		 * .reduce(BigDecimal.ZERO, BigDecimal::add);
		 * System.out.println(totalInvestido);
		 */
		/*
		 * BigDecimal valorTotal =
		 * buscaDividas.stream().map(Pagamentos::getValorParcela).reduce(BigDecimal.
		 * ZERO, BigDecimal::add); System.out.println(valorTotal);
		 * System.out.println("Total Lucro "); System.out.println("Lucro extimado");
		 */
		/*
		 * 
		 * //Dividas System.out.println("* Dívidas"); PagamentoDao pagamentoDao = new
		 * PagamentoDao();
		 * 
		 * // Total Dívidas System.out.println("- Total Dívidas "); List<Pagamentos>
		 * buscaDividas = pagamentoDao.buscaDividas(); BigDecimal valorTotal =
		 * buscaDividas.stream() .map(Pagamentos::getValorParcela)
		 * .reduce(BigDecimal.ZERO, BigDecimal::add); System.out.println(valorTotal);
		 * 
		 * // Listar todas as dívidas System.out.println("* Lista de dividas");
		 * buscaDividas.forEach(System.out::println);
		 * 
		 * //Lista de pagamentos em Atraso PagamentoDao pagamentoDao = new
		 * PagamentoDao(); System.out.println("- Pagamentos atrasados");
		 * 
		 * List<Pagamentos> listaAtrasos = pagamentoDao.buscaDividas().stream()
		 * .filter(pagamento -> pagamento.getStatus() .equals(EnumStatus.EM_ATRASO))
		 * .collect(Collectors.toList()); listaAtrasos.forEach(e ->
		 * System.out.println(e.getStatus()));
		 * 
		 * // Valor total Atraso BigDecimal valorAtraso = listaAtrasos.stream()
		 * .map(Pagamentos::getValorParcela) .reduce(BigDecimal.ZERO, BigDecimal::add);
		 * System.out.println("- Total atrasados"); System.out.println(valorAtraso);
		 * 
		 * // Valor a receber System.out.println("- Lista à receber"); PagamentoDao
		 * pagamentoDao = new PagamentoDao(); List<Pagamentos> listaAReceber =
		 * pagamentoDao.buscaDividas().stream() .filter(pagamento ->
		 * pagamento.getStatus() .equals(EnumStatus.A_PAGAR))
		 * .collect(Collectors.toList()); listaAReceber.forEach(e ->
		 * System.out.println(e.getStatus()));
		 * 
		 * // Valor total Atraso BigDecimal totalAReceber = listaAReceber.stream()
		 * .map(Pagamentos::getValorParcela) .reduce(BigDecimal.ZERO, BigDecimal::add);
		 * System.out.println("- Total atrasados"); System.out.println(totalAReceber);
		 * 
		 * 
		 * // Lista á receber System.out.println("- Lista à receber"); PagamentoDao
		 * pagamentoDao = new PagamentoDao(); List<Pagamentos> listaAReceber =
		 * pagamentoDao.buscaDividas().stream() .filter(pagamento ->
		 * pagamento.getStatus() .equals(EnumStatus.A_PAGAR))
		 * .collect(Collectors.toList()); listaAReceber.forEach(e ->
		 * System.out.println(e.getStatus()));
		 * 
		 * 
		 * // Lista á receber hoje System.out.println("- Total a receber hoje");
		 * LocalDate hoje = LocalDate.now(); PagamentoDao pagamentoDao = new
		 * PagamentoDao(); List<Pagamentos> listaAReceberHoje =
		 * pagamentoDao.buscaDividas().stream() .filter(pagamento ->
		 * pagamento.getParcelaData().compareTo(hoje) ==
		 * 0).collect(Collectors.toList()); listaAReceberHoje.forEach(e ->
		 * System.out.println(e));
		 * 
		 * // Valor total a receber hoje BigDecimal totalAReceberHoje =
		 * listaAReceberHoje.stream().map(Pagamentos::getValorParcela)
		 * .reduce(BigDecimal.ZERO, BigDecimal::add);
		 * System.out.println("- Total à receber hoje");
		 * System.out.println(totalAReceberHoje);
		 * 
		 * 
		 * // Lista á receber mês System.out.println("- Total a receber mês"); LocalDate
		 * hoje = LocalDate.now(); PagamentoDao pagamentoDao = new PagamentoDao();
		 * List<Pagamentos> listaAReceberMes = pagamentoDao.buscaDividas().stream()
		 * .filter(pagamento ->
		 * pagamento.getParcelaData().getMonth().compareTo(hoje.getMonth()) ==
		 * 0).collect(Collectors.toList()); listaAReceberMes.forEach(e ->
		 * System.out.println(e));
		 * 
		 * // Valor total a receber mês BigDecimal totalAReceberMes =
		 * listaAReceberMes.stream().map(Pagamentos::getValorParcela)
		 * .reduce(BigDecimal.ZERO, BigDecimal::add);
		 * System.out.println("- Total à receber hoje");
		 * System.out.println(totalAReceberMes);
		 * 
		 * 
		 * 
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
