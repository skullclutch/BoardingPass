import java.io.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;

public class Member {

    private String input;
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private int age;
    private String departureDate;
    private String destination;
    private String departureTime;
    private String membership;
    FileWriter userMembership = null;

    HashMap<String, Object> memberList = new HashMap<>();


    public Member(String name,String email,String phoneNumber, String gender, String age, String departureDate, String destination, String departureTime) throws IOException, ParseException {

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
        //Fix age issue

        this.departureDate = departureDate;
        memberList.put("Date", departureDate);

        this.destination = destination;
        memberList.put("Destination", destination);

        this.departureTime = departureTime;
        memberList.put("Departure Time", departureTime);

        Ticket ticket = new Ticket(this.departureTime, this.destination);

        Price.ticketPrice(this.age,this.gender,this.destination,this.departureDate);



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

    public String getMembership() {


        return String.join(" ", String.valueOf(memberList));
    }

}
