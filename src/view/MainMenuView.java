package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class MainMenuView extends JFrame {

	JPanel topPanel = new JPanel();
	JPanel buttonPanel = new JPanel();

	JLabel iconLabel;

	JButton newProcessButton = new JButton("New Process");
	JButton settingsButton = new JButton("Settings");
	JButton troubleshootButton = new JButton("Troubleshooting");
	JButton helpButton = new JButton("Help");

	URL url = LogoView.class.getResource("/logo.jpg");

	public MainMenuView() throws Exception {
		this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.WHITE);
		// this.setExtendedState(JFrame.MAXIMIZED_BOTH); // TODO uncomment
		this.setSize(800, 480);  // TODO comment
		this.setLayout(new BorderLayout());
		
		BufferedImage pic = ImageIO.read(url);
		ImageIcon image = new ImageIcon(pic);
		Image picture = image.getImage();	
		Image scaledImg = picture.getScaledInstance(93, 80, Image.SCALE_SMOOTH);
        image = new ImageIcon(scaledImg);
		iconLabel = new JLabel(image);
		
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		topPanel.setBackground(Color.WHITE);
		topPanel.add(iconLabel);

		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		setButtonProperties();
		buttonPanel.add(Box.createHorizontalGlue());
		buttonPanel.add(newProcessButton);
		buttonPanel.add(settingsButton);
		buttonPanel.add(troubleshootButton);
		buttonPanel.add(helpButton);
		buttonPanel.add(Box.createHorizontalGlue());

		this.add("North", topPanel);
		this.add("Center", buttonPanel);

		this.setVisible(true);
	}

	private void setButtonProperties(){
		newProcessButton.setMaximumSize(new Dimension(200, 150));
		newProcessButton.setBackground(Color.WHITE);
		newProcessButton.setFont(new Font("Sans", Font.PLAIN, 20));
		
		settingsButton.setMinimumSize(new Dimension(200, 150));
		settingsButton.setMaximumSize(new Dimension(200, 150));
		settingsButton.setBackground(Color.WHITE);
		settingsButton.setFont(new Font("Sans", Font.PLAIN, 20));
		
		troubleshootButton.setMaximumSize(new Dimension(200, 150));
		troubleshootButton.setBackground(Color.WHITE);
		troubleshootButton.setFont(new Font("Sans", Font.PLAIN, 20));
		
		helpButton.setMaximumSize(new Dimension(200, 150));
		helpButton.setBackground(Color.WHITE);
		helpButton.setFont(new Font("Sans", Font.PLAIN, 20));
	}
	public static void main(String[] args) throws Exception{
		new MainMenuView();
	}

}
