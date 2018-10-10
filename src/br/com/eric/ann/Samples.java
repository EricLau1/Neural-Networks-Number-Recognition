package br.com.eric.ann;

import java.util.ArrayList;
import java.util.List;

import br.com.eric.core.Numeric;

public class Samples {
	
	private List<TrainingSet> trainingSets;
	private Integer number;
	private Integer target;
	private Integer others;
	private Integer total;
	private String description;
	
	public Samples(String number, String description) {
		
		this.trainingSets = new ArrayList<>();
		this.target = 0;
		this.others = 0;
		this.total = 0;
		
		this.number = Integer.parseInt(number);
		
		Numeric numeric = new Numeric(number);
				
		for(List<Integer> target: numeric.getNumbers()) {
			
			TrainingSet set = new TrainingSet();
			set.setInput(target);
			set.setOutput(1);
			
			this.target++;
			this.trainingSets.add(set);
			
		}
		
		for(List<Integer> others: numeric.getOthers()) {
			
			TrainingSet set = new TrainingSet();
			set.setInput(others);
			set.setOutput(0);
			
			this.others++;
			this.trainingSets.add(set);
		}
	
		this.total = this.trainingSets.size();
		this.description = description;
		
	}

	public List<TrainingSet> getTrainingSets() {
		return trainingSets;
	}

	public void setTrainingSets(List<TrainingSet> trainingSets) {
		this.trainingSets = trainingSets;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public Integer getTarget() {
		return target;
	}

	public void setTarget(Integer target) {
		this.target = target;
	}

	public Integer getOthers() {
		return others;
	}

	public void setOthers(Integer others) {
		this.others = others;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toJson() {
		
		String json = "\n{\n";
		
		if(this.trainingSets.size() > 0) {
		
			json +="\t";
			json +="\"description\":\t\"" + this.description + "\",\n";

			json +="\t";
			json += "\"target\":\t" + this.target + ",\n";
			
			json +="\t";
			json += "\"others\":\t" + this.others + ",\n";
			
			json +="\t";
			json += "\"total\":\t" + this.total + "\n";
			
		}
		json += "}\n";
		return json;
	}
	
	public void showSamples() {
		
		if(this.trainingSets.size() > 0) {
			
			for(TrainingSet sample: this.getTrainingSets()) {
			
				System.out.println(sample.toJson());
			}
			
		} else {
			
			System.out.println("Training set is void.");
			
		}
		
	}
	
}
