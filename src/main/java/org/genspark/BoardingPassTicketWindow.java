package org.genspark;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

public class BoardingPassTicketWindow extends DepartureDateTimeWindow {

    JFrame frame = new JFrame("Generated Boarding Pass");
    JLabel boardingPassNumberLabel, originLabel, destinationLabel, departureDateLabel, departureTimeLabel, etaLabel,
            nameLabel, ageLabel, genderLabel, emailLabel, phoneNumberLabel, ticketPriceLabel, label;
    Member member;

    BoardingPassTicketWindow(Member member) throws ParseException {
        super(member);
        this.member = member;
        label = new JLabel("Here is your Ticket Information:");
        label.setBounds(300, 0, 800, 50);
        label.setFont(new Font(null, Font.BOLD, 25));

        ImageIcon image = new ImageIcon("BoardingPass/BoardingPassProject/src/img.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(23, 217, 147));

        frame.add(label);
        frame.setLayout(null);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardingPassNumberLabel = new JLabel("Boarding Pass Number: " + member.getBoardingPassNumber());
        boardingPassNumberLabel.setBounds(355, 70, 400, 30);
        boardingPassNumberLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(boardingPassNumberLabel);

        nameLabel = new JLabel("Name of Passenger: " + member.getName());
        nameLabel.setBounds(355, 110, 400, 30);
        nameLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(nameLabel);

        ageLabel = new JLabel("Age: " + member.getAge());
        ageLabel.setBounds(355, 150, 400, 30);
        ageLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(ageLabel);

        genderLabel = new JLabel("Gender: " + member.getGender());
        genderLabel.setBounds(355, 190, 400, 30);
        genderLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(genderLabel);

        emailLabel = new JLabel("Email: " + member.getEmail());
        emailLabel.setBounds(355, 230, 400, 30);
        emailLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(emailLabel);

        phoneNumberLabel = new JLabel("Phone Number: " + member.getPhoneNumber());
        phoneNumberLabel.setBounds(355, 270, 400, 30);
        phoneNumberLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(phoneNumberLabel);

        originLabel = new JLabel("Leaving From: " + member.getOrigin());
        originLabel.setBounds(355, 310, 400, 30);
        originLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(originLabel);

        destinationLabel = new JLabel("Will arrive at: " + member.getDestination());
        destinationLabel.setBounds(355, 350, 400, 30);
        destinationLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(destinationLabel);

        departureDateLabel = new JLabel("Leaving on: " + member.getDepartureDate());
        departureDateLabel.setBounds(355, 390, 400, 30);
        departureDateLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(departureDateLabel);

        departureTimeLabel = new JLabel("At: " + member.getDepartureTime());
        departureTimeLabel.setBounds(355, 430, 400, 30);
        departureTimeLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(departureTimeLabel);

        etaLabel = new JLabel("Will Arrive At: " + member.getETA());
        etaLabel.setBounds(355, 470, 400, 30);
        etaLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(etaLabel);

        ticketPriceLabel = new JLabel("Total Ticket Price: " + member.getTicketPrice());
        ticketPriceLabel.setBounds(355, 510, 600, 30);
        ticketPriceLabel.setFont(new Font(null, Font.BOLD, 15));
        frame.add(ticketPriceLabel);


        frame.setVisible(true);
    }

}
