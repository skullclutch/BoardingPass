import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Member {

    private String input;
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private int age;
    private String date;
    private String destination;
    private String departureTime;
    private String membership;
    FileWriter userMembership = null;

    HashMap<String, Object> memberList = new HashMap<>();


    public Member() throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Ticket Generation Terminal.");
        System.out.println("Please enter your name");
        this.name = sc.nextLine();
        memberList.put("Name", name);
        System.out.println("Please enter your email");
        this.email = sc.nextLine();
        memberList.put("Email", email);
        System.out.println("Please enter your phone number");
        this.phoneNumber = sc.nextLine();
        memberList.put("Phone Number", phoneNumber);
        System.out.println("Please enter your gender");
        this.gender = sc.nextLine();
        memberList.put("Gender", gender);
        System.out.println("Please enter your age");
        this.age = sc.nextInt();
        memberList.put("Age", age);
        sc.nextLine();
        System.out.println("Please enter the date you wish to leave");
        this.date = sc.nextLine();
        memberList.put("Date", date);
        System.out.println("Please enter where you would like to travel to");
        this.destination = sc.nextLine();
        memberList.put("Destination", destination);
        System.out.println("Please enter what time you would like to depart");
        this.departureTime = sc.nextLine();
        memberList.put("Departure Time", departureTime);

        Ticket ticket = new Ticket(this.departureTime, this.destination);

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
