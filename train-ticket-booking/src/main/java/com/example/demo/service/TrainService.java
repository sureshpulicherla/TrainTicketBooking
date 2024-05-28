package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.model.Ticket;
import com.example.demo.model.User;

public class TrainService {

	private List<Ticket> tickets = new ArrayList<>();
	private Map<String, List<Ticket>> seats = new HashMap<>();

	public TrainService() {
		seats.put("A", new ArrayList<>());
		seats.put("B", new ArrayList<>());
	}

	public Ticket puchaseTicket(String from, String to, User user, String section) {

		String normalSection = section.toUpperCase();

		if (!normalSection.equals("A") && !normalSection.equals("B")) {
			throw new IllegalArgumentException("Invalid section. Section must be 'A' or 'B'.");
		}

		Ticket ticket = new Ticket(from, to, user, 20.0, normalSection);
		tickets.add(ticket);

		seats.putIfAbsent(normalSection, new ArrayList<>());
		seats.get(normalSection).add(ticket);
		return ticket;
	}

	public Ticket getTicketDetails(User user) {

		for (Ticket ticket : tickets) {
			if (ticket.getUser().getEmail().equals(user.getEmail())) {
				return ticket;
			}
		}

		return null;
	}

	public List<Ticket> getUsers(String section) {
		return seats.get(section);
	}

	public boolean removeUser(User user) {

		Ticket ticket = getTicketDetails(user);
		if (ticket != null) {
			tickets.remove(ticket);
			seats.get(ticket.getSeat()).remove(ticket);
			return true;
		}

		return false;
	}

	public boolean updateUserSeat(User user, String newSection) {
		Ticket ticket = getTicketDetails(user);
		if (ticket != null) {
			seats.get(ticket.getSeat()).remove(ticket);
			ticket.setSeat(newSection);
			seats.get(newSection).add(ticket);
			return true;
		}
		return false;
	}
}
