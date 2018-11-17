package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.model.Cliente;

/**
 * Servlet implementation class OrcamentoCliente
 */
@WebServlet({"/agregarCliente.jsp", "/eliminarCliente.jsp"})
public class OrcamentoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	String url;
	HttpSession sessaoCliente;
	Cliente cliente;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		metGet(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		metodoPost(request, response);
	}
	
	//Escolhe a operação
	protected void metodoPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		url = request.getServletPath();
		
		if (url.equals("/agregarCliente.jsp")) {
			adicionarCliente(request, response);
		} else if (url.equals("/eliminarCliente.jsp")) {
			eliminarCliente(request, response);
		}
	}
	
	//elimina sessão
	private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) {
		sessaoCliente = request.getSession(false);	
		cliente = (Cliente) sessaoCliente.getAttribute("sessaoCliente");
		sessaoCliente.invalidate();
	}

	//Adiciona na lista
	private void adicionarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
		sessaoCliente = request.getSession(false);
		cliente = (Cliente) sessaoCliente.getAttribute("sessaoCliente");
		
		if (cliente == null) {
			cliente = new Cliente();
			sessaoCliente.setAttribute("sessaoCliente", cliente);
		}
		
		cliente.setId(Integer.parseInt(request.getParameter("idCliente")));
		cliente.setNome(request.getParameter("nomeCliente"));
	
		/*//Para que nada se repita
		int indice = -1;
		for (int i = 0; i < cliente.size(); i++) {
			Cliente clienteAux = cliente.get(i);
			if (clienteAux.getId() == cliente.getId()) {
				indice = 1;
				break;
			}
		}
		
		if (indice == -1) {
			cliente.add(produto);
		}else {
			cliente.set(indice, produto);
		}*/
		
		sessaoCliente.setAttribute("sessaoCliente", cliente);
		JOptionPane.showMessageDialog(null, "Cliente registrado corretamente");
		response.sendRedirect("carrinho.jsp");
	}

	protected void metGet(HttpServletRequest request, HttpServletResponse response) {
		
		
	}
}
