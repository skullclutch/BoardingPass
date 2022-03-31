import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

public class DepartureDateTimeWindow extends DestinationWindow implements ActionListener {

    JFrame frame = new JFrame("Enter Departure Date and Time");
    JButton submitButton;
    JTextField departureDateText, departureTimeText;
    JLabel departureDateLabel, departureTimeLabel, label;

    DepartureDateTimeWindow(Member member) {
        super(member);
        label = new JLabel("Please Choose Departure Date and Time:");
        label.setBounds(250, 0, 800, 50);
        label.setFont(new Font(null, Font.BOLD, 25));

        ImageIcon image = new ImageIcon("BoardingPass/BoardingPassProject/src/img.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(23, 217, 147));

        frame.add(label);
        frame.setLayout(null);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);

        departureDateLabel = new JLabel("Enter Departure Date");
        departureDateLabel.setBounds(10, 55, 120, 20);
        frame.add(departureDateLabel);

        departureDateText = new JTextField();
        departureDateText.setBounds(135, 55, 150, 20);
        frame.add(departureDateText);

        departureTimeLabel = new JLabel("Enter Departure Time");
        departureTimeLabel.setBounds(10, 75, 130, 20);
        frame.add(departureTimeLabel);

        departureTimeText = new JTextField("ex: 16:00 for 4:00pm");
        departureTimeText.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                departureTimeText.setText("");
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        departureTimeText.setBounds(135, 75, 150, 20);
        frame.add(departureTimeText);

        submitButton = new JButton("Submit");
        submitButton.setBounds(400, 100, 100, 50);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        frame.add(submitButton);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {
            member.setDepartureDate(departureDateText.getText());
            member.setDepartureTime(departureTimeText.getText());

            frame.dispose();

            try {
                BoardingPassTicketWindow boardingPassTicketWindow = new BoardingPassTicketWindow(member);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

        }

    }

}
