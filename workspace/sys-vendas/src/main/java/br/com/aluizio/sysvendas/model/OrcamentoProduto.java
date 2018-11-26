package br.com.aluizio.sysvendas.model;

import java.math.BigDecimal;

/**
 * Orcamento.java 24 de nov de 2018
 * 
 * @author Aluizio Monteiro
 */

public class OrcamentoProduto {
	private Integer orcamentoId;
	private String produtoNome;
	private Integer qtd;
	private BigDecimal valorUnid;
	private BigDecimal subTotal;

	public Integer getOrcamentoId() {
		return orcamentoId;
	}

	public void setOrcamentoId(Integer orcamentoId) {
		this.orcamentoId = orcamentoId;
	}

	public String getProdutoNome() {
		return produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getValorUnid() {
		return valorUnid;
	}

	public void setValorUnid(BigDecimal valorUnid) {
		this.valorUnid = valorUnid;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "\n *** OrcamentoProduto [orcamentoId=" + orcamentoId + ", produtoNome=" + produtoNome + ", qtd=" + qtd
				+ ", valorUnid=" + valorUnid + ", subTotal=" + subTotal + "]";
	}

}
