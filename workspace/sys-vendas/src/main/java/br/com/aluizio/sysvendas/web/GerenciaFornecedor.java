package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aluizio.sysvendas.dao.FornecedorDao;
import br.com.aluizio.sysvendas.model.Fornecedor;

/**
 * Servlet respons�vel pelas funcionalidades dos bot�es da p�gina
 * busca-fornecedor.jsp. Recebe os ids dos fornecedores
 */
@WebServlet("/gerenciaFornecedor")
public class GerenciaFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pagina = "";
		Fornecedor fornecedor = new Fornecedor();

		// Alterar Fornecedor
		if (request.getParameter("alterar") != null) {
			System.out.println("Id do fornecedor: " + request.getParameter("alterar"));
			// busca fornecedor pelo id e o coloca na requisi��o
			int id = Integer.parseInt(request.getParameter("alterar"));
			fornecedor.setId(id);
			Fornecedor fornecedorDao = (Fornecedor) new FornecedorDao().buscaPorId(fornecedor);
			System.out.println("Nome do fornecedor: "+fornecedorDao.getNome());
			request.setAttribute("fornecedor", fornecedorDao);

			// formul�rio de altera��o
			pagina = "/alterar-fornecedor.jsp";
		}

		// Remover Fornecedor
		if (request.getParameter("remover") != null) {
			fornecedor.setId(Integer.parseInt(request.getParameter("remover")));
			new FornecedorDao().remover(fornecedor);

			pagina = "/index.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);
	}
}
