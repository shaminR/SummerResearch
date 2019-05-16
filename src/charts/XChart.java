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

	List<Double> xData;
	List<Double> yData;
	double[][] graphData;
	XYChart chart;
	SwingWrapper<XYChart> sw;
	static double x = 0;

	public XYChart makeLineGraph() throws Exception {
		System.setProperty("xchart.nosys", "true");
		chart = new XYChartBuilder().width(800).height(600).theme(ChartTheme.Matlab).xAxisTitle("time (s)").yAxisTitle("Voltage (V)").build();

		xData = new ArrayList<Double>(10);
		yData = new ArrayList<Double>(10);
		
		for(int i = 0; i < 10; i++){
			xData.add((double)i);
			yData.add(randomGenerator());
		}
		XYSeries series = chart.addSeries("sensor voltages", xData, yData);	
		// series.setMarker(SeriesMarkers.NONE);
		series.setLineColor(Color.RED);

		style();

		return chart;
	}

	private void style(){
		chart.getStyler().setLegendPosition(LegendPosition.InsideNE);		
		chart.getStyler().setYAxisMin(-1.0);
		chart.getStyler().setYAxisMax(1.0);		
		chart.getStyler().setXAxisMin(xData.get(0)+1.0);
		chart.getStyler().setXAxisMax(xData.get(xData.size()-1)+6.0);
	}

	public void runChart(JPanel panel)throws Exception{
		while(true){
			Thread.sleep(300);
			update();
			chart.updateXYSeries("sensor voltages", xData, yData, null);//, arg3)
			panel.revalidate();
			panel.repaint();
		}
	}

	private void update(){
		double lastx = xData.get(xData.size()-1);
		chart.getStyler().setXAxisMin(xData.get(0)+5.0);
		xData.remove(0);
		xData.add(lastx + 1.0);
		
		chart.getStyler().setXAxisMax(xData.get(xData.size()-1)+6.0);

		yData.remove(0);
		yData.add(randomGenerator());
	}

	public double randomGenerator() {
		x+=15;
		return Math.cos(Math.toRadians(x));

		// int[] choices = {20, 30, 40, 50, 60};
		// int index = new Random().nextInt(choices.length);
		// return (double)choices[index];
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
