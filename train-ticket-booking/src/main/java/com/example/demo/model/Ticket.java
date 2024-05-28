package com.example.demo.model;

public class Ticket {
	private String from;
	private String to;
	private User user;
	private double pricePaid;
	private String seat;
	public Ticket() {
		super();
	}
	public Ticket(String from, String to, User user, double pricePaid, String seat) {
		super();
		this.from = from;
		this.to = to;
		this.user = user;
		this.pricePaid = pricePaid;
		this.seat = seat;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getPricePaid() {
		return pricePaid;
	}
	public void setPricePaid(double pricePaid) {
		this.pricePaid = pricePaid;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	@Override
	public String toString() {
		return "Ticket [from=" + from + ", to=" + to + ", user=" + user + ", pricePaid=" + pricePaid + ", seat=" + seat
				+ "]";
	}
	

}
