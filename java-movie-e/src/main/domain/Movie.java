package main.domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    
    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    } 
    
    // private �ʵ� ���� ���� �ϱ� ���ؼ� getter ����
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

	public List<Customer> getCustomers() {
		return customers;
	}

	public int getCustomersNum() {
		return customers.size();
	}
	
	void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }
	
	public void removePlaySchedule(int i) {
		playSchedules.remove(i);
	}

	public void addCustomer(Customer customer) {
        customers.add(customer);
    }
	
	//�����ϴ� ��ȭ���� ���� : movie class�� ��� �ִ� ��ȭ id�� ����ڰ� �Է��� movieId�� ��ġ�ϴ��� Ȯ��
    boolean contains(int movieId) {
    	return this.id == movieId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "��" + NEW_LINE
                + sb.toString();
    }
}
