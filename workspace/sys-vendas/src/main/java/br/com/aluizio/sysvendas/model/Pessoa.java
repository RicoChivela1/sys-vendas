package br.com.aluizio.sysvendas.model;

/**
 * @author Aluizio Monteiro
 */

public class Pessoa {
	private Integer id;
	private EnumPessoa pessoa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EnumPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(EnumPessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", pessoa=" + pessoa + "]";
	}

}
