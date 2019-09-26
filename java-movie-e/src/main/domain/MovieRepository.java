package main.domain;

import static main.utils.DateTimeUtils.createDateTime;

import java.util.ArrayList;
import java.util.List;

import main.domain.Movie;

public class MovieRepository {
	    private static List<Movie> movies = new ArrayList<>();
	    
	    static {
	        Movie movie1 = new Movie(1, "����", 8_000);
	        movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 12:00"), 6));
	        movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 14:40"), 6));
	        movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 17:00"), 6));
	        movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 19:40"), 3));
	        movie1.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 22:00"), 3));
	        
	        movie1.addCustomer(new Customer(100, "�ۻѸ�"));
	        movie1.addCustomer(new Customer(101, "���"));
	        movie1.addCustomer(new Customer(150, "ȫ�浿"));
	        movie1.addCustomer(new Customer(107, "��Ŭ��"));
	        movie1.addCustomer(new Customer(189, "�̽ð�"));
	        
	        movies.add(movie1);

	        Movie movie2 = new Movie(5, "��", 10_000);
	        movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 08:00"), 3));
	        movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 10:30"), 5));
	        movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 13:00"), 5));
	        movie2.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 15:30"), 5));
	        
	        movie2.addCustomer(new Customer(201, "���̼�"));
	        movie2.addCustomer(new Customer(250, "�迵ȭ"));
	        movie2.addCustomer(new Customer(207, "���ڹ�"));
	        movies.add(movie2);

	        Movie movie3 = new Movie(7, "���̺���Ʈ", 9_000);
	        movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 13:00"), 4));
	        movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 15:40"), 4));
	        movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 18:00"), 4));
	        movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 20:40"), 3));
	        movie3.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 23:15"), 3));
	        
	        movie3.addCustomer(new Customer(301, "��ȭ"));
	        movie3.addCustomer(new Customer(360, "������"));
	        movie3.addCustomer(new Customer(317, "�赵��"));
	        movies.add(movie3);

	        Movie movie4 = new Movie(8, "����", 9_000);
	        movie4.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 11:30"), 2));
	        movie4.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 16:00"), 3));
	        movie4.addPlaySchedule(new PlaySchedule(createDateTime("2019-04-16 21:30"), 2));
	        
	        movie4.addCustomer(new Customer(401, "������"));
	        movie4.addCustomer(new Customer(450, "���"));
	        movie4.addCustomer(new Customer(470, "������"));
	        movie4.addCustomer(new Customer(465, "�����"));
	        movies.add(movie4);
	    }

	    public static List<Movie> getMovies() {
	        return movies;
	    }
	    
		public static List<Customer> getCustomers(int movieId) {
			return getSelectedMovie(movieId).getCustomers();
		}

		public static int getCustomerNum(int movieId) {
			return getSelectedMovie(movieId).getCustomersNum();
		}
		
	    // movieId�� ��ȭ��üã��
	    public static Movie getSelectedMovie(int movieId) {
	    	return movies.stream()
	    			.filter(movie -> movie.contains(movieId))
	    			.findFirst()
	    			.get();
	    }

	    // ��ȭ�߰�
	    public static void addMovie(Movie created) {
	    	movies.add(created);
	    }
	    
	    //��ȭ����
		public static void removeMovie(Movie movie) {
			movies.remove(movie);	
		}
}
