package Semproj;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class candidate implements ActionListener {
    JFrame f2,can;
    ImageIcon logo;
    JLabel l3,l4,l5,l6,lc,lc1,lc2,l7;
    JTextField t2,tc1,tc2,t3;
    JPasswordField ps2;
    JButton b7,b8,bl;
    candidate()
    {
        f2=new JFrame("CANDIDATE");
        f2.setBounds(200,200,500,300);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.getContentPane().setBackground(new Color(148,195,189));
        f2.setResizable(false);
        f2.setLayout(null);

        logo = new ImageIcon(".//image//logo.jpg");
        f2.setIconImage(logo.getImage());

        l3=new JLabel("Please Enter Your Login Credentials");
        l3.setBounds(125,0,400,50);
        l3.setFont(new Font("Times New Roman",Font.PLAIN,15));
        l3.setForeground(Color.black);

        l4=new JLabel("ID");
        l4.setBounds(20,50,100,30);
        l4.setFont(new Font("Georgia",Font.PLAIN,14));
        l4.setForeground(Color.black);

        t2=new JTextField();
        t2.setBounds(130,50,200,27);
        t2.setBorder(new LineBorder(Color.lightGray,3));

        l7=new JLabel("Username");
        l7.setBounds(20,85,100,30);
        l7.setFont(new Font("Georgia",Font.PLAIN,14));
        l7.setForeground(Color.black);

        t3=new JTextField();
        t3.setBounds(130,85,200,27);
        t3.setBorder(new LineBorder(Color.lightGray,3));

        l5=new JLabel("Password");
        l5.setBounds(20,120,100,30);
        l5.setFont(new Font("Georgia",Font.PLAIN,14));
        l5.setForeground(Color.black);

        ps2=new JPasswordField("");
        ps2.setBounds(130,120,200,27);
        ps2.setBorder(new LineBorder(Color.lightGray,3));

        b7=new JButton("BACK");
        b7.setBounds(130,160,99,20);
        b7.setBackground(new Color(101,101,230));
        b7.addActionListener(this);

        b8=new JButton("LOGIN");
        b8.setBounds(232,160,99,20);
        b8.setBackground(new Color(101,101,230));
        b8.addActionListener(this);

        l6=new JLabel("Not Registered! Contact Administration For Registration");
        l6.setBounds(50,200,400,30);
        l6.setFont(new Font("Georgia",Font.PLAIN,14));
        l6.setForeground(Color.black);

        f2.add(l3);
        f2.add(l4);
        f2.add(l5);
        f2.add(l6);
        f2.add(l7);
        f2.add(t2);
        f2.add(t3);
        f2.add(ps2);
        f2.add(b7);
        f2.add(b8);
        f2.setVisible(true);
        can=new JFrame("Candidate");
        can.setBounds(200,200,600,250);
        can.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        can.setResizable(false);
        can.getContentPane().setBackground(Color.white);
        can.setVisible(false);
        can.setLayout(null);
        can.setIconImage(logo.getImage());

        lc=new JLabel("Current Voting Details");
        lc.setBounds(200,20,250,30);
        lc.setFont(new Font("Times New Roman",Font.BOLD,24));
        lc.setForeground(new Color(30,50,220));

        lc1=new JLabel("Total Current Votes");
        lc1.setBounds(90,70,150,30);
        lc1.setBackground(Color.black);
        lc1.setFont(new Font("Times new Roman",Font.PLAIN,17));

        lc2=new JLabel("Remaining Votes");
        lc2.setBounds(90,110,150,30);
        lc2.setBackground(Color.black);
        lc2.setFont(new Font("Times new Roman",Font.PLAIN,17));

        tc1=new JTextField();
        tc1.setBounds(240,70,150,30);
        tc1.setBackground(Color.white);
        tc1.setBorder(new LineBorder(Color.black,1));
        tc1.setEditable(false);

        tc2=new JTextField();
        tc2.setBounds(240,110,150,30);
        tc2.setBackground(Color.white);
        tc2.setBorder(new LineBorder(Color.black,1));
        tc2.setEditable(false);

        bl=new JButton("BACK");
        bl.setBounds(465,170,80,20);
        bl.setBackground(Color.lightGray);
        bl.addActionListener(this);

        can.add(lc);
        can.add(lc1);
        can.add(lc2);
        can.add(tc1);
        can.add(tc2);
        can.add(bl);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b8){
            String user=t3.getText();
            int id=Integer.parseInt(t2.getText());
            String pass=ps2.getText();

            boolean b=false;
            try{
                Connection c=ConnectionClass.connection();
                String query="Select * from CandidateInfo where id="+id;
                PreparedStatement pst=c.prepareStatement(query);
                ResultSet rst=pst.executeQuery(query);

                while(rst.next())
                {
                    String us=rst.getString("user");
                    String ps=rst.getString("pass");

                    if(Objects.equals(user,us)&&Objects.equals(pass,ps)){
                        b=true;
                    }
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
            if(b){
                int total=0,remaining=0;
                f2.setVisible(false);
                can.setVisible(true);
                try{
                    Connection con = ConnectionClass.connection();
                    String query = "select * from voter";
                    PreparedStatement pst = con.prepareStatement(query);

                    ResultSet rs= pst.executeQuery(query);
                    while(rs.next()){
                        int count=rs.getInt("vote_check");
                        if (Objects.equals(count,0)){
                            remaining++;
                        } else if (Objects.equals(count,1)) {
                            total++;
                        }
                    }
                    tc1.setText(String.valueOf(total));
                    tc2.setText(String.valueOf(remaining));

                }catch(Exception exc)
                {
                    exc.printStackTrace();
                }

            }
            else {
                JOptionPane.showMessageDialog(null,"Invalid id/username/password");
            }
        } else if (e.getSource()==b7) {
            f2.setVisible(false);
            new mainframe();
        } else if (e.getSource()==bl) {
            can.setVisible(false);
            f2.setVisible(true);
        }
    }
}
