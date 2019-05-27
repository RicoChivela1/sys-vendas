package br.com.aluizio.sysvendas.service;

import java.util.List;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Orcamento;

/**
 * UltimosOrcamentos.java
 * 
 * @author Aluizio Monteiro 
 * @date 25 de abr de 2019
 */

public class UltimosOrcamentos {
	

	/**
	 * Listar todas as d�vidas
	 * 
	 * @return Lista de D�vidas
	 */
	public static List<Orcamento> ultimosLancamentos() {
		List<Orcamento> orcamentos = new OrcamentoDao().ultimosLancamentos();
		return orcamentos;
	}

}
