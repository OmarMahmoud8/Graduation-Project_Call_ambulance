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
public class Message extends User{
    private int MesID;
    private String Content;
    private String Name;
    private String Email;
      
    

    public int getMesID() {
        return MesID;
    }
    public void setMesID(int MesID) {
        this.MesID = MesID;
    }
    
     public String getContent() {
        return this.Content;
    }
     public void setContent(String Content) {
        this.Content = Content;
    }
     
     public String getName() {
        return this.Name;
    }
     public void setName(String Name) {
        this.Name = Name;
    }
     
     public String getEmail() {
        return this.Email;
    }
     public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
