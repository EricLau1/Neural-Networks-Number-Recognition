package br.com.eric.icons;

public class Icons {

	private static final String PATH = "icons\\";
	private static final String []IMAGES = {"light", "red", "green"};
	private static final String ANIMATE = "mini-icon.gif";
	
	public static String load(String icon) {
		
		icon = icon.toLowerCase();
		
		for(String image: IMAGES) {
			
			if(image.equals(icon)) {
				return PATH + image + ".png";
			}
			
			if(image.equals(icon)) {
				return PATH + image + ".png";
			}
			
		}
		
		return PATH + IMAGES[0] + ".png";
	}
	
	public static String animate() {
		return PATH + ANIMATE;
	}
	
}
