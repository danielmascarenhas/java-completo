package entities;

public class Item {

	private String nome;
	private Double precoUnitario;
	private Integer quantidadeVendida;
	
	public Item() {
	}
	
	public Item(String nome, Double precoUnitario, Integer quantidadeVendida) {
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.quantidadeVendida = quantidadeVendida;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double calculaValorTotal() {
		return precoUnitario * quantidadeVendida;
	}
}