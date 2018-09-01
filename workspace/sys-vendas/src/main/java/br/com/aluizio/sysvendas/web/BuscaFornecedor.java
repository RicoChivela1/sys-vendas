package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aluizio.sysvendas.dao.FornecedorDao;
import br.com.aluizio.sysvendas.model.Fornecedor;

/**
 * ToDo
 * @author Aluizio Monteiro
 * 31 de ago de 2018
 */
@WebServlet("/buscaClientes")
public class BuscaFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String filtro = request.getParameter("filtro");
		
		Fornecedor f = new Fornecedor();
		f.setNome(filtro);
		
		FornecedorDao dao = new FornecedorDao();
			
		List<Fornecedor> fornecedores = dao.getList();
		
		request.setAttribute("fornecedores", fornecedores);
		System.out.println("Populand listbox [fornecedor]");
	}
}
