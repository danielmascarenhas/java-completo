package entities;

public class Funcionario {

	private String nome;
	private String email;
	private Double salario;
	
	public Funcionario() {
	}

	public Funcionario(String nome, String email, Double salario) {
		this.nome = nome;
		this.email = email;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Double getSalario() {
		return salario;
	}
	
}
