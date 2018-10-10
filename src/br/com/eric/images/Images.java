package br.com.eric.images;

import java.util.List;

public class Images {

	private List<Integer> image;
	
	public void setImage(List<Integer> image) {
		this.image = image;
	}
	
	public List<Integer> getImage() {
		return this.image;
	}
	
	@Override
	public String toString() {
	
		String string = "{ ";
		
		if(this.image != null) {
			for(int i = 0; i < this.image.size(); i++) {
				
				if(i < this.image.size() - 1) {
					string += this.image.get(i) + ", ";
				} else {
					string += this.image.get(i);
				}
			}
			
		}
		
		string += " }\n";
		
		return string;
		
	}
}
