package br.com.eric.core;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Flip {

	public static final int FLIP_VERTICAL = 1;
	public static final int FLIP_HORIZONTAL = -1;
	
	public static byte[] flip (byte[] bytes, int side, String type) {
		
		byte[] inverted = null;
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			
			InputStream in = new ByteArrayInputStream(bytes);

			BufferedImage imagem = ImageIO.read(in);
			
			int WIDTH = imagem.getWidth();
			int HEIGHT = imagem.getHeight();
			
			BufferedImage flipped = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

			for(int y = 0; y < HEIGHT; y++) {

				for(int x = 0; x < WIDTH; x++) {

					switch(side) {

					case FLIP_HORIZONTAL:
						flipped.setRGB((WIDTH - 1) - x, y, imagem.getRGB(x, y));
						break;
					case FLIP_VERTICAL:
						flipped.setRGB(x, (HEIGHT - 1) - y, imagem.getRGB(x, y));
						break;

					} // fim switch
				}
			}

			ImageIO.write(flipped, type, baos);
			
			inverted = baos.toByteArray();
			
			baos.close();

			return inverted;
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return null;
		
	}
}
