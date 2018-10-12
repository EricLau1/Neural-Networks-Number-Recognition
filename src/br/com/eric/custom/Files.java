package br.com.eric.custom;

import java.io.File;

public class Files {

	public static final String DIR = "matrix_files";
	
	public static void make() {
	
		File dir = new File(DIR);
		
		if(!dir.exists()) {
			dir.mkdir();
		}
	}
		
}
