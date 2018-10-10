package br.com.eric.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.eric.ann.Perceptron;
import br.com.eric.ann.TrainingSet;
import br.com.eric.core.Resize;
import br.com.eric.core.Treatment;
import br.com.eric.custom.Os;
import br.com.eric.custom.Text;
import br.com.eric.data.Store;
import br.com.eric.icons.Colors;
import br.com.eric.icons.Icons;

@SuppressWarnings("serial")
public class UiAnn extends JFrame {

	private JPanel contentPane;

	/*
	 * @Author: Eric Lau de Oliveira, 25/09/18, 15H42
	 * 
	 *  */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UiAnn frame = new UiAnn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	private List<JLabel> icons;
	private List<JLabel> numbers;
	private List<JLabel> percs;
	
	private List<Integer> input = new ArrayList<>();
	private List<Perceptron> nets;

	private List<Outputs> outputs = Outputs.initOutputsList(10);
	
	
	
	public UiAnn() {
		setTitle("Perceptron Recognition Numbers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(30, 30, 37));
		setResizable(false);
		setLocationRelativeTo(null);

		
		JLabel lblImagem = new JLabel("IMAGEM");
		lblImagem.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 32));
		lblImagem.setBackground(new Color(30, 30, 30));
		lblImagem.setForeground(new Color(129, 255, 103));
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setBounds(0, 0, 360, 451);
		lblImagem.setOpaque(true);
		contentPane.add(lblImagem);
		
		JLabel lblZero = new JLabel("icon");
		lblZero.setHorizontalAlignment(SwingConstants.CENTER);
		lblZero.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblZero.setBounds(370, 42, 46, 42);
		lblZero.setForeground(new Color(255,255,255));
		contentPane.add(lblZero);
		
		
		JLabel lblOne = new JLabel("icon");
		lblOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblOne.setForeground(Color.WHITE);
		lblOne.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblOne.setBounds(370, 79, 46, 42);
		contentPane.add(lblOne);
		
		JLabel lblTwo = new JLabel("icon");
		lblTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwo.setForeground(Color.WHITE);
		lblTwo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTwo.setBounds(370, 116, 46, 42);
		contentPane.add(lblTwo);
		
		JLabel lblThree = new JLabel("icon");
		lblThree.setHorizontalAlignment(SwingConstants.CENTER);
		lblThree.setForeground(Color.WHITE);
		lblThree.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblThree.setBounds(370, 153, 46, 42);
		contentPane.add(lblThree);
		
		JLabel lblFour = new JLabel("icon");
		lblFour.setHorizontalAlignment(SwingConstants.CENTER);
		lblFour.setForeground(Color.WHITE);
		lblFour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblFour.setBounds(370, 190, 46, 42);
		contentPane.add(lblFour);
		
		JLabel lblFive = new JLabel("icon");
		lblFive.setHorizontalAlignment(SwingConstants.CENTER);
		lblFive.setForeground(Color.WHITE);
		lblFive.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblFive.setBounds(370, 227, 46, 42);
		contentPane.add(lblFive);
		
		JLabel lblSix = new JLabel("icon");
		lblSix.setHorizontalAlignment(SwingConstants.CENTER);
		lblSix.setForeground(Color.WHITE);
		lblSix.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblSix.setBounds(370, 264, 46, 42);
		contentPane.add(lblSix);
		
		JLabel lblSeven = new JLabel("icon");
		lblSeven.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeven.setForeground(Color.WHITE);
		lblSeven.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblSeven.setBounds(370, 301, 46, 42);
		contentPane.add(lblSeven);
		
		JLabel lblEight = new JLabel("icon");
		lblEight.setHorizontalAlignment(SwingConstants.CENTER);
		lblEight.setForeground(Color.WHITE);
		lblEight.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblEight.setBounds(370, 338, 46, 42);
		contentPane.add(lblEight);
		
		JLabel lblNine = new JLabel("icon");
		lblNine.setHorizontalAlignment(SwingConstants.CENTER);
		lblNine.setForeground(Color.WHITE);
		lblNine.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNine.setBounds(370, 375, 46, 42);
		contentPane.add(lblNine);
		
		JLabel lblNumber0 = new JLabel("0");
		lblNumber0.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber0.setForeground(Color.WHITE);
		lblNumber0.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblNumber0.setBounds(426, 42, 46, 42);
		contentPane.add(lblNumber0);
		
		JLabel lblNumber1 = new JLabel("1");
		lblNumber1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber1.setForeground(Color.WHITE);
		lblNumber1.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblNumber1.setBounds(426, 79, 46, 42);
		contentPane.add(lblNumber1);
		
		JLabel lblNumber2 = new JLabel("2");
		lblNumber2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber2.setForeground(Color.WHITE);
		lblNumber2.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblNumber2.setBounds(426, 116, 46, 42);
		contentPane.add(lblNumber2);
		
