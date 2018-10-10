package br.com.eric.core;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Rotate {

	public static final int ROTATE_LEFT = 1;
	public static final int ROTATE_RIGHT = -1;
	
	public static byte[] rotate90(byte[] bytes, int side, String type) {
		
		byte[] rotated = null;
		
		BufferedImage original = null;
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			
			InputStream in = new ByteArrayInputStream(bytes);
			
			original = ImageIO.read(in);
			
			int WIDTH = original.getWidth();
			int HEIGHT = original.getHeight();
			
			BufferedImage image = new BufferedImage(HEIGHT, WIDTH , BufferedImage.TYPE_INT_RGB);

			for(int y = 0; y < HEIGHT; y++) {

				for(int x = 0; x < WIDTH; x++) {

					switch(side) {

					case ROTATE_LEFT :
						image.setRGB(y, (WIDTH - 1) - x, original.getRGB(x, y));
						break;
					case ROTATE_RIGHT :
						image.setRGB((HEIGHT - 1) - y, x, original.getRGB(x, y));

					} // fim switch

				}

			}
			
	        ImageIO.write(image, type, baos);
	        
	        rotated = baos.toByteArray();
		      
	        baos.close();
	        
	        return rotated;
			
		} catch (IOException ex) {
			
			ex.printStackTrace();
			
		}
		
		return null;
	}
	
}
