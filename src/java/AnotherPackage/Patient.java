package AnotherPackage;

import DbConnection.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GIG
 */
public class Patient extends User{
    private int pauth; // User Auth 

    public void setpauth(int pauth) {
        this.pauth = pauth;
    }

    public int getpauth() {
        return this.pauth;
    }
    
     public ArrayList<Visit> ShowAllVisit(int Uid) {
         ArrayList<Visit> AllVisit = new ArrayList<Visit>();
        //AllUsers = null;
        try {
            Patient P1 = new Patient();
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            St=Con.createStatement();
            String mysql ="Select P_ID from patient where PUser_ID ='" + Uid + "'";
            ResultSet Rs = St.executeQuery(mysql);
            if(Rs.next()) {
                  P1.setuid(Rs.getInt("P_ID"));
            }
       Statement St2;
       St2= Con.createStatement();
            String mysql2 = "Select * from visit where Pv_ID = '" + P1.getuid() + "'";
            ResultSet Rs2 = St2.executeQuery(mysql2);
            while (Rs2.next()) {
                Visit V1 = new Visit();
                V1.setvid(Rs2.getInt("Vis_ID"));
                V1.setVDay(Rs2.getString("Vday"));
                V1.timereserved(Rs2.getString("Reserved"));
                V1.setVstart_Hour(Rs2.getInt("Vstart_Hour"));
                V1.setVstart_min(Rs2.getInt("Vstart_min"));
                V1.setduration(Rs2.getInt("Vduration"));
                AllVisit.add(V1);
            }
       } catch (SQLException ex) {
        }
        return AllVisit;
    }
     
     
     
     
      public boolean CancelVisit(String vid)
    {
            int count=0;
            boolean check=false;
            try
            {
                DbConnection C = new DbConnection();
                Connection Con = C.getconnect();
                Statement St;
                St=Con.createStatement();
                int getresult = St.executeUpdate("DELETE FROM visit" + " WHERE Vis_ID="+vid);
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
     
     
     public int Depart_DR_ID(String Dep,String Day){
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            int[] Department_Doc ;
            Department_Doc = new int[10];
            int Dep_size=-1;
            int Dept_ID=0;
            //----------------------------------------------------------//
            try {
                 St = Con.createStatement();
                 String Sql = "Select * from department where Dept_Name ='"+Dep+"'";
                 ResultSet Rs = St.executeQuery(Sql);
              while(Rs.next())
              {
                Dept_ID = Rs.getInt("Dept_ID");
              }
                } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(Dept_ID !=0){
               try {
                 St = Con.createStatement();
                 String Sql = "Select * from doctor where Dept_IDD ='"+Dept_ID+"'";
                 ResultSet Rs = St.executeQuery(Sql);
              while(Rs.next())
              {
                Dep_size++;
                Department_Doc[Dep_size] = Rs.getInt("D_ID");
              }
                } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            } 
            }
            //----------------------------------------------------------//
            
            int ID = Day_DR_ID(Department_Doc, Dep_size,Day);
            
            return ID;
        }
        public int Day_DR_ID(int[] Department_Doc,int Dep_size,String Day){
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            //----------------------------------------------------------//
            int[] Day_Doc = new int[10];
            int Day_size=-1;
            int ID ;
            //---------------------------------------------------------//
            try {
                 St = Con.createStatement();
                 String Sql = "Select * from doctor_workdays where D_Day ='"+Day+"'";
                 ResultSet Rs = St.executeQuery(Sql);
              while(Rs.next())
              {
                Day_size++; 
                Day_Doc[Day_size] = Rs.getInt("D_ID");
              }
                } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //----------------------------------------------------------//
            ID = Find_Doc(Department_Doc,Day_Doc,Dep_size,Day_size);
            return ID;
        }
        public int Find_Doc(int[] Department_Doc,int[] Day_Doc,int Dep_size,int Day_size){
            //----------------------------------------------------------//
            int ID=0;
            boolean check=false;
            for(int x=0;x<=Dep_size;x++){
                for(int y=0;y<=Day_size;y++){
                    if(Department_Doc[x]==Day_Doc[y]){
                        ID=Department_Doc[x];
                        check=true;
                        break;
                    }
                    if(check) break;
                    
                }
            }
            return ID;
        }
        public int get_PatientID(int Uid){
            int Pid=0;
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            try {
                 St = Con.createStatement();
                 String Sql = "Select * from patient where PUser_ID ='"+Uid+"'";
                 ResultSet Rs = St.executeQuery(Sql);
              while(Rs.next())
              {
                Pid = Rs.getInt("P_ID");
              }
                } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
            return Pid;
        }
        
        
    /**
     *
     * @param P_ID
     * @param Day
     * @param Dep
     * @param Hour
     * @param Min
     * @return
     */
        public boolean Reserv_allowed(String Day,String Dep,int Hour,int Min){//+ DR ID in the func
               int DR_ID=0;
               DR_ID = Depart_DR_ID(Dep,Day);
               DbConnection C = new DbConnection();
               Connection Con = C.getconnect();
               Statement St;
               int count =0;
               try {
                 St = Con.createStatement();
                 String Sql = "Select count(1) from visit where Vstart_Hour ='"+Hour+"' and Vstart_Min='"+Min+"' and Dv_ID="+DR_ID+"";
                 ResultSet Rs = St.executeQuery(Sql);
               while(Rs.next())
               {
                count = Rs.getInt("count(1)");
               }
                } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
               }
               if (count>0) return false;
               else return true;
           }

    

    public boolean Reserve(int P_ID,String Day,String Dep,int Hour,int Min){
            int DR_ID=0;
            int Pid = 0;
            int counter=0;
            Pid = get_PatientID( P_ID);
            DR_ID = Depart_DR_ID(Dep,Day);
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            if(Reserv_allowed(Day,Dep,Hour,Min)){
                try {
                    St = Con.createStatement();
                    String Sql = "INSERT INTO visit (Vday,Vstart_Hour,Vstart_Min,Visit_type,Pv_ID,Dv_ID)" + 
                                             "VALUES('"+Day+"',"+Hour+","+Min+",1,"+Pid+","+DR_ID+" )";
                     counter = St.executeUpdate(Sql);


                } catch (SQLException ex) {
                    Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return counter >0;
            
        }
     
    
     
    
}