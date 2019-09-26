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
    		System.out.println("<영화를 성공적으로 추가했습니다.>");
    		OutputView.printMovies(movies);
    	}
    	
		if(selectFunctionNum == 3) {
			int movieId = InputView.getMovieId();
    		Movie selectedMovie = MovieRepository.getSelectedMovie(movieId);
    		String scheduleInfo = InputView.createSchedule();
    		MovieService.addMovieSchedule(selectedMovie, scheduleInfo);
    		System.out.println("<스케줄을 성공적으로 추가했습니다.>");
    		OutputView.printMovies(movies);
    	}
		
		if(selectFunctionNum == 4) {
			OutputView.printMovies(movies);
			int movieId = InputView.getMovieId();
			Movie selectedMovie = MovieRepository.getSelectedMovie(movieId);
			MovieService.removeMovie(selectedMovie);
			System.out.println("<영화를 성공적으로 삭제했습니다.>");
    		OutputView.printMovies(movies);
		}
		
		if(selectFunctionNum == 5) {
			OutputView.printMovies(movies);
			int movieId = InputView.getMovieId();
			Movie selectedMovie = MovieRepository.getSelectedMovie(movieId);
			int removeScheduleIndex = InputView.getScheduleIndex();
			MovieService.removeMovieSchedule(selectedMovie, removeScheduleIndex);
			System.out.println("<스케줄을 성공적으로 삭제했습니다.>");
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
