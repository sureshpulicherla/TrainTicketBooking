package com.example.demo.service;

import com.example.demo.model.Ticket;
import com.example.demo.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TrainServiceTest {

    private TrainService trainService;

    @BeforeEach
    public void setUp() {
        trainService = new TrainService();
    }

    @Test
    public void testPurchaseTicket() {
        User user = new User("Suresh", "Pulicherla", "sureshPulicherla@gmail.com");
        Ticket ticket = trainService.puchaseTicket("London", "France", user, "A");

        assertNotNull(ticket);
        assertEquals("London", ticket.getFrom());
        assertEquals("France", ticket.getTo());
        assertEquals(user, ticket.getUser());
        assertEquals(20.0, ticket.getPricePaid());
        assertEquals("A", ticket.getSeat());
    }

    @Test
    public void testGetTicketDetails() {
        User user = new User("Suresh", "Pulicherla", "sureshpulicherla@gmail.com");
        trainService.puchaseTicket("London", "France", user, "A");

        Ticket ticket = trainService.getTicketDetails(user);

        assertNotNull(ticket);
        assertEquals(user, ticket.getUser());
    }

    @Test
    public void testRemoveUser() {
        User user = new User("Suresh", "Pulicherla", "sureshpulicherla@gmail.com");
        trainService.puchaseTicket("London", "France", user, "A");

        boolean removed = trainService.removeUser(user);

        assertTrue(removed);
    }

    @Test
    public void testUpdateUserSeat() {
        User user = new User("Suresh", "Pulicherla", "sureshpulicherla@gmail.com");
        trainService.puchaseTicket("London", "France", user, "A");

        boolean updated = trainService.updateUserSeat(user, "B");

        assertTrue(updated);
        assertEquals("B", trainService.getTicketDetails(user).getSeat());
    }
}
