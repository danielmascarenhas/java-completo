package entities;

public class PessoaFisica extends Pessoa {

	private Double gastosComSaude;
	
	public PessoaFisica() {
		super();
	}
	
	public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}

	@Override
	public double calculaImposto() {

		double imposto = getRendaAnual() < 20000 ? getRendaAnual() * 0.15 : getRendaAnual() * 0.25;		
		
		if( gastosComSaude != 0 )
			return imposto - gastosComSaude * 0.5;
		
		return imposto;
	}
	
}