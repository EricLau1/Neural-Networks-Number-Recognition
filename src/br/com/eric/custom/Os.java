package br.com.eric.custom;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Os {

	private final JFileChooser find;
	
	private FileNameExtensionFilter filter;
	
	public String path;
	
	public Os() {
		
		this.find = new JFileChooser();
		
		this.path = "";
		
		this.filter = new FileNameExtensionFilter("Imagens", "png", "jpg", "jpeg");
		
		// Só ira permitir a selecão dos arquivos especificados
		this.find.setFileFilter(filter);
	}
	
	public void open(JButton button) {
		
		this.path = "";
		
		try {
			
			this.find.showOpenDialog(button);
			
			this.path = this.find.getSelectedFile().getAbsolutePath(); 
			
			
		} catch (Exception e) {
			
			System.err.println("Error open file.");
			
		}
	}
	
}
