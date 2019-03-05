package entities;

public class PessoaJuridica extends Pessoa {

	private Integer numeroDeFuncionarios;
	
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroDeFuncionarios) {
		super(nome, rendaAnual);
		this.numeroDeFuncionarios = numeroDeFuncionarios;
	}

	@Override
	public double calculaImposto() {
		return numeroDeFuncionarios < 10 ? getRendaAnual() * 0.16 : getRendaAnual() * 0.14;
	}

}