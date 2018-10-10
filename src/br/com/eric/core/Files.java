package br.com.eric.core;

import java.io.File;

public class Files {
	
	public static File[] load(String dir) throws Exception {
		
		File directory = new File(dir);
		
		if(!directory.exists()) {
			
			throw new Exception("directory not found.");
			
		}
		
		return directory.listFiles();
	}

}
