package br.com.eric.custom;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.imageio.ImageIO;

public class Text {
	
	public static boolean generate(byte[] image, String name) {
		
		Files.make();
		        
		PrintWriter file = null;

		Color color = null;
		
        try {

        	InputStream in = new ByteArrayInputStream(image);
        	
            BufferedImage buff = ImageIO.read(in);

            double avg = 0;

            for(int row = 0; row < buff.getWidth(); row++) {
                for(int col = 0; col < buff.getHeight(); col++) {

                    color = new Color(buff.getRGB(row, col));

                    int r = color.getRed();
                    int g = color.getGreen();
                    int b = color.getBlue();

                    avg += (r * 0.21f + g * 0.71f + b * 0.07f) / 255;        
                    
                }
            }

            avg /= (buff.getHeight() * buff.getWidth());
            
            file = new PrintWriter(Files.DIR + "\\" + name + ".txt");

            for(int row = 0; row < buff.getWidth(); row++) {
                for(int col = 0; col < buff.getHeight(); col++) {

                    color = new Color(buff.getRGB(row, col));

                    int r = color.getRed();
                    int g = color.getGreen();
                    int b = color.getBlue();

                    double lum = (r * 0.21f + g * 0.71f + b * 0.07f) / 255;        
                
                    if (lum <= avg) {

                    	// Preto
                    	file.print(" " + 1);
                    	
                    } else {
                        
                    	// Branco
                    	file.print(" " + 0);
                    }
                }
                file.println("");
            }
            
            file.close();
            
            return true;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		return false;
	}
}
