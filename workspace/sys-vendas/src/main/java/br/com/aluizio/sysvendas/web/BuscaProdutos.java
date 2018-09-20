package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aluizio.sysvendas.dao.ProdutoDao;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * @author Aluizio Monteiro
 * 19 de set de 2018
 */
@WebServlet("/buscaProdutos")
public class BuscaProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String filtro = request.getParameter("filtro");
		
		Produto produto = new Produto();
		produto.setNome(filtro);
		
		ProdutoDao dao = new ProdutoDao();
			
		List<Produto> produtos = dao.buscaProdutoPorNome(produto);
		
		request.setAttribute("produtos", produtos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/busca-produtos.jsp");
		rd.forward(request, response);
	}
}
