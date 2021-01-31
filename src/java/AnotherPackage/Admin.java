package AnotherPackage;


import DbConnection.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin extends User {
    
  public boolean AddUser(String fname, String lname, String Email, String PhoneNo, String Age, String Gender, String City, String Password, int utype) {
        int count = 0;
        int maxid = 0;
        boolean check = false;
        try {
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            St=Con.createStatement();
            User SetObject = new User();
            SetObject.setfname(fname);
            SetObject.setlname(lname);
            SetObject.setmail(Email);
            SetObject.setphone(PhoneNo);
            SetObject.setage(Age);
            SetObject.setgender(Gender);
            SetObject.setcity(City);
            SetObject.setupassword(Password);
            SetObject.setutype(utype);
            String Mysql = "INSERT INTO user (Fname,Lname,Mail,UserPhone,Age,City,Gender,password,UserType_id)" + "VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = Con.prepareStatement(Mysql);
            statement.setString(1, SetObject.getfname());
            statement.setString(2, SetObject.getlname());
            statement.setString(3, SetObject.getmail());
            statement.setString(4, SetObject.getphone());       
            statement.setString(5, SetObject.getage());
            statement.setString(6, SetObject.getcity());
            statement.setString(7, SetObject.getgender());
            statement.setString(8, SetObject.getupassword());
            statement.setString(9, "" + SetObject.getutype());
            int getresult = statement.executeUpdate();
            
            /*
            if (utype == 1) {
                String Mysql2 = "Select max(User_IDs) From user_data";
                ResultSet Rs;
                Rs = St.executeQuery(Mysql2);
                while (Rs.next()) {
                    maxid = Rs.getInt(1);
                    System.out.println("Value is " + maxid);
                }

                String Mysql3 = "INSERT INTO patient (P_Auth,PUser_ID)" + "VALUES(?,?)";
                PreparedStatement state = Con.prepareStatement(Mysql3);
                state.setString(1, "1");
                state.setString(2, "" + maxid);
                int executeUpdate = state.executeUpdate();
            }
            */  
            
            if (getresult == 1) {
                count++;
            }
        }
        catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        
        if (count == 1) {
            check = true;
        }
        return check;
       }
    
      public boolean DeleteUser(String id)
    {
            int count=0;
            boolean check=false;
            try
            {
                DbConnection C = new DbConnection();
                Connection Con = C.getconnect();
                Statement St;
                St=Con.createStatement();
                int getresult = St.executeUpdate("DELETE FROM user" + " WHERE id="+id);
                if(getresult == 1)
                {
                count ++;
                }                
            }
             catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }    
            
              if(count == 1)
              {
                  check=true; 
              }
              return check;
        }
    
      public boolean UpdateUser(String fname, String lname,String Phone, String id) {
        int count = 0;
        boolean check = false;
        try
        {
                DbConnection C = new DbConnection();
                Connection Con = C.getconnect();
                Statement St;
                St=Con.createStatement();
                String Mysql = "UPDATE user SET Fname=?,Lname=?,UserPhone=? WHERE id=?";
                PreparedStatement statement = Con.prepareStatement(Mysql);
                statement.setString(1, fname);
                statement.setString(2, lname);
                statement.setString(3, Phone);
                statement.setString(4, id);
                int getresult = statement.executeUpdate();
                if (getresult == 1) {
                count++;
                }
        }
        catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        if (count == 1) {
            check = true;
        }
        return check;
      }
      
      public ArrayList<User> ShowAllUser() {
        ArrayList<User> AllUsers = new ArrayList<User>();
        //AllUsers = null;
        try {
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            St=Con.createStatement();
            String mysql = "Select * from user";
            ResultSet Rs = St.executeQuery(mysql);
            while (Rs.next()) {
                User U = new User();
                U.setuid(Rs.getInt("id"));
                U.setfname(Rs.getString("Fname"));
                U.setlname(Rs.getString("Lname"));
                U.setmail(Rs.getString("Mail"));
                U.setage(Rs.getString("Age"));
                U.setcity(Rs.getString("City"));
                U.setphone(Rs.getString("UserPhone"));
                AllUsers.add(U);
            }

        } catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        return AllUsers;
      }
      
      
     public ArrayList<Visit> ShowAllVisit() {
         ArrayList<Visit> AllVisit = new ArrayList<Visit>();
        //AllUsers = null;
        try {
            Patient P1 = new Patient();
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            St= Con.createStatement();
            String mysql = "Select * from visit";
            ResultSet Rs = St.executeQuery(mysql);
            while (Rs.next()) {
                Visit V1 = new Visit();
                V1.setvid(Rs.getInt("Vis_ID"));
                V1.setVDay(Rs.getString("Vday"));
                V1.timereserved(Rs.getString("Reserved"));
                V1.setVstart_Hour(Rs.getInt("Vstart_Hour"));
                V1.setVstart_min(Rs.getInt("Vstart_min"));
                V1.setduration(Rs.getInt("Vduration"));
                AllVisit.add(V1);
            }
       } catch (SQLException ex) {
        }
        return AllVisit;
    }
     
      public ArrayList<Request> ShowAllRequest() {
         ArrayList<Request> AllRequest = new ArrayList<Request>();
        //AllUsers = null;
        try {
            User U1 = new User();
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            St= Con.createStatement();
            
            String mysql = "SELECT user.Fname,user.UserPhone,user.Mail,request.id,request.user_location,request.Date,request_status.statu,hospital.name,hospital.phone,hospital.location FROM request JOIN user ON user.id = request.User_ID JOIN hospital ON hospital.id=request.Hospital_ID JOIN request_status ON request_status.id = request.Statu_id WHERE request.Statu_id= 1";
            ResultSet Rs =St.executeQuery(mysql) ;
            
           // String mysql = "Select * from request";
            //ResultSet Rs = St.executeQuery(mysql);
            
            while (Rs.next()) {
                Request R1 = new Request();
                R1.setfname(Rs.getString("Fname"));
                R1.setphone(Rs.getString("UserPhone"));
                R1.setmail(Rs.getString("Mail"));
                R1.setReqID(Rs.getInt("id"));
                R1.setUserLocation(Rs.getString("user_location"));
                R1.setDate(Rs.getString("Date"));
                R1.setStatus(Rs.getString("statu"));
                //R1.setStatus(Rs.getString("Statu_id"));
                R1.setHosName(Rs.getString("name"));
                R1.setHosPhone(Rs.getInt("phone"));
                R1.setHosLocation(Rs.getString("location"));
                
                AllRequest.add(R1);
                
            }
            
       } catch (SQLException ex) {
        }
        return AllRequest;
    }
           

       public ArrayList<Request> ShowRequests() {
         ArrayList<Request> AllRequests = new ArrayList<Request>();
        //AllUsers = null;
        try {
            User U2 = new User();
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            St= Con.createStatement();
            
            String mysql2 = "SELECT user.Fname,user.UserPhone,user.Mail,request.id,request.user_location,request.Date,request_status.statu,hospital.name,hospital.phone,hospital.location FROM request JOIN user ON user.id = request.User_ID JOIN hospital ON hospital.id=request.Hospital_ID JOIN request_status ON request_status.id = request.Statu_id WHERE request.Statu_id IN (2,3)";
            ResultSet Rs2 =St.executeQuery(mysql2) ;
            
           // String mysql = "Select * from request";
            //ResultSet Rs = St.executeQuery(mysql);
            
            while (Rs2.next()) {
                Request R2 = new Request();
                R2.setfname(Rs2.getString("Fname"));
                R2.setphone(Rs2.getString("UserPhone"));
                R2.setmail(Rs2.getString("Mail"));
                R2.setReqID(Rs2.getInt("id"));
                R2.setUserLocation(Rs2.getString("user_location"));
                R2.setDate(Rs2.getString("Date"));
                R2.setStatus(Rs2.getString("statu"));
                //R2.setStatus(Rs2.getString("Statu_id"));
                R2.setHosName(Rs2.getString("name"));
                R2.setHosPhone(Rs2.getInt("phone"));
                R2.setHosLocation(Rs2.getString("location"));
                
                AllRequests.add(R2);
                
            }
            
       } catch (SQLException ex) {
        }
        return AllRequests;
    }
      
      public boolean DeclineRequest(String id) {
        int count = 0;
        boolean check = false;
        try
        {
                DbConnection C = new DbConnection();
                Connection Con = C.getconnect();
                Statement St;
                St=Con.createStatement();
                
                String Mysql = "UPDATE request SET Statu_id = '3'" + " WHERE id="+id;
                PreparedStatement statement = Con.prepareStatement(Mysql);
                int getresult = statement.executeUpdate();
                 statement.setString(1, id);
                if (getresult == 1) {
                count++;
                }
        }
        catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        if (count == 1) {
            check = true;
        }
        return check;
      }
      
      public boolean ApproveRequest(String id) {
        int count = 0;
        boolean check = false;
        try
        {
                DbConnection C = new DbConnection();
                Connection Con = C.getconnect();
                Statement St;
                St=Con.createStatement();
                
                String Mysql = "UPDATE request SET Statu_id = '2'" + " WHERE id="+id;
                PreparedStatement statement = Con.prepareStatement(Mysql);
                int getresult = statement.executeUpdate();
                 statement.setString(1, id);
                if (getresult == 1) {
                count++;
                }
        }
        catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        if (count == 1) {
            check = true;
        }
        return check;
      }
      

     
      
      public ArrayList<Message> ShowComments() {
         ArrayList<Message> AllComments = new ArrayList<Message>();
        //AllUsers = null;
        try {
            User U2 = new User();
            
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            St= Con.createStatement();
            
            String mysql2 = "SELECT * from message ";
            ResultSet Rs2 =St.executeQuery(mysql2) ;
            
            while (Rs2.next()) {
               Message M1 = new Message();
     
                M1.setContent(Rs2.getString("content"));
                M1.setName(Rs2.getString("name"));
                M1.setEmail(Rs2.getString("email"));

                
                AllComments.add(M1);
                
            }
            
       } catch (SQLException ex) {
        }
        return AllComments;
    }
      
      
    }