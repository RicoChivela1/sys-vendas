package br.com.aluizio.sysvendas.testes;

import java.util.List;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

public class TestaProduto {

	public static void main(String[] args) {

		/*
		 * // Busca por nome Produto produtoBuscado = new Produto();
		 * produtoBuscado.setNome("rec");
		 * 
		 * ProdutoDao dao = new ProdutoDao(); List<Produto> produtos =
		 * dao.buscaProdutoPorNome(produtoBuscado); for (Produto produto : produtos) {
		 * System.out.println(produto); System.out.println(produto.getEstoque()); }
		 */

		/*
		 * // Verifica se produto existe Produto produto = new Produto();
		 * produto.setNome("rec");
		 * 
		 * ProdutoDao dao = new ProdutoDao(); dao.existProduto(produto);
		 */

		// Testa Lista

		ProdutoDao dao = new ProdutoDao();
		List<Produto> produtos = dao.getList();

		produtos.forEach(p -> System.out.println(p));

		/*
		 * //Altera Produto produto = new Produto(); produto.setNome("ReconstruPilar");
		 * produto.setDescricao("Reconstrutor Capilar");
		 * produto.setIndicacao("Queda de cabelo"); produto.setVolume("200ml");
		 * produto.setCustoUnid(1000); produto.setSugestaoVenda(2000);
		 * 
		 * produto.setId(6);
		 * 
		 * ProdutoDao dao = new ProdutoDao(); dao.atualizar(produto);
		 */

		/*
		 * //Testa Adicionar Produto produto = new Produto();
		 * produto.setNome("ReconsPila"); produto.setDescricao("Reconstrutor Capilar");
		 * produto.setIndicacao("Queda de cabelo"); produto.setVolume("200ml");
		 * produto.setCustoUnid(1000); produto.setSugestaoVenda(2000);
		 * 
		 * ProdutoDao dao = new ProdutoDao(); dao.adicionar(produto);
		 */
	}

}
