package hash;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.data.category.DefaultCategoryDataset;

@SuppressWarnings("serial")
public class Histograma extends JFrame {
	
	public Histograma(int media, int hashs[], int m) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Histograma");
		setSize(950,700);
		setLocationRelativeTo(null);
		criarGrafico(media, hashs, m);
		setVisible(true);
	}
	
	public void criarGrafico(int media, int hashs[], int m) {
		
		DefaultCategoryDataset barra = new DefaultCategoryDataset();
		
		for(int i=0; i<hashs.length;i++) {
			Number vetorHash = hashs[i];
			barra.setValue(vetorHash, i, "");
		}
		
		JFreeChart grafico = ChartFactory.createBarChart("Histograma M = " + m, "", "", barra, PlotOrientation.VERTICAL, false,true,false);
		
		grafico.setBackgroundPaint(Color.green);
		grafico.setBorderPaint(Color.green);
		
		CategoryPlot p = grafico.getCategoryPlot();
		ValueMarker marker = new ValueMarker(media);
		marker.setStroke(new BasicStroke(2));
		marker.setPaint(Color.BLACK);
	    p.addRangeMarker(marker);
		
		ChartPanel painel = new ChartPanel(grafico);
		add(painel);
	}
	
}

