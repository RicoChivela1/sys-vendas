package produto;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ProdutoDao;

/**
 * TestaListaProduto.java
 * 
 * @authorAluizio Monteiro 20 de ago de 2018
 */

public class TestaListaProduto {

	public static void main(String[] args) {
		ProdutoDao dao = new ProdutoDao();
		List<Object> produtos = dao.getList();
		
		produtos.forEach(p -> System.out.println(p));

	}

}
