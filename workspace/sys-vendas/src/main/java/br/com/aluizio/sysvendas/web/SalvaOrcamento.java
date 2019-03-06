package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.dao.PagamentoDao;
import br.com.aluizio.sysvendas.model.Carrinho;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.EnumSituacao;
import br.com.aluizio.sysvendas.model.EnumStatus;
import br.com.aluizio.sysvendas.model.Orcamento;
import br.com.aluizio.sysvendas.model.Pagamento;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * Salva um orcamento relacionado com um cliente. 
 * Isto não efetiva uma venda.
 * @date 30/11/2018
 * @author Aluizio Monteiro 30 de nov de 2018
 */

@WebServlet("/salvaOrcamento")
public class SalvaOrcamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession sessaoCliente, usuarioLogado, sessionProdutos;

	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		
		// Pega Usuário
		usuarioLogado = request.getSession(false);
		Usuario usuario = (Usuario) usuarioLogado.getAttribute("usuarioLogado");

		// Pega Cliente
		sessaoCliente = request.getSession(false);
		Cliente cliente = (Cliente) sessaoCliente.getAttribute("sessaoCliente");

		// Popula Orçamento
		Orcamento orcamento = new Orcamento();
		orcamento.setUsuario(usuario);
		orcamento.setCliente(cliente);
		
		BigDecimal totalOrcamento = new BigDecimal(request.getParameter("totalOrcamento"));
		orcamento.setTotal(totalOrcamento);
		
		BigDecimal desconto = new BigDecimal("00.00");
		orcamento.setTotal(desconto);
		
		//Pega os produtos do carrinho
		sessionProdutos = request.getSession(false);
		ArrayList<Carrinho> list = (ArrayList<Carrinho>) sessionProdutos.getAttribute("carroCompras");
		
		//Manda Orçamento para o banco
		OrcamentoDao dao = new OrcamentoDao();
		dao.salvaOrcamento(orcamento);
		dao.salvaCarrinho(list);
		
		int fkOrcamento = dao.buscaMaiorId();
		int parcelas = Integer.parseInt(request.getParameter("parcela"));
		
		//Parte do pagamento
		System.out.println("- Parcelas: "+parcelas);
		
		
		System.out.println("- FK Orcamento: "+ fkOrcamento);
		List<Pagamento> pagamentoList = new ArrayList<>();
		
		for(int i=1;i<=parcelas;i++) {
			
			BigDecimal parcelaValor = new BigDecimal(request.getParameter("parcelaValor["+i+"]"));
			
			LocalDate parcelaData = LocalDate.parse(request.getParameter("parcelaData["+i+"]"));
			EnumStatus status = EnumStatus.valueOf("A_PAGAR");
			
			Pagamento pagamento = new Pagamento();
			pagamento.setValorParcela(parcelaValor);
			pagamento.setNumParcela(i);
			pagamento.setFkOrcamento(fkOrcamento);
			pagamento.setParcelaData(parcelaData);
			pagamento.setStatus(status);
			System.out.println(pagamento);
			
			pagamentoList.add(pagamento);
			
			
		}
		
		new PagamentoDao().inserir(pagamentoList);
		
		JOptionPane.showMessageDialog(null, "Registrado com Sucesso!");

	}
}
