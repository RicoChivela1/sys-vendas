package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GerenciaCliente
 */
@WebServlet("/gerenciaCliente")
public class GerenciaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String pOrcamento = request.getParameter("orcamento");

    	//Se null
    	if( pOrcamento != null) {
    		int id = Integer.parseInt(pOrcamento);
    		System.out.println("Id do orcamento do cliente é: "+ id);
    	}
    	
    	//Se null
    	if(request.getParameter("info") != null) {
    		int id = Integer.parseInt(request.getParameter("info"));
    		System.out.println("Id da info do cliente é: "+ id);
    	}
    	
    	//Se null
    	if(request.getParameter("alterar") != null) {
    		int id = Integer.parseInt(request.getParameter("alterar"));
    		System.out.println("Id do alterar cliente é: "+ id);
    	}
    	
    	//Se null
    	if(request.getParameter("remover") != null) {
    		int id = Integer.parseInt(request.getParameter("remover"));
    		System.out.println("Id do remover cliente é: "+ id);
    	}
	}
	

}
