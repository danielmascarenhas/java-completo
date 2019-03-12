package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Item;

public class Program {

	public static void main(String[] args) {

		File inPath = new File("<caminho>/items.csv");

		new File(inPath.getParent() + "/out").mkdir();
		
		String outPath = inPath.getParent() + "/out/summary.csv";
		
		List<Item> vendas = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(inPath))) {
			String lines = br.readLine();
			while (lines != null) {
				String[] items = lines.split(",");
				vendas.add(new Item(items[0], Double.parseDouble(items[1]), Integer.parseInt(items[2])));
				lines = br.readLine();
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(outPath))) {
				for (Item item : vendas) {
					bw.write(item.getNome() + "," + item.calculaValorTotal());
					bw.newLine();
				}
			} catch (IOException e) {
				System.out.println("Erro na escrita: " + e.getStackTrace());
			}
		
		} catch (IOException e) {
			System.out.println("Erro na leitura: " + e.getStackTrace());
		}
	}
}