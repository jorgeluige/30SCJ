package br.com.fiap.stream;

import java.time.LocalDate;

public class Cliente {

	private String nome;
	private int idade;
	private boolean ativo;
	private LocalDate dataPrimeiraCompra;
	public Cliente(String nome, int idade, boolean ativo, LocalDate dataPrimeiraCompra) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.ativo = ativo;
		this.dataPrimeiraCompra = dataPrimeiraCompra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public LocalDate getDataPrimeiraCompra() {
		return dataPrimeiraCompra;
	}
	public void setDataPrimeiraCompra(LocalDate dataPrimeiraCompra) {
		this.dataPrimeiraCompra = dataPrimeiraCompra;
	}
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", idade=" + idade + ", ativo=" + ativo + ", dataPrimeiraCompra="
				+ dataPrimeiraCompra + "]";
	}
	
	public void bloqueia() {
		setAtivo(false);
	}
	
}
