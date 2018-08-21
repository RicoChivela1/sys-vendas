/**
 * 
 */
package produto;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * BuscaProdutoPorNome.java
 * 
 * @author Aluizio Monteiro 
 * 20 de ago de 2018
 */

public class BuscaProdutoPorNome {

	public static void main(String[] args) {

		Produto produtoBuscado = new Produto();
		produtoBuscado.setNome("rec");

		ProdutoDao dao = new ProdutoDao();
		List<Produto> produtos = dao.buscaProdutoPorNome(produtoBuscado);
		for (Produto produto : produtos) {
			System.out.println(produto);
			System.out.println(produto.getEstoque());
		}

	}

}
