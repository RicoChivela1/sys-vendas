package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Orcamento;

/**
 * OrcamentoDao.java
 * @author Aluizio Monteiro
 * 22 de ago de 2018
 */

public class OrcamentoDao {
	private Connection connection;

	public OrcamentoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	//Adicionar
	public void adicionar(Orcamento orcamento) {
		String sql = "Insert into Orcamentos (subTotal, descontos,"
				+ " total, dataLancamento, confirmado, fk_cliente, fk_usuario)"
				+ " values (?,?,?,?,?,?,?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, orcamento.getSubTotal());
			stmt.setInt(2, orcamento.getDesconto());
			stmt.setInt(3, orcamento.getTotal());
			
			stmt.setDate(4, new Date(orcamento.getDataLancamento().getTimeInMillis()));
			stmt.setBoolean(5, orcamento.isConfirmado());
			
			stmt.setInt(6, orcamento.getCliente().getId());
			stmt.setInt(7, orcamento.getUsuario().getId());
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	//Alterar
	public void alterar(Orcamento orcamento) {
		String sql = "Update Orcamentos set subTotal=?, descontos=?,"
				+ " total=?, dataLancamento=?, confirmado=?,"
				+ " fk_cliente=?, fk_usuario=? where id=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, orcamento.getSubTotal());
			stmt.setInt(2, orcamento.getDesconto());
			stmt.setInt(3, orcamento.getTotal());
			
			stmt.setDate(4, new Date(orcamento.getDataLancamento().getTimeInMillis()));
			stmt.setBoolean(5, orcamento.isConfirmado());
			
			stmt.setInt(6, orcamento.getCliente().getId());
			stmt.setInt(7, orcamento.getUsuario().getId());
			stmt.setInt(8, orcamento.getId());
			
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	
	
	
}
