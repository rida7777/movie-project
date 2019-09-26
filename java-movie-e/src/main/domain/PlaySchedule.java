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
		return "���۽ð� : " + DateTimeUtils.format(startDateTime) + " ���డ���ο�: " + capacity + "\n";
	}
}
