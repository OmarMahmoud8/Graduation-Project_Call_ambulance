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
public class Visit {
    
    private int VisID;
    private int Attendence;
    private String Date;
    private int Duration;
    private String StartTime;
    private String EndTime;
    private int VisType;
    private int PID;
    private int DID;
    private String TimeReserved;
    private int PaymentMethID;
    private int visvalue;
    private String VDay;
    private int Vstart_Hour;
    private int Vstart_min;

    public String getVDay() {
        return VDay;
    }

    public void setVDay(String VDay) {
        this.VDay = VDay;
    }

    public int getVstart_Hour() {
        return Vstart_Hour;
    }

    public void setVstart_Hour(int Vstart_Hour) {
        this.Vstart_Hour = Vstart_Hour;
    }

    public int getVstart_min() {
        return Vstart_min;
    }

    public void setVstart_min(int Vstart_min) {
        this.Vstart_min = Vstart_min;
    }

    public void setvid(int VisID) {
        this.VisID = VisID;
    }

    public void setatt(int attendence) {
        this.Attendence = attendence;
    }

    public void setdate(String Date) {
        this.Date = Date;
    }

    public void setduration(int duration) {
        this.Duration = duration;
    }

    public void setstime(String stime) {
        this.StartTime = stime;
    }

    public void setftime(String ftime) {
        this.EndTime = ftime;
    }

    public void setvType(int Vistype) {
        this.VisType = Vistype;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public void setDID(int DID) {
        this.DID = DID;
    }

    public void timereserved(String ttime) {
        this.TimeReserved = ttime;
    }

    public void Paymethod(int pmethod) {
        this.PaymentMethID = pmethod;
    }

    public void visvalue(int visvalue) {
        this.visvalue = visvalue;
    }

    public int GetVisID() {
        return this.VisID;
    }

    public int GetAttendence() {
        return this.Attendence;
    }

    public String GetDate() {
        return this.Date;
    }

    public int GetDuration() {
        return this.Duration;
    }

    public String GetStartime() {
        return this.StartTime;
    }

    public String GetEndTime() {
        return this.EndTime;
    }

    public int GetVisType() {
        return this.VisType;
    }

    public int GetPID() {
        return this.PID;
    }

    public int GetDID() {
        return this.DID;
    }

    public String GetTimeRes() {
        return this.TimeReserved;
    }

    public int Getpayment() {
        return this.PaymentMethID;
    }

    public int getvisvalue() {
        return this.visvalue;
    }
    
}
