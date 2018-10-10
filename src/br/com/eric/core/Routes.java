package br.com.eric.core;

public class Routes {

	private static final String PATH = "numbers";
	
	private static String []directories = {
			"all","0","1","2","3","4","5","6","7", "8","9","new_inputs"
	};
	
	
	public static String load(String path) throws Exception {
		
		
		for(String dir: directories) {
			
			if(dir.equals(path)) {
				return PATH + "\\" + dir;
			}
			
		}
		
		throw new Exception("Directory not found.");
		
	}
}
