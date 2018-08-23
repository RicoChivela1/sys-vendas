package br.com.aluizio.sysvendas.model;

import java.util.Calendar;

/**
 * TestaInsereOrcamento.java
 * @author Aluizio Monteiro
 * 22 de ago de 2018
 */

public class Orcamento {
	private Integer id;
	private Integer subTotal;
	private Integer desconto;
	private Integer total;
	private Calendar dataLancamento;
	private boolean confirmado;
	
	private Cliente cliente;
	private Usuario usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Integer subTotal) {
		this.subTotal = subTotal;
	}

	public Integer getDesconto() {
		return desconto;
	}

	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
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

	@Override
	public String toString() {
		return "Orcamento [id=" + id + ", subTotal=" + subTotal + ", desconto=" + desconto + ", total=" + total
				+ ", dataLancamento=" + dataLancamento + ", confirmado=" + confirmado + ", cliente=" + cliente
				+ ", usuario=" + usuario + "]";
	}

	
	

	
}
