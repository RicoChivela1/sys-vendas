package orcamento;

import br.com.aluizio.sysvendas.dao.OrcamentoDao;
import br.com.aluizio.sysvendas.model.Orcamento;

/**
 * TestaBuscaPorId.java
 * @author Aluizio Monteiro
 * 26 de nov de 2018
 */

public class TesteBuscaOrcamentoPorId {

	public static void main(String[] args) {
		//id buscado
		Orcamento orcBuscado = new Orcamento();
		orcBuscado.setId(18);
		
		//cria o dao
		OrcamentoDao dao = new OrcamentoDao();
		
		//retorna cliente e respectívos endereços
		Orcamento orcResposta = dao.buscaPorId(orcBuscado);
		
		//Imprime tudo
		System.out.println(orcResposta);
		
	}
}
