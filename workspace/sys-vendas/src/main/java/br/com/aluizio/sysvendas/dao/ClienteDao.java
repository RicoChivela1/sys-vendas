package br.com.aluizio.sysvendas.dao;

import java.sql.Connection;

import br.com.aluizio.sysvendas.jdbc.ConnectionFactory;

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
	
	//Adiciona
	
	
	//Alterar
	
	//Listar
	
	//Excluir
	
}
