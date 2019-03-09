package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Entre com os dados da conta");
			System.out.print("Número: ");
			int numero = sc.nextInt();
			System.out.print("Titular: ");
			sc.nextLine();
			String titular = sc.nextLine();
			System.out.print("Saldo inicial: ");
			double saldo = sc.nextDouble();
			System.out.print("Limite de saque: ");
			double limiteDeSaque = sc.nextDouble();
			
			Conta c = new Conta(numero, titular, saldo, limiteDeSaque);
			
			System.out.println();
			System.out.print("Insira o valor a ser retirado: ");
			double valor = sc.nextDouble();
			c.sacar(valor);
			System.out.printf("Novo saldo: %.2f", c.getSaldo());
		}
		catch (InputMismatchException e) {
			System.out.println("O valor precisa ser inteiro.");
		}
		catch(DomainException e) {
			System.out.println("Erro de saque: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado.");
		}
		
		sc.close();
	}
}