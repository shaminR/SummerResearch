package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class NewProcessView extends JFrame {

	private JPanel contentPane;
	public JButton backButton;
	public JButton bladderButton;
	public JButton lungButton;
	public JButton startButton;

	public NewProcessView() throws IOException {
		//setResizable(false);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); // TODO uncomment
		//setSize(800, 480);
		
		this.setBackground(Color.WHITE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel iconPanel = new JPanel();
		iconPanel.setBorder(null);
		iconPanel.setBackground(Color.WHITE);
		contentPane.add(iconPanel, BorderLayout.NORTH);
		
		URL url = NewProcessView.class.getResource("/logo.jpg");
		BufferedImage pic = ImageIO.read(url);
		ImageIcon image = new ImageIcon(pic);
		Image picture = image.getImage();	
		Image scaledImg = picture.getScaledInstance(105, 75, Image.SCALE_SMOOTH);
        image = new ImageIcon(scaledImg);
		GridBagLayout gbl_iconPanel = new GridBagLayout();
		gbl_iconPanel.columnWidths = new int[] {21, 51, 50, 151, 50, 0};
		gbl_iconPanel.rowHeights = new int[]{80, 0};
		gbl_iconPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_iconPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		iconPanel.setLayout(gbl_iconPanel);
		
		URL url2 = NewProcessView.class.getResource("/backArrow.jpg");
		BufferedImage pic2 = ImageIO.read(url2);
		ImageIcon image2 = new ImageIcon(pic2);
		Image picture2 = image2.getImage();	
		Image scaledImg2 = picture2.getScaledInstance(30, 35, Image.SCALE_SMOOTH);
        image2 = new ImageIcon(scaledImg2);
		backButton = new JButton(image2);
		backButton.setBackground(Color.WHITE);
		backButton.setBorderPainted(false);
		backButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		backButton.setPreferredSize(new Dimension(30, 35));
		backButton.setMinimumSize(new Dimension(50, 50));
		backButton.setMaximumSize(new Dimension(50, 50));
		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.anchor = GridBagConstraints.WEST;
		gbc_backButton.insets = new Insets(0, 0, 0, 5);
		gbc_backButton.gridx = 1;
		gbc_backButton.gridy = 0;
		iconPanel.add(backButton, gbc_backButton);
		JLabel iconLabel = new JLabel(image);
		iconLabel.setBackground(Color.WHITE);
		GridBagConstraints gbc_iconLabel = new GridBagConstraints();
		gbc_iconLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_iconLabel.insets = new Insets(0, 0, 0, 5);
		gbc_iconLabel.gridx = 2;
		gbc_iconLabel.gridy = 0;
		iconPanel.add(iconLabel, gbc_iconLabel);
		
		JLabel titleLabel = new JLabel("New Process");
		titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.anchor = GridBagConstraints.WEST;
		gbc_titleLabel.gridx = 4;
		gbc_titleLabel.gridy = 0;
		iconPanel.add(titleLabel, gbc_titleLabel);
		
		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{260, 259, 0};
		gbl_mainPanel.rowHeights = new int[]{24, 26, 0, 61, 0, 61, 30, 35, 0};
		gbl_mainPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPanel.setLayout(gbl_mainPanel);
		
		JLabel selectLabel = new JLabel("Please Select an Option");
		selectLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
		selectLabel.setBackground(Color.WHITE);
		GridBagConstraints gbc_selectLabel = new GridBagConstraints();
		gbc_selectLabel.anchor = GridBagConstraints.NORTH;
		gbc_selectLabel.insets = new Insets(0, 0, 5, 0);
		gbc_selectLabel.gridx = 1;
		gbc_selectLabel.gridy = 1;
		mainPanel.add(selectLabel, gbc_selectLabel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 2;
		mainPanel.add(verticalStrut_1, gbc_verticalStrut_1);
		
		bladderButton = new JButton("Bladder Cancer Detection");
		bladderButton.setPreferredSize(new Dimension(300, 75));
		bladderButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
		bladderButton.setForeground(Color.DARK_GRAY);
		bladderButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_bladderButton = new GridBagConstraints();
		gbc_bladderButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_bladderButton.insets = new Insets(0, 0, 5, 0);
		gbc_bladderButton.gridx = 1;
		gbc_bladderButton.gridy = 3;
		mainPanel.add(bladderButton, gbc_bladderButton);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 4;
		mainPanel.add(verticalStrut, gbc_verticalStrut);
		
		lungButton = new JButton("Lung Cancer Detection");
		lungButton.setPreferredSize(new Dimension(300, 75));
		lungButton.setForeground(Color.DARK_GRAY);
		lungButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lungButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_lungButton = new GridBagConstraints();
		gbc_lungButton.fill = GridBagConstraints.BOTH;
		gbc_lungButton.insets = new Insets(0, 0, 5, 0);
		gbc_lungButton.gridx = 1;
		gbc_lungButton.gridy = 5;
		mainPanel.add(lungButton, gbc_lungButton);
		
		startButton = new JButton("START");
		startButton.setEnabled(false);
		startButton.setPreferredSize(new Dimension(150, 50));
		startButton.setFont(new Font("SansSerif", Font.BOLD, 20));
		startButton.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_startButton = new GridBagConstraints();
		gbc_startButton.anchor = GridBagConstraints.NORTH;
		gbc_startButton.gridx = 1;
		gbc_startButton.gridy = 7;
		mainPanel.add(startButton, gbc_startButton);
	}

	public void addListeners(ActionListener listener) {
		startButton.addActionListener(listener);
		backButton.addActionListener(listener);
		lungButton.addActionListener(listener);
		bladderButton.addActionListener(listener);
	}
	
	public void errorMessage(String error){
        JOptionPane.showMessageDialog(this, error);
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewProcessView frame = new NewProcessView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
