package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.EnumPessoa;
import br.com.aluizio.sysvendas.model.EnumSexo;
import br.com.aluizio.sysvendas.model.EnumSituacao;
import br.com.aluizio.sysvendas.service.CarregarDashboard;

/**
 * Servlet implementation class NovoCliente
 * 
 * @author Aluizio Monteiro 21 de set de 2018
 */

@WebServlet({"/adicionar-clientes.jsp", "/alterar-clientes.jsp"})
public class AdicionaAlteraCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String message = "";

		// Cria cliente
		Cliente cliente = new Cliente();

		// Verifica se adiciona ou atualiza
		if (req.getParameter("clienteId") != null) {// atualiza
			int id = Integer.parseInt(req.getParameter("clienteId"));
			cliente.setId(id);
			message = "Cliente atualizado com sucesso.";
		} else {
			message = "Cliente adicionado com sucesso.";
		}

		// Enum vs Radio
		EnumSituacao situacao = EnumSituacao.valueOf(req.getParameter("situacao"));
		EnumPessoa pessoa = EnumPessoa.valueOf(req.getParameter("pessoa"));
		EnumSexo sexo = EnumSexo.valueOf(req.getParameter("sexo"));

		cliente.setSituacao(situacao);
		cliente.setPessoa(pessoa);
		cliente.setSexo(sexo);

		cliente.setNome(req.getParameter("nome"));
		cliente.setSobreNome(req.getParameter("sobreNome"));

		// Data
		LocalDate nascimento = LocalDate.parse(req.getParameter("nascimento"));
		cliente.setNascimento(nascimento);

		cliente.setEmail(req.getParameter("email"));
		cliente.setCelular(req.getParameter("celular"));

		cliente.setEndereco(req.getParameter("endereco"));
		cliente.setBairro(req.getParameter("bairro"));
		cliente.setCidade(req.getParameter("cidade"));
		cliente.setComplemento(req.getParameter("complemento"));
		cliente.setNumero(req.getParameter("numero"));
		cliente.setUf(req.getParameter("uf"));
		cliente.setCep(req.getParameter("cep"));
		cliente.setFone(req.getParameter("fone"));
		cliente.setObservacao(req.getParameter("observacao"));

		// Salva Cliente
		new ClienteDao().adicionaAltera(cliente);

		JOptionPane.showMessageDialog(null, message);
		System.out.println(message);

		// Carrega a index.jsp
		CarregarDashboard.carregarDashboard(req, resp);
	}
}
