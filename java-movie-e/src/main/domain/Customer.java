package main.domain;

public class Customer {
	private int id;
	private String name;
		
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}

    boolean contains(int customerId) {
    	return this.id == customerId;
    }
    
	@Override
	public String toString() {
		return "包按ID: " + id + " 包按捞抚: " + name;
	}
}
