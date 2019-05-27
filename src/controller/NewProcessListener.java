package controller;

import view.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.NewProcessView;

public class NewProcessListener implements ActionListener {

	MainMenu menu;
	NewProcessView view;
	String pressed;
	
	public NewProcessListener(MainMenu menu, NewProcessView view) {
		pressed = "";
		this.menu = menu;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == view.backButton) {
				menu.setVisible(true);
				view.setVisible(false);
			}
			else if(e.getSource() == view.bladderButton) {
				view.lungButton.setBackground(Color.WHITE);
				view.lungButton.setEnabled(true);
				view.bladderButton.setBackground(Color.GREEN);
				view.bladderButton.setEnabled(false);
				pressed = "bladder";
				view.startButton.setEnabled(true);
			}
			else if(e.getSource() == view.lungButton) {
				view.bladderButton.setBackground(Color.WHITE);
				view.bladderButton.setEnabled(true);
				view.lungButton.setBackground(Color.GREEN);
				view.lungButton.setEnabled(false);
				pressed = "lung";
				view.startButton.setEnabled(true);
			}
			else if(e.getSource() == view.startButton) {
				if(pressed.equalsIgnoreCase("")) {
					return;
				}
				if(pressed.equalsIgnoreCase("lung")) {
					view.errorMessage("lung pressed");
				}
				if(pressed.equalsIgnoreCase("bladder")) {
					view.errorMessage("bladder pressed");
				}
				view.lungButton.setBackground(Color.WHITE);
				view.lungButton.setEnabled(true);
				view.bladderButton.setBackground(Color.WHITE);
				view.bladderButton.setEnabled(true);
			}
		} catch (Exception e2) {

		}
	}

}
