package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.dao.EnderecoClienteDao;
import br.com.aluizio.sysvendas.dao.EnderecoDao;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.Endereco;
import br.com.aluizio.sysvendas.model.EnderecoCliente;
import br.com.aluizio.sysvendas.model.EnumPessoa;
import br.com.aluizio.sysvendas.model.EnumSexo;
import br.com.aluizio.sysvendas.model.EnumSituacao;

/**
 * Servlet implementation class NovoCliente
 * @author Aluizio Monteiro
 * 24 de ago de 2018
 */

@WebServlet(urlPatterns="/novoCliente")
public class NovoCliente extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//Popula Cliente
		Cliente cliente = new Cliente();
		
		//Enum vs Radio
		EnumSituacao situacao = EnumSituacao.valueOf(req.getParameter("situacao"));
		EnumPessoa pessoa = EnumPessoa.valueOf(req.getParameter("pessoa"));
		EnumSexo sexo = EnumSexo.valueOf(req.getParameter("sexo"));
		
		cliente.setSituacao(situacao);
		cliente.setPessoa(pessoa);
		cliente.setSexo(sexo);
		
		cliente.setNome(req.getParameter("nome"));
		cliente.setSobreNome(req.getParameter("sobreNome"));
		
		//Data
		int dia = Integer.parseInt(req.getParameter("dia"));
		int mes = Integer.parseInt(req.getParameter("mes"));
		int ano = Integer.parseInt(req.getParameter("ano"));
		Calendar nascimento = new GregorianCalendar(ano, mes, dia);
		cliente.setNascimento(nascimento);
		
		cliente.setObservacao(req.getParameter("observacao"));
		cliente.setEmail(req.getParameter("email"));
		cliente.setCelular(req.getParameter("celular"));

		//Popula Endereço
		Endereco endereco = new Endereco();
		endereco.setEndereco(req.getParameter("endereco"));
		endereco.setBairro(req.getParameter("bairro"));
		endereco.setCidade(req.getParameter("cidade"));
		endereco.setComplemento(req.getParameter("complemento"));
		endereco.setNumero(req.getParameter("numero"));
		endereco.setUf(req.getParameter("uf"));
		endereco.setCep(req.getParameter("cep"));
		endereco.setFone(req.getParameter("fone"));
		endereco.setObservacao(req.getParameter("observacao"));
		
		//Salva Cliente e Endereço
		new EnderecoDao().adicionar(endereco);
		new ClienteDao().adicionar(cliente);
	
		//Relacionamento Cliente com Endereco
		EnderecoCliente enderecoCliente = new EnderecoCliente();
		enderecoCliente.setIdCliente(new ClienteDao().buscaMaiorId()); 
		enderecoCliente.setIdEndereco(new EnderecoDao().buscaMaiorId());
		
		new EnderecoClienteDao().relacionar(enderecoCliente);
		
		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
		
		req.getRequestDispatcher("/index.html").forward(req, resp);
	}
}
