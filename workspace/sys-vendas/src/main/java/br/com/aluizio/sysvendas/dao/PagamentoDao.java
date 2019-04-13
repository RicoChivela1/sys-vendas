package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.EnumStatus;
import br.com.aluizio.sysvendas.model.Orcamento;
import br.com.aluizio.sysvendas.model.Pagamentos;

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
	public void inserir(List<Pagamentos> list) {

		String sql = "Insert into Pagamentos (fk_orcamento,  numParcela,"
				+ " valorParcela, parcelaData,  status) values (?,?,?,?,?) ";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			for (Pagamentos pagamento : list) {
				stmt.setInt(1, pagamento.getFkOrcamento());
				stmt.setInt(2, pagamento.getNumParcela());
				stmt.setBigDecimal(3, pagamento.getValorParcela());

				stmt.setDate(4, java.sql.Date.valueOf(pagamento.getParcelaData()));
				stmt.setString(5, pagamento.getStatus().name());

				stmt.execute();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Altera
	public void alterar(Pagamentos pagamento) {

		String sql = "Update Pagamentos set valorParcela=?, numParcela=?,"
				+ " valorParcela=?, parcelaData=?, status=?, fk_orcamento=? where id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setBigDecimal(1, pagamento.getValorParcela());
			stmt.setInt(2, pagamento.getNumParcela());
			stmt.setBigDecimal(3, pagamento.getValorParcela());
			stmt.setDate(4, java.sql.Date.valueOf(pagamento.getParcelaData()));

			stmt.setString(5, pagamento.getStatus().name());

			stmt.setInt(6, pagamento.getId());
			stmt.setInt(7, pagamento.getFkOrcamento());

			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Busca pagamento por Orcamento
	public List<Pagamentos> buscaPgPorOrcamento(Orcamento orcamento) {
		List<Pagamentos> lista = new ArrayList<>();
		String sql = "select * from Pagamentos where fk_orcamento = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			Integer termo = orcamento.getId();
			stmt.setInt(1, termo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Pagamentos pagamento = new Pagamentos();
				pagamento.setId(rs.getInt("id"));
				pagamento.setNumParcela(rs.getInt("numParcela"));
				pagamento.setValorParcela(rs.getBigDecimal("valorParcela"));
				pagamento.setParcelaData(rs.getDate("parcelaData").toLocalDate());
				pagamento.setFkOrcamento(rs.getInt("fk_orcamento"));

				pagamento.setStatus(EnumStatus.valueOf(rs.getString("status")));

				lista.add(pagamento);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

	// Paga parcelas
	public Orcamento pagarParcela(List<Pagamentos> list) {

		String sql = "Update Pagamentos set status=?" + " where id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			int idOrcamento = 0;
			for (Pagamentos pagamento : list) {
				stmt.setString(1, pagamento.getStatus().name());
				stmt.setInt(2, pagamento.getId());
				stmt.execute();

				idOrcamento = pagamento.getFkOrcamento();
			}

			Orcamento orc = new Orcamento();
			orc.setId(idOrcamento);
			OrcamentoDao dao = new OrcamentoDao();
			Orcamento orcamento = dao.buscaOrcamentoPorId(orc);

			return orcamento;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
