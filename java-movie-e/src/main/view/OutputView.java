package main.view;

import java.util.List;

import main.domain.Customer;
import main.domain.Movie;

public class OutputView {

	public static void printMovies(List<Movie> movies) {
    	System.out.println("## 상영 영화 목록");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
	}

	public static void printCustomers(List<Customer> customers) {
		System.out.println("## 관객 목록");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
	}

	public static void printCustomerNum(Movie selectedMovie, int customerNum) {
		String movieName = selectedMovie.getName();
		System.out.println("<" + movieName + ">의 관객수는 " + customerNum + "명 입니다.");
	}
}
