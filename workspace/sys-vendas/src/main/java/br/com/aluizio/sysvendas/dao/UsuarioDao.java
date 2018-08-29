package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * @author Aluizio Monteiro
 * 
 */

public class UsuarioDao {
	Connection connection;

	public UsuarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Exclui Usuarios
	public void excluir(Usuario usuario) {
		String sql = "delete from Usuarios where id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, usuario.getId());
			stmt.execute();
			System.out.println("Usuário excluído.");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Alterar Usuario
	public void alterar(Usuario usuario) {
		String sql = "Update Usuarios set senha=? where id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getSenha());
			stmt.setInt(2, usuario.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	// Adicionar usuario
	public void adicionar(Usuario usuario) {
		String sql = "Insert into Usuarios (nome, login, senha) values (?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
