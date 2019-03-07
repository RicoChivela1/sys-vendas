package pagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.EnumStatus;
import br.com.aluizio.sysvendas.model.Pagamento;

/**
 * TestaInserePagamento.java
 * @author Aluizio Monteiro
 * 23 de ago de 2018
 */

public class TestaInserePagamento {

	public static void main(String[] args) {
		
		Pagamento pagamento1 = new Pagamento();
		pagamento1.setNumParcela(11);
		pagamento1.setValorParcela(new BigDecimal("200.0"));
		pagamento1.setParcelaData(LocalDate.now());
		pagamento1.setFkOrcamento(15);
		pagamento1.setStatus(EnumStatus.QUITADO);
		
		Pagamento pagamento2 = new Pagamento();
		pagamento2.setNumParcela(11);
		pagamento2.setValorParcela(new BigDecimal("200.0"));
		pagamento2.setParcelaData(LocalDate.now());
		pagamento2.setFkOrcamento(15);
		pagamento2.setStatus(EnumStatus.EM_ATRASO);
		
		Pagamento pagamento3 = new Pagamento();
		pagamento3.setNumParcela(11);
		pagamento3.setValorParcela(new BigDecimal("200.0"));
		pagamento3.setParcelaData(LocalDate.now());
		pagamento3.setFkOrcamento(15);
		pagamento3.setStatus(EnumStatus.A_PAGAR);
		
		List<Pagamento> list = new ArrayList<>();
		list.add(pagamento1);
		list.add(pagamento2);
		list.add(pagamento3);
		
		PagamentoDao dao = new PagamentoDao();
		dao.inserir(list);
		System.out.println("Pagamentos Inseridos com sucesso");
	}

}
