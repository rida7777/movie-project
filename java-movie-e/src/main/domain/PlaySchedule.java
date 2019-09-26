package main.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import main.utils.DateTimeUtils;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;
    
    private List<Customer> customers = new ArrayList<>();
    
    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }
    
    public LocalDateTime getStartDateTime() {
    	return startDateTime;
    }
   
    
	@Override
	public String toString() {
		return "시작시간 : " + DateTimeUtils.format(startDateTime) + " 예약가능인원: " + capacity + "\n";
	}
}
