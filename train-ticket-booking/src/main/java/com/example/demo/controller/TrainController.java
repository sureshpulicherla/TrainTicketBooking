package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.PurchaseRequest;
import com.example.demo.model.Ticket;
import com.example.demo.model.User;
import com.example.demo.service.TrainService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class TrainController {

	TrainService trainService = new TrainService();

	@PostMapping("/purchase")
	public Ticket purchaseTicket(@RequestBody PurchaseRequest request) {

		User user = new User(request.getFirstName(), request.getLastName(), request.getEmail());
		Ticket ticket = trainService.puchaseTicket(request.getFrom(), request.getTo(), user, request.getSection());
		return ticket;
	}

	@GetMapping("/ticket")
	public Ticket getTicketDetails(@RequestParam String email) {
		User user = new User();
		user.setEmail(email);
		Ticket ticket = trainService.getTicketDetails(user);
		return ticket;

	}

	@GetMapping("/users")
	public List<Ticket> getUsers(@RequestParam String section) {
		List<Ticket> users = trainService.getUsers(section);
		return users;
	}

	@DeleteMapping("/removeUser")
	public String removeUser(@RequestParam String email) {
		User user = new User();
		user.setEmail(email);
		boolean delete = trainService.removeUser(user);
		if (delete) {
			return "user removed";
		} else {
			return "user not found";
		}
	}

	@PutMapping("/user/{email}")
	public String updateUserSeat(@PathVariable String email, @RequestParam String newSection) {
		User user = new User();
		user.setEmail(email);
		boolean updated = trainService.updateUserSeat(user, newSection);

		if (updated) {
			return "user seat updated to";
		} else {
			return "user not found";
		}	
	}

}