		JLabel lblNumber3 = new JLabel("3");
		lblNumber3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber3.setForeground(Color.WHITE);
		lblNumber3.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblNumber3.setBounds(426, 153, 46, 42);
		contentPane.add(lblNumber3);
		
		JLabel lblNumber4 = new JLabel("4");
		lblNumber4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber4.setForeground(Color.WHITE);
		lblNumber4.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblNumber4.setBounds(426, 190, 46, 42);
		contentPane.add(lblNumber4);
		
		JLabel lblNumber5 = new JLabel("5");
		lblNumber5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber5.setForeground(Color.WHITE);
		lblNumber5.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblNumber5.setBounds(426, 227, 46, 42);
		contentPane.add(lblNumber5);
		
		JLabel lblNumber7 = new JLabel("7");
		lblNumber7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber7.setForeground(Color.WHITE);
		lblNumber7.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblNumber7.setBounds(426, 301, 46, 42);
		contentPane.add(lblNumber7);
		
		JLabel lblNumber6 = new JLabel("6");
		lblNumber6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber6.setForeground(Color.WHITE);
		lblNumber6.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblNumber6.setBounds(426, 264, 46,42);
		contentPane.add(lblNumber6);
		
		JLabel lblNumber8 = new JLabel("8");
		lblNumber8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber8.setForeground(Color.WHITE);
		lblNumber8.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblNumber8.setBounds(426, 338, 46, 42);
		contentPane.add(lblNumber8);
		
		JLabel lblNumber9 = new JLabel("9");
		lblNumber9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber9.setForeground(Color.WHITE);
		lblNumber9.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblNumber9.setBounds(426, 375, 46, 42);
		contentPane.add(lblNumber9);
	
		this.icons = new ArrayList<>();
		this.icons.add(lblZero);
		this.icons.add(lblOne);
		this.icons.add(lblTwo);
		this.icons.add(lblThree);
		this.icons.add(lblFour);
		this.icons.add(lblFive);
		this.icons.add(lblSix);
		this.icons.add(lblSeven);
		this.icons.add(lblEight);
		this.icons.add(lblNine);
		
		this.numbers = new ArrayList<>();
		this.numbers.add(lblNumber0);
		this.numbers.add(lblNumber1);
		this.numbers.add(lblNumber2);
		this.numbers.add(lblNumber3);
		this.numbers.add(lblNumber4);
		this.numbers.add(lblNumber5);
		this.numbers.add(lblNumber6);
		this.numbers.add(lblNumber7);
		this.numbers.add(lblNumber8);
		this.numbers.add(lblNumber9);
		
		this.percs = new ArrayList<>();
		
		JLabel lblPercZero = new JLabel("%");
		lblPercZero.setHorizontalAlignment(SwingConstants.LEFT);
		lblPercZero.setForeground(Color.WHITE);
		lblPercZero.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblPercZero.setBounds(480, 42, 91, 42);
		contentPane.add(lblPercZero);
		
		JLabel lblPercOne = new JLabel("%");
		lblPercOne.setHorizontalAlignment(SwingConstants.LEFT);
		lblPercOne.setForeground(Color.WHITE);
		lblPercOne.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblPercOne.setBounds(480, 79, 91, 42);
		contentPane.add(lblPercOne);
		
		JLabel lblPercTwo = new JLabel("%");
		lblPercTwo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPercTwo.setForeground(Color.WHITE);
		lblPercTwo.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblPercTwo.setBounds(482, 116, 89, 42);
		contentPane.add(lblPercTwo);
		
		JLabel lblPercThree = new JLabel("%");
		lblPercThree.setHorizontalAlignment(SwingConstants.LEFT);
		lblPercThree.setForeground(Color.WHITE);
		lblPercThree.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblPercThree.setBounds(482, 153, 89, 42);
		contentPane.add(lblPercThree);
		
		JLabel lblPercFour = new JLabel("%");
		lblPercFour.setHorizontalAlignment(SwingConstants.LEFT);
		lblPercFour.setForeground(Color.WHITE);
		lblPercFour.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblPercFour.setBounds(482, 190, 89, 42);
		contentPane.add(lblPercFour);
		
		JLabel lblPercFive = new JLabel("%");
		lblPercFive.setHorizontalAlignment(SwingConstants.LEFT);
		lblPercFive.setForeground(Color.WHITE);
		lblPercFive.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblPercFive.setBounds(482, 228, 89, 42);
		contentPane.add(lblPercFive);
		
		JLabel lblPercSix = new JLabel("%");
		lblPercSix.setHorizontalAlignment(SwingConstants.LEFT);
		lblPercSix.setForeground(Color.WHITE);
		lblPercSix.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblPercSix.setBounds(482, 264, 89, 42);
		contentPane.add(lblPercSix);
		
