package br.com.eric.core;

import java.io.File;
import java.util.List;

import br.com.eric.custom.Extensions;

public class Treatment {

	public static List<Integer> imageToList(File file) {
		
		try {
		
			// redimenciona a imagem para 32x32
			byte[] resize = Resize.resized(file, 32, 32);
			
			String extension = Extensions.load(file.getName(), true);

			// rotaciona a imagem para esquerda
			byte[] rotate = Rotate.rotate90(resize, Rotate.ROTATE_LEFT, extension);

			// inverte a imagem verticalmente
			byte[] flip = Flip.flip(rotate, Flip.FLIP_VERTICAL, extension);
			
			return Convert.toList(flip);
			
			
		} catch (Exception e) {
			
			System.err.println("Error Treatment class in method imageToList(File):List<>");
		
		}
		return null;
	}
	
	public static byte[] toBytes(File file) {
		
		try {
			
			// redimenciona a imagem para 32x32
			byte[] resize = Resize.resized(file, 32, 32);
			
			String extension = Extensions.load(file.getName(), true);

			// rotaciona a imagem para esquerda
			byte[] rotate = Rotate.rotate90(resize, Rotate.ROTATE_LEFT, extension);

			// inverte a imagem verticalmente
			byte[] flip = Flip.flip(rotate, Flip.FLIP_VERTICAL, extension);
			
			return flip;
			
			
		} catch (Exception e) {
			
			System.err.println("Error Treatment class in method toBytes(File):byte[]");
		
		}
		
		return null;
	}
	
}
