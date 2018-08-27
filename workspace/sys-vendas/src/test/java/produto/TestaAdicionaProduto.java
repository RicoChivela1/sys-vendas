package produto;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * TestaAdicionaProduto.java
 * 
 * @author Aluizio Monteiro 20 de ago de 2018
 */

public class TestaAdicionaProduto {

	public static void main(String[] args) {
		// Testa Adicionar
		Produto produto = new Produto();
		produto.setNome("Creme");
		produto.setDescricao("Creme");
		produto.setIndicacao("Quimico");
		produto.setVolume("200ml");
		produto.setCustoUnid(1000);
		produto.setSugestaoVenda(2000);
		
		ProdutoDao dao = new ProdutoDao();
		dao.adicionar(produto);

		System.out.println("Produto adicionado.");
	}

}
