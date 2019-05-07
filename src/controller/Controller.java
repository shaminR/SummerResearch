package controller;

import View.ChartView;
import view.*;
/**
 * Controller
 */
public class Controller {
    public static void main(String[] args) throws Exception{
        new LogoView();
        Thread.sleep(1000);
        new ChartView();
    }
}