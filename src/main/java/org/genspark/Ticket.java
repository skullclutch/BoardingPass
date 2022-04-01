package org.genspark;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ticket {

    /*generate a Boarding Pass Ticket
    Boarding Pass Number (unique)
    Date of departure
    Origin (Where they are leaving from will be final.)
    Destination(Give user choices of Destination to choose from)
    ETA (How far in miles origin is from destination and divide that by how fast plane travels return a double in 0D 0HR 0MIN 0SEC)
    Departure Time occurring
     */

    private String boardingPassTicket;
    public String time = "";
    public String departureTime;
    public String destination;
    String ETA;


    double dallasMiles = 1451.00;
    double denverMiles = 1033.00;
    double chicagoMiles = 2032.00;
    double newYorkMiles = 2806.00;


    Ticket(String departureTime, String destination, String departureDate) throws ParseException {
        this.ETA = eta(departureTime, chooseDestination(destination), departureDate);
        this.destination = destination;
    }

    public int chooseDestination(String Destination) {


        int time = 0;

        switch (Destination) {
            case "Denver":
                time = calcTimeOfFlight(denverMiles);
                break;
            case "Chicago":
                time = calcTimeOfFlight(chicagoMiles);
                break;
            case "New York":
                time = calcTimeOfFlight(newYorkMiles);
                break;
            case "Dallas":
                time = calcTimeOfFlight(dallasMiles);
                break;
            default:
                System.out.println("Invalid Selection");
                break;
        }

        return time;
    }

    public int calcTimeOfFlight(double Destination) {


        double flightTime = Math.ceil(Destination / 500); //plane travels at 500mph
        return (int) flightTime;

    }

    public String eta(String departureTime, int flightTime, String departureDate) throws ParseException {

        //combine departure date and departure time into a parsed millisecond value
        String departureDateAndTime = departureDate + " " + departureTime;


        // get the hours from the departure time and convert it to date so that the Calendar util will accept it
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Date departTimeParsed = sdf.parse(departureDateAndTime);

        //Create a calendar object, set it to the departure Time and add the flight time to it
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(departTimeParsed);
        calendar.add(Calendar.HOUR_OF_DAY, flightTime);

        //set up way to print out a string using the SimpleDateFormat
        SimpleDateFormat sdf2 = new SimpleDateFormat("MMM/d/YYYY HH:mm aa");
        long arrivalTimeinHours = (calendar.getTimeInMillis());
        ETA = sdf2.format(arrivalTimeinHours);
        return ETA;


    }

}
