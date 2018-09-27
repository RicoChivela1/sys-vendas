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
 * Servlet implementation class NovaCategoria
 * 
 * @author Aluizio Monteiro 29 de ago de 2018
 */

@WebServlet("/adicionaCategoria")
public class AdicionaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Categoria categoria = new Categoria();
		categoria.setNome(request.getParameter("nome"));

		new CategoriaDao().adicionaAltera(categoria);

		JOptionPane.showMessageDialog(null, "Categoria adicionada com sucesso.");

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
