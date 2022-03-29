import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DestinationWindow extends GenderWindow implements ActionListener {

    JFrame frame = new JFrame("Select Destination");
    JButton chicagoButton, dallasButton, denverButton, newYorkButton;
    JLabel label;


    DestinationWindow() {

        label = new JLabel("Please Pick Your Destination of Choice:");
        label.setBounds(250,0,800,50);
        label.setFont(new Font(null, Font.BOLD,25));

        ImageIcon image = new ImageIcon("BoardingPass/BoardingPassProject/src/img.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(23, 217, 147));

        frame.add(label);
        frame.setLayout(null);
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);

        chicagoButton = new JButton("Chicago");
        chicagoButton.setBounds(250,200,250,200);
        chicagoButton.setFont(new Font(null, Font.BOLD, 30));
        chicagoButton.setFocusable(false);
        chicagoButton.addActionListener(this);
        frame.add(chicagoButton);

        dallasButton = new JButton("Dallas");
        dallasButton.setBounds(500,200,250,200);
        dallasButton.setFont(new Font(null, Font.BOLD, 30));
        dallasButton.setFocusable(false);
        dallasButton.addActionListener(this);
        frame.add(dallasButton);

        denverButton = new JButton("Denver");
        denverButton.setBounds(250,400,250,200);
        denverButton.setFont(new Font(null, Font.BOLD, 30));
        denverButton.setFocusable(false);
        denverButton.addActionListener(this);
        frame.add(denverButton);

        newYorkButton = new JButton("New York");
        newYorkButton.setBounds(500,400,250,200);
        newYorkButton.setFont(new Font(null, Font.BOLD, 30));
        newYorkButton.setFocusable(false);
        newYorkButton.addActionListener(this);
        frame.add(newYorkButton);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == chicagoButton) {
            member.setDestination(chicagoButton.getActionCommand());
            frame.dispose();
            DepartureDateTimeWindow departureDateTimeWindow = new DepartureDateTimeWindow();

        } else if (e.getSource() == dallasButton) {
            member.setDestination(dallasButton.getActionCommand());
            frame.dispose();
            DepartureDateTimeWindow departureDateTimeWindow = new DepartureDateTimeWindow();

        } else if (e.getSource() == denverButton) {
            member.setDestination(denverButton.getActionCommand());
            frame.dispose();
            DepartureDateTimeWindow departureDateTimeWindow = new DepartureDateTimeWindow();

        } else if (e.getSource() == newYorkButton) {
            member.setDestination(newYorkButton.getActionCommand());
            frame.dispose();
            DepartureDateTimeWindow departureDateTimeWindow = new DepartureDateTimeWindow();

        }
    }

}