package Semproj;

import jdk.jshell.spi.ExecutionControlProvider;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class voter implements ActionListener {
    JFrame f3,fr1;
    ImageIcon logo;
    JLabel l7,l8,lv1,lv2,lv3,ID,Name;
    DefaultTableModel model;
    JTextField t3,id_field,Name_field;
    JTextArea l9;
    JButton b9,b10,vb,vb4,search;
    JTable table;
    voter()
    {
        f3=new JFrame("VOTER");
        f3.setBounds(200,200,500,200);
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f3.getContentPane().setBackground(new Color(148,195,189));
        f3.setResizable(false);
        f3.setLayout(null);

        logo = new ImageIcon(".//image//logo.jpg");
        f3.setIconImage(logo.getImage());

        l7=new JLabel("Please Enter Your Login Credentials");
        l7.setBounds(125,0,400,50);
        l7.setFont(new Font("Times New Roman",Font.PLAIN,15));
        l7.setForeground(Color.black);

        l8=new JLabel("ID");
        l8.setBounds(20,50,100,30);
        l8.setFont(new Font("Georgia",Font.PLAIN,14));
        l8.setForeground(Color.black);

        t3=new JTextField();
        t3.setBounds(130,50,200,27);
        t3.setBorder(new LineBorder(Color.lightGray,3));

        search=new JButton("Search");
        search.setBounds(340,55,99,20);
        search.setBackground(new Color(101,101,230));
        search.addActionListener(this);
        f3.add(search);

        l9=new JTextArea();
        l9.setBounds(20,85,500,50);
        l9.setBackground(new Color(148,195,189));
        l9.setFont(new Font("Georgia",Font.PLAIN,14));
        l9.setForeground(Color.black);

        b9=new JButton("BACK");
        b9.setBounds(130,135,99,20);
        b9.setBackground(new Color(101,101,230));
        b9.addActionListener(this);

        b10=new JButton("LOGIN");
        b10.setBounds(232,135,99,20);
        b10.setEnabled(false);
        b10.setBackground(new Color(101,101,230));
        b10.addActionListener(this);


        f3.add(l7);
        f3.add(l8);
        f3.add(l9);
        f3.add(t3);
        //f3.add(ps3);
        f3.add(b9);
        f3.add(b10);
        f3.setVisible(true);

        fr1=new JFrame("VOTER");
        fr1.setBounds(200,200,600,250);
        fr1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr1.setResizable(false);
        fr1.getContentPane().setBackground(Color.white);
        fr1.setVisible(false);
        fr1.setLayout(null);
        fr1.setIconImage(logo.getImage());

        lv1=new JLabel("Candidate ID");
        lv1.setBounds(120,0,100,20);
        lv1.setFont(new Font("Times New Roman",Font.PLAIN,14));
        fr1.add(lv1);

        lv2=new JLabel("Candidate Name");
        lv2.setBounds(240,0,100,20);
        lv2.setFont(new Font("Times New Roman",Font.PLAIN,14));
        fr1.add(lv2);

        lv3=new JLabel("Candidate Qualification");
        lv3.setBounds(365,0,150,20);
        lv3.setFont(new Font("Times New Roman",Font.PLAIN,14));
        fr1.add(lv3);

        model=new DefaultTableModel(0,3);
        table=new JTable(model);
        table.setBounds(100,20,400,70);
        table.setBackground(Color.BLACK);
        table.setForeground(Color.white);
        fr1.add(table);

        ID=new JLabel("Enter ID");
        ID.setBounds(10,130,120,30);
        ID.setBackground(Color.white);
        ID.setForeground(Color.black);
        ID.setFont(new Font("Times New Roman",Font.ITALIC,14));
        fr1.add(ID);

        id_field=new JTextField();
        id_field.setBounds(120,130,120,25);
        id_field.setBorder(new LineBorder(Color.black,1));
        fr1.add(id_field);
        
        Name=new JLabel("Name");
        Name.setBounds(10,160,120,30);
        Name.setBackground(Color.white);
        Name.setForeground(Color.black);
        Name.setFont(new Font("Times New Roman",Font.ITALIC,14));
        fr1.add(Name);

        Name_field=new JTextField();
        Name_field.setBounds(120,160,120,25);
        Name_field.setBorder(new LineBorder(Color.black,1));
        fr1.add(Name_field);
        
        vb4=new JButton("CAST VOTE");
        vb4.setBounds(300,160,120,30);
        vb4.setBackground(Color.BLACK);
        vb4.setFocusable(false);
        vb4.setForeground(Color.white);
        vb4.addActionListener(this);

        vb=new JButton("BACK");
        vb.setBounds(465,170,80,20);
        vb.setBackground(Color.lightGray);
        vb.addActionListener(this);
        fr1.add(vb4);
        fr1.add(vb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b10){
            try{
                Connection con=ConnectionClass.connection();
                String q="Select * from CandidateInfo";
                PreparedStatement ps=con.prepareStatement(q);

                ResultSet rs=ps.executeQuery(q);
                while (rs.next())
                {
                    int id=rs.getInt("id");
                    String nm=rs.getString("name");
                    String qua=rs.getString("qualification");

                    String []data={String.valueOf(id),nm,qua};
                    model.addRow(data);
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
            f3.setVisible(false);
            fr1.setVisible(true);
        } else if (e.getSource()==b9) {
            f3.setVisible(false);
            new mainframe();
        } else if (e.getSource()==vb) {
            fr1.setVisible(false);
            f3.setVisible(true);
        } else if (e.getSource()==search) {
            b10.setEnabled(true);
            String id=t3.getText();
            try{
                Connection con = ConnectionClass.connection();
                String qu = "select* from voter where id= "+ id;
                PreparedStatement ps = con.prepareStatement(qu);

                ResultSet rs = ps.executeQuery(qu);
                while(rs.next()){
                    String Name=rs.getString("name");
                    String Fn=rs.getString("Fname");

                    l9.setText("\t         Name : "+Name+"" +
                            "\n\t      Father Name : "+Fn);

                }
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource()==vb4) {
            boolean f=false;
            Connection c=ConnectionClass.connection();
            try {
                String qu="select * from voter where id = "+ t3.getText();

                PreparedStatement ps=c.prepareStatement(qu);

                ResultSet rp=ps.executeQuery(qu);
                while(rp.next()){
                    int chk=rp.getInt("vote_check");
                    if(Objects.equals(chk,1)){
                        JOptionPane.showMessageDialog(null,"Vote is Already Casted From This ID!\n" +
                                "Can't cast again");
                    }
                    else if (Objects.equals(chk,0))
                    {
                        String query="Update voter set vote_check=1 where id = "+t3.getText();
                        PreparedStatement pst=c.prepareStatement(query);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Vote Casted! Thanks :-)");
                        f=true;
                        fr1.setVisible(false);
                        new mainframe();
                    }
                }
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
            if(f){
                try {
                    String q = "select* from CandidateInfo where id= " + id_field.getText();
                    PreparedStatement ps = c.prepareStatement(q);
                    ResultSet rst = ps.executeQuery(q);

                    while (rst.next()) {
                        int id = rst.getInt("votes");
                        id += 1;
                        String qu = "update CandidateInfo set votes = " + id + " where id = " + id_field.getText();
                        PreparedStatement pst = c.prepareStatement(qu);
                        pst.executeUpdate();
                    }
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
}
