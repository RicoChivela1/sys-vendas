package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.UsuarioDao;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * Servlet implementation class NovoUsuario
 * @author Aluizio Monteiro
 * 29 de ago de 2018
 */

@WebServlet("/novoUsuario")
public class NovoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("nome"));
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
	
		new UsuarioDao().adicionar(usuario);
		
		JOptionPane.showMessageDialog(null,  "Usuário Adicionado com sucesso");
		
		request.getRequestDispatcher("/index.jsp")
		.forward(request, response);
		
	}
	
	

}
