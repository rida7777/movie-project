package main.domain;

import java.util.List;

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
			int movieId = InputView.getMovieId();
    		Movie selectedMovie = MovieRepository.getSelectedMovie(movieId);
    		String scheduleInfo = InputView.createSchedule();
    		MovieService.addMovieSchedule(selectedMovie, scheduleInfo);
    		System.out.println("<�������� ���������� �߰��߽��ϴ�.>");
    		OutputView.printMovies(movies);
    	}
		
		if(selectFunctionNum == 4) {
			OutputView.printMovies(movies);
			int movieId = InputView.getMovieId();
			Movie selectedMovie = MovieRepository.getSelectedMovie(movieId);
			MovieService.removeMovie(selectedMovie);
			System.out.println("<��ȭ�� ���������� �����߽��ϴ�.>");
    		OutputView.printMovies(movies);
		}
		
		if(selectFunctionNum == 5) {
			OutputView.printMovies(movies);
			int movieId = InputView.getMovieId();
			Movie selectedMovie = MovieRepository.getSelectedMovie(movieId);
			int removeScheduleIndex = InputView.getScheduleIndex();
			MovieService.removeMovieSchedule(selectedMovie, removeScheduleIndex);
			System.out.println("<�������� ���������� �����߽��ϴ�.>");
    		OutputView.printMovies(movies);
		}
		
    	if(selectFunctionNum == 6) {
    		OutputView.printMovies(movies);
    		int movieId = InputView.getMovieId();
    		List<Customer> customers = MovieService.getCustomer(movieId);
    		OutputView.printCustomers(customers);
    	}
    	
    	if(selectFunctionNum == 7) {
    		OutputView.printMovies(movies);
    		int movieId = InputView.getMovieId();
    		Movie selectedMovie = MovieRepository.getSelectedMovie(movieId);
    		int customerNum = MovieService.getCustomerNum(movieId);
    		OutputView.printCustomerNum(selectedMovie, customerNum);
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
