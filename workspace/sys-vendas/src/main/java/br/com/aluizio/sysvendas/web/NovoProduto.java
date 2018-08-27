package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * NovoCliente.java
 * @author Aluizio Monteiro
 * 27 de ago de 2018
 */

@WebServlet("/novoProduto")
public class NovoProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//Popula Produto
		Produto produto = new Produto();
		produto.setNome(req.getParameter("nome"));
		produto.setDescricao(req.getParameter("descricao"));
		produto.setIndicacao(req.getParameter("indicacao"));
		produto.setVolume(req.getParameter("volume"));
		produto.setCustoUnid(
				Integer.parseInt(req.getParameter("custoUnid")));
		produto.setSugestaoVenda(
				Integer.parseInt(req.getParameter("sugestaoVenda")));
		
		ProdutoDao dao = new ProdutoDao();
		dao.adicionar(produto);

		JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso");
		
		RequestDispatcher rd = req.getRequestDispatcher( "index.html" );
		rd.forward( req, resp );
	}

}
