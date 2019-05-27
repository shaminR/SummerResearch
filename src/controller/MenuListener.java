package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.*;

public class MenuListener implements ActionListener {

	MainMenu menu;
	NewProcessView newProcessView;

	public MenuListener(MainMenu menu, NewProcessView newProcessView) {
		this.menu = menu;
		this.newProcessView = newProcessView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource() == menu.newProcessButton) {
				newProcessView.setVisible(true);
				Thread.sleep(100);
				menu.setVisible(false);
			} 
			else if(e.getSource() == menu.settingsButton) {
				
			}
			else if(e.getSource() == menu.troubleshootButton) {
				
			}
			else if(e.getSource() == menu.helpButton) {
				
			}
		}catch(Exception a){
			System.err.println("exception in menu listener");
			a.printStackTrace();
		}
	}

}
