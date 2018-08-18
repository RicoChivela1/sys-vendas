package br.com.aluizio.sysvendas.testes;

import br.com.aluizio.sysvendas.dao.EstoqueDao;
import br.com.aluizio.sysvendas.model.Estoque;

public class TestaEstoque {
	public static void main(String[] args) {
		
		
		Estoque estoqueBuscado = new Estoque();
		estoqueBuscado.setId(1);
		
		EstoqueDao dao = new EstoqueDao();
		System.out.println(dao.buscaEstoqueId(estoqueBuscado));
		
	/*	//Alterar
		Estoque estoque = new Estoque();
		
		
		estoque.setQtdEntrada(10);
		estoque.setQtdMinima(10);
		estoque.setQtdSaida(10);
		estoque.setId(1);
		
		EstoqueDao dao = new EstoqueDao();
		dao.alterar(estoque);*/
		
		
		/*//Adicionar
		Estoque estoque = new Estoque();
		estoque.setQtdEntrada(10);
		estoque.setQtdMinima(10);
		estoque.getQtdSaida();
		
		EstoqueDao dao = new EstoqueDao();
		dao.adicionar(estoque);*/
	}
}
