package main;

import main.domain.MovieController;
import main.view.InputView;

public class MovieApplication {
    public static void main(String[] args) {
        int selectFunctionNum;  
        
		do {
        	selectFunctionNum = InputView.selectFunction();
         	MovieController.run(selectFunctionNum);
        } while(selectFunctionNum != 8); //input = 4 Á¾·á
    }
}