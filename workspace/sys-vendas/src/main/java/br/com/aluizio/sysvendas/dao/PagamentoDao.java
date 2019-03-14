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
	public void inserir(List<Pagamento> list) {

		String sql = "Insert into Pagamentos (fk_orcamento,  numParcela," + 
		" valorParcela, parcelaData,  status) values (?,?,?,?,?) ";

		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			for(Pagamento pagamento : list) {
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
	public void alterar(Pagamento pagamento) {

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
		public List<Pagamento> buscaPgPorOrcamento(Orcamento orcamento) {
			List<Pagamento> lista = new ArrayList<>();
				String sql = "select * from Pagamentos where fk_orcamento = ?";

				try (PreparedStatement stmt = connection.prepareStatement(sql)) {
					Integer termo = orcamento.getId();
					stmt.setInt(1, termo);

					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {
						Pagamento pagamento = new Pagamento();
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


}
