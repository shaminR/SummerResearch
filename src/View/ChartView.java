package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.style.Styler.ChartTheme;

import charts.*;

/**
 * ChartView
 */
public class ChartView extends JFrame{
    
    JPanel chartPanel;// = new XChartPanel<Chart>();
    XYChart chart;
    JButton press;
    XChart chartWrapper;

    public ChartView() {
        try {
            chartWrapper = new XChart();
            chart = chartWrapper.makeLineGraph();
            constructFrame();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("error");
        }
    }

    private void constructFrame() throws Exception{
        this.setTitle("ChartPro");
        // this.setSize(800, 480);
        // this.setResizable(true);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setLocationRelativeTo(null);
        this.setBackground(Color.WHITE);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        //to fullscreen on linux
        GraphicsDevice device = this.getGraphicsConfiguration().getDevice();
        // device.setFullScreenWindow(f);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        press = new JButton("press for fun");
        chartPanel = new XChartPanel<XYChart>(chart);
        
        this.add(chartPanel);
        this.add(press);

        this.pack();
        this.setVisible(true);

        chartWrapper.runChart(chartPanel);
    }
    
    public static void main(String[] args) {
        ChartView yuh = new ChartView();
    }
}