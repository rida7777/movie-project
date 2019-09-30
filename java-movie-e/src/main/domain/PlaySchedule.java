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
   
    //�ش罺������ ������ ������ִ� ��
	public List<Customer> getCustomers() {
		return customers;
	}
    
	//�ش� �������� ������ 
	public int getCustomerNum() {
		return customers.size();
	}
	
	//�����ٿ� �����߰��ϱ�
	public void addCustomer(Customer customer) {
        customers.add(customer);
    }
	
	//��������
	public void removeCustomer(int cusomterIndex) {
		this.customers.remove(cusomterIndex-1);
	}
		
	@Override
	public String toString() {
		return "���۽ð� : " + DateTimeUtils.format(startDateTime) + " ���డ���ο�: " + capacity + "\n";
	}
}
