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
   
    //해당스케줄의 관객을 출력해주는 것
	public List<Customer> getCustomers() {
		return customers;
	}
    
	//해당 스케줄의 관객수 
	public int getCustomerNum() {
		return customers.size();
	}
	
	//스케줄에 관객추가하기
	public void addCustomer(Customer customer) {
        customers.add(customer);
    }
	
	//관객삭제
	public void removeCustomer(int cusomterIndex) {
		this.customers.remove(cusomterIndex-1);
	}
		
	@Override
	public String toString() {
		return "시작시간 : " + DateTimeUtils.format(startDateTime) + " 예약가능인원: " + capacity + "\n";
	}
}
