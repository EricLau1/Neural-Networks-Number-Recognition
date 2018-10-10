package br.com.eric.lab;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.com.eric.ann.Perceptron;
import br.com.eric.ann.TrainingSet;
import br.com.eric.core.Files;
import br.com.eric.core.Routes;
import br.com.eric.core.Treatment;
import br.com.eric.custom.Custom;

public class Training {

	private Perceptron perceptron;
	private String description;
	private String folder;
	private List<String> files;
	private List<Results> results;
	private List<TrainingSet> images;
	private Integer size;
	
	public void start(Perceptron p, String target, String desc) throws Exception {
		
		if(!p.isTrained()) {
			
			throw new Exception("Artificial Neural Network not is trained.");
			
		} else {
			
			
			this.perceptron = p;
			this.description = desc;
			
			this.images = new ArrayList<>();
			this.results = new ArrayList<>();
			
			String path = Routes.load(target);
			
			this.files = new ArrayList<>();
			this.folder = path;
			
			for(File file: Files.load(path)) {
				
				files.add(file.getAbsolutePath());
				
				//System.out.println(file.getAbsolutePath());
				
				TrainingSet set = new TrainingSet();
				
				set.setInput(Treatment.imageToList(file));
	
				
				this.images.add(set);
				
		
				this.calculate(set, file.getAbsolutePath());
				
				//System.out.println("testing...");

			}
			
			this.size = files.size();
			
			//System.out.println("finished!!!");
			//System.out.println(this.toString());
		}
		
	}
	
	private void calculate(TrainingSet image, String name) {
		
		Results result = new Results();
		
		result.setFileName(name);
		
		Double x = this.perceptron.run(image);
		
		result.setPrecision(x);
		
		boolean y = (x < 0.5)? false : true;
		
		result.setResult(y);
		
		this.results.add(result);
		
	}
	
	@Override
	public String toString() {
		
		String string = "\r\nResultados Obtidos:\r\n\r\n";
		
		string += "Descrição: " + this.description + ",\r\n";
		string += "Diretorio Alvo: " + this.folder + ",\r\n";
		string += "Qtde. Arquivos: " + this.size + ",\r\n";
		string += "Arquivos testados:\r\n";
		
		for(int i = 0; i < this.results.size(); i++) {
		
			string += "[ File: " + this.results.get(i).getFileName() + ", ";
			string += "Resultado: " + this.results.get(i).getResult() + ", ";
			string += "Valor Preciso: ";
			string += Custom.doubleFormat(this.results.get(i).getPrecision(), ".", 12);
			string += " ]\r\n";
		}
		
		string += "\r\n";
		
		return string;
		
	}

	public Perceptron getPerceptron() {
		return perceptron;
	}

	public void setPerceptron(Perceptron perceptron) {
		this.perceptron = perceptron;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public List<String> getFiles() {
		return files;
	}

	public void setFiles(List<String> files) {
		this.files = files;
	}

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	public List<TrainingSet> getImages() {
		return images;
	}

	public void setImages(List<TrainingSet> images) {
		this.images = images;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
}
