package br.com.eric.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import br.com.eric.custom.Extensions;

public class Numeric {

	private List<List<Integer>> numbers;
	private List<List<Integer>> others;

	private boolean full = false;

	public Numeric(String number) {

		this.numbers = new ArrayList<>();

		try {

			// verifica se o numero existe na lista de diretorios
			String path = Routes.load(number);

			// percorre a lista de arquivos do diretorio
			for (File files : Files.load(path)) {

				// pega o caminho do arquivo no diretorio
				String file = files.getAbsolutePath();

				// o parametro true retona apenas a extensão do arquivo
				String extension = Extensions.load(files.getName(), true);

				// redimenciona a imagem para 32x32
				byte[] resize = Resize.resized(new File(file), 32, 32);

				// rotaciona a imagem para esquerda
				byte[] rotate = Rotate.rotate90(resize, Rotate.ROTATE_LEFT, extension);

				// inverte a imagem verticalmente
				byte[] flip = Flip.flip(rotate, Flip.FLIP_VERTICAL, extension);

				// converte a imagem para uma lista binária
				List<Integer> binary = Convert.toList(flip);

				this.numbers.add(binary);
			} // end for
			
			//System.out.println("target (" + number +"), loaded successfully.");

			this.others = new ArrayList<>();
			
			
			
			for(int i = 0; i < 10; i++) {
				
				
				path = Routes.load("" + i);
				
				if( !("" + i).equals(number)) {
			

					//System.out.println("Other numbers load...");
					for (File files : Files.load(path)) {

						// o parametro false retona o nome sem a extensão do arquivo
						if (! (Extensions.load(files.getName(), false).equals(number)) ) {

							// pega o caminho do arquivo no diretorio
							String file = files.getAbsolutePath();

							// o parametro true retona apenas a extensão do arquivo
							String extension = Extensions.load(files.getName(), true);

							// redimenciona a imagem para 32x32
							byte[] resize = Resize.resized(new File(file), 32, 32);

							// rotaciona a imagem para esquerda
							byte[] rotate = Rotate.rotate90(resize, Rotate.ROTATE_LEFT, extension);

							// inverte a imagem verticalmente
							byte[] flip = Flip.flip(rotate, Flip.FLIP_VERTICAL, extension);

							// converte a imagem para uma lista binária
							List<Integer> binary = Convert.toList(flip);
							
							this.others.add(binary); 

							//System.out.println("\n" + Extensions.load(files.getName(), false) + ", loaded successfully.");
							
						} else {
							//System.out.println("\n" + Extensions.load(files.getName(), false) + ", ignored.");	
						}
						
					} // end for
					
					//System.out.println("Os arquivos foram lidos com sucesso!");
					
					this.full = true;

					
				}
							
				
			}
	
	
			
		} catch (Exception e) {

			System.err.println("ERRO: " + e.getMessage());

		}

	}



	public void pretty() {

		System.out.println("Number Target: ");
		for (List<Integer> list : this.numbers) {

			String vector = "\n[";
			int count = 0;

			for (Integer number : list) {

				if (count < list.size() - 1) {
					vector += number + ", ";
				} else {
					vector += number + "]";
				}

				count++;
			}
			System.out.println(vector);
		}

		System.out.println("\nOther numbers: ");
		
		for (List<Integer> list : this.others) {

			String vector = "\n[";
			int count = 0;

			for (Integer number : list) {

				if (count < list.size() - 1) {
					vector += number + ", ";
				} else {
					vector += number + "]";
				}

				count++;
			}
			System.out.println(vector);
		}
	}

	public List<List<Integer>> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<List<Integer>> numbers) {
		this.numbers = numbers;
	}

	public List<List<Integer>> getOthers() {
		return this.others;
	}

	public void setIgnore(List<List<Integer>> others) {
		this.others = others;
	}

	public void setFull(boolean full) {
		this.full = full;
	}
	
	public boolean getFull() {
		return this.full;
	}

}
