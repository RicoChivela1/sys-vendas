package endereco;

import br.com.aluizio.sysvendas.dao.EnderecoDao;
import br.com.aluizio.sysvendas.model.Endereco;

/**
 * TestaInsereEndereco.java
 * @author Aluizio Monteiro
 * 25 de ago de 2018
 */

public class TestaInsereEndereco {

	public static void main(String[] args) {
		//Endereço
				Endereco endereco = new Endereco();
				
				endereco.setEndereco("Avenida Das Pedras");
				endereco.setBairro("Bairro verde");
				endereco.setCidade("Samambaia");
				endereco.setComplemento("Lote 14/15");
				endereco.setNumero("12");
				endereco.setUf("DF");
				endereco.setCep("12234232");
				endereco.setFone("12 11223344");
				endereco.setObservacao("Endereço fictício");
				
				EnderecoDao dao = new EnderecoDao();
				dao.adicionar(endereco);

	}

}
