package jfreechart;

import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PieChart extends ApplicationFrame {

	public PieChart(String title) {
		super(title);
		setContentPane(createDemoPanel());
	}

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		PieChart demo = new PieChart("Genetic Identity");
		demo.setSize(560, 367);
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}

	public static JPanel createDemoPanel() {
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart);
	}

	private static JFreeChart createChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart("DNA", // chart title
				dataset, // data
				true, // include legend
				false, false);

		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */
		File pieChart = new File("PieChart.jpeg");
		try {
			ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return chart;
	}

	private static PieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Adenin", new Double(20));
		dataset.setValue("Cytosine", new Double(20));
		dataset.setValue("Guanine", new Double(40));
		dataset.setValue("Thymine", new Double(10));
		return dataset;
	}

}
