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
 * @author Aluizio Monteiro
 * 20 de ago de 2018
 */

public class ClienteDao {
	Connection connection;

	public ClienteDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	//Adiciona Cliente
	public void adicionar(Cliente cliente) {
		String sql = "insert into Clientes (pessoa, situacao,"
				+ " sexo, nome, sobreNome, nascimento, observacao, email, celular) "
				+ " values (?,?,?,?,?,?,?,?,?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, cliente.getPessoa().name());
			stmt.setString(2, cliente.getSituacao().name());
			stmt.setString(3, cliente.getSexo().name());
			stmt.setString(4, cliente.getNome());
			stmt.setString(5, cliente.getSobreNome());
			
			stmt.setDate(6, new Date(cliente.getNascimento().getTimeInMillis()));
			
			stmt.setString(7, cliente.getObservacao());
			stmt.setString(8, cliente.getEmail());
			stmt.setString(9, cliente.getCelular());
		
			stmt.execute();
			
			System.out.println("Cliente adicionado com sucesso");
			
		} catch (SQLException e) {
			System.out.println("Erro ao adicionar cliente");
			e.printStackTrace();
			throw new RuntimeException(e);	
			
		}	
	}

	// Busca o ultimo Id
		public int buscaMaiorId(){
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
		

	//Alterar
	public void alterar(Cliente cliente) {
		String sql = "Update Clientes set pessoa=?, situacao=?, sexo=?,"
				+ " nome=?, sobreNome=?, nascimento=?, observacao=?, email=?,"
				+ " celular=? where id=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, cliente.getPessoa().name());
			stmt.setString(2, cliente.getSituacao().name());
			stmt.setString(3, cliente.getSexo().name());
			stmt.setString(4, cliente.getNome());
			stmt.setString(5, cliente.getSobreNome());
			stmt.setDate(6, new Date(cliente.getNascimento().getTimeInMillis()));
			stmt.setString(7, cliente.getObservacao());
			stmt.setString(8, cliente.getEmail());
			stmt.setString(9, cliente.getCelular());
			stmt.setInt(10, cliente.getId());
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Listar
	public List<Cliente> getList(){
		String sql = "Select * from Clientes";	
		List<Cliente> lista = new ArrayList<>();
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Cliente cliente = new Cliente();
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
				
				lista.add(cliente);
				
			}
			return lista ;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}

	//Excluir
	public void remover(Cliente cliente) {
		String sql = "Delete from Clientes where id=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, cliente.getId());
			stmt.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
	}

	//Verifica se Cliente existe
	public boolean existCliente(Cliente cliente) {
		String sql = "select * from Clientes where nome like ?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			String termo = "%"+cliente.getNome()+"%";
			stmt.setString(1, termo);
			ResultSet rs = stmt.executeQuery();
			
			if(!rs.next()) {
				System.out.println("Cliente não existe");
				return false;
			}else {
				System.out.println("Cliente existe");
				return true;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Busca por nome
	public List<Cliente> buscaPorNome(Cliente c) {
		List<Cliente> lista = new ArrayList<>();
		
		if(!existCliente(c)) {
			System.out.println("Cliente não existe");
			
		}else {
			String sql = "select * from Clientes where nome like ?";
			
			try (PreparedStatement stmt = connection.prepareStatement(sql)){
				String termo = "%"+c.getNome()+"%";
				stmt.setString(1, termo);
				
				ResultSet rs = stmt.executeQuery();
			
				while(rs.next()) {
					Cliente cliente = new Cliente();
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
					
					lista.add(cliente);
				}
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return lista;	
	}
}
 