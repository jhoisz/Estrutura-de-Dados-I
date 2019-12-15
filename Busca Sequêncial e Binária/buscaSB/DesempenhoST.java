package buscaSB;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

@SuppressWarnings("serial")
public class DesempenhoST extends JFrame {
	private static int var = 1;
	private static int N, lim;
	
	private static ArrayList<Double> tempoC = new ArrayList<Double>();
	private static ArrayList<Double> tempoE = new ArrayList<Double>();
	
	public DesempenhoST(int det) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Grafico Barra");
		setSize(950,700);
		setLocationRelativeTo(null);
		criarGrafico(det);
		setVisible(true);
	}
	
	public void criarGrafico(int det) {
		DefaultCategoryDataset barra = new DefaultCategoryDataset();
		int i;
		for(i=0; i<tempoC.size(); i++) {
			barra.setValue(tempoC.get(i), "Buscas corretas", "Busca " + (i+1));
		}
		for(i=0; i<tempoC.size(); i++) {
			barra.setValue(tempoE.get(i), "Buscas incorretas", "Busca " + (i+1));
		}
		
		if(det == 1) {
			JFreeChart grafico = ChartFactory.createBarChart3D("Busca Binaria", "Tipos", "Tempo", barra, PlotOrientation.VERTICAL, true,true,false);
			ChartPanel painel = new ChartPanel(grafico);
			add(painel);
			CategoryPlot barraItem = grafico.getCategoryPlot();
			for(i=0; i<lim; i++) {
				barraItem.getRenderer().setSeriesPaint(i, Color.blue);
				i+=2;
			}
			
			for(i=1; i<lim; i++) {
				barraItem.getRenderer().setSeriesPaint(i, Color.red);
				i+=2;
			}
		}else if(det == 2) {
			JFreeChart grafico = ChartFactory.createBarChart3D("Busca Sequencial", "Tipos", "Tempo (ms)", barra, PlotOrientation.VERTICAL, true,true,false);
			ChartPanel painel = new ChartPanel(grafico);
			add(painel);
			
			CategoryPlot barraItem = grafico.getCategoryPlot();
			for(i=0; i<lim; i++) {
				barraItem.getRenderer().setSeriesPaint(i, Color.blue);
				i+=2;
			}
			
			for(i=1; i<lim; i++) {
				barraItem.getRenderer().setSeriesPaint(i, Color.red);
				i+=2;
			}
		}		
	}
	
	public static void main (String[] args) {
		String[] choices = {"Busca binaria", "Busca sequencial"};
		String in = (String) JOptionPane.showInputDialog(null, "Selecione o tipo de busca ", "Buscas", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
    	N = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade N de chaves desejada"));
    	lim = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de dobramentos"));
    	
    	int limite = (int) Math.pow(2, lim-1);
		
    	switch(in) {
			case "Busca binaria":
				while(var<=limite) {
					buscaBin();
				}
				new DesempenhoST(1);
				break;
			case "Busca sequencial":
				while(var<=limite) {
					buscaSeq();
				}
				new DesempenhoST(2);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcao invalida! ");
				break;
			}
		System.out.println(tempoC.size());
		System.out.println(tempoE.size());
		
	}

	public static void buscaBin () { 
        BinarySearchST<Integer, Integer> st = new BinarySearchST<Integer, Integer>();
        int buscasCorretas=0, buscasErradas=0;
    	
    	
    	insereBinaryST(st, var);
    	
    	//busca bem sucedida 10x cada chave
    	
    	Stopwatch timerC = new Stopwatch();
    	for(Integer it: st.keys()) {
    		for(int i=0; i<10; i++) {
    			if(st.contains(it)) {
        			buscasCorretas++;    			
        		}
    		}
    	}
    	tempoC.add(timerC.elapsedTime());
    	
    	//busca mal sucedida 10x cada chave
    	int x = 1;
    	Stopwatch timerE = new Stopwatch();
    	for(@SuppressWarnings("unused") Integer it: st.keys()) {
    		for(int i=0; i<10; i++) {
    			if(!st.contains(N*var+x)) {
        			buscasErradas++;
        			x++;
    			}
    		}	
    	}
    	tempoE.add(timerE.elapsedTime());
    	
    	var*=2;
    	
    	System.out.println("Buscas corretas: " +buscasCorretas);
    	System.out.println("Buscas erradas: " +buscasErradas);

    }

	private static void insereBinaryST(BinarySearchST<Integer, Integer> st, int var) {
		Random gerador = new Random();
    	for(int i=0; i<N*var; i++) {
    		int x;
    		do {
    			x = gerador.nextInt(N*var);
    		}while(st.contains(x));
    		st.put(x, i);
    	}
    	
    	for (Integer it : st.keys()) {
			System.out.println(it);
		}
    }
	
	public static void buscaSeq() { 
	    	SequentialSearchST<Integer, Integer> st = new SequentialSearchST<Integer, Integer>();
	    	
	    	int buscasCorretas=0, buscasErradas=0;
	    		    	
	    	insereSequentialST(st, var);
	    	
	    	//busca bem sucedida 10x cada chave
	    	Stopwatch timerC = new Stopwatch();
	    	for(Integer it: st.keys()) {
	    		for(int i=0; i<10; i++) {
	    			if(st.contains(it)) {
	        			buscasCorretas++;    			
	        		}
	    		}
	    	}
	    	tempoC.add(timerC.elapsedTime());
	    	
	    	//busca mal sucedida 10x cada chave
	    	int x=1;
	    	Stopwatch timerE = new Stopwatch();
	    	for(@SuppressWarnings("unused") Integer it: st.keys()) {
	    		for(int i=0; i<10; i++) {
	    			if(!st.contains(N*var+x)) {
	        			buscasErradas++;
	        			x++;
	    			}
	    		}
	    	}   
	    	tempoE.add(timerE.elapsedTime());
	    	var*=2;
	    	
	    	System.out.println("Buscas corretas: " +buscasCorretas);
	    	System.out.println("Buscas erradas: " +buscasErradas);

	    }
		
		public static void insereSequentialST (SequentialSearchST<Integer, Integer> st, int var) {
	    	Random gerador = new Random();
	    	for(int i=0; i<N*var; i++) {
	    		int x;
	    		do {
	    			x = gerador.nextInt(N*var);
	    		}while(st.contains(x));
	    		st.put(x, i);
	    	}
	    	
	    	for (Integer it : st.keys()) {
				System.out.println(it);
			}
	    	System.out.println();
	    	
	    }
}