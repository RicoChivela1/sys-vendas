package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aluizio.sysvendas.dao.CategoriaDao;
import br.com.aluizio.sysvendas.model.Categoria;

/**
 * @author Aluizio Monteiro
 * 26 de set de 2018
 */
@WebServlet("/buscaCategoria")
public class BuscaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String filtro = request.getParameter("filtro");
		
		Categoria categoria = new Categoria();
		categoria.setNome(filtro);
		
		CategoriaDao dao = new CategoriaDao();
			
		List<Object> categorias = dao.buscaPorNome(categoria);
		
		request.setAttribute("categorias", categorias);
		
		RequestDispatcher rd = request.getRequestDispatcher("/busca-categorias.jsp");
		rd.forward(request, response);
	}
}
