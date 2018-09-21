package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.EnumPessoa;
import br.com.aluizio.sysvendas.model.EnumSexo;
import br.com.aluizio.sysvendas.model.EnumSituacao;

/**
 * ClienteDao.java
 * 
 * @author Aluizio Monteiro 20 de ago de 2018
 */

public class ClienteDao implements IDAO {
	Connection connection;

	public ClienteDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Adiciona e Altera Cliente
	@Override
	public void adicionaAltera(Object object) {
		Cliente cliente = (Cliente) object;
		String sql;
		if (cliente.getId() == null) {
			sql = "insert into Clientes (pessoa, situacao," + " sexo, nome, sobreNome, nascimento, "
					+ " email, celular, endereco, bairro, cidade, "
					+ " complemento, numero, uf, cep, fone, observacao) "
					+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		} else {
			sql = "update Clientes set pessoa=?, situacao=?," + " sexo=?, nome=?, sobreNome=?, nascimento=?, "
					+ " email=?, celular=?, endereco=?, bairro=?, cidade=?, "
					+ " complemento=?, numero=?, uf=?, cep=?, fone=?, observacao=? " + " where id=" + cliente.getId();
		}

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getPessoa().name());
			stmt.setString(2, cliente.getSituacao().name());
			stmt.setString(3, cliente.getSexo().name());
			stmt.setString(4, cliente.getNome());
			stmt.setString(5, cliente.getSobreNome());

			stmt.setDate(6, new Date(cliente.getNascimento().getTimeInMillis()));

			stmt.setString(7, cliente.getEmail());
			stmt.setString(8, cliente.getCelular());
			stmt.setString(9, cliente.getEndereco());
			stmt.setString(10, cliente.getBairro());
			stmt.setString(11, cliente.getCidade());
			stmt.setString(12, cliente.getComplemento());
			stmt.setString(13, cliente.getNumero());
			stmt.setString(14, cliente.getUf());
			stmt.setString(15, cliente.getCep());
			stmt.setString(16, cliente.getFone());
			stmt.setString(17, cliente.getObservacao());

			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		}
	}

	// Excluir
	@Override
	public void remover(Object object) {
		Cliente cliente = (Cliente) object;
		String sql = "Delete from Clientes where id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, cliente.getId());
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	// Busca Cliente por Id
	@Override
	public Object buscaPorId(Object object) {
		Cliente clienteBuscado = (Cliente) object;
		String sql = "Select * from Clientes as c where c.id=?";

		Cliente cliente = new Cliente();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, clienteBuscado.getId());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {

				cliente.setId(rs.getInt("id"));
				cliente.setPessoa(EnumPessoa.valueOf(rs.getString("pessoa")));
				cliente.setSituacao(EnumSituacao.valueOf(rs.getString("situacao")));
				cliente.setSexo(EnumSexo.valueOf(rs.getString("sexo")));
				cliente.setNome(rs.getString("nome"));
				cliente.setSobreNome(rs.getString("sobreNome"));

				Calendar nascimento = Calendar.getInstance();
				nascimento.setTime(rs.getDate("nascimento"));
				cliente.setNascimento(nascimento);

				cliente.setEmail(rs.getString("email"));
				cliente.setCelular(rs.getString("celular"));

				cliente.setEndereco(rs.getString("endereco"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setNumero(rs.getString("numero"));
				cliente.setUf(rs.getString("uf"));
				cliente.setCep(rs.getString("cep"));
				cliente.setFone(rs.getString("fone"));
				cliente.setObservacao(rs.getString("observacao"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return cliente;
	}

	// Listar
	@Override
	public List<Object> getList() {
		String sql = "Select * from Clientes";

		List<Object> lista = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setPessoa(EnumPessoa.valueOf(rs.getString("pessoa")));
				cliente.setSituacao(EnumSituacao.valueOf(rs.getString("situacao")));
				cliente.setSexo(EnumSexo.valueOf(rs.getString("sexo")));
				cliente.setNome(rs.getString("nome"));
				cliente.setSobreNome(rs.getString("sobreNome"));

				Calendar nascimento = Calendar.getInstance();
				nascimento.setTime(rs.getDate("nascimento"));
				cliente.setNascimento(nascimento);

				cliente.setObservacao(rs.getString("observacao"));
				cliente.setEmail(rs.getString("email"));
				cliente.setCelular("celular");

				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setNumero(rs.getString("numero"));
				cliente.setUf(rs.getString("uf"));
				cliente.setCep(rs.getString("cep"));
				cliente.setFone(rs.getString("fone"));
				cliente.setObservacao(rs.getString("observacao"));
				lista.add(cliente);

			}
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Busca o ultimo Id
	public int buscaMaiorId() {
		String sql = "Select MAX(id) from Clientes";
		int id = 0;
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				id = rs.getInt(1);
			}
		}

		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return id;
	}

	// Busca por nome
	public List<Cliente> buscaPorNome(Cliente c) {
		List<Cliente> lista = new ArrayList<>();

		if (!existCliente(c)) {
			System.out.println("Cliente não existe");

		} else {
			String sql = "select * from Clientes where nome like ?";

			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				String termo = "%" + c.getNome() + "%";
				stmt.setString(1, termo);

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setId(rs.getInt("id"));
					cliente.setPessoa(EnumPessoa.valueOf(rs.getString("pessoa")));
					cliente.setSituacao(EnumSituacao.valueOf(rs.getString("situacao")));
					cliente.setSexo(EnumSexo.valueOf(rs.getString("sexo")));
					cliente.setNome(rs.getString("nome"));
					cliente.setSobreNome(rs.getString("sobreNome"));

					Calendar nascimento = Calendar.getInstance();
					nascimento.setTime(rs.getDate("nascimento"));
					cliente.setNascimento(nascimento);

					cliente.setObservacao(rs.getString("observacao"));
					cliente.setEmail(rs.getString("email"));
					cliente.setCelular(rs.getString("celular"));

					lista.add(cliente);
				}

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return lista;
	}

	// Verifica se Cliente existe
	public boolean existCliente(Cliente cliente) {
		String sql = "select * from Clientes where nome like ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			String termo = "%" + cliente.getNome() + "%";
			stmt.setString(1, termo);
			ResultSet rs = stmt.executeQuery();

			if (!rs.next()) {
				System.out.println("Cliente não existe");
				return false;
			} else {
				System.out.println("Cliente existe");
				return true;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
