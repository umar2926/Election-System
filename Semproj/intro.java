package Semproj;

import javax.swing.*;
import java.awt.*;

public class intro {
    JFrame f;
    JLabel l,l1;
    JProgressBar pb2;
    intro()
    {
        f = new JFrame();
        f.setBounds(200, 200, 500, 500);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setUndecorated(true);
        f.getContentPane().setBackground(Color.white);
        f.setLayout(null);

        l = new JLabel("ELECTION PORTAL");
        l.setBounds(130, 250, 250, 30);
        l.setForeground(new Color(50, 150, 128));
        l.setFont(new Font("Geo rgian", Font.BOLD, 22));

        l1 = new JLabel();
        l1.setIcon(new ImageIcon(".//image//au.png"));
        l1.setBounds(110, 10, 250, 220);


        pb2 = new JProgressBar();
        pb2.setValue(0);
        pb2.setStringPainted(true);
        pb2.setBounds(90, 300, 300, 35);
        pb2.setForeground(new Color(15,0,220));

        f.add(pb2);
        f.add(l1);
        f.add(l);
        f.setVisible(true);
        for (int i = 0; i <= 100; i++) {
            pb2.setString("Loading . . . " + i);
            pb2.setValue(i);
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        f.setVisible(false);
    }
}
