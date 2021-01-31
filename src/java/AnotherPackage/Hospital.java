/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnotherPackage;

/**
 *
 * @author GIG
 */
public class Hospital extends User{
    
    private int HospitalID;
    private String HosLocation;
    private String HosName;
    private int HosPhone;
    

     public int getHospitalID() {
        return HospitalID;
    }
    public void setHospitalID(int HospitalID) {
        this.HospitalID = HospitalID;
    }

    public String getHosLocation() {
        return HosLocation;
    }
    public void setHosLocation(String HosLocation) {
        this.HosLocation = HosLocation;
    }
    
     public String getHosName() {
        return HosName;
    }
    public void setHosName(String HosName) {
        this.HosName = HosName;
    }
    
     public int getHosPhone() {
        return HosPhone;
    }
    public void setHosPhone(int HosPhone) {
        this.HosPhone = HosPhone;
    }

 
}
