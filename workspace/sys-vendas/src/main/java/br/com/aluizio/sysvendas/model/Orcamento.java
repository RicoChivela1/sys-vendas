package br.com.aluizio.sysvendas.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Orcamento.java
 * 
 * @author Aluizio Monteiro 24 de nov de 2018
 */

public class Orcamento {
	private Integer id;
	private Integer totalParcelas;
	private Integer parcelasPagas;
	private Integer parcelasAPagar;
	private Cliente cliente;
	private Usuario usuario;
	private BigDecimal subTotal;
	private BigDecimal descontos;
	private BigDecimal total;
	private LocalDate dataLancamento = LocalDate.now();
	private boolean confirmado;
	private List<Carrinho> list;

	
	
	public List<Carrinho> getList() {
		return list;
	}

	public void setList(List<Carrinho> list) {
		this.list = list;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTotalParcelas() {
		return totalParcelas;
	}

	public void setTotalParcelas(Integer totalParcelas) {
		this.totalParcelas = totalParcelas;
	}

	public Integer getParcelasPagas() {
		return parcelasPagas;
	}

	public void setParcelasPagas(Integer parcelasPagas) {
		this.parcelasPagas = parcelasPagas;
	}

	public Integer getParcelasAPagar() {
		return parcelasAPagar;
	}

	public void setParcelasAPagar(Integer parcelasAPagar) {
		this.parcelasAPagar = parcelasAPagar;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getDescontos() {
		return descontos;
	}

	public void setDescontos(BigDecimal descontos) {
		this.descontos = descontos;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "Orcamento [id=" + id + ", totalParcelas=" + totalParcelas + ", parcelasPagas=" + parcelasPagas
				+ ", parcelasAPagar=" + parcelasAPagar + ", cliente=" + cliente + ", usuario=" + usuario + ", subTotal="
				+ subTotal + ", descontos=" + descontos + ", total=" + total + ", dataLancamento=" + dataLancamento
				+ ", confirmado=" + confirmado + ", list=" + list + "]";
	}

	public String getOrcamento() {
		return "Orcamento [id=" + id + ", "
				+ "cliente=" + cliente.getNome() + ", "
				+ "usuario=" + usuario.getNome() + ", "
				+ "subTotal=" + subTotal + ", "
				+ "descontos=" + descontos + ", "
				+ "total=" + total + ", "
				
				+ "totalParcelas=" + totalParcelas + ", "
				+ "parcelasPagas=" + parcelasPagas + ", "
				
				+ "dataLancamento=" + dataLancamento + ", "
				+ "confirmado=" + confirmado + ", "
				+ "parcelasAPagar=" + parcelasAPagar + ", "
				+ "list=" + list + "]";
	}

}