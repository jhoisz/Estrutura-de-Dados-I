package graficosFinais;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarraErro extends JFrame {
	
	public GraficoBarraErro(double tempo1, double tempo2, double tempo3, int tipo) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Grafico Barra");
		setSize(950,700);
		setLocationRelativeTo(null);
		criarGrafico(tempo1,tempo2,tempo3,tipo);
		setVisible(true);
	}
	
	public void criarGrafico(double tempo1, double tempo2, double tempo3, int tipo) {
		
		DefaultCategoryDataset barra = new DefaultCategoryDataset();
		
		if(tipo==1) {
			barra.setValue(tempo1, "Quick Sort", "1k");
			barra.setValue(tempo2, "Merge Sort", "1k");
			barra.setValue(tempo3, "Selection Sort", "1k");
		}else {
			if(tipo==2) {
				barra.setValue(tempo1, "Quick Sort", "10k");
				barra.setValue(tempo2, "Merge Sort", "10k");
				barra.setValue(tempo3, "Selection Sort", "10k");
			}else {
				barra.setValue(tempo1, "Quick Sort", "50k");
				barra.setValue(tempo2, "Merge Sort", "50k");
				barra.setValue(tempo3, "Selection Sort", "50k");
			}
		}
		
		
		
		JFreeChart grafico = ChartFactory.createBarChart3D("Algoritmos de Ordenacao", "Tipos", "Tempo (ms)", barra, PlotOrientation.VERTICAL, true,true,false);
		
		CategoryPlot barraItem = grafico.getCategoryPlot();
		barraItem.getRenderer().setSeriesPaint(0, Color.MAGENTA);
		barraItem.getRenderer().setSeriesPaint(1, Color.CYAN);
		barraItem.getRenderer().setSeriesPaint(2, Color.YELLOW);
		
		
		ChartPanel painel = new ChartPanel(grafico);
		add(painel);
	}
	
	public static void main (String[] args) {
		double tempo1, tempo2, tempo3;
		double x1,x2,x3;
		double y1,y2,y3;
		int op=1;
		
		while(op!=0) {
			op = Integer.parseInt(JOptionPane.showInputDialog("1 - Grafico 1k\n2 - Grafico 10k\n3 - Grafico 50k\n0 - Sair\nDigite uma opcao"));
			switch(op) {
			case 1:
				String[] a1 = StdIn.readAllStrings();
				String[] b1 = new String[1000];
		    	for(int i=0;i<1000;i++) {
		    		b1[i] = a1[i];
		    	}
		    	String[] c1 = b1.clone();
				String[] d1 = b1.clone();
				
		    	Stopwatch cont1 = new Stopwatch();//quickSort 1k
		        Quick.sort(b1);
		        Quick.show(b1);
		        tempo1 = cont1.elapsedTime();
		        
		    	Stopwatch cont2 = new Stopwatch(); //mergeSort 1k
		        MergeSort.sort(c1);
		        MergeSort.show(c1);
		        tempo2 = cont2.elapsedTime();
		        
		        Stopwatch cont3 = new Stopwatch(); //selectionSort 1k
		        Selection.sort(d1);
		        Selection.show(d1);
		        tempo3 = cont3.elapsedTime();
		        
		        new GraficoBarraErro(tempo1,tempo2,tempo3,1);
				break;
				
			case 2:
				String[] a2 = StdIn.readAllStrings();
				String[] b2 = new String[10000];
		    	for(int i=0;i<10000;i++) {
		    		b2[i] = a2[i];
		    	}
		    	String[] c2 = b2.clone();
				String[] d2 = b2.clone();
				
				Stopwatch op1 = new Stopwatch();//quickSort 1k
		        Quick.sort(b2);
		        Quick.show(b2);
		        x1 = op1.elapsedTime();
		        
		    	Stopwatch op2 = new Stopwatch(); //mergeSort 100k
		        MergeSort.sort(c2);
		        MergeSort.show(c2);
		        x2 = op2.elapsedTime();
		        
		        Stopwatch op3 = new Stopwatch(); //selectionSort 10k
		        Selection.sort(d2);
		        Selection.show(d2);
		        x3 = op3.elapsedTime();
		        
		        new GraficoBarraErro(x1,x2,x3,2);
				
				break;
				
			case 3:
				String[] a3 = StdIn.readAllStrings();
				String[] aux1 = a3.clone();
				String[] aux2 = a3.clone();
				
				Stopwatch timer1 = new Stopwatch(); //quickSort 50k
		        Quick.sort(a3);
		        Quick.show(a3);
		        y1 = timer1.elapsedTime();
		        
		        Stopwatch timer2 = new Stopwatch(); //mergeSort 50k
		        MergeSort.sort(aux1);
		        MergeSort.show(aux1);
		        y2 = timer2.elapsedTime();
		        
		        Stopwatch timer3 = new Stopwatch(); //selectionSort 50k
		        Selection.sort(aux2);
		        Selection.show(aux2);
		        y3 = timer3.elapsedTime();
		        
				new GraficoBarraErro(y1,y2,y3,3);
				break;
				
			default:
				return;
			}
		}
	}
}




