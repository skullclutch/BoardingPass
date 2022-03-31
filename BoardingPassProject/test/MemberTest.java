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
    }

    @Test
    void getOrigin() {
        assertEquals("LAX", member.getOrigin());
    }

    @Test
    void getName() {
        assertEquals(null, member.getName());
    }

    @Test
    void getEmail() {
        assertEquals(null, member.getEmail());
    }

    @Test
    void getPhoneNumber() {
        assertEquals(null, member.getPhoneNumber());
    }

    @Test
    void getAge() {
        assertEquals(0, member.getAge());
    }

    @Test
    void getGender() {
        assertEquals(null, member.getGender());
    }

    @Test
    void getDepartureDate() {
        assertEquals(null, member.getDepartureDate());
    }

    @Test
    void getDestination() {
        assertEquals(null, member.getDestination());
    }

    @Test
    void getDepartureTime() {
        assertEquals(null, member.getDepartureTime());
    }

    @Test
    void getBoardingPassNumber() {
        assertEquals(null, member.getBoardingPassNumber());
    }

    @Test
    void getETA() throws ParseException {
        assertEquals(null, member.getETA());
    }

    @Test
    void getTicketPrice() throws ParseException {
        assertEquals(null, member.getTicketPrice());
    }

    @AfterEach
    void tearDown() {
    }
}