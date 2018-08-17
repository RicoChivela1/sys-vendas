package br.com.aluizio.sysvendas.model;

/**
 * @author Aluizio Monteiro
 */
public class Estoque {
	private Integer id;
	private Integer qtdEntrada;
	private Integer qtdSaida;
	private Integer qtdMinima;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtdEntrada() {
		return qtdEntrada;
	}

	public void setQtdEntrada(Integer qtdEntrada) {
		this.qtdEntrada = qtdEntrada;
	}

	public Integer getQtdSaida() {
		return qtdSaida;
	}

	public void setQtdSaida(Integer qtdSaida) {
		this.qtdSaida = qtdSaida;
	}

	public Integer getQtdMinima() {
		return qtdMinima;
	}

	public void setQtdMinima(Integer qtdMinima) {
		this.qtdMinima = qtdMinima;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", qtdEntrada=" + qtdEntrada + ", qtdSaida=" + qtdSaida + ", qtdMinima="
				+ qtdMinima + "]";
	}

}
