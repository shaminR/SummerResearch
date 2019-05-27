package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import controller.*;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	public JButton newProcessButton;
	public JButton settingsButton;
	public JButton troubleshootButton;
	public JButton helpButton;
	
	public MainMenu() throws IOException {
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setResizable(false);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // TODO uncomment
		//setSize(800, 480);
		
		this.setBackground(Color.WHITE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel iconPanel = new JPanel();
		iconPanel.setBorder(null);
		FlowLayout fl_iconPanel = (FlowLayout) iconPanel.getLayout();
		fl_iconPanel.setAlignment(FlowLayout.LEFT);
		iconPanel.setBackground(Color.WHITE);
		contentPane.add(iconPanel, BorderLayout.NORTH);
		
		URL url = LogoView.class.getResource("/logo.jpg");
		BufferedImage pic = ImageIO.read(url);
		ImageIcon image = new ImageIcon(pic);
		Image picture = image.getImage();	
		Image scaledImg = picture.getScaledInstance(105, 75, Image.SCALE_SMOOTH);
        image = new ImageIcon(scaledImg);
		JLabel iconLabel = new JLabel(image);
		iconLabel.setBackground(Color.WHITE);
		iconPanel.add(iconLabel);
		
		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.CENTER);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		buttonPanel.add(horizontalGlue_1);
		
		newProcessButton = new JButton("New Process");
		newProcessButton.setMinimumSize(new Dimension(150, 100));
		newProcessButton.setMaximumSize(new Dimension(150, 100));
		newProcessButton.setForeground(Color.DARK_GRAY);
		newProcessButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
		newProcessButton.setBackground(Color.WHITE);
		buttonPanel.add(newProcessButton);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		buttonPanel.add(horizontalStrut);
		
		settingsButton = new JButton("Settings");
		settingsButton.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		settingsButton.setMinimumSize(new Dimension(150, 100));
		settingsButton.setMaximumSize(new Dimension(150, 100));
		settingsButton.setForeground(Color.DARK_GRAY);
		settingsButton.setBackground(Color.WHITE);
		settingsButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
		buttonPanel.add(settingsButton);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(10);
		buttonPanel.add(horizontalStrut_1);
		
		troubleshootButton = new JButton("Troubleshoot");
		troubleshootButton.setMinimumSize(new Dimension(150, 100));
		troubleshootButton.setMaximumSize(new Dimension(150, 100));
		troubleshootButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
		troubleshootButton.setForeground(Color.DARK_GRAY);
		troubleshootButton.setBackground(Color.WHITE);
		buttonPanel.add(troubleshootButton);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(10);
		buttonPanel.add(horizontalStrut_2);
		
		helpButton = new JButton("Help");
		helpButton.setMinimumSize(new Dimension(150, 100));
		helpButton.setMaximumSize(new Dimension(150, 100));
		helpButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
		helpButton.setForeground(Color.DARK_GRAY);
		helpButton.setBackground(Color.WHITE);
		buttonPanel.add(helpButton);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		buttonPanel.add(horizontalGlue);
		
		// this.setVisible(true);
	}
	
	public void addListeners(ActionListener listener) {
		newProcessButton.addActionListener(listener);
		troubleshootButton.addActionListener(listener);
		settingsButton.addActionListener(listener);
		helpButton.addActionListener(listener);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
