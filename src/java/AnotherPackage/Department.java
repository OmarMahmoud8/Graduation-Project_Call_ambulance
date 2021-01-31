package AnotherPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GIG
 */
public class Department {
    private int Deptid;
    private String DeptName;
    private int clinicid;

    public void setdeptid(int deptid) {
        this.Deptid = deptid;
    }

    public int getdeptid() {
        return this.Deptid;
    }

    public void setdeptname(String deptname) {
        this.DeptName = deptname;
    }

    public String getdeptname() {
        return this.DeptName;
    }

    public void setclinicid(int clinicid) {
        this.clinicid = clinicid;
    }

    public int getclinicid() {
        return this.clinicid;
    }
    
}
