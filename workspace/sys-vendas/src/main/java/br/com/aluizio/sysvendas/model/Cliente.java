package br.com.aluizio.sysvendas.model;

/**
 * @author Aluizio Monteiro
 */
public class Cliente extends Pessoa{
	private Integer id;
	private EnumPessoa pessoa;
	private EnumSituacao situacao;
	private EnumSexo sexo;
	private String nome;
	private String sobreNome;
	private String nascimento;
	private String observacao;
	private String email;
	private String celular;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public EnumPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(EnumPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public EnumSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(EnumSituacao situacao) {
		this.situacao = situacao;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", pessoa=" + pessoa + ", nome=" + nome + ", sobreNome=" + sobreNome
				+ ", nascimento=" + nascimento + ", situacao=" + situacao + ", sexo=" + sexo + ", observacao="
				+ observacao + ", email=" + email + ", celular=" + celular + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
