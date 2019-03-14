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
	private BigDecimal subTotalOrcamento;
	private BigDecimal descontos;
	private BigDecimal totalOrcamento;
	private LocalDate dataLancamento = LocalDate.now();
	private boolean confirmado;
	private List<Carrinho> list;
	private List<Pagamento> pagamentos;
	
	
	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

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

	public void setDescontos(BigDecimal d) {
		this.descontos = d;
	}

	public BigDecimal getTotalOrcamento() {
		return totalOrcamento;
	}

	public void setTotalOrcamento(BigDecimal totalOrcamento) {
		this.totalOrcamento = totalOrcamento;
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

	public BigDecimal getSubTotalOrcamento() {
		return subTotalOrcamento;
	}

	public void setSubTotalOrcamento(BigDecimal subTotalOrcamento) {
		this.subTotalOrcamento = subTotalOrcamento;
	}

	@Override
	public String toString() {
		return "Orcamento [id=" + id + ", totalParcelas=" + totalParcelas + ", parcelasPagas=" + parcelasPagas
				+ ", parcelasAPagar=" + parcelasAPagar + ", cliente=" + cliente + ", usuario=" + usuario
				+ ", subTotalOrcamento=" + subTotalOrcamento + ", descontos=" + descontos + ", totalOrcamento="
				+ totalOrcamento + ", dataLancamento=" + dataLancamento + ", confirmado=" + confirmado + ", list="
				+ list + ", pagamentos=" + pagamentos + "]";
	}

	
	

	
}