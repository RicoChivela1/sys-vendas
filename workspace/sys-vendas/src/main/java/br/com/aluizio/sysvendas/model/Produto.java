package br.com.aluizio.sysvendas.model;

/**
 * @author Aluizio Monteiro
 */
public class Produto extends Categoria {
	private Integer id;
	private String nome;
	private String descricao;
	private String indicacao;
	private String volume;
	private Integer custoUnid;
	private Integer sugestaoVenda;
	
	private Estoque estoque;
	private Categoria categoria;

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIndicacao() {
		return indicacao;
	}

	public void setIndicacao(String indicacao) {
		this.indicacao = indicacao;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public Integer getCustoUnid() {
		return custoUnid;
	}

	public void setCustoUnid(Integer custoUnid) {
		this.custoUnid = custoUnid;
	}

	public Integer getSugestaoVenda() {
		return sugestaoVenda;
	}

	public void setSugestaoVenda(Integer sugestaoVenda) {
		this.sugestaoVenda = sugestaoVenda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", indicacao=" + indicacao
				+ ", volume=" + volume + ", custoUnid=" + custoUnid + ", sugestaoVenda=" + sugestaoVenda + "]";
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
