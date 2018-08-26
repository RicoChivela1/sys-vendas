package endereco;

import br.com.aluizio.sysvendas.dao.EnderecoDao;

/**
 * TestaMaxId.java
 * 
 * @author Aluizio Monteiro 26 de ago de 2018
 */

public class TestaMaxId {
	public static void main(String[] args) {

		System.out.println(new EnderecoDao().buscaMaiorId());
	}

}
