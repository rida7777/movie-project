package main.controller;

import java.util.List;

import main.domain.Customer;
import main.domain.Movie;
import main.domain.MovieRepository;
import main.service.MovieService;
import main.view.InputView;
import main.view.OutputView;

public class MovieController {

	public static void run(int selectFunctionNum) {
		List<Movie> movies = MovieRepository.getMovies();
		
		if(selectFunctionNum == 1) {
			OutputView.printMovies(movies);
		}
		
		if(selectFunctionNum == 2) {
    		String movieInfo = InputView.createMovie();
    		MovieService.addMovie(movieInfo);
    		System.out.println("<��ȭ�� ���������� �߰��߽��ϴ�.>");
    		OutputView.printMovies(movies);
    	}
    	
		if(selectFunctionNum == 3) {
			OutputView.printMovies(movies);
			Movie selectedMovie = MovieService.getMovieByMovieId();
    		String scheduleInfo = InputView.createSchedule();
    		MovieService.addMovieSchedule(selectedMovie, scheduleInfo);
    		System.out.println("<�������� ���������� �߰��߽��ϴ�.>");
    		OutputView.printMovies(movies);
    	}
		
		if(selectFunctionNum == 4) {
			OutputView.printMovies(movies);
			Movie selectedMovie = MovieService.getMovieByMovieId();
			MovieService.removeMovie(selectedMovie);
			System.out.println("<��ȭ�� ���������� �����߽��ϴ�.>");
    		OutputView.printMovies(movies);
		}
		
		if(selectFunctionNum == 5) {
			OutputView.printMovies(movies);
			Movie selectedMovie = MovieService.getMovieByMovieId();
			int removeScheduleIndex = InputView.getScheduleIndex();
			MovieService.removeMovieSchedule(selectedMovie, removeScheduleIndex);
			System.out.println("<�������� ���������� �����߽��ϴ�.>");
    		OutputView.printMovies(movies);
		}
    	
    	if(selectFunctionNum == 6) {
    		OutputView.printMovies(movies);
    		Movie selectedMovie = MovieService.getMovieByMovieId();
    		int customerNum = MovieService.getCustomerNum(selectedMovie);
    		OutputView.printCustomerNum(selectedMovie, customerNum);
    	}
    	
    	if(selectFunctionNum == 7) {
    		OutputView.printMovies(movies);
    		Movie selectedMovie = MovieService.getMovieByMovieId();
			int scheduleIndex = InputView.getScheduleIndex();
			String customerInfo = InputView.createCustomer();
			MovieService.addCustomer(selectedMovie, scheduleIndex, customerInfo);
			System.out.println("<���Ű� �Ϸ�ƽ��ϴ�.>");
    	}
    	
    	if(selectFunctionNum == 8) {
    		OutputView.printMovies(movies);  		
    		Movie selectedMovie = MovieService.getMovieByMovieId();
			int scheduleIndex = InputView.getScheduleIndex();
    		List<Customer> customers = MovieService.getCustomer(selectedMovie, scheduleIndex);
    		OutputView.printCustomers(customers);
    		int customerIndex = InputView.getCustomerIndex();
    		MovieService.removeCustomer(selectedMovie, scheduleIndex, customerIndex);
    		System.out.println("<���Ű� ��ҵƽ��ϴ�.>");
    	}
    	
    	if(selectFunctionNum == 9) {
    		OutputView.printMovies(movies);
    		Movie selectedMovie = MovieService.getMovieByMovieId();
			int scheduleIndex = InputView.getScheduleIndex();
    		List<Customer> customers = MovieService.getCustomer(selectedMovie, scheduleIndex);
    		OutputView.printCustomers(customers);
    	}
	}	
	
	//����ó�� -> ��Ű�� ���� �ϳ� �����
	//selectFunctionNum�� 1 2 3 4�� �ϳ����� �Ѵ�.
	public static void checkVaildFunctionNum(int selectFunctionNum) {
		if (selectFunctionNum != 1 && selectFunctionNum != 2 && selectFunctionNum != 3  && selectFunctionNum != 4)  {
			throw new IllegalArgumentException();
		}
	}

	// id name price Ÿ���� �� �ִ´ٰ� �����ϰ�, �Է� ����Ȯ��
	public static void checkVaildMovieInfo(String movieInfo) {
		String[] movieInfos = movieInfo.split(" ");
		if (movieInfos.length != 3) {
			throw new IllegalArgumentException();
		}
	}

	// Ÿ���� �� �ִ´ٰ� �����ϰ�, �Է� ����Ȯ��
	public static void checkVaildScheduleInfo(String scheduleInfo) {
		String[] scheduleInfos = scheduleInfo.split("_");
		if (scheduleInfos.length != 2) {
			throw new IllegalArgumentException();
		}
	}

	// ��ȭ��Ͽ� ���� ID�� �Է�������
	public static void checkExistMovie(int movieId) {
		if(!MovieRepository.getSelectedMovie(movieId).contains(movieId)) {
			throw new IllegalArgumentException();
		}
	}
}
