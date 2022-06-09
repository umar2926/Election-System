package Semproj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class mainframe implements ActionListener {
    JFrame fm;
    JButton b,b1,b2;
    ImageIcon logo;
    mainframe()
    {
        fm = new JFrame("Election System");
        fm.setBounds(200, 200, 500, 500);
        fm.setResizable(false);
        fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fm.getContentPane().setBackground(new Color(255, 255, 255));
        fm.setLayout(null);

        logo = new ImageIcon(".//image//logo.jpg");
        fm.setIconImage(logo.getImage());

        ImageIcon i = new ImageIcon(".//image//admin.png");
        b = new JButton(i);
        b.setBackground(Color.white);
        b.setBorder(BorderFactory.createEmptyBorder());
        b.setFocusable(false);
        b.setBounds(50, 30, 150, 120);
        b.addActionListener(this);

        JLabel admin = new JLabel("ADMIN");
        admin.setToolTipText("Click on image to enter admin section");
        admin.setBounds(80, 155, 100, 30);
        admin.setFont(new Font("Times New Roman", Font.BOLD, 16));
        admin.setForeground(new Color(0, 0, 0));

        ImageIcon i2 = new ImageIcon(".//image//voter.png");
        b2 = new JButton(i2);
        b2.setBackground(Color.white);
        b2.setBorder(BorderFactory.createEmptyBorder());
        b2.setBounds(290, 30, 120, 120);
        b2.addActionListener(this);

        JLabel voter = new JLabel("VOTER");
        voter.setToolTipText("Click on image to enter voter section");
        voter.setBounds(330, 150, 100, 30);
        voter.setFont(new Font("Times New Roman", Font.BOLD, 16));
        voter.setForeground(new Color(0, 0, 0));

        ImageIcon i3 = new ImageIcon(".//image//candidate.png");
        b1 = new JButton(i3);
        b1.setBackground(Color.white);
        b1.setBorder(BorderFactory.createEmptyBorder());
        b1.setBounds(190, 230, 170, 120);
        b1.addActionListener(this);

        JLabel candidate = new JLabel("CANDIDATE");
        candidate.setToolTipText("Click on image to enter candidate section");
        candidate.setBounds(200, 350, 100, 30);
        candidate.setFont(new Font("Times New Roman", Font.BOLD, 16));
        candidate.setForeground(new Color(0, 0, 0));

        fm.add(admin);
        fm.add(voter);
        fm.add(candidate);
        fm.add(b);
        fm.add(b1);
        fm.add(b2);
        fm.setVisible(true);
    }
    public static void main(String[] args){
        new intro();
        new mainframe();
       }


    @Override
    public void actionPerformed(ActionEvent e) {
        int chk=0;
        Connection con=ConnectionClass.connection();
        String Qu="select* from start_stop";
        try{
            PreparedStatement ps=con.prepareStatement(Qu);
            ResultSet rs=ps.executeQuery(Qu);
            while (rs.next()){
                chk=rs.getInt("choice");
            }
        }catch (Exception es){
            es.printStackTrace();
        }
        if (e.getSource()==b)
        {
            fm.setVisible(false);
            new admin();
        } else if (e.getSource()==b1) {
            if(Objects.equals(chk,1)){
                JOptionPane.showMessageDialog(null,"Voting Is Not Started Yet!");
            } else if (Objects.equals(chk,0)) {
                fm.setVisible(false);
                new candidate();
            }
        } else if (e.getSource()==b2) {
            if(Objects.equals(chk,1)){
                JOptionPane.showMessageDialog(null,"Voting Is Not Started Yet!");
            } else if (Objects.equals(chk,0)) {
                fm.setVisible(false);
                new voter();
            }
        }
    }
}
