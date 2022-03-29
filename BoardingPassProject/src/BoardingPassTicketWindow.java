import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

public class BoardingPassTicketWindow extends DepartureDateTimeWindow {

    JFrame frame = new JFrame("Generated Boarding Pass");
    JLabel boardingPassNumberLabel, flightDetailsLabel, fromToLabel, userInformationLabel, ticketPriceLabel, label;


    BoardingPassTicketWindow() throws ParseException {

        label = new JLabel("Here is your Ticket Information:");
        label.setBounds(300,0,800,50);
        label.setFont(new Font(null, Font.BOLD, 25));

        ImageIcon image = new ImageIcon("BoardingPass/BoardingPassProject/src/img.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(23, 217, 147));

        frame.add(label);
        frame.setLayout(null);
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardingPassNumberLabel = new JLabel("Boarding Pass Number: " + member.getBoardingPassNumber());
        boardingPassNumberLabel.setBounds(355,70,600,30);
        boardingPassNumberLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(boardingPassNumberLabel);

        userInformationLabel = new JLabel("Name of Passenger: " + member.getName() + '\n' +
                "Age: " + member.getAge() + '\n' + "M/F: " + member.getGender() + '\n' + "Email: " + member.getEmail() +
                '\n' + "Phone Number: " + member.getPhoneNumber());
        userInformationLabel.setBounds(355,100,600,30);
        userInformationLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(userInformationLabel);

        fromToLabel = new JLabel("Leaving from: " + member.getOrigin() + " Will arrive at: " + member.getDestination());
        fromToLabel.setBounds(355,250,600,30);
        fromToLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(fromToLabel);

        flightDetailsLabel = new JLabel("Leaving on: " + member.getDepartureDate() + '\n' +
                "At: " + member.getDepartureTime() + '\n' +
                "Will arrive at: " + member.getETA());
                //Throwing errors
                /*fix problem w/ line 147 in Member,
                line 50 + 33 in Ticket,
                line 46 in BoardingPassTicketWindow,
                line 95 in DepartureDateTimeWindow(4 internal errors) BasicButtonListener*/
        flightDetailsLabel.setBounds(355,280,600,30);
        flightDetailsLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(flightDetailsLabel);

        ticketPriceLabel = new JLabel("Total Ticket Price: " + member.getTicketPrice());
        ticketPriceLabel.setBounds(355,370,600,30);
        ticketPriceLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(ticketPriceLabel);


        frame.setVisible(true);
    }

}
