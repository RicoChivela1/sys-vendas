package br.com.aluizio.sysvendas.model;

import java.math.BigDecimal;

/**
 * @author Aluizio Monteiro Esta classe formará uma lista de produtos do
 *         orçamento. cada ocorrencia de produto possui um id do cliente
 *         associado. Ela guarda os ítens exibidos na JSP "sessão"
 */

public class Carrinho {
	private Integer idCliente; // não armazenar
	private String nomeCliente; // não armazenar

	private Integer produtoId;
	private Integer orcamentoId;
	private String produtoNome;
	private Integer qtd;
	private BigDecimal valorUnid;
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

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

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
		return "Carrinho [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", produtoId=" + produtoId
				+ ", orcamentoId=" + orcamentoId + ", produtoNome=" + produtoNome + ", qtd=" + qtd + ", valorUnid="
				+ valorUnid + ", subTotal=" + subTotal + "]";
	}

}
