package org.genspark;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    Member member;

    @BeforeEach
    void setUp() {
        member = new Member();
        member.setDestination("Chicago");
        member.setGender("f");
        member.setAge("11");
        member.setName("Heather");
        member.setPhoneNumber("555-444-3333");
        member.setDepartureDate("10/24/2022");
        member.setDepartureTime("13:00");
        member.setEmail("me@email.com");

    }

    @Test
    void getOrigin() {
        assertEquals("LAX", member.getOrigin());
        assertNotEquals("ATX", member.getOrigin());
    }

    @Test
    void getName() {
        assertEquals("Heather", member.getName());
        assertNotEquals("Renee", member.getName());
    }

    @Test
    void getEmail() {
        assertEquals("me@email.com", member.getEmail());
        assertNotEquals("them@email.com", member.getEmail());

    }

    @Test
    void getPhoneNumber() {
        assertEquals("555-444-3333", member.getPhoneNumber());
        assertNotEquals("555-333-3223", member.getPhoneNumber());

    }

    @Test
    void getAge() {
        assertEquals(11, member.getAge());
        assertNotEquals(55, member.getAge());

    }

    @Test
    void getGender() {
        assertEquals("f", member.getGender());
        assertNotEquals("m", member.getGender());

    }

    @Test
    void getDepartureDate() {
        assertEquals("10/24/2022", member.getDepartureDate());
        assertNotEquals("18/24/2022", member.getDepartureDate());

    }

    @Test
    void getDestination() {
        assertEquals("Chicago", member.getDestination());
        assertNotEquals("Dallas", member.getDestination());

    }

    @Test
    void getDepartureTime() {
        assertEquals("13:00", member.getDepartureTime());
        assertNotEquals("22:00", member.getDepartureTime());

    }


    @AfterEach
    void tearDown() {
    }

}