package br.com.aluizio.sysvendas.model;

/**
 * @author Aluizio Monteiro novo
 */
public class Produto extends Categoria {
	private Integer id;
	private String nome;
	private String descricao;
	private String indicacao;
	private String volume;
	private Integer custoUnid;
	private Integer sugestaoVenda;
	
	private String imagem;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", indicacao=" + indicacao
				+ ", volume=" + volume + ", custoUnid=" + custoUnid + ", sugestaoVenda=" + sugestaoVenda + ", imagem="
				+ imagem + ", estoque=" + estoque + ", categoria=" + categoria + "]";
	}

	

	
}
