package br.com.aluizio.sysvendas.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Cliente.java
 * @author Aluizio Monteiro
 * 20 de ago de 2018
 */

public class Cliente{


	private Integer id;
	private EnumPessoa pessoa;
	private EnumSituacao situacao;
	private EnumSexo sexo;
	private String nome;
	private String sobreNome;
	private Calendar nascimento;
	private String observacao;
	private String email;
	private String celular;
	private Endereco endereco;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public EnumPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(EnumPessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public EnumSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(EnumSituacao situacao) {
		this.situacao = situacao;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		 DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return "Cliente [id=" + this.id + ", pessoa=" + pessoa + ", nome=" + nome + ", sobreNome=" + sobreNome
				+ ", nascimento=" + df.format(this.nascimento.getTime()) + ", situacao=" + situacao + ", sexo=" + sexo + ", observacao="
				+ observacao + ", email=" + email + ", celular=" + celular + "]";
	}

}
