package pagamento;

import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.EnumStatus;
import br.com.aluizio.sysvendas.model.Orcamento;
import br.com.aluizio.sysvendas.model.Pagamento;

/**
 * TestaPagamento.java
 * @author Aluizio Monteiro 
 * 11 de abr de 2019
 */

public class TestaPagamento {
	public static void main(String[] args) {
		Pagamento pagamento = new Pagamento();
		pagamento.setStatus(EnumStatus.QUITADO);
		pagamento.setFkOrcamento(54);
		pagamento.setNumParcela(7);
				
		PagamentoDao dao = new PagamentoDao();
		Orcamento orcamento = dao.pagarParcela(pagamento);
		System.out.println(orcamento);
		System.out.println("Pagamento registrado com sucesso");
	}
}
