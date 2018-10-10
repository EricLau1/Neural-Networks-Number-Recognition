package br.com.eric.custom;

public class Extensions {

	
	public static String load(String path, boolean extension) {
		
		if(!extension) {
			
			String string = "";
			
			for(int i = 0; i < path.length(); i++) {
				
				if(path.charAt(i) != '.') {
					string += path.charAt(i);
				}else {
					break;
				}
			}
			
			String ex = "";
			for(int i = string.length() - 1; i >= 0; i--) {
				if(string.charAt(i) != '\\') {
					ex += string.charAt(i);
				}else {
					break;
				}
			}
			return ex;
		}
		return path.substring(path.lastIndexOf('.') + 1, path.length());
	}
	
}
