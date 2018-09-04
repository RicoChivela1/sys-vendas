package br.com.aluizio.sysvendas.web;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aluizio.sysvendas.dao.ClienteDao;
import br.com.aluizio.sysvendas.dao.EnderecoDao;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.Endereco;
import br.com.aluizio.sysvendas.model.EnumPessoa;
import br.com.aluizio.sysvendas.model.EnumSexo;
import br.com.aluizio.sysvendas.model.EnumSituacao;

/**
 * Servlet implementation class AlterarCliente
 */
@WebServlet("/alterarCliente")
public class AlterarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	//Update Cliente
    	if(req.getParameter("clienteId") != null) {
    		int id = Integer.parseInt(req.getParameter("clienteId"));
    		System.out.println("ID D CLIENTE: "+id);
        		
    		//Popula Cliente
    		Cliente cliente = new Cliente();
    		cliente.setId(id);
    		
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
    		
    		//Altera
    		new ClienteDao().alterar(cliente);
    	}
    	
    	//Update Endereco
    	if(req.getParameter("enderecoId") != null) {
    		int id = Integer.parseInt(req.getParameter("enderecoId"));
    		//Popula Endereço
    		Endereco endereco = new Endereco();
    		endereco.setId(id);
    		endereco.setEndereco(req.getParameter("endereco"));
    		endereco.setBairro(req.getParameter("bairro"));
    		endereco.setCidade(req.getParameter("cidade"));
    		endereco.setComplemento(req.getParameter("complemento"));
    		endereco.setNumero(req.getParameter("numero"));
    		endereco.setUf(req.getParameter("uf"));
    		endereco.setCep(req.getParameter("cep"));
    		endereco.setFone(req.getParameter("fone"));
    		endereco.setObservacao(req.getParameter("observacao"));
    		
    		//Altera
    		new EnderecoDao().alterar(endereco);
    	}
    	
    	//JOptionPane.showMessageDialog(null, "Dados alterados com sucesso.");
    	RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
    	rd.forward(req, resp);
		
	}

}
