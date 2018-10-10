package br.com.eric.core;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resize {

	public static byte[] resized(File image, int width, int height) {

		byte[] img;
		
		try {
			
			BufferedImage original = ImageIO.read(image);
			BufferedImage newImage = new BufferedImage(width, height, original.getType());
			
			Graphics2D g2d = newImage.createGraphics();
			
			g2d.drawImage(original, 0, 0, width, height, null);
			
			g2d.dispose();
			
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			ImageIO.write(newImage, "png", baos);
			
			baos.flush();
			
			img = baos.toByteArray();
			
			baos.close();
			
			return img;
			
		} catch (IOException e) {
			
			System.out.println("...");
			
		}
		
		return null;
	}
}
