package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Endereco;

/**
 * EnderecoDao.java
 * @author Aluizio Monteiro 25 de ago de 2018
 */

public class EnderecoDao {
	private Connection connection;

	public EnderecoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Adicionar Endereço
	public void adicionar(Endereco endereco) {
		String sql = "Insert into Enderecos (endereco, bairro, cidade, "
				+ "complemento, numero, uf, cep, fone, observacao) " + " values(?,?,?,?,?,?,?,?,?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, endereco.getEndereco());
			stmt.setString(2, endereco.getBairro());
			stmt.setString(3, endereco.getCidade());
			stmt.setString(4, endereco.getComplemento());
			stmt.setString(5, endereco.getNumero());
			stmt.setString(6, endereco.getUf());
			stmt.setString(7, endereco.getCep());
			stmt.setString(8, endereco.getFone());
			stmt.setString(9, endereco.getObservacao());
			
			stmt.execute();
			System.out.println("Endereço adicionado com sucesso");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Busca o ultimo Id
	public int buscaMaiorId(){
		String sql = "Select MAX(id) from Enderecos";
		int id = 0;
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				id = rs.getInt(1);
			}
		} 

		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return id;
	}
	
	//Alterar
	public void alterar(Endereco endereco) {
		String sql = "Update Enderecos set endereco=?, bairro=?, cidade=?, "
				+ "complemento=?, numero=?, uf=?, cep=?, fone=?, observacao=? "
				+ "where id=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			
			stmt.setString(1, endereco.getEndereco());
			stmt.setString(2, endereco.getBairro());
			stmt.setString(3, endereco.getCidade());
			stmt.setString(4, endereco.getComplemento());
			stmt.setString(5, endereco.getNumero());
			stmt.setString(6, endereco.getUf());
			stmt.setString(7, endereco.getCep());
			stmt.setString(8, endereco.getFone());
			stmt.setString(9, endereco.getObservacao());
			stmt.setInt(10, endereco.getId());
			
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
