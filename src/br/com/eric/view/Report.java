package br.com.eric.view;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.com.eric.ann.Perceptron;
import br.com.eric.lab.Training;
import br.com.eric.ram.Memory;
import br.com.eric.web.WebPage;

public class Report {
	
	public static void write(Memory ram, int total) {

		try {

			Training test = new Training();

			String path = "relatorios\\";

			for (int j = 0; j < 10; j++) {

				PrintWriter relatory = new PrintWriter(path + "\\" + j + ".txt");

				for (int i = 0; i < total; i++) {

					test.start(ram.getNeurons().get(j), i+"", "Neuronio treinado para reconhecer o [ " + j + " ]");

					relatory.println(test.toString());
					
					relatory.println("");

					relatory.flush();

				}

				relatory.close();

			}

			System.out.println("Relatorios finalizados.");

		} catch (Exception e) {

			System.err.println(e.getMessage());

		}
	}
	
	public static void load(List<Perceptron> nets) {
		
		try {

			String path = "C:\\Users\\eric\\Desktop\\relatorios\\";

			PrintWriter relatory = new PrintWriter(path + "\\new_inputs.txt");
			
			List<Training> lst = new ArrayList<>();
			
			for (int i = 0; i < 10; i++) {

				Training test = new Training();
				
				System.out.println("new input test...");

				test.start(nets.get(i),"new_inputs", "Neuronio treinado para reconhecer [ " + i + " ]");

				relatory.println(test.toString());
				
				relatory.println("");

				System.out.println(i + ", complete!");
				
				lst.add(test);
				
			}

			relatory.flush();

			relatory.close();

			System.out.println("Relatorios finalizados.");

			
			WebPage page = new WebPage(lst);
			//page.mostre();
			page.start();
			
			
		} catch (Exception e) {

			System.err.println(e.getMessage());

		}
		
	}
	

}
