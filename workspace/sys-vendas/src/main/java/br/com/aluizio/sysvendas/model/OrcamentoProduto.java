package br.com.aluizio.sysvendas.model;

import java.math.BigDecimal;

/**
 * TestaInsereOrcamento.java
 * 
 * @author Aluizio Monteiro 22 de ago de 2018
 */
	
public class OrcamentoProduto {
	private Integer id;
	private Integer fk_orcamento;
	private Integer fk_produto;
	private Integer qtd;
	private BigDecimal subtotal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFk_orcamento() {
		return fk_orcamento;
	}

	public void setFk_orcamento(Integer fk_orcamento) {
		this.fk_orcamento = fk_orcamento;
	}

	public Integer getFk_produto() {
		return fk_produto;
	}

	public void setFk_produto(Integer fk_produto) {
		this.fk_produto = fk_produto;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "OrcamentoProduto [id=" + id + ", fk_orcamento=" + fk_orcamento + ", fk_produto=" + fk_produto + ", qtd="
				+ qtd + ", subtotal=" + subtotal + "]";
	}

}
