package endereco;

import br.com.aluizio.sysvendas.dao.EnderecoDao;
import br.com.aluizio.sysvendas.model.Endereco;

/**
 * TestaInsereEndereco.java
 * @author Aluizio Monteiro
 * 25 de ago de 2018
 */

public class TestaAlteraEndereco {

	public static void main(String[] args) {
		//Endereço
				Endereco endereco = new Endereco();
				
				endereco.setEndereco("Avenida Das Ostras");
				endereco.setBairro("Bairro Ostras");
				endereco.setCidade("Ostras");
				endereco.setComplemento("Lote 14/15");
				endereco.setNumero("12");
				endereco.setUf("DF");
				endereco.setCep("12234232");
				endereco.setFone("12 11223344");
				endereco.setObservacao("Endereço fictício");
				endereco.setId(1);
				EnderecoDao dao = new EnderecoDao();
				dao.alterar(endereco);
				System.out.println("Endereço alterado com sucesso");

	}

}
