package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aluizio.sysvendas.dao.CategoriaDao;
import br.com.aluizio.sysvendas.model.Categoria;

/**
 * Servlet responsável pelas funcionalidades dos botões
 * da página busca-categoria.jsp.
 * Recebe os ids dos clientes
 */
@WebServlet("/gerenciaCategoria")
public class GerenciaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String pagina = "";
    	Categoria categoriaid = new Categoria();
    
    	//Alterar Categoria
    	if(request.getParameter("alterar") != null) {
    		categoriaid.setId(Integer.parseInt(request.getParameter("alterar")));
    		Categoria categoria = (Categoria) new CategoriaDao()
					.buscaPorId(categoriaid);
    		
			request.setAttribute("categoria", categoria);
    		pagina = "/alterar-categoria.jsp";
    	}
    	
    	//Remove Categoria
    	if(request.getParameter("remover") != null) {
    		categoriaid.setId(Integer.parseInt(request.getParameter("remover")));
			new CategoriaDao().remover(categoriaid);
    		pagina = "/index.jsp";
    	} 
    	
    	RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);
	}
}
