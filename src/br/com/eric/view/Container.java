package br.com.eric.view;

import java.util.ArrayList;
import java.util.List;

import br.com.eric.ann.Perceptron;
import br.com.eric.ann.TrainingSet;
import br.com.eric.ram.Memory;

public class Container {

	public static List<Perceptron> trained() {
		
		Memory ram = new Memory();
		
		for(int i = 0; i < 10; i++) {
		
			if(ram.load("" + i)) {
				System.out.println(i + ", Treinado.");
			} else {
				System.out.println(i + ", Falhou.");
			}
			
		}
		
		return ram.getNeurons();
	}
	
	public static List<Outputs> run(TrainingSet input, List<Perceptron> p) {
		
		List<Outputs> outputs = new ArrayList<>();
		
		System.out.println("\nOutputs precision percents: \n");
		for(int i = 0; i < p.size(); i++) {
			
			double y = p.get(i).run(input);
			
			
			System.out.printf("\r\n[%d] -> %.12f%%\r\n", i, y);
			
			Outputs out = new Outputs();
			out.setPrecision(y);
			
			boolean response = (y < 0.5)? false : true;
			out.setOutput(response);
			
			outputs.add(out);
		}
		
		return outputs;
		
	}
	
}
