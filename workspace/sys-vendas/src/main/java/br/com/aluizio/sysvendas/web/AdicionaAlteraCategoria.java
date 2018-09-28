package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.CategoriaDao;
import br.com.aluizio.sysvendas.model.Categoria;

/**
 * Servlet invocada por alterar-categoria.jsp
 * 
 * @author Aluizio Monteiro 28 de sep de 2018
 */

@WebServlet("/adicionaAlteraCategoria")
public class AdicionaAlteraCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String message = "";
		Categoria categoria = new Categoria();
		
		if(req.getParameter("categoriaId") != null) {
			categoria.setId(Integer.parseInt(req.getParameter("categoriaId")));
			message = "Categoria adicionada com sucesso.";
		}else {
			message = "Categoria alterada com sucesso.";
		}
		
		categoria.setNome(req.getParameter("nome"));
		new CategoriaDao().adicionaAltera(categoria);
		
		JOptionPane.showMessageDialog(null, message);
		
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
