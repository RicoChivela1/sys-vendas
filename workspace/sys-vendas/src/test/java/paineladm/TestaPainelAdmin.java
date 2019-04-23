package paineladm;

/**
 * TestaPainelAdmin.java
 * 
 * @author Aluizio Monteiro 21 de abr de 2019
 */

public class TestaPainelAdmin {
	public static void main(String[] args) {
		/*
		 * System.out.println("Visão Geral"); System.out.println("Total Investido");
		 * System.out.println("Total Lucro "); System.out.println("Lucro extimado");
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
