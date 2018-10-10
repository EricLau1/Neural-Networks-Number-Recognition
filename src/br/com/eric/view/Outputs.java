package br.com.eric.view;

import java.util.ArrayList;
import java.util.List;

public class Outputs {

	private Boolean output;
	private Double precision;
	
	public Outputs() {
		
	}

	public Boolean getOutput() {
		return output;
	}

	public void setOutput(Boolean output) {
		this.output = output;
	}

	public Double getPrecision() {
		return precision;
	}

	public void setPrecision(Double precision) {
		this.precision = precision;
	}
	
	public static List<Outputs> initOutputsList(final int SIZE) {
		
		List<Outputs> lst = new ArrayList<>();
		
		for(int i = 0; i < SIZE; i++) {
			
			Outputs out = new Outputs();
			out.setOutput(false);
			out.setPrecision(0.0d);
			
			lst.add(out);
		}
		return lst;
	}

}
