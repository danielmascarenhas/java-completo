package entities;

public abstract class Pessoa {
	
	private String nome;
	private Double rendaAnual;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, Double rendaAnual) {
		super();
		this.nome = nome;
		this.rendaAnual = rendaAnual;
	}

	public String getNome() {
		return nome;
	}
	
	public Double getRendaAnual() {
		return rendaAnual;
	}
	
	public abstract double calculaImposto();
	
	@Override
	public String toString() {
		return nome
				+ ": $ "
				+ String.format("%.2f", calculaImposto());
	}
}