/*package graficosFinais;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import mergeSort.MergeSort;
import mergeSort.StdIn;
import mergeSort.StdOut;
import mergeSort.Stopwatch;

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
		barra.setValue(tempoM, "Merge Sort", "");        
		barra.setValue(tempoQ, "Quick Sort", "");        
		barra.setValue(tempoS, "Selection Sort", "");        
		if(tipo == 1) {
			JFreeChart grafico = ChartFactory.createBarChart3D("Algoritmos de ordenacao \n(Arquivo completo)", "Tipos", "Tempo (ms)", barra, PlotOrientation.VERTICAL, true,true,false);
			CategoryPlot barraItem = grafico.getCategoryPlot();
			barraItem.getRenderer().setSeriesPaint(0, Color.YELLOW);
			barraItem.getRenderer().setSeriesPaint(1, Color.MAGENTA);
			barraItem.getRenderer().setSeriesPaint(2, Color.CYAN);

			
			ChartPanel painel = new ChartPanel(grafico);
			add(painel);
		}else if(tipo == 2) {
			JFreeChart grafico = ChartFactory.createBarChart3D("Algoritmos de ordenacao \n(10k)", "Tipos", "Tempo (ms)", barra, PlotOrientation.VERTICAL, true,true,false);
			CategoryPlot barraItem = grafico.getCategoryPlot();
			barraItem.getRenderer().setSeriesPaint(0, Color.YELLOW);
			barraItem.getRenderer().setSeriesPaint(1, Color.MAGENTA);
			barraItem.getRenderer().setSeriesPaint(2, Color.CYAN);

			
			ChartPanel painel = new ChartPanel(grafico);
			add(painel);
		}else if(tipo == 3) {
			JFreeChart grafico = ChartFactory.createBarChart3D("Algoritmos de ordenacao \n(1k)", "Tipos", "Tempo (ms)", barra, PlotOrientation.VERTICAL, true,true,false);
			CategoryPlot barraItem = grafico.getCategoryPlot();
			barraItem.getRenderer().setSeriesPaint(0, Color.YELLOW);
			barraItem.getRenderer().setSeriesPaint(1, Color.MAGENTA);
			barraItem.getRenderer().setSeriesPaint(2, Color.CYAN);

			
			ChartPanel painel = new ChartPanel(grafico);
			add(painel);
		}
	}
	
	public static void main (String[] args) {		
		/*
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
					double tempoQ2, tempoM2, tempoS2;
					String[] a2 = StdIn.readAllStrings();
					String[] b2 = new String[10000];
					
			    	for(int i=0;i<10000;i++) {
			    			b2[i] = a2[i];
			    	}		

					String[] aux12 = b2.clone();
					String[] aux22 = b2.clone();

					Stopwatch timerM2 = new Stopwatch();
			        MergeSort.sort(a2);
			        MergeSort.show(a2);
			        tempoM2 = timerM2.elapsedTime();
					
			    	Stopwatch timerQ2 = new Stopwatch();
			        Quick.sort(aux12);
			        Quick.show(aux12);
			        tempoQ2 = timerQ2.elapsedTime();
			        
			        Stopwatch timerS2 = new Stopwatch();
			        Selection.sort(aux22);
			        Selection.show(aux22);
			        tempoS2 = timerS2.elapsedTime();
			        
			        new GraficoBarra(tempoM2, tempoQ2, tempoS2, 2);
				
			        break;
				case 3:
					//1k
					double tempoQ3, tempoM3, tempoS3;
					String[] a3 = StdIn.readAllStrings();
					String[] b3 = new String[1000];
					
			    	for(int i=0;i<1000;i++) {
			    			b3[i] = a3[i];
			    	}		

					String[] aux13 = b3.clone();
					String[] aux23 = b3.clone();

					Stopwatch timerM3 = new Stopwatch();
			        MergeSort.sort(a3);
			        MergeSort.show(a3);
			        tempoM3 = timerM3.elapsedTime();
					
			    	Stopwatch timerQ3 = new Stopwatch();
			        Quick.sort(aux13);
			        Quick.show(aux13);
			        tempoQ3 = timerQ3.elapsedTime();
			        
			        Stopwatch timerS3 = new Stopwatch();
			        Selection.sort(aux23);
			        Selection.show(aux23);
			        tempoS3 = timerS3.elapsedTime();
			        
			        new GraficoBarra(tempoM3, tempoQ3, tempoS3, 3);
				
			        break;

				default:
					return;
		}
		
		double tempo1, tempo2, tempo3;
		double x1,x2,x3;
		double y1,y2,y3;
		int	op = Integer.parseInt(JOptionPane.showInputDialog("1 - Grafico 1k\n2 - Grafico 10k\n3 - Grafico 50k\n0 - Sair\nDigite uma opcao"));
			switch(op) {
			case 1:
				String[] a1 = StdIn.readAllStrings();
				String[] b1 = new String[1000];
		    	for(int i=0;i<1000;i++) {
		    		b1[i] = a1[i];
		    	}
		    	String[] c1 = b1.clone();
				String[] d1 = b1.clone();
				
		    	Stopwatch cont1 = new Stopwatch();//quickSort 1k
		        Quick.sort(b1);
		        Quick.show(b1);
		        tempo2 = cont1.elapsedTime();
		        
		    	Stopwatch cont2 = new Stopwatch(); //mergeSort 1k
		        MergeSort.sort(c1);
		        MergeSort.show(c1);
		        tempo1 = cont2.elapsedTime();
		        
		        Stopwatch cont3 = new Stopwatch(); //selectionSort 1k
		        Selection.sort(d1);
		        Selection.show(d1);
		        tempo3 = cont3.elapsedTime();
		        
		        new GraficoBarra(tempo1,tempo2,tempo3,1);
				break;
				
			case 2:
				String[] a2 = StdIn.readAllStrings();
				String[] b2 = new String[10000];
		    	for(int i=0;i<10000;i++) {
		    		b2[i] = a2[i];
		    	}
		    	String[] c2 = b2.clone();
				String[] d2 = b2.clone();
				
				Stopwatch op1 = new Stopwatch();//quickSort 1k
		        Quick.sort(b2);
		        Quick.show(b2);
		        x2 = op1.elapsedTime();
		        
		    	Stopwatch op2 = new Stopwatch(); //mergeSort 100k
		        MergeSort.sort(c2);
		        MergeSort.show(c2);
		        x1 = op2.elapsedTime();
		        
		        Stopwatch op3 = new Stopwatch(); //selectionSort 10k
		        Selection.sort(d2);
		        Selection.show(d2);
		        x3 = op3.elapsedTime();
		        
		        new GraficoBarra(x1,x2,x3,2);
				
				break;
				
			case 3:
				String[] a3 = StdIn.readAllStrings();
				String[] aux1 = a3.clone();
				String[] aux2 = a3.clone();
				
				Stopwatch timer1 = new Stopwatch(); //quickSort 50k
		        Quick.sort(a3);
		        Quick.show(a3);
		        y2 = timer1.elapsedTime();
		        
		        Stopwatch timer2 = new Stopwatch(); //mergeSort 50k
		        MergeSort.sort(aux1);
		        MergeSort.show(aux1);
		        y1 = timer2.elapsedTime();
		        
		        Stopwatch timer3 = new Stopwatch(); //selectionSort 50k
		        Selection.sort(aux2);
		        Selection.show(aux2);
		        y3 = timer3.elapsedTime();
		        
				new GraficoBarra(y1,y2,y3,3);
				break;
				
			default:
				return;
			}
		}		
		
	}*/