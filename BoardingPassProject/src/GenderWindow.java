import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenderWindow extends BaseWindow implements ActionListener {

    JFrame frame = new JFrame("Select Gender");
    JButton femaleButton, maleButton;
    JLabel label;
    Member member;


    GenderWindow(Member member) {
        this.member = member;
        label = new JLabel("Please Pick How You Identify:");
        label.setBounds(300, 0, 800, 50);
        label.setFont(new Font(null, Font.BOLD, 25));

        ImageIcon image = new ImageIcon("BoardingPass/BoardingPassProject/src/img.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(new Color(23, 217, 147));

        frame.add(label);
        frame.setLayout(null);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);

        femaleButton = new JButton("Female");
        femaleButton.setBounds(250, 200, 250, 200);
        femaleButton.setFont(new Font(null, Font.BOLD, 30));
        femaleButton.setFocusable(false);
        femaleButton.addActionListener(this);
        frame.add(femaleButton);

        maleButton = new JButton("Male");
        maleButton.setBounds(500, 200, 250, 200);
        maleButton.setFont(new Font(null, Font.BOLD, 30));
        maleButton.setFocusable(false);
        maleButton.addActionListener(this);
        frame.add(maleButton);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == femaleButton) {
            member.setGender(femaleButton.getActionCommand());

            frame.dispose();

            DestinationWindow destinationWindow = new DestinationWindow(member);

        } else if (e.getSource() == maleButton) {
            member.setGender(maleButton.getActionCommand());

            frame.dispose();

            DestinationWindow destinationWindow = new DestinationWindow(member);
        }
    }
}
