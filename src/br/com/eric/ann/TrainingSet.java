package br.com.eric.ann;

import java.util.ArrayList;
import java.util.List;

public class TrainingSet {

	private List<Integer> input;
	private Integer output;
	
	public TrainingSet() {
		this.input = new ArrayList<>();
	}
	
	public List<Integer> getInput() {
		return input;
	}
	public void setInput(List<Integer> input) {
		this.input = input;
	}
	public Integer getOutput() {
		return output;
	}
	public void setOutput(Integer output) {
		this.output = output;
	}
	
	public String toJson() {
		String json = "{\n";
		
		if(this.input.size() > 0) {
			json += "\t\"input\":\t";
			
			for(int i = 0; i < this.input.size() - 1; i++) {
				
				json += this.input.get(i) + ", ";
			}
			
			json += this.input.get(this.input.size() - 1) + ",\n";
		
			json += "\t";
			
			json += "\"output\":\t" + this.output + "\n";
		}
		json += "}\n";
		return json;
	}
	
}
