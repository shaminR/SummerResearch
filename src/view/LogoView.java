package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

/**
 * LogoView
 */
public class LogoView extends JFrame{
	
	/*URL url = LogoView.class.getResource("img/logo.jpg");
	// BufferedImage pic = ImageIO.read(url);
    ImageIcon image = new ImageIcon(url);
    JLabel label = new JLabel(image);*/
    JPanel panel = new JPanel();    
    JPanel emptyPanel = new JPanel();
    JProgressBar bar = new JProgressBar();

    public LogoView() throws Exception{
    	
    	
    	URL url = LogoView.class.getResource("/logo.jpg");
    	BufferedImage pic = ImageIO.read(url);
        ImageIcon image = new ImageIcon(pic);
        JLabel label = new JLabel(image);
    	
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        GraphicsDevice device = this.getGraphicsConfiguration().getDevice();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        label.setBackground(Color.WHITE);
        emptyPanel.setBackground(Color.WHITE);
        panel.add(label);

        bar.setValue(0);
        bar.setBackground(Color.WHITE);
        bar.setForeground(Color.GREEN);
        bar.setBorder(new LineBorder(Color.WHITE, 3));

        // bar.setSize(100, 10);

        panel.setBackground(Color.WHITE);
        this.add(emptyPanel);
        this.add( panel);
        this.add(bar);
        
        this.pack();
        this.setVisible(true);

        fill();
    }

    private void fill(){
    	try {
            for(int i = 0; i <= 100; i+=10){
                bar.setValue(i+10);
                Thread.sleep(100);
            }
        } catch (Exception e) {}
    }
    public static void main(String[] args)throws Exception {
        new LogoView();   
    }
}