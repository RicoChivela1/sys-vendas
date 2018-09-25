package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.EnumPessoa;
import br.com.aluizio.sysvendas.model.Fornecedor;

/**
 * FornecedorDao.java
 * @author Aluizio Monteiro
 * 20 de ago de 2018
 */

public class FornecedorDao {

	Connection connection;

	public FornecedorDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	//Adicionar
	public void adicionar(Fornecedor fornecedor) {
		String sql = "Insert into Fornecedores (pessoa, nome, "
				+ "cnpjCpf, cep, endereco, bairro, cidade, complemento, "
				+ "uf, fone, email, observacao) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, fornecedor.getPessoa().name());
			stmt.setString(2, fornecedor.getNome());
			stmt.setString(3, fornecedor.getCnpjCpf());
			stmt.setString(4, fornecedor.getCep());
			stmt.setString(5, fornecedor.getEndereco());
			stmt.setString(6, fornecedor.getBairro());
			stmt.setString(7, fornecedor.getCidade());
			stmt.setString(8, fornecedor.getComplemento());
			stmt.setString(9, fornecedor.getUf());
			stmt.setString(10, fornecedor.getFone());
			stmt.setString(11, fornecedor.getEmail());
			stmt.setString(12, fornecedor.getObservacao());
			
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
  
	//Alterar
	public void alterar(Fornecedor fornecedor) {
		String sql = "Update Fornecedores set pessoa=?, nome=?, "
				+ "cnpjCpf=?, cep=?, endereco=?, bairro=?, cidade=?, complemento=?, "
				+ "uf=?, fone=?, email=?, observacao=? where id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, fornecedor.getPessoa().name());
			stmt.setString(2, fornecedor.getNome());
			stmt.setString(3, fornecedor.getCnpjCpf());
			stmt.setString(4, fornecedor.getCep());
			stmt.setString(5, fornecedor.getEndereco());
			stmt.setString(6, fornecedor.getBairro());
			stmt.setString(7, fornecedor.getCidade());
			stmt.setString(8, fornecedor.getComplemento());
			stmt.setString(9, fornecedor.getUf());
			stmt.setString(10, fornecedor.getFone());
			stmt.setString(11, fornecedor.getEmail());
			stmt.setString(12, fornecedor.getObservacao());
			
			stmt.setInt(13, fornecedor.getId());
			
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	//Remover
	public void remover(Fornecedor fornecedor) {
		String sql = "Delete from Fornecedores where id=? ";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, fornecedor.getId());
			stmt.execute();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	//Listar
	public List<Fornecedor> getList() {
		String sql = "Select * from Fornecedores";
		List<Fornecedor> lista = new ArrayList<>();
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setPessoa(EnumPessoa.valueOf(rs.getString("pessoa")));
				fornecedor.setId(rs.getInt("id"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setCnpjCpf(rs.getString("cnpjCpf"));
				fornecedor.setCep(rs.getString("cep"));
				fornecedor.setEndereco(rs.getString("endereco"));
				fornecedor.setBairro(rs.getString("bairro"));
				fornecedor.setCidade(rs.getString("cidade"));
				fornecedor.setComplemento(rs.getString("complemento"));
				fornecedor.setUf(rs.getString("uf"));
				fornecedor.setFone(rs.getString("fone"));
				fornecedor.setEmail(rs.getString("email"));
				fornecedor.setObservacao(rs.getString("observacao"));
				
				lista.add(fornecedor);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	// Busca Maior Id
		public int buscaMaiorId() {
			String sql = "Select max(id) from Fornecedores";
			int id = 0;
			try (PreparedStatement stmt = connection.prepareStatement(sql)){
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					id = rs.getInt(1);
				}
				return id;
				
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}
