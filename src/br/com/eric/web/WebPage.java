package br.com.eric.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.com.eric.lab.Training;

public class WebPage {

	private Bootstrap boot;
	private String url;
	
	private List<Training> t_results;
	
	public WebPage(List<Training> t_results) {

		this.t_results = t_results;
		
		this.boot = new Bootstrap(this.t_results);
	
		this.url = boot.ROOT + "\\index.html";

		this.index();
	
	}

	public void index() {

		PrintWriter index = null;

		try {

			index = new PrintWriter(this.url);

			index.println(boot.html());

			index.flush();

		} catch (Exception e) {

			System.err.println("falha ao criar o arquivo de index.");

		} finally {

			index.close();

		}

	}

	public void start() {

		new Thread() {
			@Override
			public void run() {
				
				try {
				
					Runtime.getRuntime().exec("cmd.exe /c start " + "web\\index.html");
				
				} catch (IOException e) {
					
					e.printStackTrace();
				
				}
			}
		}.run();

	}
	
	
	
	public void mostre() {
		for(Training t: this.t_results) {
			System.out.println(t.toString());
		}
	}
	
	
	
	
}
