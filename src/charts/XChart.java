package charts;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler.ChartTheme;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.markers.SeriesMarkers;

/** Creates a simple real-time chart */
public class XChart {

	// double[] xData;
	// double[] yData;
	List<Double> xData;
	List<Double> yData;
	double[][] graphData;
	XYChart chart;
	SwingWrapper<XYChart> sw;

	public XYChart makeLineGraph() throws Exception {
		System.setProperty("xchart.nosys", "true");
		// chart = QuickChart.getChart("A line graph", "Time", "Voltage", "sensor voltage", graphData[0], graphData[1]);
		chart = new XYChartBuilder().width(800).height(600).theme(ChartTheme.Matlab).title("voltage over time").xAxisTitle("time (s)").yAxisTitle("Voltage (V)").build();

		xData = new ArrayList<Double>(20);
		yData = new ArrayList<Double>(20);
		
		for(int i = 0; i < 20; i++){
			xData.add((double)i);
			yData.add(randomGenerator());
		}
		XYSeries series = chart.addSeries("sensor voltages", xData, yData);	
		series.setMarker(SeriesMarkers.NONE);
		series.setLineColor(Color.RED);

		style();

		return chart;
	}

	private void style(){
		chart.getStyler().setLegendPosition(LegendPosition.InsideNE);		
		chart.getStyler().setYAxisMin(0.0);
		chart.getStyler().setYAxisMax(100.0);		
		chart.getStyler().setXAxisMin(xData.get(0)-1.0);
	}

	public void runChart(JPanel panel)throws Exception{
		while(true){
			Thread.sleep(200);

			// graphData = appendedGraph(graphData);
			update();
			chart.updateXYSeries("sensor voltages", xData, yData, null);//, arg3)
			// chart.updateXYSeries("sensor voltage", graphData[0], graphData[1], null);
			panel.revalidate();
			panel.repaint();
			// sw.repaintChart();
		}
	}

	private void update(){
		double lastx = xData.get(xData.size()-1);
		xData.remove(0);
		xData.add(lastx + 1.0);

		yData.remove(0);
		yData.add(randomGenerator());
	}

	@Deprecated
	private double[][] appendedGraph(double[][] arr) {
		double[] xDataNew = new double[arr[0].length];
		double[] yDataNew = new double[arr[1].length];
		int i;
		for(i = 1; i < arr[0].length; i++){
			xDataNew[i-1] = arr[0][i];
			yDataNew[i-1] = arr[1][i];
		}
		xDataNew[arr[0].length-1] = arr[0][arr[0].length-1] + 1;
		yDataNew[arr[1].length-1] = randomGenerator();

		return new double[][] {xDataNew, yDataNew};
	}

	public double randomGenerator() {
		int[] choices = {20, 30, 40};
		int index = new Random().nextInt(choices.length);
		return (double)choices[index];
	}
	public static void main(String[] args) throws Exception {
		System.setProperty("xchart.nosys", "true");
		try {
			XChart chart = new XChart();
			chart.makeLineGraph();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
