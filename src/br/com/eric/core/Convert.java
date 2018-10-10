package br.com.eric.core;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Convert {

	public static List<Integer> toList(byte[] image) {
		
		Color cor = null;
        
        List<Integer> list = new ArrayList<>();  

        try {

        	InputStream in = new ByteArrayInputStream(image);
        	
            BufferedImage buff = ImageIO.read(in);

            double media = 0;

            for(int row = 0; row < buff.getWidth(); row++) {
                for(int col = 0; col < buff.getHeight(); col++) {

                    cor = new Color(buff.getRGB(row, col));

                    int r = cor.getRed();
                    int g = cor.getGreen();
                    int b = cor.getBlue();

                    media += (r * 0.21f + g * 0.71f + b * 0.07f) / 255;        
                    
                }
            }

            media /= (buff.getHeight() * buff.getWidth());

            for(int row = 0; row < buff.getWidth(); row++) {
                for(int col = 0; col < buff.getHeight(); col++) {

                    cor = new Color(buff.getRGB(row, col));

                    int r = cor.getRed();
                    int g = cor.getGreen();
                    int b = cor.getBlue();

                    double lum = (r * 0.21f + g * 0.71f + b * 0.07f) / 255;        
                
                    if (lum <= media) {

                    	// Preto
                    	list.add(1);
                    	
                    } else {
                        
                    	// Branco
                    	
                    	list.add(0);
                    }
                }
            }
            
            return list;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;      
	}
	
	
}
