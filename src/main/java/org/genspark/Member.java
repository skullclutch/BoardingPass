package org.genspark;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;

public class Member {
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private int age;
    private String departureDate;
    private String destination;
    private String departureTime;
    private String membership;
    private String origin = "LAX";
    private String boardingPassNumber;
    private String randomUUID;
    private String ETA;
    private String ticketPrice;
    FileWriter userMembership = null;

    HashMap<String, Object> memberList = new HashMap<>();

    public Member() {
        this.name = getName();
        this.email = getEmail();
        this.phoneNumber = getPhoneNumber();
        this.age = getAge();
        this.gender = getGender();
        this.destination = getDestination();
        this.departureDate = getDepartureDate();
        this.departureTime = getDepartureTime();
        this.boardingPassNumber = getBoardingPassNumber();
        this.origin = getOrigin();
    }

    public String getOrigin() {
        return origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        memberList.put("Name", name);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        memberList.put("Email", email);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        memberList.put("Phone Number", phoneNumber);
    }

    public int getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = Integer.parseInt(age);
        memberList.put("Age", age);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        memberList.put("Gender", gender);
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
        memberList.put("Departure Date", departureDate);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;

        memberList.put("Destination", destination);
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
        memberList.put("Departure Time", departureTime);
    }

    public String getBoardingPassNumber() {
        this.randomUUID = UUID.randomUUID().toString().split("-")[0].toUpperCase(Locale.ROOT);
        memberList.put("Boarding Pass Number", boardingPassNumber);
        return randomUUID;
    }

    public String getETA() throws ParseException {
        Ticket ticket = new Ticket(this.departureTime, this.destination, this.departureDate);
        memberList.put("ETA", ticket);
        return String.valueOf(ticket.ETA);
    }

    public String getTicketPrice() throws ParseException {
        this.ticketPrice = String.valueOf(Price.ticketPrice(this.age, this.gender, this.destination, this.departureDate));
        memberList.put("Ticket Price", ticketPrice);
        return ticketPrice;
    }


}
