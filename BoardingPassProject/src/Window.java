import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

public class Window {

    JFrame frame;
    JButton quitButton, submitButton;
    JTextField nameText, departureDateText, ageText, emailText, genderText, destinationText, departureTimeText,phoneNumberText;
    JLabel nameLabel, departureDateLabel, ageLabel, emailLabel, genderLabel, destinationLabel, departureTimeLabel, phoneNumberLabel;


    Window() {
        frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("Boarding Pass Ticket");
        frame.setSize(600,400);
        frame.setLocationRelativeTo(null);


        ImageIcon image = new ImageIcon("BoardingPass/BoardingPassProject/src/img.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(23, 217, 147));

        nameLabel = new JLabel("Enter Name");
        nameLabel.setBounds(10,10,90,20);
        frame.add(nameLabel);

        nameText = new JTextField();
        nameText.setBounds(135,10,150,20);
        frame.add(nameText);

        departureDateLabel = new JLabel("Enter Departure Date");
        departureDateLabel.setBounds(10,30,150,20);
        frame.add(departureDateLabel);

        departureDateText = new JTextField();
        departureDateText.setBounds(135,30,150,20);
        frame.add(departureDateText);

        ageLabel = new JLabel("Enter Age");
        ageLabel.setBounds(10,50,90,20);
        frame.add(ageLabel);

        ageText = new JTextField();
        ageText.setBounds(135,50,150,20);
        frame.add(ageText);

        emailLabel = new JLabel("Enter Email");
        emailLabel.setBounds(10,70,90,20);
        frame.add(emailLabel);

        emailText = new JTextField();
        emailText.setBounds(135,70,150,20);
        frame.add(emailText);

        genderLabel = new JLabel("Enter Gender");
        genderLabel.setBounds(10,90,90,20);
        frame.add(genderLabel);

        genderText = new JTextField();
        genderText.setBounds(135,90,150,20);
        frame.add(genderText);

        destinationLabel = new JLabel("Enter Destination");
        destinationLabel.setBounds(10,110,150,20);
        frame.add(destinationLabel);

        destinationText = new JTextField();
        destinationText.setBounds(135,110,150,20);
        frame.add(destinationText);

        departureTimeLabel = new JLabel("Enter Departure Time");
        departureTimeLabel.setBounds(10,130,150,20);
        frame.add(departureTimeLabel);

        departureTimeText = new JTextField();
        departureTimeText.setBounds(135,130,150,20);
        frame.add(departureTimeText);

        phoneNumberLabel = new JLabel("Enter Phone Number");
        phoneNumberLabel.setBounds(10,150,150,20);
        frame.add(phoneNumberLabel);

        phoneNumberText = new JTextField();
        phoneNumberText.setBounds(135,150,150,20);
        frame.add(phoneNumberText);

        submitButton = new JButton("Submit");
        submitButton.setBounds(50,225,100,50);
        submitButton.addActionListener((event) -> {
            try {
                new Member(nameText.getText(),emailText.getText(),phoneNumberText.getText(), genderText.getText(), ageText.getText(), departureDateText.getText(),destinationText.getText(),departureTimeText.getText());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
        frame.add(submitButton);

        quitButton = new JButton("Quit");
        quitButton.setBounds(150,225,100,50);
        quitButton.addActionListener((event)->frame.dispose());
        frame.add(quitButton);

        frame.setVisible(true);
    }

}
