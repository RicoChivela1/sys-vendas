package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.UsuarioDao;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * Login.java
 * @author Aluizio Monteiro
 * 29 de ago de 2018
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		Usuario usuarioBuscado = new Usuario();
		usuarioBuscado.setLogin(request.getParameter("login"));
		usuarioBuscado.setSenha(request.getParameter("senha"));
		
		Usuario usuario = new UsuarioDao().buscaUsuario(usuarioBuscado);
		System.out.println(usuario);
		
		if(usuario.getId() == null) {
			System.out.println("Erro ao tentar se logar.");
			
			JOptionPane.showMessageDialog(null,  "Nome ou senha incorretas.");
			
			request.getRequestDispatcher("index.html")
			.forward(request, response);
		}else {
			System.out.println("Usu�rio "+usuario.getNome()+ "efetuou login.");
			Cookie cookie = new Cookie("usuario.logado", "usuario.getNome()");
			cookie.setMaxAge(10 * 60);
			response.addCookie(cookie);
			
			request.getRequestDispatcher("index.jsp")
			.forward(request, response);
		}
			
		
	}

}








