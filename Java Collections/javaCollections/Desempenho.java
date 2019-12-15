package javaCollections;

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
public class Desempenho extends JFrame {

	public Desempenho(int det, ArrayList<Double> tempo) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Grafico Barra");
		setSize(950, 700);
		setLocationRelativeTo(null);
		criarGrafico(det, tempo);
		setVisible(true);
	}

	public void criarGrafico(int det, ArrayList<Double> tempo) {
		DefaultCategoryDataset barra = new DefaultCategoryDataset();
		int i;
		String collection = "";
		for (i = 0; i < tempo.size(); i++) {
			switch (i) {
			case 0:
				collection = "Vetor";
				break;
			case 1:
				collection = "LinkedList";
				break;
			case 2:
				collection = "ArrayList";
				break;
			case 3:
				collection = "HashSet";
				break;
			case 4:
				collection = "LinkedHashSet";
				break;
			case 5:
				collection = "TreeSet";
				break;
			case 6:
				collection = "HashMap";
				break;
			case 7:
				collection = "LinkedHashMap";
				break;
			case 8:
				collection = "TreeMap";
				break;
			}
			barra.setValue(tempo.get(i), "Collections", collection);
		}
		String tipo = "";
		switch (det) {
		case 1:
			tipo = "JAVA COLLECTIONS - Insercao";
			break;
		case 2:
			tipo = "JAVA COLLECTIONS - Busca";
			break;
		case 3:
			tipo = "JAVA COLLECTIONS - Exclusao";
			break;
		default:
			break;
		}

		JFreeChart grafico = ChartFactory.createBarChart3D(tipo, "Tipos", "Tempo", barra, PlotOrientation.VERTICAL,
				true, true, false);
		ChartPanel painel = new ChartPanel(grafico);
		add(painel);
		CategoryPlot barraItem = grafico.getCategoryPlot();
		for (i = 0; i < tempo.size(); i++) {
			barraItem.getRenderer().setSeriesPaint(i, Color.blue);
		}
	}
}