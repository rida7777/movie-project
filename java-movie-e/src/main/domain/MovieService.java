package main.domain;

import static main.utils.DateTimeUtils.createDateTime;

import java.time.LocalDateTime;
import java.util.List;

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
	
	public static void removeMovie(Movie selectedMovie) {
		MovieRepository.removeMovie(selectedMovie);
	}

	public static void removeMovieSchedule(Movie selectedMovie, int removeScheduleIndex) {
		selectedMovie.removePlaySchedule(removeScheduleIndex - 1);
	}
	
	public static List<Customer> getCustomer(int movieId) {
		return MovieRepository.getCustomers(movieId);
	}

	public static int getCustomerNum(int movieId) {
		return MovieRepository.getCustomerNum(movieId);
	}
}
