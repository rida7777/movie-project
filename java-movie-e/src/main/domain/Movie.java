package main.domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;
    private List<PlaySchedule> playSchedules = new ArrayList<>();
    
    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    } 
    
    // private 필드 값을 얻어가게 하기 위해서 getter 세팅
    public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public List<PlaySchedule> getPlaySchedules() {
		return playSchedules;
	}
	
	public void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }
	
	public void removePlaySchedule(int i) {
		playSchedules.remove(i);
	}
	
	public int getCustmerNum() {
		int customers = 0;
		for (PlaySchedule playSchedule : playSchedules) {
			customers += playSchedule.getCustomerNum();
		}
		return customers;
	}
	
	//존재하는 영화인지 검증 : movie class에 들어 있는 영화 id와 사용자가 입력한 movieId가 일치하는지 확인
    public boolean contains(int movieId) {
    	return this.id == movieId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }
}
