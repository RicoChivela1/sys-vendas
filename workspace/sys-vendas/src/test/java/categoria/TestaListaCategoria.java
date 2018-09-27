package categoria;

import java.util.List;

import br.com.aluizio.sysvendas.dao.CategoriaDao;

/**
 * TestaListaCategoria.java
 * @author Aluizio Monteiro
 * 27 de ago de 2018
 */

public class TestaListaCategoria {

	public static void main(String[] args) {
		
		List<Object> list = new CategoriaDao().getList();
		list.forEach(c -> System.out.println(c));

	}

}
