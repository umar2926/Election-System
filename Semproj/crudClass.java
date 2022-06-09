package Semproj;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;


public class crudClass {
    public static boolean adminLogin(String id,String ps)
    {
        boolean b=false;
        try {
            Connection connect=ConnectionClass.connection();
            String q="Select * from admin";
            PreparedStatement pst=connect.prepareStatement(q);

            ResultSet rs=pst.executeQuery(q);
            while (rs.next())
            {
                String getID = rs.getString("user");
                String getPS = rs.getString("pass");
                if (Objects.equals(getID, id) && Objects.equals(getPS, ps))
                {
                    b=true;
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }
    public static boolean register_candidate(registration r){
        boolean b=false;
        try{
            Connection con=ConnectionClass.connection();
            String insert="insert into CandidateInfo(name,Fname, Phone, qualification,age,user,pass) values(?,?,?,?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(insert);

            pstmt.setString(1,r.getName());
            pstmt.setString(2,r.getFname());
            pstmt.setString(3,r.getNum());
            pstmt.setString(4, r.getQualification());
            pstmt.setInt(5,r.getAge());
            pstmt.setString(6,r.getUsername());
            pstmt.setString(7, r.getPass());

            pstmt.executeUpdate();
            b=true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return b;
    }
}

