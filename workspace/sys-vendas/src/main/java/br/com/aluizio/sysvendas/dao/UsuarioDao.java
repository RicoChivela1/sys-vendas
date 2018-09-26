package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * @author Aluizio Monteiro
 * 
 */

public class UsuarioDao implements IDAO {
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

	// Busca Usuario por login e senha
	public Usuario buscaUsuario(Usuario usuarioBuscado) {
		String sql = "Select * from Usuarios where login=? and senha=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuarioBuscado.getLogin());
			stmt.setString(2, usuarioBuscado.getSenha());

			ResultSet rs = stmt.executeQuery();
			Usuario usuario = new Usuario();

			while (rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
			}

			return usuario;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Se usuario existe
	public boolean isUsuario(Usuario usuario) {
		String sql = "Select * from Usuarios where login=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getLogin());

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void adicionaAltera(Object object) {
		Usuario usuario = (Usuario) object;
		String sql = "";

		if (usuario.getId() == null) {
			sql = "Insert into Usuarios (nome, login, senha) " + " values (?,?,?)";
		} else {
			sql = "Update Usuarios set nome=?, login=?, senha=? " + " where id=" + usuario.getId();
		}

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void remover(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object buscaPorId(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getList() {
		List<Object> lista = new ArrayList<>();
		String sql = "Select * from Usuarios";
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				lista.add(usuario);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

	// Busca por nome
	public List<Usuario> buscaPorNome(Usuario u) {

		List<Usuario> usuarios = new ArrayList<>();
		if (!existUsuario(u)) {
			System.out.println("Usuario não existe.");
		} else {
			String sql = "select * from Usuarios where nome like ?";

			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				String termo = "%" + u.getNome() + "%";
				stmt.setString(1, termo);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setLogin(rs.getString("login"));
					usuario.setSenha(rs.getString("senha"));

					usuarios.add(usuario);
				}

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return usuarios;
	}

	// Verifica se Produto existe

	public boolean existUsuario(Usuario usuario) {
		String sql = "select * from Usuarios where nome like ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			String termo = "%" + usuario.getNome() + "%";
			stmt.setString(1, termo);
			ResultSet rs = stmt.executeQuery();
			if (!rs.next()) {
				System.out.println("não existe");
				return false;

			} else {
				System.out.println("existe sim");
				return true;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
