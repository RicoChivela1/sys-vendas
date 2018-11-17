package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.model.Carrinho;

/**
 * Servlet implementation class Carrinho
 */
@WebServlet({ "/remover-carrinho.jsp", "/agregar-carrinho.jsp" })
public class OrcamentoProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url = "" ;
	HttpSession sessionProdutos;
	ArrayList<Carrinho> list;
	Carrinho carrinho;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		defineOperacao(request, response);
	}
	

	private void defineOperacao(HttpServletRequest request, HttpServletResponse response) throws IOException {

		url = request.getServletPath();

		System.out.println("A URL É: "+url);
		
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
		System.out.println("Id a ser removeido: "+Integer.parseInt(request.getParameter("id")));
		list.remove(Integer.parseInt(request.getParameter("id")));
		
		JOptionPane.showMessageDialog(null, "Produto Excluido");
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
	
		System.out.println("SUGESTÃO DE VENDA BIGDECIMAL" + sugestaoVenda);
		System.out.println("QTD PRODUTO BIGDECIMAL" + sugestaoVenda);
		
		carrinho.setCustoUnid(sugestaoVenda);
		carrinho.setSubTotal(sugestaoVenda.multiply(qtdProduto));
		System.out.println("SUBTOTAL" + carrinho.getCustoUnid());

		// Bloqueia produtos repetidos
		int indice = -1;

		for (int i = 0; i < list.size(); i++) {
			Carrinho carrinhoAux = list.get(i);
			if (carrinhoAux.getIdProduto() == carrinho.getIdProduto()) {
				indice = 1;
				break;
			}
		}

		if (indice == -1) {
			list.add(carrinho);
		} else {
			list.set(indice, carrinho);
		}

		sessionProdutos.setAttribute("carroCompras", list);
		JOptionPane.showMessageDialog(null, "Registrado corretamente");
		response.sendRedirect("orcamento.jsp");
	}
}
