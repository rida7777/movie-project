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
    		System.out.println("<영화를 성공적으로 추가했습니다.>");
    		OutputView.printMovies(movies);
    	}
    	
		if(selectFunctionNum == 3) {
			OutputView.printMovies(movies);
			Movie selectedMovie = MovieService.getMovieByMovieId();
    		String scheduleInfo = InputView.createSchedule();
    		MovieService.addMovieSchedule(selectedMovie, scheduleInfo);
    		System.out.println("<스케줄을 성공적으로 추가했습니다.>");
    		OutputView.printMovies(movies);
    	}
		
		if(selectFunctionNum == 4) {
			OutputView.printMovies(movies);
			Movie selectedMovie = MovieService.getMovieByMovieId();
			MovieService.removeMovie(selectedMovie);
			System.out.println("<영화를 성공적으로 삭제했습니다.>");
    		OutputView.printMovies(movies);
		}
		
		if(selectFunctionNum == 5) {
			OutputView.printMovies(movies);
			Movie selectedMovie = MovieService.getMovieByMovieId();
			int removeScheduleIndex = InputView.getScheduleIndex();
			MovieService.removeMovieSchedule(selectedMovie, removeScheduleIndex);
			System.out.println("<스케줄을 성공적으로 삭제했습니다.>");
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
			System.out.println("<예매가 완료됐습니다.>");
    	}
    	
    	if(selectFunctionNum == 8) {
    		OutputView.printMovies(movies);  		
    		Movie selectedMovie = MovieService.getMovieByMovieId();
			int scheduleIndex = InputView.getScheduleIndex();
    		List<Customer> customers = MovieService.getCustomer(selectedMovie, scheduleIndex);
    		OutputView.printCustomers(customers);
    		int customerIndex = InputView.getCustomerIndex();
    		MovieService.removeCustomer(selectedMovie, scheduleIndex, customerIndex);
    		System.out.println("<예매가 취소됐습니다.>");
    	}
    	
    	if(selectFunctionNum == 9) {
    		OutputView.printMovies(movies);
    		Movie selectedMovie = MovieService.getMovieByMovieId();
			int scheduleIndex = InputView.getScheduleIndex();
    		List<Customer> customers = MovieService.getCustomer(selectedMovie, scheduleIndex);
    		OutputView.printCustomers(customers);
    	}
	}	
	
	//예외처리 -> 패키지 따로 하나 만들기
	//selectFunctionNum이 1 2 3 4중 하나여야 한다.
	public static void checkVaildFunctionNum(int selectFunctionNum) {
		if (selectFunctionNum != 1 && selectFunctionNum != 2 && selectFunctionNum != 3  && selectFunctionNum != 4)  {
			throw new IllegalArgumentException();
		}
	}

	// id name price 타입은 잘 넣는다고 가정하고, 입력 갯수확인
	public static void checkVaildMovieInfo(String movieInfo) {
		String[] movieInfos = movieInfo.split(" ");
		if (movieInfos.length != 3) {
			throw new IllegalArgumentException();
		}
	}

	// 타입은 잘 넣는다고 가정하고, 입력 갯수확인
	public static void checkVaildScheduleInfo(String scheduleInfo) {
		String[] scheduleInfos = scheduleInfo.split("_");
		if (scheduleInfos.length != 2) {
			throw new IllegalArgumentException();
		}
	}

	// 영화목록에 없는 ID를 입력했을때
	public static void checkExistMovie(int movieId) {
		if(!MovieRepository.getSelectedMovie(movieId).contains(movieId)) {
			throw new IllegalArgumentException();
		}
	}
}
