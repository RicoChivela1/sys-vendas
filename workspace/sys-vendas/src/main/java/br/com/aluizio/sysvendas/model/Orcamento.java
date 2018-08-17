package br.com.aluizio.sysvendas.model;

import java.util.Calendar;

/**
 * @author Aluizio Monteiro
 */

public class Orcamento {
	private Integer id;
	private Integer subTotal;
	private Integer desconto;
	private Integer total;
	private Calendar dataLancamento;
	private boolean confirmado;

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

	@Override
	public String toString() {
		return "Orcamento [id=" + id + ", subTotal=" + subTotal + ", desconto=" + desconto + ", total=" + total
				+ ", dataLancamento=" + dataLancamento + ", confirmado=" + confirmado + "]";
	}

	
}
