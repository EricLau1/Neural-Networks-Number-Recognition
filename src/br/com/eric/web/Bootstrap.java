package br.com.eric.web;

import java.util.List;

import br.com.eric.custom.Custom;
import br.com.eric.custom.Timestamps;
import br.com.eric.lab.Training;

public class Bootstrap extends Browser {
	
	private String created;

	public Bootstrap() {
		super();	
	}
	
	public Bootstrap(List<Training> t) {
		super();
		this.create(t);
	}
	
	public String html() {
		
		String html = "<!doctype html>" + this.br();
		
		
		html += "<html lang=\"pt-br\">" + this.br();

		html += this.header() + this.br();
		
		html += this.body() + this.br();
		
		html += "</html>";
		
		return html;
		
	}
	
	public String header() {
		
		String head = "<head>" + this.br();

		head += "<meta charset=\"UTF-8\" />" + this.br();
		
		
		head += "<title> Neural Networks - Report </title>" + this.br();
	
		head += "<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">" + this.br();
				
		head += "</head>" + this.br();
		
		return head;
		
	}
	
	public String body() {
		
		String body = "<body>" + this.br();
		
		body += "<div class=\'container\'>" + this.br();
			
		body += "<h1> Reports </h1>" + this.br() + "<hr/>" + this.br();
		
		if(!this.created.equals("")) {
		
			body += this.created + this.br();
		
		}
		
		
		body += this.footer() + this.br();
		
		body += "</div>" + this.br();
		
		body += "</body>" + this.br();
		
		return body;

	}
	
	private String footer() {
		String footer = "<footer class=\'footer text-center\' style=\'padding: 20px;\'>";
		
		Timestamps today = new Timestamps();
		
		footer += "Redes Neurais Artificiais by Eric Lau de Oliveira - " + today.getCreated_at();
		footer += "</footer>" + this.br();
		return footer;
	}
	
	private void create(List<Training> t_results) {
		
		String create = "";
		
		if(t_results.size() > 0) {
			
			for(Training t: t_results) {
				
			
				create += "<h3 class=\'text-dark text-center display-5 \'>" + t.getDescription() + "</h3>" + this.br();
				
				create += "<p class=\'alert alert-info\'> <strong>Target Folder</strong>: <a href=\'"+ t.getFolder() +"\' class=\'btn btn-link\'>" + t.getFolder() + "</a></p>" + this.br();
			
				create += "<p class=\'alert alert-warning\'> Amount Files: <strong>" + t.getSize() + "</strong></p>" + this.br();
				
				create += "<h5 class=\'text-danger\'> arquivos testados:</h5>" + this.br(); 
				
				create += "<table class=\'table table-striped table-hover\'>" + this.br();
				
				create += "<th> Arquivo </th> <th> Resultado </th> <th> Decimal </th> <th> % </td>" + this.br();
				
				for(int i = 0; i < t.getResults().size(); i++) {
					
					
					if(t.getResults().get(i).getResult()) {
						
						create += "<tr class=\'table-success\'>" + this.br();

						create += "<td><a href=\'"+ t.getResults().get(i).getFileName() +"\' class=\'text-success\'>" + t.getResults().get(i).getFileName() + "</a></td>" + this.br();
						
						create += "<td><span class=\'text-success\'><strong>" + t.getResults().get(i).getResult() + "</strong></span></td>" + this.br();
					
						create += "<td><span class=\'text-success\'><strong>" + Custom.doubleFormat(t.getResults().get(i).getPrecision(), ".", 12) + "</strong></span></td>" + this.br();
						
						create += "<td><span class=\'text-success\'><strong>" + Custom.doubleFormat(t.getResults().get(i).getPrecision() * 100,".",0) + "%</strong></span></td>" + this.br();
						
					} else {
						
						create += "<tr>" + this.br();

						create += "<td> <a href=\'"+ t.getResults().get(i).getFileName() +"\' class=\'text-info\'>" + t.getResults().get(i).getFileName() + "</a></td>" + this.br();
						
						create += "<td>" + t.getResults().get(i).getResult() + "</td>" + this.br();
					
						create += "<td>" + Custom.doubleFormat(t.getResults().get(i).getPrecision(), ".", 12) + "</td>" + this.br();
						
						create += "<td>" + Custom.doubleFormat(t.getResults().get(i).getPrecision() * 100,".",0) + "%</td>" + this.br();
							
					}
				
					create += "<tr>" + this.br();
				}
				
				create += "</table>" + this.br();
				
				create += "<hr/>" + this.br() + this.br();
				
			} // end for t_results
			
		}
		
		this.created = create + this.br();
	}
}
