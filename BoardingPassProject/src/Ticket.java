import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class Ticket {

    /*generate a Boarding Pass Ticket
    Boarding Pass Number (unique)
    Date of departure
    Origin (Where they are leaving from will be final.)
    Destination(Give user choices of Destination to choose from)
    ETA (How far in miles origin is from destination and divide that by how fast plane travels return a double in 0D 0HR 0MIN 0SEC)
    Departure Time
     */

    private String boardingPassTicket;
    public String time = "";
    public String departureTime;
    public String destination;
    String ETA;


    double dallas = 1451.00;
    double denver = 1033.00;
    double chicago = 2032.00;
    double newYork = 2806.00;


    Ticket(String departureTime, String destination) throws ParseException {
        this.ETA = eta(departureTime, chooseDestination(destination));
        this.boardingPassTicket = String.valueOf(getGenNumber());
        System.out.println(this.departureTime + " " + this.ETA + " " + this.boardingPassTicket);
    }

    //ONLY USED WHILE TESTING WITH MAIN METHOD IN THIS CLASS
    public Ticket() {

    }
    //*****************************


    public int chooseDestination(String Destination) { //If theres a GUI parameter would take in a listener


        int time = 0;

        switch (Destination) {
            case "Denver":
                time = calcTimeOfFlight(denver);
                break;
            case "Chicago":
                time = calcTimeOfFlight(chicago);
                break;
            case "New York City":
                time = calcTimeOfFlight(newYork);
                break;
            case "Dallas":
                time = calcTimeOfFlight(dallas);
                break;
            default:
                System.out.println("Invalid Selection");
                break;
        }

        return time;
    }

    public int calcTimeOfFlight(double Destination) {


        double flightTime = Math.ceil(Destination / 500); //plane travels at 500mph

        System.out.println("Flight Time: " + flightTime);

        return (int) flightTime;

    }

    public String eta(String departureTime, int flightTime) throws ParseException {
        System.out.println("Departure Time: " + departureTime);

        // get the hours from the departure time and convert it to date so that the Calendar util will accept it
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date departTimeParsed = sdf.parse(departureTime);

        //Create a calendar object, set it to the departure Time and add the flight time to it
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(departTimeParsed);
        calendar.add(Calendar.HOUR_OF_DAY, flightTime);

        //set up way to print out a string using the SimpleDateFormat
        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
        long arrivalTimeinHours =  (calendar.getTimeInMillis());
        System.out.println("ETA: " + sdf2.format(arrivalTimeinHours));
        return (sdf.format(arrivalTimeinHours));


    }


   GenNumber genNumber = new GenNumber();

    public GenNumber getGenNumber() {
        return genNumber;
    }
    //    public int generatePassNumber() {
//
//        Random r = new Random();
//
//        int ticketNum = r.nextInt(5000);
//
//        System.out.println("Boarding Pass Number: " + ticketNum);
//
//        return ticketNum;
//
//    }

}
