package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Pagamento
 */
@WebServlet("/Pagamento")
public class Pagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//abre detalhes
    	/*if( pOrcamento != null) {
    		int id = Integer.parseInt(pOrcamento);
    		System.out.println("Id do orcamento do cliente é: "+ id);
    		
    		//objeto contendo o id do cliente
    		Cliente clienteBuscado = new Cliente();
    		clienteBuscado.setId(id);	
    		
    		Orcamento orcBuscado = new Orcamento();
    		orcBuscado.setId(id);

    		OrcamentoDao dao = new OrcamentoDao();
    		
    		//retorna orçamento
    		Orcamento orcamento = dao.buscaOrcamentoPorId(orcBuscado);
    		request.setAttribute("orcamento", orcamento);
    		
    		pagina = "/info-orcamento.jsp";
    	}*/
	}

}
