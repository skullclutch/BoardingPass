import java.util.Locale;

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
    int ETA;


    double dallas = 1451.00;
    double denver = 1033.00;
    double chicago = 2032.00;
    double newYork = 2806.00;



    Ticket(String departureTime, String destination) {
       this.ETA = eta(departureTime, chooseDestination(destination));
        System.out.println(this.departureTime + " " + this.ETA);
    }


    public int chooseDestination(String Destination) { //If theres a GUI parameter would take in a listener


        int time = 0;

        switch (Destination.toUpperCase(Locale.ROOT)) {
            case "DENVER":
                 time = calcTimeOfFlight(denver);
                break;
            case "CHICAGO":
                time = calcTimeOfFlight(chicago);
                break;
            case "NEW YORK":
                time = calcTimeOfFlight(newYork);
                break;
            case "DALLAS":
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

        System.out.println("this is how long the flight will take " + flightTime);

        return (int) flightTime;

    }

    public int eta(String departureTime, int flightTime) {

        this.departureTime = departureTime;

        return Integer.parseInt(departureTime) + flightTime;

    }



}
