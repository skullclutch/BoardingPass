import javax.swing.*;
import java.awt.*;

public class BoardingPassTicketWindow extends DepartureDateTimeWindow {

    JFrame frame = new JFrame("Generated Boarding Pass");
    JLabel boardingPassNumberLabel, dateLabel, originLabel, destinationLabel, ETALabel, departureTimeLabel, nameLabel,
    emailLabel, phoneNumberLabel, genderLabel, ageLabel, ticketPriceLabel, label;


    BoardingPassTicketWindow() {

        label = new JLabel("Here is your Boarding Pass:");
        label.setBounds(300,0,800,50);
        label.setFont(new Font(null, Font.BOLD, 25));

        ImageIcon image = new ImageIcon("BoardingPass/BoardingPassProject/src/img.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(23, 217, 147));

        frame.add(label);
        frame.setLayout(null);
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);

        boardingPassNumberLabel = new JLabel("Boarding Pass Number: ");


        frame.setVisible(true);
    }

}
