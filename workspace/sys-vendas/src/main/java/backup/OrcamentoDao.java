package backup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Carrinho;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.EnumPessoa;
import br.com.aluizio.sysvendas.model.EnumSexo;
import br.com.aluizio.sysvendas.model.EnumSituacao;
import br.com.aluizio.sysvendas.model.Orcamento;
import br.com.aluizio.sysvendas.model.Pagamentos;
import br.com.aluizio.sysvendas.model.Usuario;
import br.com.aluizio.sysvendas.model.Vendas;

/**
 * OrcamentoDao.java
 * 
 * @author Aluizio Monteiro
 * @date 24 de nov de 2018
 */

public class OrcamentoDao {
	private Connection connection;

	public OrcamentoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Adicionar um Orcamento
	public void salvaOrcamento(Orcamento orcamento) {
		String sql = "Insert into Orcamentos (subTotalOrcamento, descontos, totalOrcamento, dataLancamento, fk_cliente, fk_usuario, totalParcelas, parcelasPagas) values (?,?,?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setBigDecimal(1, orcamento.getSubTotalOrcamento());

			stmt.setBigDecimal(2, orcamento.getDescontos());
			stmt.setBigDecimal(3, orcamento.getTotalOrcamento());

			stmt.setDate(4, java.sql.Date.valueOf(orcamento.getDataLancamento()));
			stmt.setInt(5, orcamento.getCliente().getId());
			stmt.setInt(6, orcamento.getUsuario().getId());

			stmt.setInt(7, orcamento.getTotalParcelas());
			stmt.setInt(8, orcamento.getParcelasPagas());

			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	// Alterar
	public void alterar(Orcamento orcamento) {
		String sql = "Update Orcamentos set descontos=?," + " totalOrcamento=?, dataLancamento=?,"
				+ " fk_cliente=?, fk_usuario=?, totalParcelas=?, parcelasPagas=? where id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setBigDecimal(1, orcamento.getDescontos());
			stmt.setBigDecimal(2, orcamento.getTotalOrcamento());
			stmt.setDate(3, java.sql.Date.valueOf(orcamento.getDataLancamento()));

			stmt.setInt(4, orcamento.getCliente().getId());
			stmt.setInt(5, orcamento.getUsuario().getId());

			stmt.setInt(6, orcamento.getTotalParcelas());
			stmt.setInt(7, orcamento.getParcelasPagas());

			stmt.setInt(8, orcamento.getId());

			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Busca maior id dos orçamentos
	public int buscaMaiorId() {
		String sql = "Select max(id) from Orcamentos";
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

	// Salva carrinho de compras
	public void salvaCarrinho(List<Carrinho> list) {
		int maiorId = buscaMaiorId(); // orçamento
		String sql = "Insert into carrinho (" + "fk_orcamento, produtoNome, qtd, valorUnid, subTotal, produtoId)"
				+ "values (?,?,?,?,?,?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			for (Carrinho carrinho : list) {
				stmt.setInt(1, maiorId); // fk_orcamento
				stmt.setString(2, carrinho.getProdutoNome());
				stmt.setInt(3, carrinho.getQtd());
				stmt.setBigDecimal(4, carrinho.getValorUnid());
				stmt.setBigDecimal(5, carrinho.getSubTotal());
				stmt.setInt(6, carrinho.getProdutoId());
				stmt.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// busca tudo por id do orcamento
	public Orcamento buscaOrcamentoPorId(Orcamento orcamentoBuscado) {
		Orcamento orcamento = new Orcamento();
		Cliente cliente = new Cliente();
		Usuario usuario = new Usuario();

		String sql = "select * from orcamentos as o " + "inner join carrinho as k on k.fk_orcamento = o.id "
				+ "inner join clientes as c on o.fk_cliente = c.id "
				+ "inner join usuarios as u on o.fk_usuario = u.id " + "where o.id = " + orcamentoBuscado.getId();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				orcamento.setId(rs.getInt("o.id"));

				// Carrega usuario
				usuario.setId(rs.getInt("u.id"));
				usuario.setNome(rs.getString("u.nome"));

				orcamento.setUsuario(usuario);

				// Dados do orcamento
				orcamento.setSubTotalOrcamento(rs.getBigDecimal("subTotal"));
				orcamento.setDescontos(rs.getBigDecimal("descontos"));
				orcamento.setTotalOrcamento(rs.getBigDecimal("totalOrcamento"));
				orcamento.setDataLancamento(rs.getDate("dataLancamento").toLocalDate());

				orcamento.setTotalParcelas(rs.getInt("totalParcelas"));
				orcamento.setParcelasPagas(rs.getInt("parcelasPagas"));
				orcamento.setParcelasAPagar(rs.getInt("parcelasAPagar"));

				// Carregar Cliente
				cliente.setId(rs.getInt("c.id"));
				cliente.setPessoa(EnumPessoa.valueOf(rs.getString("c.pessoa")));
				cliente.setSituacao(EnumSituacao.valueOf(rs.getString("c.situacao")));
				cliente.setSexo(EnumSexo.valueOf(rs.getString("c.sexo")));
				cliente.setNome(rs.getString("c.nome"));
				cliente.setSobreNome(rs.getString("c.sobreNome"));
				cliente.setNascimento(rs.getDate("nascimento").toLocalDate());
				cliente.setEmail(rs.getString("c.email"));
				cliente.setCelular(rs.getString("c.celular"));
				cliente.setEndereco(rs.getString("c.endereco"));
				cliente.setBairro(rs.getString("c.bairro"));
				cliente.setCidade(rs.getString("c.cidade"));
				cliente.setComplemento(rs.getString("c.complemento"));
				cliente.setNumero(rs.getString("c.numero"));
				cliente.setUf(rs.getString("c.uf"));
				cliente.setCep(rs.getString("c.cep"));
				cliente.setFone(rs.getString("c.fone"));
				cliente.setObservacao(rs.getString("c.observacao"));
				orcamento.setCliente(cliente);

				// carregar carrinho
				List<Carrinho> carrinhos = new CarrinhoDao().getCarrinhos(orcamento);
				orcamento.setList(carrinhos);

				// carregar pagamento
				List<Pagamentos> pagamentos = new PagamentoDao().buscaPgPorOrcamento(orcamento);
				orcamento.setPagamentos(pagamentos);
			}

			return orcamento;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Lista Orcamento pelo cliente
	public List<Orcamento> getList(Cliente clienteBuscado) {
		String sql = "select * from orcamentos as o " + "right join clientes as c on o.fk_cliente = c.id "
				+ "right join usuarios as u on o.fk_usuario = u.id " + "where o.fk_cliente = ?";
		List<Orcamento> list = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, clienteBuscado.getId());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("fk_cliente"));
				cliente.setNome(rs.getString("c.nome"));

				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("fk_usuario"));
				usuario.setNome(rs.getString("u.nome"));

				Orcamento orcamento = new Orcamento();
				orcamento.setCliente(cliente);
				orcamento.setUsuario(usuario);
				orcamento.setId(rs.getInt("o.id"));
				orcamento.setDescontos(rs.getBigDecimal("o.descontos"));
				orcamento.setTotalOrcamento(rs.getBigDecimal("o.totalOrcamento"));
				// Calculado no banco
				// (`subTotalOrcamento` - ((`subTotalOrcamento` * `descontos`) / 100))
				orcamento.setDataLancamento(rs.getDate("o.dataLancamento").toLocalDate());
				orcamento.setSubTotalOrcamento(rs.getBigDecimal("o.subTotalOrcamento"));
				orcamento.setTotalParcelas(rs.getInt("totalParcelas"));
				orcamento.setParcelasPagas(rs.getInt("parcelasPagas"));
				orcamento.setParcelasAPagar(rs.getInt("parcelasAPagar"));
				list.add(orcamento);
			}
			return list;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Atualiza
	public void atualizaParcelas(Orcamento orcamento) {
		String sql = "Update Orcamentos set parcelasPagas=? where id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, orcamento.getParcelasPagas());
			stmt.setInt(2, orcamento.getId());

			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Lista com Somatório de vendas por mês
	public List<Vendas> getVendasMes() {
		String sql = "select sum(totalOrcamento) as total, dataLancamento as data, year(dataLancamento) as ano from orcamentos group by month(dataLancamento) limit 12";

		List<Vendas> list = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Vendas vendasMes = new Vendas();

				LocalDate data = rs.getDate("data").toLocalDate();

				vendasMes.setMes(data.getMonth());
				vendasMes.setAno(data.getYear());
				vendasMes.setValorTotal(rs.getBigDecimal("total"));

				list.add(vendasMes);
			}
			return list;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Lista com Somatório de vendas por ano
	public List<Vendas> getVendasAno() {
		String sql = "select sum(totalOrcamento) as total, dataLancamento as data from orcamentos group by year(dataLancamento)";

		List<Vendas> list = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Vendas vendasMes = new Vendas();

				LocalDate data = rs.getDate("data").toLocalDate();

				vendasMes.setMes(Month.JANUARY);
				vendasMes.setAno(data.getYear());
				vendasMes.setValorTotal(rs.getBigDecimal("total"));

				list.add(vendasMes);
			}
			return list;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
