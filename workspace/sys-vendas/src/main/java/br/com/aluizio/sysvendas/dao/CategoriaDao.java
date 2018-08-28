package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Categoria;

/**
 * CategoriaDao.java
 * 
 * @author Aluizio Monteiro 20 de ago de 2018
 */

public class CategoriaDao {
	Connection connection;

	public CategoriaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionar(Categoria categoria) {
		String sql = "Insert into Categorias (nome) value (?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, categoria.getNome());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}

	public void alterar(Categoria categoria) {
		String sql = "update Categorias set nome=? where id=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, categoria.getNome());
			stmt.setInt(2, categoria.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void excluir(Categoria categoria) {
		String sql = "Delete from Categorias where id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, categoria.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Categoria> getList() {
		String sql = "select * from Categorias";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			List<Categoria> list = new ArrayList<>();
			
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id"));
				categoria.setNome(rs.getString("nome"));
				list.add(categoria);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public int buscaMaiorId() {
		String sql = "select max(id) from Categorias";
		int id = 0;
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				id = rs.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	

}
