package Semproj;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


public class admin implements ActionListener {
    JFrame f1;
    JLabel l, l2, l3, l4, l5, l6,l7,l8,l9,l10,l11,l12;
    JTextField t1;
    ImageIcon logo;
    JPasswordField ps1,Pass;
    JButton b3, b4, start, stop, current, declare, register, remove, sb,stb,Reg_submit,SEARCH,del;
    JPanel p1, p2, p3,p4,p5,p6,p7;
    JProgressBar pb, pb1, pb2, pb3;
    JTable tb;
    DefaultTableModel tbl;
    Timer T1,t;
    JTextField Name,F_Name,Ph_Num,Age,Qualification,Email,Search;
    JLabel winner;
    int y=0,z=0 ;
    boolean b;
    String Us;

    admin() {
        f1 = new JFrame("ADMIN");
        f1.setBounds(200, 100, 900, 350);
        f1.setResizable(false);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.getContentPane().setBackground(new Color(148, 195, 189));
        f1.setLayout(null);

        p1 = new JPanel();
        p1.setBounds(400, 0, 500, 400);
        p1.setLayout(null);
        p1.setBackground(new Color(101, 101, 255));
        p1.setVisible(true);
        f1.add(p1);

        logo = new ImageIcon(".//image//logo.jpg");
        f1.setIconImage(logo.getImage());

        l2 = new JLabel("Please Enter Your Login Credentials");
        l2.setBounds(100, 50, 400, 50);
        l2.setFont(new Font("Times New Roman", Font.BOLD, 17));
        l2.setForeground(Color.black);

        l3 = new JLabel("Username");
        l3.setBounds(30, 100, 100, 30);
        l3.setFont(new Font("Georgia", Font.BOLD, 16));
        l3.setForeground(Color.black);

        t1 = new JTextField();
        t1.setBounds(130, 100, 230, 30);
        t1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        t1.setBorder(new LineBorder(Color.black, 1));

        l4 = new JLabel("Password");
        l4.setBounds(30, 135, 100, 30);
        l4.setFont(new Font("Georgia", Font.BOLD, 16));
        l4.setForeground(Color.black);

        ps1 = new JPasswordField();
        ps1.setBounds(130, 135, 230, 30);
        ps1.setFont(new Font("verdana", Font.BOLD, 16));
        ps1.setBorder(new LineBorder(Color.black, 1));

        b3 = new JButton("BACK");
        b3.setBounds(255, 275, 120, 25);
        b3.setBackground(new Color(101, 101, 255));
        b3.setBorder(new LineBorder(Color.black, 1));
        b3.setFocusable(false);
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);

