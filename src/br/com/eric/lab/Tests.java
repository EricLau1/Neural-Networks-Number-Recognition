package br.com.eric.lab;

import java.io.File;
import java.util.List;

import br.com.eric.core.Convert;
import br.com.eric.core.Files;
import br.com.eric.core.Flip;
import br.com.eric.core.Resize;
import br.com.eric.core.Rotate;
import br.com.eric.core.Routes;
import br.com.eric.custom.Extensions;
import br.com.eric.custom.Text;
import br.com.eric.images.Images;

public class Tests {

	public static void main(String[] args) {
		
Images image = new Images();
		
		
		try {
			
			String route = Routes.load("all");
			
			for(File files: Files.load(route)) {
				
				String file = files.getAbsolutePath();
				
				System.out.println(Extensions.load(files.getName(), false));
				
				byte[] resize = Resize.resized(new File(file), 32, 32);
				
				System.out.println("resized...");
				
				byte[] rotate = Rotate.rotate90(resize, Rotate.ROTATE_LEFT, "jpg"); 
				
				System.out.println("rotated...");
				
				byte[] flip = Flip.flip(rotate, Flip.FLIP_VERTICAL , "jpg");
				
				System.out.println("inverted...");
				
				if(Text.generate(flip, files.getName())) {
					System.out.println("generated file...");
				}
				
				List<Integer> binary = Convert.toList(flip);
				
				//System.out.println("binary...");
				
				image.setImage(binary);
				
				System.out.println(image.toString());
				
			}
			
		} catch (Exception e) {
			
			System.err.println(e.getMessage());
			
		}


	}

}
