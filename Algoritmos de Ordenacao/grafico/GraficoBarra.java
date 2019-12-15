package grafico;
import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import mergeSort.MergeSort;
import mergeSort.StdOut;
import mergeSort.Stopwatch;

public class GraficoBarra extends JFrame {
	
	public GraficoBarra() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Grafico Barra");
		setSize(950,700);
		setLocationRelativeTo(null);
		criarGrafico();
		setVisible(true);
	}
	
	public void criarGrafico() {
		
		DefaultCategoryDataset barra = new DefaultCategoryDataset();
		barra.setValue(0.337, "Selection Sort", "1k");    //1k
		barra.setValue(0.305, "Quick Sort", "1k");        //1k
		barra.setValue(0.286, "Merge Sort", "1k");        //1k
		
		barra.setValue(1.836, "Selection Sort", "10k");   //10k
		barra.setValue(1.533, "Quick Sort", "10k");        //10k
		barra.setValue(1.294, "Merge Sort", "10k");        //10k

		barra.setValue(46.251, "Selection Sort", "50k");   //50k
		barra.setValue(6.022, "Quick Sort", "50k");        //50k
		barra.setValue(5.869, "Merge Sort" , "50k");        //50k
		
		JFreeChart grafico = ChartFactory.createBarChart3D("Algoritmos de Ordenacao", "Tipos", "Tempo (ms)", barra, PlotOrientation.VERTICAL, true,true,false);
		
		CategoryPlot barraItem = grafico.getCategoryPlot();
		barraItem.getRenderer().setSeriesPaint(0, Color.MAGENTA);
		barraItem.getRenderer().setSeriesPaint(1, Color.CYAN);
		barraItem.getRenderer().setSeriesPaint(2, Color.YELLOW);
		
		
		ChartPanel painel = new ChartPanel(grafico);
		add(painel);
	}
	
	public static void main (String[] args) {
		new GraficoBarra();
		
	}
	
}
