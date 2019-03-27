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
import br.com.aluizio.sysvendas.model.EnumStatus;
import br.com.aluizio.sysvendas.model.Orcamento;
import br.com.aluizio.sysvendas.model.Pagamento;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * Salva um orcamento relacionado com um cliente. 
 * Isto n�o efetiva uma venda.
 * @date 30/11/2018
 * @author Aluizio Monteiro 30 de nov de 2018
 */

@WebServlet("/salvaOrcamento")
public class SalvaOrcamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession sessaoCliente, usuarioLogado, sessionProdutos;

	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		
		// Pega Usu�rio
		usuarioLogado = request.getSession(false);
		Usuario usuario = (Usuario) usuarioLogado.getAttribute("usuarioLogado");

		// Pega Cliente
		sessaoCliente = request.getSession(false);
		Cliente cliente = (Cliente) sessaoCliente.getAttribute("sessaoCliente");

		// Popula Or�amento
		Orcamento orcamento = new Orcamento();
		orcamento.setUsuario(usuario);
		orcamento.setCliente(cliente);

		///////////////////////////////////////
		
		
		int totalParcelas = Integer.parseInt(request.getParameter("totalParcelas")); 					
		
									
		///////////////////////////////////////
		
		String sTotalOrcamento = request.getParameter("totalOrcamento");
		String sSubTotalOrcamento = request.getParameter("subTotalOrcamento");
		String sDescontos = request.getParameter("descontos");
		
		
		
		
		
		
		BigDecimal totalOrcamento = new BigDecimal(sTotalOrcamento);
		
		orcamento.setTotalOrcamento(totalOrcamento);
		
		BigDecimal subTotalOrcamento = new BigDecimal(sSubTotalOrcamento);
		orcamento.setSubTotalOrcamento(subTotalOrcamento);
		
		BigDecimal descontos = new BigDecimal(sDescontos);
		orcamento.setDescontos(descontos);
		
		//Seta a dataLancamento de agora
		LocalDate dataLancamento = LocalDate.now();
		orcamento.setDataLancamento(dataLancamento);
		
		OrcamentoDao dao = new OrcamentoDao();
		int fkOrcamento = (dao.buscaMaiorId()+1);
		
		//Pega os produtos do carrinho
		sessionProdutos = request.getSession(false);
		ArrayList<Carrinho> list = (ArrayList<Carrinho>) sessionProdutos.getAttribute("carroCompras");
	
		List<Pagamento> pagamentoList = new ArrayList<>();

		
		
		
		
		for(int i=1;i<=totalParcelas;i++) {
			
			BigDecimal parcelaValor = new BigDecimal(request.getParameter("parcelaValor["+i+"]"));
			
			LocalDate parcelaData = LocalDate.parse(request.getParameter("parcelaData["+i+"]"));
	
			EnumStatus status = EnumStatus.valueOf(request.getParameter("checkBoxPagar["+i+"]"));

			Pagamento pagamento = new Pagamento();
			pagamento.setValorParcela(parcelaValor);
			pagamento.setNumParcela(i);
			pagamento.setFkOrcamento(fkOrcamento);
			pagamento.setParcelaData(parcelaData);
			pagamento.setStatus(status);
			System.out.println(pagamento);
			
			pagamentoList.add(pagamento);
		
			System.out.println("A parcela foi paga? " +status);
			
			
		}
		
		//orcamento.setParcelasPagas(parcelasPagas);
		int parcelasPagas = 0; 
		orcamento.setParcelasPagas(parcelasPagas);
		orcamento.setTotalParcelas(totalParcelas);
		
		//Manda Or�amento para o banco
				
				dao.salvaOrcamento(orcamento);
				dao.salvaCarrinho(list);
								
				//Parte do pagamento
				System.out.println("- Parcelas: "+totalParcelas);
		
				
				
				
				
				
				
				
				
				
		//////////////////////////////////
		new PagamentoDao().inserir(pagamentoList);
		
		JOptionPane.showMessageDialog(null, "Registrado com Sucesso!");

	}
}
