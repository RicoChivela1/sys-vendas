package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Categoria;
import br.com.aluizio.sysvendas.model.Produto;

/**
 * CategoriaDao.java
 * 
 * @author Aluizio Monteiro 20 de ago de 2018
 */

public class CategoriaDao implements IDAO {
	Connection connection;

	public CategoriaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	@Override
	public void adicionaAltera(Object object) {
		String sql = "";
		Categoria categoria = (Categoria) object;

		if (categoria.getId() == null) {
			sql = "Insert into Categorias (nome) value (?)";
		} else {
			sql = "update Categorias set nome=? where id=" + categoria.getId();
		}

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, categoria.getNome());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Busca Categoria pelo id do produto
	@Override
	public Object buscaPorId(Object object) {
		Produto produto = (Produto) object;
		Categoria categoria = new Categoria();
		String sql = "select * from Categorias join Produtos "
				+ " on Categorias.id = Produtos.fk_categoria where Produtos.id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, produto.getId());
			System.out.println("Id do Produto: " + produto.getId());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				categoria.setId(rs.getInt("id"));
				categoria.setNome(rs.getString("nome"));
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return categoria;
	}

	// Busca por nome
	@Override
	public List<Object> buscaPorNome(Object object) {
		Categoria c = (Categoria) object;
		List<Object> lista = new ArrayList<>();

		if (!existCategoria(c)) {
			System.out.println("Categoria n�o existe");

		} else {
			String sql = "select * from Categorias where nome like ?";

			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				String termo = "%" + c.getNome() + "%";
				stmt.setString(1, termo);

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Categoria categoria = new Categoria();
					categoria.setId(rs.getInt("id"));
					categoria.setNome(rs.getString("nome"));

					lista.add(categoria);
				}

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return lista;
	}

	// Verifica se Cliente existe
	public boolean existCategoria(Categoria categoria) {
		String sql = "select * from Categorias where nome like ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			String termo = "%" + categoria.getNome() + "%";
			stmt.setString(1, termo);
			ResultSet rs = stmt.executeQuery();

			if (!rs.next()) {
				System.out.println("Categoria n�o existe");
				return false;
			} else {
				System.out.println("Categoria existe");
				return true;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Remove Categoria
	@Override
	public void remover(Object object) {
		Categoria categoria = (Categoria) object;
		String sql = "Delete from Categorias where id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, categoria.getId());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Lista Categorias
	@Override
	public List<Object> getList() {
		String sql = "select * from Categorias";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			List<Object> list = new ArrayList<>();

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

}
