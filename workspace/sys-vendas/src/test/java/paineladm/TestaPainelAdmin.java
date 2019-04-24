package paineladm;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.EnumStatus;
import br.com.aluizio.sysvendas.model.Pagamentos;

/**
 * TestaPainelAdmin.java
 * 
 * @author Aluizio Monteiro 21 de abr de 2019
 */

public class TestaPainelAdmin {
	static BigDecimal totalInvestido = new BigDecimal("00.00");

	public static void main(String[] args) {

	
		/*
		 * // Valor a receber System.out.println("- Lista � receber"); PagamentoDao
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
		 * // Lista � receber System.out.println("- Lista � receber"); PagamentoDao
		 * pagamentoDao = new PagamentoDao(); List<Pagamentos> listaAReceber =
		 * pagamentoDao.buscaDividas().stream() .filter(pagamento ->
		 * pagamento.getStatus() .equals(EnumStatus.A_PAGAR))
		 * .collect(Collectors.toList()); listaAReceber.forEach(e ->
		 * System.out.println(e.getStatus()));
		 * 
		 * 
		 * // Lista � receber hoje System.out.println("- Total a receber hoje");
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
		 * System.out.println("- Total � receber hoje");
		 * System.out.println(totalAReceberHoje);
		 * 
		 * 
		 * // Lista � receber m�s System.out.println("- Total a receber m�s"); LocalDate
		 * hoje = LocalDate.now(); PagamentoDao pagamentoDao = new PagamentoDao();
		 * List<Pagamentos> listaAReceberMes = pagamentoDao.buscaDividas().stream()
		 * .filter(pagamento ->
		 * pagamento.getParcelaData().getMonth().compareTo(hoje.getMonth()) ==
		 * 0).collect(Collectors.toList()); listaAReceberMes.forEach(e ->
		 * System.out.println(e));
		 * 
		 * // Valor total a receber m�s BigDecimal totalAReceberMes =
		 * listaAReceberMes.stream().map(Pagamentos::getValorParcela)
		 * .reduce(BigDecimal.ZERO, BigDecimal::add);
		 * System.out.println("- Total � receber hoje");
		 * System.out.println(totalAReceberMes);
		 * 
		 * 
		 * 
		 * // Lista � receber semana System.out.println("- Lista a receber semana");
		 * //LocalDate hoje = LocalDate.now();
		 * 
		 * List<Pagamentos> listaAReceberSemana = new
		 * PagamentoDao().buscaDividasSemana(); listaAReceberSemana.forEach(e
		 * ->System.out.println(e));
		 * 
		 * // Valor total a receber semana BigDecimal totalAReceberSemana =
		 * listaAReceberSemana.stream().map(Pagamentos::getValorParcela)
		 * .reduce(BigDecimal.ZERO, BigDecimal::add);
		 * System.out.println("- Total � receber semana");
		 * System.out.println(totalAReceberSemana);
		 * 
		 * 
		 * //Produtos System.out.println("Produtos"); ProdutoDao produtoDao = new
		 * ProdutoDao();
		 * 
		 * // Top List System.out.println("* Os cinco mais vendidos"); List<Produto>
		 * topList = produtoDao.topList(); topList.forEach(p -> System.out.println(p));
		 * 
		 * // Na Reserva System.out.println("* Est�o na reserva"); List<Produto>
		 * reservaList = produtoDao.reservaList(); reservaList.forEach(p ->
		 * System.out.println(p));
		 * 
		 * // Esgotado System.out.println("* Esgotados"); List<Produto> esgotadoList =
		 * produtoDao.esgotadoList(); esgotadoList.forEach(p -> System.out.println(p));
		 */
	}

}
