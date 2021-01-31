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
public class Request extends Hospital{
      
    private String Date;
    private int ReqID;
    private int StatusID;
    private String UserLocation;
    private int HosID;
    private int UserID;
     private int ReqStatusID;
     private String Status;
     
    
     
     
    
    
    public String getDate() {
        return this.Date;
    }
    public void setDate(String Date) {
        this.Date = Date;
    }
   
    public int getReqID() {
        return ReqID;
    }
    public void setReqID(int ReqID) {
        this.ReqID = ReqID;
    }
    
    public int getHosID() {
        return HosID;
    }
    public void setHosID(int HosID) {
        this.HosID = HosID;
    }
    
    public int getUserID() {
        return UserID;
    }
    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

     public int getStatusID() {
        return StatusID;
    }
    public void setStatusID(int StatusID) {
        this.StatusID = StatusID;
    }

     public String getUserLocation() {
        return UserLocation;
    }
    public void setUserLocation(String UserLocation) {
        this.UserLocation = UserLocation;
    }
    
     public int getReqStatusID() {
        return ReqStatusID;
    }
    public void setReqStatusID(int ReqStatusID) {
        this.ReqStatusID = ReqStatusID;
    }
    
    public String getStatus() {
        return Status;
    }
    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}
