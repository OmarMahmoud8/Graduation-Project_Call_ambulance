package AnotherPackage;


import AnotherPackage.User;
import DbConnection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GIG
 */
public class Doctor extends User {
    
    private int D_ID;
    private String Dr_Qual;
    private int Dept_ID;

    public void SetDid(int DID) {
        this.D_ID = DID;
    }

    public int GetDID() {
        return this.D_ID;
    }

    public void SetDeptID(int DeptID) {
        this.Dept_ID = DeptID;
    }

    public int GetDeptID() {
        return this.Dept_ID;
    }

    public void SetQuals(String Quals) {
        this.Dr_Qual = Quals;
    }

    public String getQuals() {
        return this.Dr_Qual;
    }
    public ArrayList<Visit> ShowAllVisitD(int Uid) {
         ArrayList<Visit> AllVisit = new ArrayList<Visit>();
        //AllUsers = null;
        try {
            Doctor D1 = new Doctor();
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            St=Con.createStatement();
            String mysql ="Select D_ID from doctor where DUser_ID ='" + Uid + "'";
            ResultSet Rs = St.executeQuery(mysql);
            if(Rs.next()) {
                  D1.SetDid(Rs.getInt("D_ID"));
            }
       Statement St2;
       St2= Con.createStatement();
            String mysql2 = "Select * from visit where Dv_ID = '" + D1.GetDID() + "'";
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
    
}
