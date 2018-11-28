package br.com.aluizio.sysvendas.model;

import java.math.BigDecimal;

/**
 * @author Aluizio Monteiro
 * Esta classe formará uma lista de produtos do orçamento
 */

public class Carrinho {
	private Integer idCliente;
	private String nomeCliente;
	
	private Integer idProduto;
	private String nomeProduto;
	private Integer qtdProduto;
	private BigDecimal custoUnid;
	private BigDecimal subTotal;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Integer getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(Integer qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public BigDecimal getCustoUnid() {
		return custoUnid;
	}

	public void setCustoUnid(BigDecimal custoUnid) {
		this.custoUnid = custoUnid;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "Carrinho [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", idProduto=" + idProduto
				+ ", nomeProduto=" + nomeProduto + ", qtdProduto=" + qtdProduto + ", custoUnid=" + custoUnid
				+ ", subTotal=" + subTotal + "]";
	}
	
}
