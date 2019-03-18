package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o caminho completo do arquivo: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			Map<String, Integer> list = new LinkedHashMap<>();
			
			String line = br.readLine();
			
			while (line != null) {
				
				String[] dados = line.split(",");
				String candidado = dados[0];
				int votos = Integer.parseInt(dados[1]);
				
				if (list.containsKey(candidado)) {
					votos += list.get(candidado);
				}
				list.put(candidado, votos);
				line = br.readLine();
			}
			
			for (String key : list.keySet()) {
				System.out.println(key + ": " + list.get(key));
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getStackTrace());
		}
		
		sc.close();
	}

}
