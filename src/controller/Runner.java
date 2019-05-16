package controller;

import view.ChartView;
import view.LogoView;

// import views.*;

public class Runner {

	public static void main(String[] args) throws Exception{
		new LogoView();
		Thread.sleep(1000);
		new ChartView();
	}

}
