package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 * @author Aluizio Monteiro
 * 31 de ago de 2018
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Deslogar em 10 minutos
		request.getSession().setMaxInactiveInterval(10 * 60);
		request.getSession().removeAttribute("usuarioLogado");
		System.out.println("Usuário deslogado");
		request.getRequestDispatcher("/index.html").forward(request, response);
	}
}
