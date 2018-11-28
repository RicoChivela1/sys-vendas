package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.aluizio.sysvendas.model.Carrinho;

/**
 * Controla a adição e remoção de produtos no um orçamento (session).
 */
@WebServlet({ "/remover-carrinho.jsp", "/agregar-carrinho.jsp" })
public class OrcamentoProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url = "" ;
	private HttpSession sessionProdutos;
	private ArrayList<Carrinho> list;
	private Carrinho carrinho;
	private BigDecimal total = new BigDecimal(0);
	private LocalDate hoje;
	private LocalDate vencParcela;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		defineOperacao(request, response);
	}

	private void defineOperacao(HttpServletRequest request, HttpServletResponse response) throws IOException {

		url = request.getServletPath();
		
		if (url.equals("/agregar-carrinho.jsp")) {
			agregar(request, response);
		} else if (url.equals("/remover-carrinho.jsp")) {
			remover(request, response);
		}
	}
 
	// Exclui produto
	private void remover(HttpServletRequest request, HttpServletResponse response) throws IOException {
		sessionProdutos = request.getSession(false);
		list = (ArrayList<Carrinho>) sessionProdutos.getAttribute("carroCompras");
		list.remove(Integer.parseInt(request.getParameter("id")));
		atualizaTotal();
		response.sendRedirect("orcamento.jsp");
	}

	private void agregar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		sessionProdutos = request.getSession(false);
		list = (ArrayList<Carrinho>) sessionProdutos.getAttribute("carroCompras");

		if (list == null) {
			list = new ArrayList<Carrinho>();
			sessionProdutos.setAttribute("carroCompras", list);
		}

		carrinho = new Carrinho();
		carrinho.setIdProduto(Integer.parseInt(request.getParameter("idProduto")));
		carrinho.setNomeProduto(request.getParameter("nomeProduto"));
		carrinho.setQtdProduto(Integer.parseInt(request.getParameter("qtdProduto")));
		
		//Calcula subtotal
		BigDecimal sugestaoVenda = new BigDecimal(request.getParameter("sugestaoVenda"));
		BigDecimal qtdProduto = new BigDecimal(request.getParameter("qtdProduto"));
		
		carrinho.setCustoUnid(sugestaoVenda);
		carrinho.setSubTotal(sugestaoVenda.multiply(qtdProduto));
		
		
		
		// Data que vem do input
		String dataTexto = request.getParameter("vencParcela");
		if(dataTexto == null) {
			sessionProdutos.setAttribute("vencParcela", LocalDate.now());		
		}
		
		
		
	
		// Bloqueia produtos repetidos
		int indice = -1;

		for (int i = 0; i < list.size(); i++) {
			Carrinho carrinhoAux = list.get(i);
			if (carrinhoAux.getIdProduto() == carrinho.getIdProduto()) {
				indice = i;
				break;
			}
		}

		if (indice == -1) {
			list.add(carrinho);
		} else {
			list.set(indice, carrinho);
		}

		sessionProdutos.setAttribute("carroCompras", list);
		atualizaTotal();
		response.sendRedirect("orcamento.jsp");
	}

	public void atualizaTotal() {
		//Calcula total
		total = new BigDecimal(0);
		for (int i = 0; i < list.size(); i++) {
			total = total.add(list.get(i).getSubTotal());
		}
		System.out.println("Somatório do total: "+total);
		sessionProdutos.setAttribute("total", total);
	}
}
