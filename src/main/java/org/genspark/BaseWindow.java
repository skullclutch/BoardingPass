package org.genspark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BaseWindow extends Member implements ActionListener {

    JFrame frame;
    JButton quitButton, submitButton;
    JTextField nameText, ageText, emailText, phoneNumberText;
    JLabel nameLabel, ageLabel, emailLabel, phoneNumberLabel;
    public Member member = new Member();

    BaseWindow() {

        frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Boarding Pass Ticket Terminal");
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);

        ImageIcon image = new ImageIcon("BoardingPass/BoardingPassProject/src/img.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(23, 217, 147));

        nameLabel = new JLabel("Enter Name");
        nameLabel.setBounds(10, 10, 90, 20);
        frame.add(nameLabel);

        nameText = new JTextField();
        nameText.setBounds(135, 10, 150, 20);
        frame.add(nameText);

        ageLabel = new JLabel("Enter Age");
        ageLabel.setBounds(10, 30, 90, 20);
        frame.add(ageLabel);

        ageText = new JTextField();
        ageText.setBounds(135, 30, 150, 20);
        frame.add(ageText);

        emailLabel = new JLabel("Enter Email");
        emailLabel.setBounds(10, 50, 90, 20);
        frame.add(emailLabel);

        emailText = new JTextField();
        emailText.setBounds(135, 50, 150, 20);
        frame.add(emailText);

        phoneNumberLabel = new JLabel("Enter Phone Number");
        phoneNumberLabel.setBounds(10, 70, 150, 20);
        frame.add(phoneNumberLabel);

        phoneNumberText = new JTextField();
        phoneNumberText.setBounds(135, 70, 150, 20);
        frame.add(phoneNumberText);

        submitButton = new JButton("Submit");
        submitButton.setBounds(50, 225, 100, 50);
        submitButton.addActionListener(this);
        frame.add(submitButton);

        quitButton = new JButton("Quit");
        quitButton.setBounds(150, 225, 100, 50);
        quitButton.addActionListener((event) -> frame.dispose());
        frame.add(quitButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {

            member.setName(nameText.getText());
            member.setAge(ageText.getText());
            member.setEmail(emailText.getText());
            member.setPhoneNumber(phoneNumberText.getText());

            frame.dispose();

            GenderWindow genderWindow = new GenderWindow(member);

        }

    }
}
