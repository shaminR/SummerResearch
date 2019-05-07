package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
    XChart chartWrapper;
    
    JButton press;
    JLabel title= new JLabel("Voltage over time");

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
        this.setLayout(new BorderLayout());
        //to fullscreen on linux
        GraphicsDevice device = this.getGraphicsConfiguration().getDevice();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        press = new JButton("press for fun");
        
        chartPanel = new XChartPanel<XYChart>(chart);
        chartPanel.setBorder(new EmptyBorder(10, 15, 10, 15));
        chartPanel.setDoubleBuffered(true);

        title.setFont(new Font("Sans", Font.PLAIN, 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        
        this.add("Center", chartPanel);
        this.add("South", press);
        this.add("North", title);

        this.pack();
        this.setVisible(true);
        chartWrapper.runChart(chartPanel);
    }
    public static void main(String[] args) {
        ChartView yuh = new ChartView();
    }
}