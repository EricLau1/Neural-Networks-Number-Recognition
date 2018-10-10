package br.com.eric.ann;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.eric.custom.Custom;


/* 
 *  Melhor taxa de Acerto 100000 iterations com Learn rate 0.03 -> 90% de acerto
 *  
 * */
public class Perceptron {

	private List<Double> w;
	private Double b;
	private int size = 0;
	private int iterations;
	private boolean trained;
	private final Double LEARN_RATE = 0.03d;
	private LocalDateTime ini;
	private LocalDateTime end;
	private int target;
	
	private List<TrainingSet> samples;
	
	public Perceptron() {
		
		this.w = new ArrayList<>();
		
		this.b = 0.0;
	
		this.trained = false;
	
	}
	
	public Perceptron(List<TrainingSet> samples, int iterations) {
		
		this.size = samples.get(0).getInput().size();
		this.iterations = iterations;
		
		this.samples = samples;
		this.trained = false;
		
		this.initWeights();
		
	}
	
	private boolean initWeights() {
		
		
		if(this.size != 0) {

			this.w = new ArrayList<>();
			
			for(int i = 0; i < this.size; i++) {
				this.w.add((double) Math.random());
			}
			
			this.b = (double) Math.random();
			
			return true;
		}
		
		return false;
	}
	
	public double run(TrainingSet sample) {
		
		double u = 0.0;
		
		for(int i = 0; i < this.w.size(); i++) {
			
			u += (double)(this.w.get(i) * sample.getInput().get(i));
		}
		u += this.b;
		
		return Activate.sigmoid(u);
		
	}
	
	private void correct(TrainingSet sample) {
		
		double y = this.run(sample);
		
		double err;
		for(int i = 0; i < this.w.size(); i++) {
			
			err = (this.w.get(i) + (sample.getOutput() - y) * sample.getInput().get(i) * this.LEARN_RATE);
			this.w.set(i, err);
		}
		this.b += (sample.getOutput() - y);
	}
	
	public boolean train() {
		
		int count = 0;
		
		this.ini = LocalDateTime.now();
		
		while(count < this.iterations) {
			
			for(int i = 0; i < this.samples.size(); i++) {
				
				this.correct(this.samples.get(i));
			}
			
			count++;
		}
		
		this.end = LocalDateTime.now();
		
		this.trained = true;
		
		
		return this.trained;
	}
	
	public String toJson() {
		
		String json = "{\n";
		json += "\t" + Custom.marks("number") + " :\t" + this.target + ",\n";
		json += "\t" + Custom.marks("trained") + ":\t" + this.trained + ",\n";
		json += "\t" + Custom.marks("size_w") + " :\t" + this.w.size() + ",\n";
		json += "\t" + Custom.marks("weights") + ":\n\t[\n";
		
		for(int i = 0; i < this.w.size(); i++) {
			
			if(i < this.size - 1) {
				json += "\t\t" + Custom.doubleFormat(this.w.get(i), ".") + ",\n";
			} else {
				json += "\t\t" + Custom.doubleFormat(this.w.get(i), ".") + "\n";
			}
			
		}
		json += "\t],\n";
		
		json += "\t" + Custom.marks("bias") + "   :\t" + this.b +"\n}";
		
		return json;
	}
	
	public List<Double> getWeights() {
		return this.w;
	}
	
	public Double getBias() {
		return this.b;
	}
	
	public boolean isTrained() {
		return this.trained;
	}
	
	public List<TrainingSet> getSamples() {
		return this.samples;
	}

	public List<Double> getW() {
		return w;
	}

	public void setW(List<Double> w) {
		this.w = w;
	}

	public Double getB() {
		return b;
	}

	public void setB(Double b) {
		this.b = b;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getIterations() {
		return iterations;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public void setTrained(boolean trained) {
		this.trained = trained;
	}

	public void setSamples(List<TrainingSet> samples) {
		this.samples = samples;
	}

	public Double getLEARN_RATE() {
		return LEARN_RATE;
	}

	public LocalDateTime getIni() {
		return ini;
	}

	public void setIni(LocalDateTime ini) {
		this.ini = ini;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
	
}

