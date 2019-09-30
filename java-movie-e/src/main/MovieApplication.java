package main;

import main.controller.MovieController;
import main.view.InputView;

public class MovieApplication {
    public static void main(String[] args) {
        int selectFunctionNum;  
        
		do {
        	selectFunctionNum = InputView.selectFunction();
         	MovieController.run(selectFunctionNum);
        } while(selectFunctionNum != 10); 
    }
}