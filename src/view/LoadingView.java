package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;

public class LoadingView extends JFrame {

	private JPanel contentPane;

	public LoadingView() throws Exception{
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
		
		URL url = LoadingView.class.getResource("/logo.jpg");
		BufferedImage pic = ImageIO.read(url);
		ImageIcon image = new ImageIcon(pic);
		Image picture = image.getImage();	
		Image scaledImg = picture.getScaledInstance(105, 75, Image.SCALE_SMOOTH);
        image = new ImageIcon(scaledImg);
		JLabel iconLabel = new JLabel(image);
		iconLabel.setBackground(Color.WHITE);
		iconPanel.add(iconLabel);
		
		URL gifURL = LoadingView.class.getResource("/loadingSpin3.gif");
		ImageIcon gifImage = new ImageIcon(gifURL);
		gifImage.setImage(gifImage.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

		JPanel middlePanel = new JPanel();
		GridBagLayout gbl_middlePanel = new GridBagLayout();
		gbl_middlePanel.columnWidths = new int[]{350, 100, 0};
		gbl_middlePanel.rowHeights = new int[]{95, 33, 0, 192, 0};
		gbl_middlePanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_middlePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		middlePanel.setLayout(gbl_middlePanel);
		contentPane.add(middlePanel, BorderLayout.CENTER);
		
		Component verticalStrut_1 = Box.createVerticalStrut(70);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 0;
		middlePanel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		JLabel loadingLabel = new JLabel(" Loading...");
		loadingLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		GridBagConstraints gbc_loadingLabel = new GridBagConstraints();
		gbc_loadingLabel.fill = GridBagConstraints.VERTICAL;
		gbc_loadingLabel.insets = new Insets(0, 0, 5, 0);
		gbc_loadingLabel.gridx = 1;
		gbc_loadingLabel.gridy = 1;
		middlePanel.add(loadingLabel, gbc_loadingLabel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 2;
		middlePanel.add(verticalStrut, gbc_verticalStrut);
		JLabel loadingSpingLabel = new JLabel(gifImage);
		GridBagConstraints gbc_loadingSpingLabel = new GridBagConstraints();
		gbc_loadingSpingLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_loadingSpingLabel.gridx = 1;
		gbc_loadingSpingLabel.gridy = 3;
		middlePanel.add(loadingSpingLabel, gbc_loadingSpingLabel);
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadingView frame = new LoadingView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
