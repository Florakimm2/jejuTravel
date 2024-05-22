package jejuTravelPackage;

import javax.swing.*;
import java.awt.event.*;

public class Frame extends JFrame implements ActionListener{
    JFrame f;
    JButton button;
    JLabel label;
    JPanel panel;

    public Frame(String msg) {
        f = new JFrame(msg);
        f.setSize(400, 400);

        panel = new JPanel();
        button = new JButton("Button");
        label = new JLabel("Please, Click the Button");

        //1st type
        button.addActionListener(this);
        panel.add(button);
        panel.add(label);

        f.add(panel);
        f.setVisible(true);
    }

    //event handling 코드 구현
    //overriding
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            label.setText("Clicked the Button");
        }
    }
}
