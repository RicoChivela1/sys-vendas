package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Categoria;
import br.com.aluizio.sysvendas.model.Estoque;
import br.com.aluizio.sysvendas.model.Produto;

public class ProdutoDao implements IDAO {
	Connection connection;

	public ProdutoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Listar Todos Produto
	@Override
	public List<Object> getList() {
		String sql = "select * from Produtos";
		List<Object> produtos = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				Estoque estoque = new Estoque();
				Categoria categoria = new Categoria();

				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setIndicacao(rs.getString("indicacao"));
				produto.setVolume(rs.getString("volume"));
				produto.setCustoUnid(rs.getBigDecimal("custoUnid"));
				produto.setSugestaoVenda(rs.getBigDecimal("sugestaoVenda"));
				produto.setPercentual(rs.getDouble("percentual"));
				produto.setLucro(rs.getBigDecimal("lucro"));
				produto.setImagem(rs.getString("imagem"));
				estoque.setId(rs.getInt("fk_estoque"));
				categoria.setId(rs.getInt("fk_categoria"));

				produtos.add(produto);
			}
			return produtos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Verifica se Produto existe

	public boolean existProduto(Produto produto) {
		String sql = "select * from Produtos where Produtos.nome like ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			String termo = "%" + produto.getNome() + "%";
			stmt.setString(1, termo);
			ResultSet rs = stmt.executeQuery();
			if (!rs.next()) {
				System.out.println("n�o existe");
				return false;

			} else {
				System.out.println("existe sim");
				return true;

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Adicionar e Alterar Produto
	@Override
	public void adicionaAltera(Object object) {
		Produto produto = (Produto) object;
		String sql = "";

		if (produto.getId() == null) {
			sql = "insert into Produtos (nome, descricao, indicacao, volume, "
					+ " custoUnid, sugestaoVenda, fk_categoria, fk_estoque, "
					+ " lucro, percentual, imagem)"
					+ " values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		} else {
			sql = "update Produtos set nome=?, descricao=?, indicacao=?, "
					+ " volume=?, custoUnid=?, sugestaoVenda=?, fk_categoria=?, " + " fk_estoque=?, imagem=? "
					+ " where id=" + produto.getId();
		}

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());
			stmt.setString(3, produto.getIndicacao());
			stmt.setString(4, produto.getVolume());
			stmt.setBigDecimal(5, produto.getCustoUnid());
			stmt.setBigDecimal(6, produto.getSugestaoVenda());
			stmt.setInt(7, produto.getCategoria().getId());
			stmt.setInt(8, produto.getEstoque().getId());
			stmt.setBigDecimal(9, produto.getLucro());
			stmt.setDouble(10, produto.getPercentual());
			stmt.setString(11, produto.getImagem());
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Remove Produto
	@Override
	public void remover(Object object) {
		Produto produto = (Produto) object;
		String sql = "Delete from Produtos where id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, produto.getId());
			stmt.execute();
			System.out.println("Produto removido");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	// Busca Produto por id
	@Override
	public Object buscaPorId(Object object) {
		Produto produtoBuscado = (Produto) object;
		Produto produto = new Produto();
		String sql = "select * from Produtos join Estoques "
				+ " on Estoques.id = Produtos.fk_estoque where Produtos.id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, produtoBuscado.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Estoque estoque = new Estoque();
				Categoria categoria = new Categoria();

				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setIndicacao(rs.getString("indicacao"));
				produto.setVolume(rs.getString("volume"));
				produto.setCustoUnid(rs.getBigDecimal("custoUnid"));
				produto.setSugestaoVenda(rs.getBigDecimal("sugestaoVenda"));
				produto.setPercentual(rs.getDouble("percentual"));
				produto.setLucro(rs.getBigDecimal("lucro"));
				produto.setImagem(rs.getString("imagem"));

				estoque.setId(rs.getInt("fk_estoque"));
				estoque.setQtdEntrada(rs.getInt("qtdEntrada"));
				estoque.setQtdSaida(rs.getInt("qtdSaida"));
				estoque.setQtdMinima(rs.getInt("qtdMinima"));
				estoque.setQtdDisponivel(rs.getInt("qtdDisponivel"));

				categoria.setId(rs.getInt("fk_categoria"));
				categoria.setNome(rs.getString("nome"));

				produto.setEstoque(estoque);
				produto.setCategoria(categoria);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return produto;
	}

	// Busca Imagem separadamente baseado no id do produto
	public String recuperaImagem(int id) {

		String sql = "select imagem from Produtos where id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getString("imagem");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	// Busca Produto por nome
	@Override
	public List<Object> buscaPorNome(Object object) {
		Produto p = (Produto) object;
		List<Object> produtos = new ArrayList<>();
		if (!existProduto(p)) {
			System.out.println("Produto n�o existe.");
		} else {
			String sql = "select Produtos.*, Estoques.* from Produtos "
					+ "join Estoques on Produtos.fk_estoque = Estoques.id " + "where Produtos.nome like ?";

			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				String termo = "%" + p.getNome() + "%";
				stmt.setString(1, termo);
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Produto produto = new Produto();
					produto.setId(rs.getInt("id"));
					produto.setNome(rs.getString("nome"));
					produto.setDescricao(rs.getString("descricao"));
					produto.setIndicacao(rs.getString("indicacao"));
					produto.setVolume(rs.getString("volume"));
					produto.setCustoUnid(rs.getBigDecimal("custoUnid"));
					produto.setPercentual(rs.getDouble("percentual"));
					produto.setLucro(rs.getBigDecimal("lucro"));
					produto.setSugestaoVenda(rs.getBigDecimal("sugestaoVenda"));
					produto.setImagem(rs.getString("imagem"));

					Estoque estoque = new Estoque();
					estoque.setQtdEntrada(rs.getInt("qtdEntrada"));
					estoque.setQtdSaida(rs.getInt("qtdSaida"));
					estoque.setQtdMinima(rs.getInt("qtdMinima"));
					estoque.setQtdDisponivel(rs.getInt("qtdDisponivel"));
					produto.setEstoque(estoque);

					produtos.add(produto);

				}
				return produtos;

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return produtos;
	}

	// Busca maxId
	public int buscaMaiorId() {
		String sql = "Select max(id) from Produtos";
		int id = 0;
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
