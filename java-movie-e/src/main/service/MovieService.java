package main.service;

import static main.utils.DateTimeUtils.createDateTime;

import java.time.LocalDateTime;
import java.util.List;

import main.domain.Customer;
import main.domain.Movie;
import main.domain.MovieRepository;
import main.domain.PlaySchedule;
import main.view.InputView;

public class MovieService {
	
	//영화추가
	public static void addMovie(String movieInfo) {
		String[] movieInfos = movieInfo.split(" ");
		int movieId = Integer.parseInt(movieInfos[0]);
		String movieName = movieInfos[1];
		int price = Integer.parseInt(movieInfos[2]);
		Movie created = new Movie(movieId, movieName, price);
		
		MovieRepository.addMovie(created);
	}

	//스케줄추가
	public static void addMovieSchedule(Movie selectedMovie, String scheduleInfo) {
		String[] scheduleInfos = scheduleInfo.split("_");
		LocalDateTime startDateTime = createDateTime(scheduleInfos[0]);
		int capacity = Integer.parseInt(scheduleInfos[1]);
		PlaySchedule playSchedule = new PlaySchedule(startDateTime, capacity);

		selectedMovie.addPlaySchedule(playSchedule);
	}
	
	//영화삭제
	public static void removeMovie(Movie selectedMovie) {
		MovieRepository.removeMovie(selectedMovie);
	}

	//스케줄삭제
	public static void removeMovieSchedule(Movie selectedMovie, int removeScheduleIndex) {
		selectedMovie.removePlaySchedule(removeScheduleIndex - 1);
	}

	//영화별 관객수
	public static int getCustomerNum(Movie selectedMovie) {
		return selectedMovie.getCustmerNum();
	}
	
	//영화예매 : 관객추가
	public static void addCustomer(Movie selectedMovie, int scheduleIndex, String customerInfo) {
		String[] customerInfos = customerInfo.split(" ");
		int customerId = Integer.parseInt(customerInfos[0]);
		String customerName = customerInfos[1];
		Customer customer = new Customer(customerId, customerName);
		List<PlaySchedule> playSchedules = selectedMovie.getPlaySchedules();
		PlaySchedule ps = playSchedules.get(scheduleIndex-1);
		ps.addCustomer(customer);
		//		playSchedules.get(scheduleIndex - 1).addCustomer(customer);
	}

	//예매취소 : 관객삭제
	public static void removeCustomer(Movie selectedMovie, int scheduleIndex, int cusomterIndex) {
		selectedMovie.getPlaySchedules().get(scheduleIndex - 1).removeCustomer(cusomterIndex);
	}
		
	//스케줄별 관객정보
	public static List<Customer> getCustomer(Movie selectedMovie, int scheduleIndex) {
		List<PlaySchedule> playSchedules = selectedMovie.getPlaySchedules();
		return playSchedules.get(scheduleIndex - 1).getCustomers();
	}

	public static Movie getMovieByMovieId() {
		int movieId = InputView.getMovieId();
		return MovieRepository.getSelectedMovie(movieId);
	}
}
