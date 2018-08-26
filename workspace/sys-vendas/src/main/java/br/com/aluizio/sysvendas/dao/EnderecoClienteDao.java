package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.EnderecoCliente;

/**
 * EnderecoClienteDao.java
 * @author Aluizio Monteiro
 * 26 de ago de 2018
 */

public class EnderecoClienteDao {

	private Connection connection;

	public EnderecoClienteDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Salva relacionamento
	public void relacionar(EnderecoCliente enderecoCliente) {
		String sql = "Insert into Enderecos_Clientes (fk_endereco, fk_cliente) "
				+ " values (?, ?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, enderecoCliente.getIdEndereco());
			stmt.setInt(2, enderecoCliente.getIdCliente());
			stmt.execute();
			System.out.println("Relacionamento Salvo");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	
}
