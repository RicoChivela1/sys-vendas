package br.com.aluizio.sysvendas.model;

import java.math.BigDecimal;

/**
 * @author Aluizio Monteiro Esta classe formar� uma lista de produtos do
 *         or�amento. cada ocorrencia de produto possui um id do cliente
 *         associado. Ela guarda os �tens exibidos na JSP "sess�o"
 */

public class Carrinho {
	//private Integer idCliente; // n�o armazenar
	//private String nomeCliente; // n�o armazenar

	private Integer produtoId;
	private Integer orcamentoId;
	private String produtoNome;
	private Integer qtd;
	private BigDecimal valorUnid;
	private BigDecimal subTotal;

	/*public Integer getIdCliente() {
		
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
	}*/

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
		return "Carrinho [produtoId=" + produtoId + ", orcamentoId=" + orcamentoId + ", produtoNome=" + produtoNome
				+ ", qtd=" + qtd + ", valorUnid=" + valorUnid + ", subTotal=" + subTotal + "]";
	}

	

}
