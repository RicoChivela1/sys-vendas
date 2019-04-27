package br.com.aluizio.sysvendas.model;

import java.math.BigDecimal;
import java.time.Month;

/**
 * GraficoVendas.java
 * 
 * @author Aluizio Monteiro 26 de abr de 2019
 */

public class Vendas {

	private BigDecimal valorTotal;
	private Month mes;
	private int ano;

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Month getMes() {
		return mes;
	}

	public void setMes(Month mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "VendasMes [valorTotal=" + valorTotal + ", mes=" + mes + ", ano=" + ano + "]";
	}

}
