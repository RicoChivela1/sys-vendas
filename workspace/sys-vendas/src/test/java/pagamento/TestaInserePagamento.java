package pagamento;

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
		
		Pagamento pagamento = new Pagamento();
		pagamento.setValorTotal(1000);
		pagamento.setQtdParcelas(12);
		pagamento.setValorParcela(pagamento.getValorTotal()/pagamento.getQtdParcelas());
		pagamento.setDiaVencimento(15);
		pagamento.setParcelasPagas(0);
		pagamento.setStatus(EnumStatus.EM_DIAS);
		
		PagamentoDao dao = new PagamentoDao();
		dao.inserir(pagamento);
		System.out.println("Pagamento Inserido com sucesso");
	}

}
