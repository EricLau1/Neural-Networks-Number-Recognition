package br.com.eric.view;


import java.time.LocalTime;

import br.com.eric.ann.Perceptron;
import br.com.eric.data.Manager;
import br.com.eric.data.Store;
import br.com.eric.ram.Memory;

public class Run {
	
	// Modifique a quantidade de iterações para ver os restultados do treinamento
	private static final Integer ITERATIONS = 100000;

	public static void main(String[] args) {

		Memory ram = new Memory(ITERATIONS);
		
		for(int i = 0; i < 10; i++) {

			System.out.println("iniciando treinamento -> " + i);
			
			System.out.println("[" + LocalTime.now() + "]");
			
			if (ram.load("" + i)) {
				System.out.println(i + ", Treinado!");
			} else {
				System.out.println(i + ", Falhou.");
			}
			
			System.out.println("[" + LocalTime.now() + "]\n");
		}

		System.out.println("Todos os neuronios foram treinados.");

		int total = ram.getNeurons().size();

		System.out.println("Total de neuronios: " + total);
		
		Report.write(ram, total);
		
		int i = 0;
		
		if(Store.dropAll()) {
		
			System.out.println("Collections excluded");
			
			for(Perceptron p: ram.getNeurons()) {
				
				if(Manager.persist(p, i)) {
					
					System.out.println("\nnew data saved successfully!!");
					
				} else {
					System.err.printf("\nerror save data (%d)\n", i);
				}
				i++;
			}
		}
		

		
	}
}
