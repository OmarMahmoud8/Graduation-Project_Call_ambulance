/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;


import AnotherPackage.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kareem
 */
public class DbConnection {
    public Connection getconnect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12179916", "sql12179916", "WBPPRGf2en");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;

    }

    public boolean login(String mail, String pass) {

        boolean check = false;
        int count;
        count = 0;
        DbConnection C = new DbConnection();
        Connection Con = C.getconnect();
        Statement St;
        try {
            St = Con.createStatement();
            String Sql = "Select count(1) from user where Mail='" + mail + "' and password='" + pass + "'";
            ResultSet Rs = St.executeQuery(Sql);
            while (Rs.next()) {
                count = Rs.getInt("count(1)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (count == 1) {
            check = true;
        }
        return check;
    }

    public int hasrole(String mail) {
        int x = 0;
        DbConnection C = new DbConnection();
        Connection Con = C.getconnect();
        Statement St;
        try {
            St = Con.createStatement();
            String Sql = "Select UserType_id from user where Mail='" + mail + "'";
            ResultSet Rs = St.executeQuery(Sql);
            while (Rs.next()) {
                x = Rs.getInt("UserType_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    public User GetDataforS(String mail,String ID) {
        User U = new User();
        DbConnection C = new DbConnection();
        Connection Con = C.getconnect();
        Statement St;
        if(!mail.equals(""))
        {
            try {
            St = Con.createStatement();
            String Sql = "Select * from user where Mail='" + mail + "'";
            ResultSet Rs = St.executeQuery(Sql);
            while (Rs.next()) {

                U.setuid(Rs.getInt("id"));
                U.setfname(Rs.getString("Fname"));
                U.setlname(Rs.getString("Lname"));
                U.setage(Rs.getString("Age"));
                U.setcity(Rs.getString("City"));
                U.setphone(Rs.getString("UserPhone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else
        {
            try {
            St = Con.createStatement();
            String Sql = "Select * from user where id='" + ID + "'";
            ResultSet Rs = St.executeQuery(Sql);
            while (Rs.next()) {
                U.setfname(Rs.getString("Fname"));
                U.setlname(Rs.getString("Lname"));
                U.setphone(Rs.getString("UserPhone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        return U;
    }

    public boolean Register(String fname, String lname, String mail, String phone, String age, String city, String gender, String pass) {
        boolean check = false;
        int count;
        count = 0;
        User U1 = new User() ;
        DbConnection C = new DbConnection();
        Connection Con = C.getconnect();
        Statement St;
        try {
            St = Con.createStatement();
            String Sql = "INSERT INTO user (Fname,Lname,Mail,UserPhone,Age,City,Gender,password,UserType_id) VALUES ('" + fname + "','" + lname + "','" + mail + "','" + phone + "','" + age + "','" + city + "','" + gender + "','" + pass + "',1) ";
            if(St.executeUpdate(Sql)==1)
            {
                count ++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         if (count == 1) {
            check = true;
        }
        return check;
         
    }
    
    public String RetrievePass(String mail, String phone) {
        String Pass = "";
        //int count1 = 0;
        //boolean check1 = false;
        User U1 = new User() ;
        DbConnection C = new DbConnection();
        Connection Con = C.getconnect();
        Statement St;
        try {
           St = Con.createStatement();
            String Mysql = " select Upassword from user_data where Mail ='" + mail + "' and UserPhone= '" + phone + "' ";
            ResultSet Rs = St.executeQuery(Mysql);
            while (Rs.next()) {
                Pass = Rs.getString("Upassword");
            }
} catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Pass;
    }
    
    
     /*
         public boolean AuthForgotPass (String mail,String phone){
            int count=0;
            boolean check=false;
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            
            try{
                St = Con.createStatement();
                String Sql = "Select count(1) from user_data where Mail='"+mail+"' and UserPhone='"+phone+"'";
                ResultSet Rs = St.executeQuery(Sql);
                while(Rs.next())
              {
                count = Rs.getInt("count(1)");
              }
                
            }
            catch (SQLException ex){
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(count == 1)
              {
                  check=true; 
              }
              return check;
        } 
         
        public String getPass(boolean auth,String mail,String phone){
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            String pass="";
            if(auth){
                try{
                St = Con.createStatement();
                String Sql = "Select * from user_data where Mail='"+mail+"' and UserPhone='"+phone+"'";
                ResultSet Rs = St.executeQuery(Sql);
                while(Rs.next()){
                pass = Rs.getString("Upassword");
              
                }
              }
                catch (SQLException ex){
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            return pass;
        }
        
    */
    
}
