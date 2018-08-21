package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Estoque;

public class EstoqueDao {

	Connection connection;
	
	public EstoqueDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	//Busca Estoque por Id
	public Estoque buscaEstoqueId(Estoque estoqueBuscado) {
		String sql = "select * from Estoques "
				+ "where id = ?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, estoqueBuscado.getId());
			ResultSet rs = stmt.executeQuery();
			Estoque estoque = new Estoque();
			while(rs.next()) {
				
				estoque.setQtdEntrada(rs.getInt("qtdEntrada"));
				estoque.setQtdSaida(rs.getInt("qtdSaida"));
				estoque.setQtdMinima(rs.getInt("qtdMinima"));
				
			}
			return estoque;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
				
	}
	
	//Alterar estoque
	public void alterar(Estoque estoque) {
		String sql = "Update Estoques set qtdEntrada=?, qtdSaida=?, qtdMinima=?"
				+ " where id=?";
				
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, estoque.getQtdEntrada());
			stmt.setInt(2, estoque.getQtdSaida());
			stmt.setInt(3, estoque.getQtdMinima());
			stmt.setInt(4, estoque.getId());
			
			System.out.println("Estoque alterado com sucesso");
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	
}
