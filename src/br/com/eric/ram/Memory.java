package br.com.eric.ram;

import java.util.ArrayList;
import java.util.List;

import br.com.eric.ann.Perceptron;
import br.com.eric.ann.Samples;

public class Memory {
	
	private List<Perceptron> neurons;
	private int iterations;
	
	public Memory(int iterations) {
		this.neurons = new ArrayList<>();
		this.iterations = iterations;
	}
	
	public Memory() {
		this.neurons = new ArrayList<>();
		this.iterations = 0;
	}
	
	public boolean load(String number) {
		
		Samples sample = new Samples(number, "Numerical Character " + number);
		
		this.iterations = (this.iterations != 0)? this.iterations : 1000;
		
		Perceptron p =  new Perceptron(sample.getTrainingSets(), this.iterations);
		
		if(p.train()) {
			
			this.neurons.add(p);
			
			return true;
		
		}
		
		return false;
	}
	
	public List<Perceptron> getNeurons() {
		return this.neurons;
	}

}
