import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private JFrame frame = new JFrame("Login");
    private JButton startButton = new JButton("Start the Game");
    ImageIcon st = new ImageIcon("tictactoe img.jpg");

    MainMenu() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 505);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);


        //Background
        JLabel background = new JLabel(new ImageIcon("tictactoe gif.gif"));
        background.setLayout(null);
        background.setForeground(Color.gray);

        startButton.setBounds(171, 415, 150, 40);
        startButton.setBackground(Color.lightGray);
        startButton.setBorder(null);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new Game();
            }
        });

        frame.add(startButton);
        frame.add(background);
        frame.setVisible(true);

    }
}
