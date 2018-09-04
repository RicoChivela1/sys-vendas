package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Cliente;

/**
 * Servlet implementation class GerenciaCliente
 */
@WebServlet("/gerenciaCliente")
public class GerenciaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String pOrcamento = request.getParameter("orcamento");
    	String pagina = "";

    	//abre orçamento
    	if( pOrcamento != null) {
    		int id = Integer.parseInt(pOrcamento);
    		System.out.println("Id do orcamento do cliente é: "+ id);
    		
    		pagina = "/orcamento-cliente.jsp";
    	}
    	
    	//Exibe informações completas sobre o cliente
    	if(request.getParameter("info") != null) {
    		int id = Integer.parseInt(request.getParameter("info"));
    		System.out.println("Id da info do cliente é: "+ id);
    		
    		pagina = "/info-cliente.jsp";
    	}
    	
    	//permite alterar clientes
    	if(request.getParameter("alterar") != null) {
    		int id = Integer.parseInt(request.getParameter("alterar"));
    		
    		Cliente clienteBuscado = new Cliente();
    		clienteBuscado.setId(id);
    		
			Cliente cliente = new ClienteDao().buscaPorId(clienteBuscado);
    		request.setAttribute("cliente", cliente);
    		
    		RequestDispatcher rd = request.getRequestDispatcher("/alterar-cliente.jsp");
    		rd.forward(request, response);
    	
    		pagina = "/alterar-cliente.jsp";
    	}
    	
    	//remove cliente
    	if(request.getParameter("remover") != null) {
    		int id = Integer.parseInt(request.getParameter("remover"));
    		System.out.println("Id do remover cliente é: "+ id);
    		
    		pagina = "/remover-cliente.jsp";
    	}
    	
    	RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);
	}
	

}
