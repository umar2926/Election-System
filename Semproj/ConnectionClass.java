package Semproj;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    static Connection con;
    public static Connection connection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String user="root";
            String pass="usawan123";
            String url ="jdbc:mysql://localhost:3306/semesterproject";

            con= DriverManager.getConnection(url,user,pass);

        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
