package br.com.eric.web;

import java.io.File;

public class Browser {

	protected final String ROOT = "web";
	
	public Browser() {
		
		if(this.make()) {
			System.out.println("diretório web criado com sucesso!");
		}
		
	}
	
	protected boolean make() {
		
		try {
			
			File folder = new File(this.ROOT);
			
			if(!folder.isDirectory()) {
				
				folder.mkdir();
			
			}
			
			return true;
		
		} catch (Exception e) {
			
			System.out.println("Erro ao criar diretorio web.");
			
		}
		
		return false;
	}
	
	protected String br() {
		return "\n\r";
	}
	
	protected String tab(int x) {
		String space = "\t";
		
		for(int i = 0; i < Math.abs(x); i++) {
			space += "\t";
		}
		return space;
	}
	
}
