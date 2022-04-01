package org.genspark;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

Ticket ticket;
    @BeforeEach
    void setUp() throws ParseException {

        ticket = new Ticket("22:00", "New York", "8/22/2022");
    }

    @Test
    void eta() throws ParseException {
        String eta = "Aug/23/2022 03:00 AM";
        String resultETA = ticket.eta("22:00", 5, "8/22/2022");
        assertEquals(eta, resultETA);
        assertNotEquals("Aug/27/2022 05:00 AM", resultETA);
    }

    @Test
    void chooseDestination() {
        int resultCD = ticket.chooseDestination("New York");
        assertEquals(6, resultCD);
        assertNotEquals(3, resultCD);
    }

    @Test
    void calcTimeOfFlight() {
        double dallasMiles = 1451.00;
        int resultCFT = ticket.calcTimeOfFlight(dallasMiles);
        assertEquals(3, resultCFT);
        assertNotEquals(8, resultCFT);

    }

    @AfterEach
    void tearDown() {
    }

}