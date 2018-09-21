package br.com.aluizio.sysvendas.dao;

import java.util.List;

/**
 * IDAO.java
 * @author Aluizio Monteiro
 * 21 de set de 2018
 */

public interface IDAO {
	void adicionaAltera(Object object);
	void remover(Object object);
	Object buscaPorId(Object object);
	List<Object> getList();
}
