package br.com.eric.custom;

public class Custom {
	
	public static String marks(String text) {
		return "\""+ text +"\"";
	}

	public static String doubleFormat(Double x, String character) {
		
		return (String.format("%.10f", x)).replaceAll(",", character);
		
	}
	
	public static String doubleFormat(Double x, String character, int qtde) {
		
		return (String.format("%."+ qtde +"f", x)).replaceAll(",", character);
		
	}
}
