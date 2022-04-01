package org.genspark;

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
        rateByAge(ratesDaysAwayAndDestination(ratebyDestination(destination), daysAway(departureDate)), age, gender);
        return finalPrice;
    }

    public static double rateByAge(double rate, int age, String gender) {

        double ageDiscount = rate;

        if (age <= 12) {
            ageDiscount = rate - (rate * .5);
        } else if (age >= 60) {
            ageDiscount = rate - (rate * .6);
        } else {
            ageDiscount = rate;
        }

        return rateByGender(ageDiscount, gender);
    }

    public static double rateByGender(double ageDiscount, String gender) {
        if (gender.equals("f")) {
            finalPrice = ageDiscount - (ageDiscount * .25);

        } else finalPrice = ageDiscount;

        return finalPrice;
    }


    public static double ratebyDestination(String destination) {

        switch (destination) {
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

        // set today's date and format it as a String "dd/MM/yyyy"
        Calendar c = new GregorianCalendar();
        String year = String.valueOf(c.get(Calendar.YEAR));
        String month = String.valueOf(c.get(Calendar.MONTH) + 1);
        String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        String todaysDateStr = String.valueOf(month + "/" + day + "/" + year);


        //parse both departure date and current date
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date d1 = sdf.parse(todaysDateStr);
        Date d2 = sdf.parse(departureDate);

        // use get time to find the difference in milliseconds
        long difference_In_Time = d2.getTime() - d1.getTime();


        //convert difference into days
        int difference_In_Days = (int) ((difference_In_Time / (1000 * 60 * 60 * 24)) % 365);

        return difference_In_Days;
    }

    // increase price based off of the proximity to today's date
    public static double ratesDaysAwayAndDestination(double basePrice, int daysAway) {
        double rateByDaysAway = 0;

        if (daysAway >= 90) {
            rateByDaysAway = basePrice;
        } else if (daysAway >= 75) {
            rateByDaysAway = (basePrice * .25) + basePrice;
        } else if (daysAway >= 30) {
            rateByDaysAway = (basePrice * .50) + basePrice;
        } else if (daysAway >= 14) {
            rateByDaysAway = (basePrice * .75) + basePrice;
        } else if (daysAway >= 0) {
            rateByDaysAway = (basePrice * .85) + basePrice;
        }

        return rateByDaysAway;

    }
}
