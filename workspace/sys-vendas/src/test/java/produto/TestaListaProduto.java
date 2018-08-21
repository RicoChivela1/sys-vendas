package produto;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * TestaListaProduto.java
 * 
 * @authorAluizio Monteiro 20 de ago de 2018
 */

public class TestaListaProduto {

	public static void main(String[] args) {
		ProdutoDao dao = new ProdutoDao();
		List<Produto> produtos = dao.getList();

		produtos.forEach(p -> System.out.println(p));

	}

}
