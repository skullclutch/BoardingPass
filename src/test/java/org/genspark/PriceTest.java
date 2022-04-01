package org.genspark;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    Price price;
    @BeforeEach
    void setUp() {
price = new Price();
    }

    @Test
    void ticketPrice() throws ParseException {
    double resultTP = Double.parseDouble(Price.ticketPrice(15, "Female", "Dallas", "10/22/2022"));
    double priceToDallasFor15YearOldFemailOnOct22_2022 = 232.41;
    assertEquals(priceToDallasFor15YearOldFemailOnOct22_2022, resultTP);
    assertNotEquals(200.00, resultTP);
    }

    @Test
    void rateByAge() {
    double resultRBA = Price.rateByAge(400.00, 11, "m");
    assertEquals(200.00, resultRBA);
    assertNotEquals(300.00, resultRBA);
    }

    @Test
    void rateByGender() {
        double resultRBG = Price.rateByGender(300.00, "Female");
        assertEquals(225.00, resultRBG);
        assertNotEquals(300.00, resultRBG);
    }

    @Test
    void ratebyDestination() {
        double resultRBD = Price.ratebyDestination("Dallas");
        assertEquals(309.88, resultRBD);
        assertNotEquals(400.00, resultRBD);
    }

    @Test
    void daysAway() throws ParseException {
        int resultDA = Price.daysAway("10/22/2022");
        int daysAwayFromMarch312022 = 204;
        assertEquals(daysAwayFromMarch312022, resultDA);
        assertNotEquals(45, resultDA);
    }

    @Test
    void ratesDaysAwayAndDestination() {
        double resultRDAAD = Price.ratesDaysAwayAndDestination(400.00, 108);
        assertEquals(400.00, resultRDAAD);
        assertNotEquals(200.00, resultRDAAD);
    }

    @AfterEach
    void tearDown() {
    }
}