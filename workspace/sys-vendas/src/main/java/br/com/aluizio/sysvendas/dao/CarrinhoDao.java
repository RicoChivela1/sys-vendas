package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Carrinho;
import br.com.aluizio.sysvendas.model.Orcamento;

/**
 * CarrinhoDao.java
 * 
 * @author Aluizio Monteiro 11 de mar de 2019
 */

public class CarrinhoDao {
	private Connection connection;

	public CarrinhoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Lista de carrinho
	public List<Carrinho> getCarrinhos(Orcamento orcamento) {

		String sql = "select * from carrinho where fk_orcamento = " + orcamento.getId();
		List<Carrinho> list = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Carrinho carrinho = new Carrinho();
				carrinho.setProdutoId(rs.getInt("produtoId"));
				carrinho.setOrcamentoId(rs.getInt("fk_orcamento"));
				carrinho.setProdutoNome(rs.getString("produtoNome"));
				carrinho.setQtd(rs.getInt("qtd"));
				carrinho.setSubTotal(rs.getBigDecimal("subTotal"));
				carrinho.setValorUnid(rs.getBigDecimal("valorUnid"));
				list.add(carrinho);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

}