        b4 = new JButton("LOGIN");
        b4.setBounds(190, 180, 120, 25);
        b4.setBackground(new Color(148, 195, 189));
        b4.setBorder(new LineBorder(Color.black, 1));
        b4.setFocusable(false);
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);

        l5 = new JLabel("Incorrect username or password");
        l5.setBounds(135, 205, 250, 30);
        l5.setForeground(new Color(255, 0, 0));
        l5.setFont(new Font("sans", Font.BOLD, 14));
        l5.setVisible(false);

        p1.add(l2);
        p1.add(l3);
        p1.add(l5);
        p1.add(t1);
        p1.add(l4);
        p1.add(ps1);
        f1.add(b3);
        p1.add(b4);

        start = new JButton("Start Voting");
        start.setBounds(10, 40, 170, 50);
        start.setFocusable(false);
        start.setBackground(Color.black);
        start.setForeground(Color.WHITE);
        start.setEnabled(false);
        start.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
        start.addActionListener(this);
        f1.add(start);

        stop = new JButton("Stop Voting");
        stop.setBounds(195, 40, 170, 50);
        stop.setFocusable(false);
        stop.setBackground(Color.black);
        stop.setForeground(Color.WHITE);
        stop.setEnabled(false);
        stop.addActionListener(this);
        stop.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
        f1.add(stop);

        current = new JButton("Current Voting");
        current.setBounds(10, 110, 170, 50);
        current.setFocusable(false);
        current.setBackground(Color.black);
        current.setForeground(Color.WHITE);
        current.setEnabled(false);
        current.addActionListener(this);
        current.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
        f1.add(current);

        declare = new JButton("Declare Voting");
        declare.setBounds(195, 110, 170, 50);
        declare.setFocusable(false);
        declare.setBackground(Color.black);
        declare.setForeground(Color.WHITE);
        declare.setEnabled(false);
        declare.addActionListener(this);
        declare.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
        f1.add(declare);

        register = new JButton("Register Candidate");
        register.setBounds(10, 180, 170, 50);
        register.setFocusable(false);
        register.setBackground(Color.black);
        register.setForeground(Color.WHITE);
        register.setEnabled(false);
        register.addActionListener(this);
        register.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
        f1.add(register);

        remove = new JButton("Remove Candidate");
        remove.setBounds(195, 180, 170, 50);
        remove.setFocusable(false);
        remove.setBackground(Color.black);
        remove.setForeground(Color.WHITE);
        remove.setEnabled(false);
        remove.addActionListener(this);
        remove.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
        f1.add(remove);
        f1.setVisible(true);

        //start framework
        {
            p2 = new JPanel();
            p2.setBounds(400, 0, 500, 400);
            p2.setLayout(null);
            p2.setBackground(Color.black);
            p2.setVisible(false);
            f1.add(p2);

            ImageIcon i1 = new ImageIcon(".//image//start.jpg");
            sb = new JButton(i1);
            sb.setBounds(120, 20, 221, 229);
            sb.setBorder(BorderFactory.createEmptyBorder());
            sb.addActionListener(this);
            p2.add(sb);
            l = new JLabel("Voting has Started");
            l.setBounds(150, 245, 300, 30);
            l.setFont(new Font("Times New Roman", Font.ITALIC, 22));
            l.setForeground(Color.white);
            l.setVisible(false);
            p2.add(l);

            pb = new JProgressBar(0, 100);
            pb.setBounds(0, 305, 500, 7);
            pb.setBorder(null);
            pb.setBorderPainted(false);
            pb.setBackground(Color.black);
            pb.setForeground(Color.red);
            p2.add(pb);

            pb1 = new JProgressBar(JProgressBar.VERTICAL, 100, 200);
            pb1.setBounds(478, 0, 7, 305);
            pb1.setBorderPainted(false);
            pb1.setBorder(null);
            pb1.setBackground(Color.black);
            pb1.setForeground(Color.red);
            p2.add(pb1);

            pb2 = new JProgressBar(100, 200);
            pb2.setBounds(0, 0, 478, 7);
            pb2.setBorder(null);
            pb2.setBorderPainted(false);
            pb2.setBackground(Color.black);
            pb2.setForeground(Color.red);
            p2.add(pb2);

            pb3 = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
            pb3.setBounds(0, 7, 7, 400);
            pb3.setBorder(null);
            pb3.setBorderPainted(false);
            pb3.setBackground(Color.black);
            pb3.setForeground(Color.red);
            p2.add(pb3);

            T1 = new Timer(40, e -> {
                pb.setValue(y++);
                pb3.setValue(y++);
                if (y >= 100) {
                    T1.setDelay(60);
                    pb1.setValue(y++);
                    pb2.setValue(y++);
                    if (y >= 230) {
                        T1.stop();
                        l.setVisible(true);
                        b=true;
                    }
                }
            });
        }
        //stop framework
        {
            p3 = new JPanel();
            p3.setBounds(400, 0, 500, 400);
            p3.setLayout(null);
            p3.setBackground(Color.black);
            p3.setVisible(false);
            f1.add(p3);

            ImageIcon i2 = new ImageIcon(".//image//stop.jpg");
            stb = new JButton(i2);
            stb.setBounds(120, 20, 221, 229);
            stb.setBorder(BorderFactory.createEmptyBorder());
            stb.addActionListener(this);
            p3.add(stb);

            l6=new JLabel("Please Wait .....");
            l6.setBounds(180,255,200,30);
            l6.setFont(new Font("Times New Roman",Font.BOLD,18));
            l6.setForeground(Color.white);
            l6.setVisible(false);
            p3.add(l6);

            t=new Timer(100, e1 -> {
                l6.setVisible(true);
                z++;
                if (z==40)
                {
                    l6.setText("Processing....");
                }
                else if(z>=80){
                    l6.setText("Voting Stopped");
                    t.stop();
                }
            });
        }
        //Register Candidate
        {
            p4 = new JPanel();
            p4.setBounds(400, 0, 500, 400);
            p4.setLayout(null);
            p4.setBackground(Color.black);
            p4.setVisible(false);
            f1.add(p4);

            JLabel info,name,f_name,ph_num,age,qualification,email,pass;


            info=new JLabel("Please Provide Information");
            info.setBounds(140,10,300,30);
            info.setForeground(Color.white);
            info.setFont(new Font("Times New Roman",Font.ITALIC,18));
            p4.add(info);

            name=new JLabel("Name");
            name.setBounds(10,50,120,25);
            name.setForeground(Color.white);
            name.setFont(new Font("Claredon",Font.ITALIC,14));
            p4.add(name);

            f_name=new JLabel("Father Name");
            f_name.setBounds(10,85,120,25);
            f_name.setForeground(Color.white);
            f_name.setFont(new Font("Claredon",Font.ITALIC,14));
            p4.add(f_name);

            ph_num=new JLabel("Phone No");
            ph_num.setBounds(10,118,120,25);
            ph_num.setForeground(Color.white);
            ph_num.setFont(new Font("Claredon",Font.ITALIC,14));
            p4.add(ph_num);

            age=new JLabel("Age");
            age.setBounds(10,150,120,25);
            age.setForeground(Color.white);
            age.setFont(new Font("Claredon",Font.ITALIC,14));
            p4.add(age);

            qualification=new JLabel("Qualification");
            qualification.setBounds(10,185,120,25);
            qualification.setForeground(Color.white);
            qualification.setFont(new Font("Claredon",Font.ITALIC,14));
            p4.add(qualification);

            email=new JLabel("Username");
            email.setBounds(10,220,120,25);
            email.setForeground(Color.white);
            email.setFont(new Font("Claredon",Font.ITALIC,14));
            p4.add(email);

            pass=new JLabel("Password");
            pass.setBounds(10,255,120,25);
            pass.setForeground(Color.white);
            pass.setFont(new Font("Claredon",Font.ITALIC,14));
            p4.add(pass);


            Name=new JTextField();
            Name.setBounds(150,47,200,25);
            Name.setBorder(new LineBorder(Color.lightGray,1));
            Name.setFont(new Font("Arial",Font.PLAIN,14));
            p4.add(Name);

            F_Name=new JTextField();
            F_Name.setBounds(150,82,200,25);
            F_Name.setBorder(new LineBorder(Color.lightGray,1));
            F_Name.setFont(new Font("Arial",Font.PLAIN,14));
            p4.add(F_Name);

            Ph_Num=new JTextField();
            Ph_Num.setBounds(150,117,200,25);
            Ph_Num.setBorder(new LineBorder(Color.lightGray,1));
            Ph_Num.setFont(new Font("Arial",Font.PLAIN,14));
            p4.add(Ph_Num);

            Age=new JTextField();
            Age.setBounds(150,152,200,25);
            Age.setBorder(new LineBorder(Color.lightGray,1));
            Age.setFont(new Font("Arial",Font.PLAIN,14));
            p4.add(Age);

            Qualification=new JTextField();
            Qualification.setBounds(150,187,200,25);
            Qualification.setBorder(new LineBorder(Color.lightGray,1));
            Qualification.setFont(new Font("Arial",Font.PLAIN,14));
            p4.add(Qualification);

            Email=new JTextField();
            Email.setBounds(150,222,200,25);
            Email.setBorder(new LineBorder(Color.lightGray,1));
            Email.setFont(new Font("Arial", Font.PLAIN,14));
            p4.add(Email);

            Pass=new JPasswordField();
            Pass.setBounds(150,257,200,25);
            Pass.setBorder(new LineBorder(Color.lightGray,1));
            Pass.setFont(new Font("Verdana",Font.BOLD,14));
            p4.add(Pass);

            Reg_submit=new JButton("Submit");
            Reg_submit.setBounds(360,260,100,20);
            Reg_submit.setForeground(Color.black);
            Reg_submit.setBackground(Color.white);
            Reg_submit.addActionListener(this);
            p4.add(Reg_submit);
        }
        //remove candidate
        {
            p5 = new JPanel();
            p5.setBounds(400, 0, 500, 400);
            p5.setLayout(null);
            p5.setBackground(Color.black);
            p5.setVisible(false);
            f1.add(p5);

            JLabel search;
            search=new JLabel("Enter Candidate's ID");
            search.setBounds(10,20,200,30);
            search.setFont(new Font("Times New Roman",Font.ITALIC,16));
            search.setForeground(Color.white);
            p5.add(search);

            Search=new JTextField();
            Search.setBounds(200,23,120,20);
            Search.setBorder(new LineBorder(Color.lightGray,1));
            Search.setFont(new Font("Times New Roman",Font.BOLD,16));
            p5.add(Search);

            SEARCH=new JButton("Search");
            SEARCH.setBounds(350,25,100,17);
            SEARCH.setBackground(Color.white);
            SEARCH.setForeground(Color.black);
            SEARCH.setFocusable(false);
            SEARCH.setFont(new Font("Times New Roman",Font.PLAIN,16));
            SEARCH.addActionListener(this);
            p5.add(SEARCH);
            
            l7=new JLabel();
            l7.setBounds(20,60, 200,30);
            l7.setForeground(Color.white);
            l7.setFont(new Font("Times New Roman",Font.ITALIC,18));
            p5.add(l7);

            l8=new JLabel();
            l8.setBounds(250,60, 200,30);
            l8.setForeground(Color.white);
            l8.setFont(new Font("Times New Roman",Font.ITALIC,18));
            p5.add(l8);

            l9=new JLabel();
            l9.setBounds(20,100, 200,30);
            l9.setForeground(Color.white);
            l9.setFont(new Font("Times New Roman",Font.ITALIC,18));
            p5.add(l9);

            l10=new JLabel();
            l10.setBounds(250,100, 200,30);
            l10.setForeground(Color.white);
            l10.setFont(new Font("Times New Roman",Font.ITALIC,18));
            p5.add(l10);

            l11=new JLabel();
            l11.setBounds(20,140, 200,30);
            l11.setForeground(Color.white);
            l11.setFont(new Font("Times New Roman",Font.ITALIC,18));
            p5.add(l11);
            
            l12=new JLabel();
            l12.setBounds(250,140, 200,30);
            l12.setForeground(Color.white);
            l12.setFont(new Font("Times New Roman",Font.ITALIC,18));
            p5.add(l12);

            del=new JButton("Delete");
            del.setBounds(350,270,100,20);
            del.setBackground(Color.white);
            del.setForeground(Color.black);
            del.setFocusable(false);
            del.setEnabled(false);
            del.setFont(new Font("Times New Roman",Font.PLAIN,16));
            del.addActionListener(this);
            p5.add(del);
        }
        //current details
        {
            p6=new JPanel();
            p6.setBounds(400, 0, 500, 400);
            p6.setLayout(null);
            p6.setBackground(Color.black);
            p6.setVisible(false);
            f1.add(p6);

            tbl=new DefaultTableModel(0,2);
            tb=new JTable(tbl);
            tb.setBounds(0,100,500,100);
            tb.setFont(new Font("Times New Roman",Font.ITALIC,16));
            tb.setBorder(new LineBorder(Color.white,1));

            TableColumn tc=tb.getColumnModel().getColumn(0);
            TableColumn tc1=tb.getColumnModel().getColumn(1);
            DefaultTableCellRenderer tr=new DefaultTableCellRenderer();
            tr.setHorizontalAlignment(SwingConstants.CENTER);
            tc.setCellRenderer(tr);
            tc1.setCellRenderer(tr);
            tb.setBackground(Color.black);
            tb.setForeground(Color.white);
            p6.add(tb);
            
        }
        //declare voting
        {
            p7=new JPanel();
            p7.setBounds(400, 0, 500, 400);
            p7.setLayout(null);
            p7.setBackground(Color.black);
            p7.setVisible(false);
            f1.add(p7);

            winner=new JLabel();
            winner.setBounds(40,130,500,50);
            winner.setFont(new Font("Times New Roman",Font.ITALIC,20));
            winner.setForeground(Color.white);
            p7.add(winner);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b4) {
            String user = t1.getText();
            String pass = ps1.getText();
            boolean b = crudClass.adminLogin(user, pass);
            if (b) {
                p1.setVisible(false);
                start.setEnabled(true);
                stop.setEnabled(true);
                current.setEnabled(true);
                declare.setEnabled(true);
                register.setEnabled(true);
                remove.setEnabled(true);
            } else {
                l5.setVisible(true);
            }
        } else if (e.getSource() == b3) {
            t1.setText("");
            ps1.setText("");
            f1.setVisible(false);
            new mainframe();
        } else if (e.getSource() == start) {
            p1.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p7.setVisible(false);
            p6.setVisible(false);
            try {
                Connection c = ConnectionClass.connection();
                String q = "select*from start_stop";
                PreparedStatement ps = c.prepareStatement(q);

                ResultSet rs = ps.executeQuery(q);
                int i = 0;
                while (rs.next()) {
                    i = rs.getInt("choice");
                }
                if (Objects.equals(i, 1)) {
                    p2.setVisible(true);
                    String qu = "update start_stop set choice='0' where choice='1'";
                    PreparedStatement pst = c.prepareStatement(qu);
                    pst.executeUpdate();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Voting Is Already Started");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == sb) {
            T1.start();
        } else if (e.getSource() == stop) {
            try {
                p1.setVisible(false);
                p2.setVisible(false);
                p4.setVisible(false);
                p5.setVisible(false);
                p7.setVisible(false);
                p6.setVisible(false);
                Connection c = ConnectionClass.connection();
                String q = "select*from start_stop";
                PreparedStatement ps = c.prepareStatement(q);

                ResultSet rs = ps.executeQuery(q);
                int i = 0;
                while (rs.next()) {
                    i = rs.getInt("choice");
                }
                if (Objects.equals(i, 0)) {
                    p2.setVisible(false);
                    p3.setVisible(true);
                    String qu = "update start_stop set choice='1' where choice='0'";
                    PreparedStatement pst = c.prepareStatement(qu);
                    pst.executeUpdate();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Voting Has Already Stopped");
                }
            }catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == stb) {
            t.start();
        } else if (e.getSource()==register){
            p1.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(false);
            p6.setVisible(false);
            p5.setVisible(false);
            p7.setVisible(false);
            p4.setVisible(true);
        } else if (e.getSource()==Reg_submit) {
            String name=Name.getText();
            String f_name=F_Name.getText();
            String ph=Ph_Num.getText();
            String qua=Qualification.getText();
            String user=Email.getText();
            String ps=Pass.getText();
            int age=Integer.parseInt(Age.getText());

            registration r=new registration(name,f_name,qua,ph,user,ps,age);
           boolean b=crudClass.register_candidate(r);
           if(b)
           {
               try{
                   Connection con=ConnectionClass.connection();
                   String choose="select* from CandidateInfo";
                   PreparedStatement pst=con.prepareStatement(choose);

                   ResultSet rs=pst.executeQuery(choose);
                   while(rs.next())
                   {
                       Us=rs.getString("name");
                       if(Objects.equals(name,Us))
                       {
                           int id = rs.getInt("id");
                           JOptionPane.showMessageDialog(null,"Candidate Registered "
                                   +"\nYour ID is: "+id);
                       }
                   }
               }catch (Exception exc){
                   exc.printStackTrace();
               }
           }
           else
               JOptionPane.showMessageDialog(null,"Error Occurred In adding Candidate");
        } else if (e.getSource()==remove) {
            p1.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(false);
            p5.setVisible(true);
        } else if (e.getSource()==SEARCH) {
            del.setEnabled(true);
            Us=Search.getText();
           
            try{
                Connection con=ConnectionClass.connection();
                String choose="select * from CandidateInfo where id="+Search.getText();
                PreparedStatement pst=con.prepareStatement(choose);

                ResultSet r=pst.executeQuery(choose);
                while(r.next())
                {
                    String nm=r.getString("name");
                    String Fn = r.getString("Fname");
                    String ph = r.getString("Phone");
                    String q = r.getNString("qualification");
                    String us = r.getString("user");
                    int age = r.getInt("Age");

                    l7.setText("Name: "+nm);
                    l8.setText("Father Name: "+ Fn);
                    l9.setText("Age: "+age);
                    l10.setText("Qualification: "+q);
                    l11.setText("Phone No:"+ph);
                    l12.setText("Username: "+us);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource()==del) {

            boolean B;
            try {
                Connection c=ConnectionClass.connection();
                String query="delete from CandidateInfo where id ="+Search.getText();
                PreparedStatement pstmtdel= c.prepareStatement(query);;
                pstmtdel.executeUpdate();
                B=true;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }if(B){
                l7.setText("");
                l8.setText("");
                l9.setText("");
                l10.setText("");
                l11.setText("");
                l12.setText("");
                JOptionPane.showMessageDialog(null,"Candidate Removed");
            }
            else
                JOptionPane.showMessageDialog(null,"Error! Can't Remove Candidate");
        } else if (e.getSource()==current) {
            try {
                Connection con = ConnectionClass.connection();
                String Query = "Select* from Candidateinfo";
                PreparedStatement ps=con.prepareStatement(Query);

                ResultSet rs=ps.executeQuery(Query);
                while (rs.next()){
                    String name=rs.getString("name");
                    int id=rs.getInt("votes");

                    String []data={name,String.valueOf(id)};
                    tbl.addRow(data);
                }
            }catch (Exception exp)
            {
                exp.printStackTrace();
            }
                p1.setVisible(false);
                p2.setVisible(false);
                p3.setVisible(false);
                p4.setVisible(false);
                p5.setVisible(false);
                p7.setVisible(false);
                p6.setVisible(true);
        } else if (e.getSource()==declare) {
            p1.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(false);
            p6.setVisible(false);
            p7.setVisible(true);
           try {
               int votes=0;
               String name=null;
                Connection con = ConnectionClass.connection();
                String st="select * from CandidateInfo";
                PreparedStatement ps = con.prepareStatement(st);

                ResultSet rs=ps.executeQuery(st);
                while (rs.next()){
                    int chk=rs.getInt("votes");
                    String Name=rs.getString("name");
                    if(votes<chk){
                        votes=chk;
                        name=Name;
                    }
                }
               winner.setText("Winner Is "+name+" With "+votes+" Votes");
           }catch (Exception ec)
           {
               ec.printStackTrace();
           }
        }

    }
}