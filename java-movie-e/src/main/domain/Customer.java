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

	@Override
	public String toString() {
		return "����ID: " + id + " �����̸�: " + name;
	}
}
