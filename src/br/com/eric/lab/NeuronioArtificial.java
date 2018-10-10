package br.com.eric.lab;

public class NeuronioArtificial {

	public static void main(String[] args) {
		
		double[] entradas = {0, 0, 1};
		double[] pesos = new double[entradas.length];
		double bias = 1.0;
		double soma = 0.0;
		
		for(int i = 0; i < pesos.length; i++) {
			pesos[i] = Math.random();
			soma += entradas[i] * pesos[i]; 
		}
		soma += bias;
		
		double y = (double) 1 / (1 + Math.exp(-soma));
		
		System.out.println(y);
		
	}
}
