package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Pessoa> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int quantidadeDeContribuintes = sc.nextInt();
		
		for (int i = 1; i <= quantidadeDeContribuintes; i++) {
			System.out.println("Dados do contribuinte # " + i + ":");
			System.out.print("Pessoa física ou jurídica (f/j)? ");
			sc.nextLine();
			char tipoDePessoa = sc.nextLine().charAt(0);
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Rendimento anual: ");
			double rendaAnual = sc.nextDouble();
			if(tipoDePessoa == 'f') {
				System.out.print("Gastos com saúde: ");
				double gastosComSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaAnual, gastosComSaude));
			}
			else {
				System.out.print("Número de funcionários: ");
				int numeroDeFuncionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numeroDeFuncionarios));
			}			
		}
		
		System.out.println();
		System.out.println("Impostos Pagos");
		for(Pessoa pessoa : list) {
			System.out.println(pessoa.toString());
		}
		
		double totalDeImpostos = 0;
		for (Pessoa pessoa : list) {
			totalDeImpostos += pessoa.calculaImposto();
		}
		System.out.println();
		System.out.println("Total de Impostos Pagos: " + String.format("%.2f", totalDeImpostos));
		
		sc.close();
	}
}