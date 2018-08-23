package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Pagamento;

/**
 * PagamentoDao.java
 * 
 * @author Aluizio Monteiro 
 * @Date 23 de ago de 2018
 */

public class PagamentoDao {

	private Connection connection;

	public PagamentoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Inserir
	public void inserir(Pagamento pagamento) {

		String sql = "Insert into Pagamentos (valorTotal, qtdParcelas," + " valorParcela, diaVencimento, parcelasPagas,"
				+ " status) values (?,?,?,?,?,?) ";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, pagamento.getValorTotal());
			stmt.setInt(2, pagamento.getQtdParcelas());
			stmt.setInt(3, pagamento.getValorParcela());
			stmt.setInt(4, pagamento.getDiaVencimento());
			stmt.setInt(5, pagamento.getParcelasPagas());
			stmt.setString(6, pagamento.getStatus().name());

			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Altera
	public void alterar(Pagamento pagamento) {

		String sql = "Update Pagamentos set valorTotal=?, qtdParcelas=?,"
				+ " valorParcela=?, diaVencimento=?, parcelasPagas=?, status=? where id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, pagamento.getValorTotal());
			stmt.setInt(2, pagamento.getQtdParcelas());
			stmt.setInt(3, pagamento.getValorParcela());
			stmt.setInt(4, pagamento.getDiaVencimento());
			stmt.setInt(5, pagamento.getParcelasPagas());
			stmt.setString(6, pagamento.getStatus().name());

			stmt.setInt(7, pagamento.getId());

			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
