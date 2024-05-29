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

	public Ticket purchaseTicket(String from, String to, User user, String section) {
        if (from == null || to == null || user == null || section == null || (!section.equals("A") && !section.equals("B"))) {
            throw new IllegalArgumentException("Invalid input. Section must be 'A' or 'B'.");
        }
        Ticket ticket = new Ticket(from, to, user, 20.0, section);
        tickets.add(ticket);

        if (!seats.containsKey(section)) {
            seats.put(section, new ArrayList<>());
        }

        seats.get(section).add(ticket);
        return ticket;
    }

    public Ticket getTicketDetails(User user) {
        if (user == null || user.getEmail() == null) {
            throw new IllegalArgumentException("User or email cannot be null.");
        }
        for (Ticket ticket : tickets) {
            if (ticket.getUser().getEmail().equals(user.getEmail())) {
                return ticket;
            }
        }
        return null;
    }

    public List<Ticket> getUsers(String section) {
        if (section == null || (!section.equals("A") && !section.equals("B"))) {
            throw new IllegalArgumentException("Section must be 'A' or 'B'.");
        }
        return seats.get(section);
    }

    public boolean removeUser(User user) {
        if (user == null || user.getEmail() == null) {
            throw new IllegalArgumentException("User or email cannot be null.");
        }
        Ticket ticket = getTicketDetails(user);
        if (ticket != null) {
            tickets.remove(ticket);
            seats.get(ticket.getSeat()).remove(ticket);
            return true;
        }
        return false;
    }

    public boolean updateUserSeat(User user, String newSection) {
        if (user == null || user.getEmail() == null || newSection == null || (!newSection.equals("A") && !newSection.equals("B"))) {
            throw new IllegalArgumentException("Invalid input. New section must be 'A' or 'B'");
        }
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
