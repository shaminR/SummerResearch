package controller;

import view.*;
import controller.*;

public class Runner {

	public static void main(String[] args) {
		try {
			
			LogoView logo = new LogoView();
			logo.runLogo();
			
			LoadingView loading = new LoadingView();
			loading.setFocusableWindowState(false);
			loading.toBack();
			loading.setVisible(true);
			
			MainMenu menu = new MainMenu();
			NewProcessView newProcessView = new NewProcessView();
	
			MenuListener menuListener = new MenuListener(menu, newProcessView);
			NewProcessListener newProcessListener = new NewProcessListener(menu, newProcessView);
			
			newProcessView.addListeners(newProcessListener);
			menu.addListeners(menuListener);
			menu.setVisible(true);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
