package it.polito.tdp.lab04.model;

public class Corso {

	private String codins;
	private int numeroCrediti;
	private String nome;
	private int periodoDidattico;
	
	public Corso(String codins, int numeroCrediti, String nome, int periodoDidattico) {
		this.codins = codins;
		this.numeroCrediti = numeroCrediti;
		this.nome = nome;
		this.periodoDidattico = periodoDidattico;
	}

	@Override
	public String toString() {
		return this.nome;
	}
	
	public String toStringFull() {
		return codins + "  " + numeroCrediti + "  " + nome + "  " + periodoDidattico;
	}

	public String getCodins() {
		return codins;
	}

	public int getNumeroCrediti() {
		return numeroCrediti;
	}

	public String getNome() {
		return nome;
	}

	public int getPeriodoDidattico() {
		return periodoDidattico;
	}

}
