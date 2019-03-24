package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o caminho do arquivo: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			List<Funcionario> list = new ArrayList<>();

			String line = br.readLine();
			
			while (line != null) {
				String[] funcionarios = line.split(",");
				list.add(new Funcionario(
						funcionarios[0],
						funcionarios[1],
						Double.parseDouble(funcionarios[2]))
				);
				line = br.readLine();				
			}
			
			System.out.print("E-mail das pessoas com salário maior que: ");
			double salario = sc.nextDouble();
			
			List<String> emails = list.stream()
					.filter(f -> f.getSalario() > salario)
					.map(f -> f.getEmail()).sorted()
					.collect(Collectors.toList());
						
			double somaDeSalarios = list.stream()
					.filter(f -> f.getNome().toUpperCase().charAt(0) == 'M')
					.map(f -> f.getSalario())
					.reduce(0.0, (x,y) -> x + y);
			
			System.out.println("E-mail dos funcionários que recebem +2000:");
			emails.forEach(System.out::println);
			
			System.out.printf("%s%.2f", "Soma dos salários dos funcionários que iniciam com a letra M: ", somaDeSalarios);
			
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
