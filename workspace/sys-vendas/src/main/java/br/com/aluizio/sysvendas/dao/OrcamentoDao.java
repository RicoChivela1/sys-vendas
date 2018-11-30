package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;
import br.com.aluizio.sysvendas.model.Carrinho;
import br.com.aluizio.sysvendas.model.Cliente;
import br.com.aluizio.sysvendas.model.EnumPessoa;
import br.com.aluizio.sysvendas.model.EnumSexo;
import br.com.aluizio.sysvendas.model.EnumSituacao;
import br.com.aluizio.sysvendas.model.Orcamento;
import br.com.aluizio.sysvendas.model.Usuario;

/**
 * OrcamentoDao.java
 * 
 * @author Aluizio Monteiro 24 de nov de 2018
 */

public class OrcamentoDao {
	private Connection connection;

	public OrcamentoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	// Adicionar um Orcamento
	public void salvarOrcamento(Orcamento orcamento) {
		String sql = "Insert into Orcamentos (descontos,"
				+ " total, dataLancamento, confirmado, fk_cliente, fk_usuario)"
				+ " values (?,?,?,?,?,?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setBigDecimal(1, orcamento.getDescontos());
			stmt.setBigDecimal(2, orcamento.getTotal());

			stmt.setDate(3, java.sql.Date.valueOf(orcamento.getDataLancamento()));
			stmt.setBoolean(4, orcamento.isConfirmado());
			stmt.setInt(5, orcamento.getCliente().getId());
			stmt.setInt(6, orcamento.getUsuario().getId());
			stmt.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	// Alterar
	public void alterar(Orcamento orcamento) {
		String sql = "Update Orcamentos set descontos=?," + " total=?, dataLancamento=?, confirmado=?,"
				+ " fk_cliente=?, fk_usuario=? where id=?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setBigDecimal(1, orcamento.getDescontos());
			stmt.setBigDecimal(2, orcamento.getTotal());
			stmt.setDate(3, java.sql.Date.valueOf(orcamento.getDataLancamento()));
			stmt.setBoolean(4, orcamento.isConfirmado());

			stmt.setInt(5, orcamento.getCliente().getId());
			stmt.setInt(6, orcamento.getUsuario().getId());
			stmt.setInt(7, orcamento.getId());

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

	/**
	 *
	 */
	public void salvarCarrinho(List<Carrinho> list) {
		int maiorId = buscaMaiorId(); // orçamento
		String sql = "Insert into carrinho ("
				+ "fk_orcamento, produtoNome, qtd, valorUnid, subTotal)"
				+ "values (?,?,?,?,?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			for (Carrinho carrinho : list) {
				stmt.setInt(1, maiorId); //fk_orcamento
				stmt.setString(2, carrinho.getProdutoNome());
				stmt.setInt(3, carrinho.getQtd());
				stmt.setBigDecimal(4, carrinho.getValorUnid());
				stmt.setBigDecimal(5, carrinho.getSubTotal());
				stmt.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}  
	}
	
	
	public Orcamento buscaPorId(Orcamento orcamentoBuscado){
		Orcamento orcamento = new Orcamento();
		Cliente cliente = new Cliente();
		Usuario usuario = new Usuario();
		
		String sql = "select * from orcamentos as o "
				+ "inner join carrinho as c "
				+ "on c.fk_orcamento = o.id "
				+ "inner join clientes as c on o.fk_cliente = c.id "
				+ "inner join usuarios as u on o.fk_usuario = u.id "
				+ "where o.id = "+orcamentoBuscado.getId();
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				orcamento.setId(rs.getInt("o.id"));
				
				//Carrega usuario
				usuario.setId(rs.getInt("u.id"));
				usuario.setNome(rs.getString("u.nome"));

				orcamento.setUsuario(usuario);
				
				//Dados do orcamento
				orcamento.setSubTotal(rs.getBigDecimal("subTotal"));
				orcamento.setDescontos(rs.getBigDecimal("descontos"));
				orcamento.setTotal(rs.getBigDecimal("total"));
				
				//orcamento.setDataLancamento(dataLancamento);
				
				orcamento.setConfirmado(true);
				
				//Carrega Cliente
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
			}
			
			return orcamento;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}

	/*private List<listOrcamentoProduto> listOrcamentoProduto(Orcamento orcBuscado) {
		String sql = "Select * from orcamentos_produtos where fk_orcamento ="+orcBuscado.getId();
		List<OrcamentoProduto> list = new ArrayList<>();
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				OrcamentoProduto orcProduto = new OrcamentoProduto();
				orcProduto.setOrcamentoId(rs.getInt("fk_orcamento"));
				orcProduto.setProdutoNome(rs.getString("produtoNome"));
				orcProduto.setQtd(rs.getInt("qtd"));
				orcProduto.setValorUnid(rs.getBigDecimal("valorUnid"));
				orcProduto.setSubTotal(rs.getBigDecimal("subTotal"));
				
				list.add(orcProduto);
			}
			return list;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}*/

}
