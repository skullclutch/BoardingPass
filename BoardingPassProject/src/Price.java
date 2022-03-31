import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

//TODO to call this method, just enter ticketPrice(age, "gender", "destination", "departureDate");


public class Price {
    //make a final price variable;
    static double finalPrice = 0.00;
    //Establish base prices for each of the four destination choices
    static double basePriceChicago = 400.00;
    static double basePriceDenver = 288.00;
    static double basePriceDallas = 309.88;
    static double basePriceNYC = 426.00;




    public static double ticketPrice(int age, String gender, String destination, String departureDate) throws ParseException {
//        daysAway(departureDate); // will return a long rate: rate by days away.
//        System.out.println("Destination introduced: " + destination);
//        ratesDaysAwayAndDestination(ratebyDestination(destination), daysAway(departureDate));
        rateByAge(ratesDaysAwayAndDestination(ratebyDestination(destination), daysAway(departureDate)), age, gender);
//        System.out.println("Final Price: " + finalPrice);
        return finalPrice;
    }

    private static double rateByAge(double rate, int age, String gender) {

//        System.out.println("original rate: " + rate);
        double ageDiscount = rate;

        if(age <=12){
            ageDiscount = rate - (rate * .5);
        } else if(age >= 60){
            ageDiscount = rate - (rate * .6);
        } else {ageDiscount = rate;}

//        System.out.println("age discount: " + ageDiscount);
//        System.out.println(gender);
//        gender = gender.toUpperCase();
        return rateByGender(ageDiscount, gender);
    }

    private static double rateByGender(double ageDiscount, String gender) {
        if(gender.equals("f")){
            finalPrice = ageDiscount - (ageDiscount * .25);
//            System.out.println("Discount of gender: " + finalPrice);

        } else finalPrice = ageDiscount;

        return finalPrice;
    }


    public static double ratebyDestination(String destination){
        System.out.println(destination);

        switch (destination){
            case "Chicago":
                return basePriceChicago;
            case "Denver":
                return basePriceDenver;
            case "Dallas":
                return basePriceDallas;
            case "New York":
                return basePriceNYC;
            default:
                System.out.println("please enter one of the four available cities");
                return 0;
        }
    }

    public static int daysAway(String departureDate) throws ParseException {
//        System.out.println("Departure Date fed to the daysAway method: " + departureDate);

        // set today's date and format it as a String "dd/MM/yyyy"
        Calendar c = new GregorianCalendar();
        String year = String.valueOf(c.get(Calendar.YEAR));
        String month = String.valueOf(c.get(Calendar.MONTH)+1);
        String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        String todaysDateStr = String.valueOf(month + "/" + day +"/" + year);



        //parse both departure date and current date
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date d1 = sdf.parse(todaysDateStr);
        Date d2 = sdf.parse(departureDate);

        // use get time to find the difference in milliseconds
        long difference_In_Time = d2.getTime() - d1.getTime();


        //convert difference into days
        int difference_In_Days = (int) ((difference_In_Time / (1000 * 60 * 60 * 24)) % 365);

//        System Printout results to test
//        System.out.println("Today String: " + todaysDateStr);
//        System.out.println("Today Parsed: " + d1);
//        System.out.println("Today getTime(): " + d1.getTime());
//        System.out.println("");
//        System.out.println("Departure String: " + departureDate);
//        System.out.println("Departure Parsed: " + d2);
//        System.out.println("Departure Date with getTime(): " + d2.getTime());
//        System.out.println("Difference in days: " + difference_In_Days);


        return difference_In_Days;
    }

    // increase price based off of the proximity to today's date
    private static double ratesDaysAwayAndDestination(double basePrice, int daysAway) {
        double rateByDaysAway = 0;

        if ( daysAway >=90){
            rateByDaysAway = basePrice;}
        else if(daysAway >=75){
            rateByDaysAway = (basePrice * .25) + basePrice;}
        else if ( daysAway >=30){
            rateByDaysAway = (basePrice * .50) + basePrice;}
        else if ( daysAway >=14){
            rateByDaysAway = (basePrice * .75) + basePrice;}
        else if ( daysAway >=0){
            rateByDaysAway = (basePrice * .85) + basePrice;
        }
//        System.out.println(rateByDaysAway);
        return rateByDaysAway;
    }



//    public static void main(String[] args) throws ParseException {
//        //establish base price for each City
//
//        ticketPrice(13, "f", "Chicago", "6/25/2022");
//        }
}