		JLabel lblPercSeven = new JLabel("%");
		lblPercSeven.setHorizontalAlignment(SwingConstants.LEFT);
		lblPercSeven.setForeground(Color.WHITE);
		lblPercSeven.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblPercSeven.setBounds(482, 301, 89, 42);
		contentPane.add(lblPercSeven);
		
		JLabel lblPercEight = new JLabel("%");
		lblPercEight.setHorizontalAlignment(SwingConstants.LEFT);
		lblPercEight.setForeground(Color.WHITE);
		lblPercEight.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblPercEight.setBounds(480, 338, 91, 42);
		contentPane.add(lblPercEight);
		
		JLabel lblPercNine = new JLabel("%");
		lblPercNine.setHorizontalAlignment(SwingConstants.LEFT);
		lblPercNine.setForeground(Color.WHITE);
		lblPercNine.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblPercNine.setBounds(482, 375, 89, 42);
		contentPane.add(lblPercNine);
		
		this.percs.add(lblPercZero);
		this.percs.add(lblPercOne);
		this.percs.add(lblPercTwo);
		this.percs.add(lblPercThree);
		this.percs.add(lblPercFour);
		this.percs.add(lblPercFive);
		this.percs.add(lblPercSix);
		this.percs.add(lblPercSeven);
		this.percs.add(lblPercEight);
		this.percs.add(lblPercNine);
		
		this.initPercs();
		
		Colors colors = new Colors();
		
		this.canvas();
		
		this.init();
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				
					Os os = new Os();
					
					os.open(btnOpen);
					
					int w = lblImagem.getWidth();
					int h = lblImagem.getHeight();
					
					lblImagem.setText("");
					
					File file = new File(os.path);

					byte[] img = Resize.resized(file, w, h);

					lblImagem.setIcon(new ImageIcon(img));
					
					
					Text.generate( Treatment.toBytes(file), ""+os.path.hashCode());
					
					input = Treatment.imageToList(file);
					
					TrainingSet set = new TrainingSet();
					set.setInput(input);
					
					System.out.println(set.toJson());
					
					classify(set);
				
					canvas();
					
				} catch (Exception ex) {
					
					System.out.println("canceled...");
					//lblImagem.setIcon(null);
					//lblImagem.setText("IMAGEM");
				}
	
			}
		});
		btnOpen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOpen.setBounds(615, 11, 89, 23);
		btnOpen.setBackground(new Color(0, 0, 0));
		btnOpen.setFocusPainted(false);
		btnOpen.setForeground(colors.getGreen());
		contentPane.add(btnOpen);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(654, 392, 50, 48);
		lblLogo.setText("");
		lblLogo.setIcon(new ImageIcon("icons/Logo-icon.png"));
		
		contentPane.add(lblLogo);
		
		JButton btnGenerate = new JButton("Relat\u00F3rios");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Report.load(nets);
			}
		});
		btnGenerate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenerate.setForeground(new Color(129, 255, 103));
		btnGenerate.setFocusPainted(false);
		btnGenerate.setBackground(Color.BLACK);
		btnGenerate.setBounds(615, 42, 89, 23);
		contentPane.add(btnGenerate);
		
		
	}
	
	private void init() {
		
		try {
			
			this.nets = Store.findAll();
			
			if(this.nets != null) {
				
				System.out.println("\ndados coletados do banco de dados.");
			
			} else {
				
				System.out.println("\niniciando novo treinamento.");
				
				this.nets = Container.trained();
				
			}
			
		
		} catch (Exception e) {
			
			System.err.println("\nnão conseguiu ler os dados do mongodb.\n");
		
		}
		
	}
	
	private void classify(TrainingSet set) {
		
		if(this.input != null) {
		
			this.outputs = Container.run(set, this.nets);
		
		} else {
			
			System.out.println("não possui valores de entrada.");
			
		}
		
	}
	
	private void canvas() {
		
		for(int i = 0; i < this.icons.size(); i++) {
			
			this.icons.get(i).setText("");
			
			if(this.outputs.get(i).getOutput()) {
				
				this.icons.get(i).setIcon(new ImageIcon(Icons.animate()));
			
			} else {
			
				this.icons.get(i).setIcon(new ImageIcon(Icons.load("red")));
			
			}
			
			if(!this.input.isEmpty()) {
				
				double p = this.outputs.get(i).getPrecision() * 100;
				
				String format = String.format("%.0f%%", p);
				
				if(p >= 1.0) {
					this.percs.get(i).setText(format);
				} else {
					this.percs.get(i).setText("");
				}
				
				
			}
			
			
		}
	
		for(JLabel label: this.numbers) {
			label.setForeground(new Color(218, 247, 166));
		}
	}
	
	private void initPercs() {
		for(JLabel label: this.percs) {
			label.setText("");
		}
	}
}
