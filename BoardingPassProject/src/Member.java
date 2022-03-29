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


    public Member(String name, String email, String phoneNumber, String age) {

        this.name = name;
        memberList.put("Name", name);

        this.email = email;
        memberList.put("Email", email);

        this.phoneNumber = phoneNumber;
        memberList.put("Phone Number", phoneNumber);

        this.age = Integer.parseInt(age);
        memberList.put("Age", age);

    }

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

    public String getMembership() {
        return String.join(" ", String.valueOf(memberList));
    }

    public void setMembership(String membership) {
        this.membership = membership;
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
        this.ETA = String.valueOf(new Ticket(this.getDepartureTime(),this.getDestination()));
        memberList.put("ETA", ETA);
        return ETA;
    }

    public String getTicketPrice() throws ParseException {
        this.ticketPrice = String.valueOf(Price.ticketPrice(this.age, this.gender, this.destination, this.departureDate));
        memberList.put("Ticket Price", ticketPrice);
        return ticketPrice;
    }


    public Member(String name, String email, String phoneNumber, String gender, String age, String departureDate, String destination, String departureTime) throws IOException, ParseException {

        this.name = name;
        memberList.put("Name", name);

        this.email = email;
        memberList.put("Email", email);

        this.phoneNumber = phoneNumber;
        memberList.put("Phone Number", phoneNumber);

        this.gender = gender;
        memberList.put("Gender", gender);

        this.age = Integer.parseInt(age);
        memberList.put("Age", age);

        this.departureDate = departureDate;
        memberList.put("Date", departureDate);

        this.destination = destination;
        memberList.put("Destination", destination);

        this.departureTime = departureTime;
        memberList.put("Departure Time", departureTime);

//        Ticket ticket = new Ticket(this.departureTime, this.destination);

//        Price.ticketPrice(this.age,this.gender,this.destination,this.departureDate);


        try {
            //When writing the FileWriter, type in the filename, and "true" if you want to append or "false" if you don't want to append if a file exists.
            userMembership = new FileWriter("UserInfo.csv", true);
            //Add a PrintWriter to do the actual writing
            PrintWriter pw = new PrintWriter(userMembership);
            // Next we command the PrintWriter to print the memberlist HashMap we created.
            pw.print(memberList);
            //you must ALWAYS close the PrintWriter otherwise it will not write anything
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


//    public String getInput() {
//        return input;
//    }
//
//    public void setMembership() throws IOException {
//
//        userMembership.write(String.valueOf(memberList));
//
//        userMembership.close();
//
//    }

}
