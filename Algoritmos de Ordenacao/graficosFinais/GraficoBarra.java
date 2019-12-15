package graficosFinais;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarra extends JFrame {
	
	public GraficoBarra(double tempoM, double tempoQ, double tempoS, int tipo) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Grafico Barra");
		setSize(950, 700);
		setLocationRelativeTo(null);
		criarGrafico(tempoM, tempoQ, tempoS, tipo);
		
		setVisible(true);
	}
	
	public void criarGrafico(double tempoM, double tempoQ, double tempoS, int tipo) {
		
		DefaultCategoryDataset barra = new DefaultCategoryDataset();
		barra.setValue(tempoS, "Selection Sort", "");        
		barra.setValue(tempoQ, "Quick Sort", "");        
		barra.setValue(tempoM, "Merge Sort", "");        

		if(tipo == 1) {
			JFreeChart grafico = ChartFactory.createBarChart3D("Algoritmos de ordenacao \n(Arquivo completo)", "Tipos", "Tempo (ms)", barra, PlotOrientation.VERTICAL, true,true,false);
			CategoryPlot barraItem = grafico.getCategoryPlot();
			barraItem.getRenderer().setSeriesPaint(0, Color.YELLOW);
			barraItem.getRenderer().setSeriesPaint(1, Color.MAGENTA);
			barraItem.getRenderer().setSeriesPaint(2, Color.CYAN);

			grafico.setBackgroundPaint(Color.pink);
			ChartPanel painel = new ChartPanel(grafico);
			add(painel);
		}else if(tipo == 2) {
			JFreeChart grafico = ChartFactory.createBarChart3D("Algoritmos de ordenacao \n(10k)", "Tipos", "Tempo (ms)", barra, PlotOrientation.VERTICAL, true,true,false);
			CategoryPlot barraItem = grafico.getCategoryPlot();
			barraItem.getRenderer().setSeriesPaint(0, Color.YELLOW);
			barraItem.getRenderer().setSeriesPaint(1, Color.MAGENTA);
			barraItem.getRenderer().setSeriesPaint(2, Color.CYAN);
			
			grafico.setBackgroundPaint(Color.pink);
			ChartPanel painel = new ChartPanel(grafico);
			add(painel);
		}else if(tipo == 3) {
			JFreeChart grafico = ChartFactory.createBarChart3D("Algoritmos de ordenacao \n(1k)", "Tipos", "Tempo (ms)", barra, PlotOrientation.VERTICAL, true,true,false);
			CategoryPlot barraItem = grafico.getCategoryPlot();
			barraItem.getRenderer().setSeriesPaint(0, Color.YELLOW);
			barraItem.getRenderer().setSeriesPaint(1, Color.MAGENTA);
			barraItem.getRenderer().setSeriesPaint(2, Color.CYAN);


			grafico.setBackgroundPaint(Color.pink);			
			ChartPanel painel = new ChartPanel(grafico);
			add(painel);
		}
	}
	
	public static void main (String[] args) {		
		
		UIManager.getDefaults().put("OptionPane.background",new Color(255,203,219));
		UIManager.put ("Panel.background", new Color(255,203,219));
		
		int op = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de palavras a serem lidas: \n1 - Grafico do arquivo completo\n2 - Grafico de 10k palavras\n3 - Grafico de 1k palavras\n0 - Sair\nDigite uma opcao: "));
		
		switch(op) {
				case 1:
					//50k
					double tempoQ, tempoM, tempoS;
					
					String[] a = StdIn.readAllStrings();
					String[] aux1 = a.clone();
					String[] aux2 = a.clone();
								        
			    	Stopwatch timerM = new Stopwatch();
			        MergeSort.sort(a);
			        MergeSort.show(a);
			        tempoM = timerM.elapsedTime();
			        
					Stopwatch timerQ = new Stopwatch();
			        Quick.sort(aux1);
			        Quick.show(aux1);
			        tempoQ = timerQ.elapsedTime();
			        
			        Stopwatch timerS = new Stopwatch();
			        Selection.sort(aux2);
			        Selection.show(aux2);
			        tempoS = timerS.elapsedTime();
			        
			        new GraficoBarra(tempoM, tempoQ, tempoS, 1);
				
			        break;
				case 2:
					//10k
					double tempoQ1, tempoM1, tempoS1;
					
					String[] a1 = StdIn.readAllStrings();
					String[] b = new String[10000];

					for(int i = 0; i< 10000; i++) {
						b[i] = a1[i];
					}
					
					String[] aux11 = b.clone();
					String[] aux21 = b.clone();
								        
			    	Stopwatch timerM1 = new Stopwatch();
			        MergeSort.sort(b);
			        MergeSort.show(b);
			        tempoM1 = timerM1.elapsedTime();
			        
					Stopwatch timerQ1 = new Stopwatch();
			        Quick.sort(aux11);
			        Quick.show(aux11);
			        tempoQ1 = timerQ1.elapsedTime();
			        
			        Stopwatch timerS1 = new Stopwatch();
			        Selection.sort(aux21);
			        Selection.show(aux21);
			        tempoS1 = timerS1.elapsedTime();
			        
			        new GraficoBarra(tempoM1, tempoQ1, tempoS1, 2);
				
			        break;
				case 3:
					//1k
					double tempoQ2, tempoM2, tempoS2;
					
					String[] a2 = StdIn.readAllStrings();
					String[] c = new String[1000];
										
					for(int i=0; i<1000; i++) {
						c[i] = a2[i];
					}
					
					String[] aux12 = c.clone();
					String[] aux22 = c.clone();
								        
			    	Stopwatch timerM2 = new Stopwatch();
			        MergeSort.sort(c);
			        MergeSort.show(c);
			        tempoM2 = timerM2.elapsedTime();
			        
					Stopwatch timerQ2 = new Stopwatch();
			        Quick.sort(aux12);
			        Quick.show(aux12);
			        tempoQ2 = timerQ2.elapsedTime();
			        
			        Stopwatch timerS2 = new Stopwatch();
			        Selection.sort(aux22);
			        Selection.show(aux22);
			        tempoS2 = timerS2.elapsedTime();
			        
			        new GraficoBarra(tempoM2, tempoQ2, tempoS2, 3);
				
			        break;

				default:
					return;
		}		
	}
}