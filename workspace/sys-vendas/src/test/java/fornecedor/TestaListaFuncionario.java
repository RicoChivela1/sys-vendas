package fornecedor;

import java.util.List;

import br.com.aluizio.sysvendas.dao.FornecedorDao;
import br.com.aluizio.sysvendas.model.Fornecedor;

/**
 * TestaListaFuncionario.java
 * @author Aluizio Monteiro
 * 20 de ago de 2018
 */

public class TestaListaFuncionario {

	public static void main(String[] args) {
		FornecedorDao dao = new FornecedorDao();
		List<Fornecedor> fornecedores = dao.getList();
		
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
	
		System.out.println("Fornecedor listados com sucesso");

	}
}
