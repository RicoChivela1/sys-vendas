package br.com.aluizio.sysvendas.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * Salva um orcamento relacionado com um cliente. Isto não efetiva uma venda.
 * 
 * @author Aluizio Monteiro 30 de nov de 2018
 */

@WebServlet("/salvaOrcamento")
public class SalvaOrcamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession sessaoCliente, usuarioLogado, sessionProdutos;

	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		
		// Usuario
		usuarioLogado = request.getSession(false);
		Usuario usuario = (Usuario) usuarioLogado.getAttribute("usuarioLogado");

		int idUsuario = usuario.getId();
		String nomeUsuario = usuario.getNome();

		System.out.println("O Id do Usuário é: " + idUsuario);
		System.out.println("O nome do Usuário é: " + nomeUsuario);

		
		// Cliente
		sessaoCliente = request.getSession(false);
		Cliente cliente = (Cliente) sessaoCliente.getAttribute("sessaoCliente");

		int idCliente = cliente.getId();
		String nomeCliente = cliente.getNome();

		System.out.println("O Id do cliente é: " + idCliente);
		System.out.println("O nome do cliente é: " + nomeCliente);

		
		/*//Produtos
		sessionProdutos = request.getSession(false);
		ArrayList<Carrinho> list = (ArrayList<Carrinho>) sessionProdutos.getAttribute("carroCompras");
		
		List<OrcamentoProduto> list = new ArrayList<>();
		list.add(oP1);
		list.add(oP2);
		list.add(oP3);
		
		dao.salvarOrcametoProduto(list);*/
		/*
		 * cliente.setId(2);
		 * 
		 * 
		 * Usuario usuario = new Usuario(); usuario.setId(6);
		 * 
		 * Orcamento orcamento = new Orcamento();
		 * 
		 * orcamento.setTotal(new BigDecimal("10.00")); orcamento.setDescontos(new
		 * BigDecimal("0.50"));
		 * 
		 * LocalDate dataLancamento = LocalDate.now();
		 * orcamento.setDataLancamento(dataLancamento);
		 * 
		 * orcamento.setConfirmado(true);
		 * 
		 * orcamento.setCliente(cliente); orcamento.setUsuario(usuario);
		 * 
		 * OrcamentoDao dao = new OrcamentoDao(); dao.salvarOrcamento(orcamento);
		 * 
		 * System.out.println("Orcamento salvo com sucesso");
		 * 
		 * 
		 * 
		 * OrcamentoProduto oP1 = new OrcamentoProduto();
		 * oP1.setProdutoNome("teste orçamento 1"); oP1.setQtd(2); oP1.setValorUnid(new
		 * BigDecimal("12.00")); oP1.setSubTotal(new BigDecimal("24.00"));
		 * 
		 * List<OrcamentoProduto> list = new ArrayList<>(); list.add(oP1);
		 * list.add(oP2); list.add(oP3);
		 * 
		 * dao.salvarOrcametoProduto(list);
		 */

	}
}
