package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.CategoriaDao;
import br.com.aluizio.sysvendas.dao.EstoqueDao;
import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.dao.ProdutoFornecedorDao;
import br.com.aluizio.sysvendas.model.Categoria;
import br.com.aluizio.sysvendas.model.Estoque;
import br.com.aluizio.sysvendas.model.Produto;
import br.com.aluizio.sysvendas.model.ProdutoFornecedor;

/**
 * Servlet implementation class NovoCliente
 * 
 * @author Aluizio Monteiro 27 de ago de 2018
 */

@WebServlet("/novoProduto")
public class NovoProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Popula Categoria
		Categoria categoria = new Categoria();
		categoria.setNome(req.getParameter("categoria"));

		CategoriaDao categoriaDao = new CategoriaDao();
		categoriaDao.adicionar(categoria);
		categoria.setId(categoriaDao.buscaMaiorId());
		
		// Popula Estoque
		Estoque estoque = new Estoque();
		estoque.setQtdEntrada(Integer.parseInt(req.getParameter("qtdEstoque")));
		
		estoque.setQtdMinima(Integer.parseInt(req.getParameter("qtdMinima")));
		
		estoque.setQtdSaida(Integer.parseInt(req.getParameter("qtdMinima")));
				
		
		EstoqueDao estoqueDao = new EstoqueDao();
		estoqueDao.adicionar(estoque);
		
		// Popula Produto
		Produto produto = new Produto();
		
		int idCategoria = new CategoriaDao().buscaMaiorId();
		Categoria c = new Categoria();
		c.setId(idCategoria);
		
		int idEstoque = new EstoqueDao().buscaMaiorId();
		Estoque e = new Estoque();
		e.setId(idEstoque);
		
		produto.setCategoria(c);
		produto.setEstoque(e);
		
		produto.setNome(req.getParameter("nome"));
		produto.setDescricao(req.getParameter("descricao"));
		produto.setIndicacao(req.getParameter("indicacao"));
		produto.setVolume(req.getParameter("volume"));
		produto.setCustoUnid(Integer.parseInt(req.getParameter("custoUnid")));
		produto.setSugestaoVenda(Integer.parseInt(req.getParameter("sugestaoVenda")));

		ProdutoDao produtoDao = new ProdutoDao();
		produtoDao.adicionar(produto);

		//Faz busca pelo listbox fornecedor retornando o id da seleção
		int idFornecedor = Integer.parseInt(req.getParameter("fornecedor"));
		
		//Faz busca do último produto adicionado e retorna
		int idProduto = new ProdutoDao().buscaMaiorId();
		
		//Salva o relacionamento
		ProdutoFornecedor produtoFornecedor = new ProdutoFornecedor();
		produtoFornecedor.setIdFornecedor(idFornecedor);
		produtoFornecedor.setIdProduto(idProduto);
		
		new ProdutoFornecedorDao().relacionar(produtoFornecedor);

		JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso");

		RequestDispatcher rd = req.getRequestDispatcher("/index.html");
		rd.forward(req, resp);
	}

}
