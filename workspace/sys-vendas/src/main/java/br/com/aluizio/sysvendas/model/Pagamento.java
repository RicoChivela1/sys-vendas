package br.com.aluizio.sysvendas.model;

/**
 * @author Aluizio Monteiro
 */
public class Pagamento {
	private Integer id;
	private Integer valorTotal;
	private Integer qtdParcelas;
	private Integer valorParcela;
	private Integer diaVencimento;
	private Integer parcelasPagas;
	private EnumStatus status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Integer valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(Integer qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	public Integer getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Integer valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Integer getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public Integer getParcelasPagas() {
		return parcelasPagas;
	}

	public void setParcelasPagas(Integer parcelasPagas) {
		this.parcelasPagas = parcelasPagas;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", valorTotal=" + valorTotal + ", qtdParcelas=" + qtdParcelas + ", valorParcela="
				+ valorParcela + ", diaVencimento=" + diaVencimento + ", parcelasPagas=" + parcelasPagas + ", status="
				+ status + "]";
	}

}
