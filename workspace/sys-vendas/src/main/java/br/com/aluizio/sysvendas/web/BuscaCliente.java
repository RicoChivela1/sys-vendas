package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Cliente;

/**
 * ToDo
 * @author Aluizio Monteiro
 * 31 de ago de 2018
 */
@WebServlet("/buscaClientePorNome")
public class BuscaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<html><body>");
		writer.println("Resultado da busca: <br />");
		
		String filtro = request.getParameter("filtro");
		
		Cliente clienteBuscado = new Cliente();
		
		clienteBuscado.setNome(filtro);
		ClienteDao dao = new ClienteDao();
		List<Cliente> clientes = dao.buscaPorNome(clienteBuscado);
		 
		
		writer.println("<ul>");
		
		for (Cliente cliente : clientes) {
			writer.println("<li>"+cliente+"</li>");
			writer.println("<br />");
		}
		writer.println("</ul>");
		
		writer.println("</body></html>");
	}



}
