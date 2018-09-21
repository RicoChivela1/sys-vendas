package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Estoque;
import br.com.aluizio.sysvendas.model.Produto;

public class ProdutoDao {
	Connection connection;

	
	public ProdutoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Listar Todos Produto
	public List<Produto> getList() {
		String sql = "select * from Produtos";
		List<Produto> produtos = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				Estoque estoque = new Estoque();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setIndicacao(rs.getString("indicacao"));
				produto.setVolume(rs.getString("volume"));
				produto.setCustoUnid(rs.getInt("custoUnid"));
				produto.setSugestaoVenda(rs.getInt("sugestaoVenda"));
				produto.setImagem(rs.getString("imagem"));
				estoque.setId(rs.getInt("fk_categoria"));
				produto.setEstoque(estoque);

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

	
	
	
	// Adicionar Produto
	public void adicionar(Produto produto) {
		String sql = "insert into Produtos (nome, descricao, indicacao, "
				+ "volume, custoUnid, sugestaoVenda, fk_categoria, fk_estoque, imagem)"
				+ " values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());
			stmt.setString(3, produto.getIndicacao());
			stmt.setString(4, produto.getVolume());
			stmt.setInt(5, produto.getCustoUnid());
			stmt.setInt(6, produto.getSugestaoVenda());
			stmt.setInt(7, produto.getCategoria().getId());
			stmt.setInt(8, produto.getEstoque().getId());
			stmt.setString(9, produto.getImagem());
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Atualizar Produto
	public void atualizar(Produto produto) {
		String sql = "update Produtos set nome=?, descricao=?, indicacao=?, "
				+ "volume=?, custoUnid=?, sugestaoVenda=?, imagem=? where id=?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());
			stmt.setString(3, produto.getIndicacao());
			stmt.setString(4, produto.getVolume());
			stmt.setInt(5, produto.getCustoUnid());
			stmt.setInt(6, produto.getSugestaoVenda());
			stmt.setInt(7, produto.getId());
			stmt.setString(8, produto.getImagem());
	
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Busca por nome
	public List<Produto> buscaProdutoPorNome(Produto p) {

		List<Produto> produtos = new ArrayList<>();
		if (!existProduto(p)) {
			System.out.println("Produto não existe.");
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
					produto.setCustoUnid(rs.getInt("custoUnid"));
					produto.setSugestaoVenda(rs.getInt("sugestaoVenda"));
					produto.setImagem(rs.getString("imagem"));
					
					Estoque estoque = new Estoque();
					estoque.setQtdEntrada(rs.getInt("qtdEntrada"));
					estoque.setQtdSaida(rs.getInt("qtdSaida"));
					estoque.setQtdMinima(rs.getInt("qtdMinima"));

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

	//Busca maxId
	public int buscaMaiorId() {
		String sql = "Select max(id) from Produtos";
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
	
	// Busca Imagem
	   public String recuperaImagem(int id){
	        
	        String sql = "select imagem from Produtos where id=?";
	        
	        try (PreparedStatement stmt = connection.prepareStatement(sql)){ 
	        	stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();
	            if(rs.next()) {
	            	return rs.getString("imagem");
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
			return null;
	       
	    }
}
