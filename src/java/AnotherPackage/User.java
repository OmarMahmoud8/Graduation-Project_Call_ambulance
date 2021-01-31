package AnotherPackage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import DbConnection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
@ManagedBean
public class User {

    protected int uid;
    protected String fname;
    protected String lname;
    protected String mail;
    protected String age;
    protected String city;
    protected String Address;
    protected String gender;
    protected String upassword;
    protected String Phone;
    protected int utype;
    protected String message;

    public void setuid(int uid) {
        this.uid = uid;
    }

    public void setfname(String fname) {
        this.fname = fname;
    }

    public void setlname(String lname) {
        this.lname = lname;
    }

//    public boolean setfname(String fname) {
//        boolean checkdigit = true;
//        if (!fname.equals("")) {
//            for (char c : fname.toCharArray()) {
//                if (Character.isDigit(c)) {
//                    checkdigit = false;
//                    break;
//                }
//            }
//
//        }
//        if (checkdigit) {
//            this.fname = fname;
//        }
//        return checkdigit;
//    }
//    public boolean setlname(String lname) {
//        boolean checkdigit = true;
//        if (!lname.equals("")) {
//            for (char c : lname.toCharArray()) {
//                if (Character.isDigit(c)) {
//                    checkdigit = false;
//                    break;
//                }
//            }
//
//        }
//        if (checkdigit) {
//            this.lname = lname;
//        }
//        return checkdigit;
//    }
    public void setmail(String mail) {
        this.mail = mail;
    }

    public void setage(String age) {
        this.age = age;
    }

//    public boolean setage(String age) {
//        boolean checkdigit = true;
//        if (!age.equals("")) {
//            for (char c : age.toCharArray()) {
//                if (!Character.isDigit(c)) {
//                    checkdigit = false;
//                    break;
//                }
//            }
//
//        }
//        if (checkdigit) {
//            this.age = age;
//        }
//        return checkdigit;
//    }
    public void setcity(String city) {
        this.city = city;
    }

//    public boolean setcity(String city) {
//        boolean checkdigit = true;
//        if (!city.equals("")) {
//            for (char c : city.toCharArray()) {
//                if (Character.isDigit(c)) {
//                    checkdigit = false;
//                    break;
//                }
//            }
//
//        }
//        if (checkdigit) {
//            this.city = city;
//        }
//        return checkdigit;
//    }
    public void setaddress(String Addr) {
        this.Address = Addr;
    }

    public void setgender(String Gender) {
        this.gender = Gender;
    }

    public void setupassword(String Pass) {
        this.upassword = Pass;
    }

    public void setphone(String Phone) {
        this.Phone = Phone;
    }

//    public boolean setphone(String Phone) {
//        boolean checkdigit = true;
//        if (!Phone.equals("")) {
//            for (char c : Phone.toCharArray()) {
//                if (!Character.isDigit(c)) {
//                    checkdigit = false;
//                    break;
//                }
//            }
//
//        }
//        if (checkdigit) {
//            this.Phone = Phone;
//        }
//        return checkdigit;
//    }
    public void setutype(int utype) {
        this.utype = utype;
    }

    public int getuid() {
        return this.uid;
    }

    public String getfname() {
        return this.fname;
    }

    public String getlname() {
        return this.lname;
    }

    public String getmail() {
        return this.mail;
    }

    public String getage() {
        return this.age;
    }

    public String getcity() {
        return this.city;
    }

    public String getgender() {
        return this.gender;
    }

    public String getadd() {
        return this.Address;
    }

    public String getupassword() {
        return this.upassword;
    }

    public String getphone() {
        return this.Phone;
    }

    public int getutype() {
        return this.utype;
    }

    public void setmsg(String msg) {
        this.message = msg;
    }

    public String getmessage() {
        return this.message;
    }

    public String login() {
        boolean isvalid = false;
        DbConnection x1 = new DbConnection();
        isvalid = x1.login(mail, upassword);
        if (isvalid) {
            User Ux = new User(); //Create Object to get data for session
            Ux = x1.GetDataforS(mail, "");
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpSession httpSession = request.getSession(false);
            int id = Ux.getuid();
            String fname = Ux.getfname();
            String lname = Ux.getlname();
            httpSession.setAttribute("mail", mail);
            httpSession.setAttribute("id", id);
            httpSession.setAttribute("fname", fname);
            httpSession.setAttribute("lname", lname);
            if (x1.hasrole(mail) == 1) {
                message = "Patient.jsp";
            } else if (x1.hasrole(mail) == 2) {
                message = "Admin.jsp";
            } else if (x1.hasrole(mail) == 3) {
                message = "Doctor.jsp";
            }
        } else {
            message = "FailedLogin.jsp";
        }
        
        return message;
    }

    public String register() {
        DbConnection r1 = new DbConnection();
        if (r1.Register(fname, lname, mail, Phone, age, city, gender, upassword)) {
            message = "Registered.jsp";
        } else {
            message = "Failed";
        }
        return message;

    }

    public String forgetpass() {
        DbConnection f1 = new DbConnection();
        String x = "";
        x = f1.RetrievePass(mail, Phone);
        if (!x.equals("")) {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpSession httpSession = request.getSession(false);
            httpSession.setAttribute("pass", x);

            message = "Successfullypassret.jsp";
        } else {
            message = "UnSuccessfullyFP.jsp";
        }
        return message;
    }
    

     public ArrayList<Request> ShowAllMyRequest(int Uid) {
         ArrayList<Request> AllMyRequest = new ArrayList<Request>();
        //AllUsers = null;
        try {
            User U1 = new User();
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            St=Con.createStatement();
            String mysql ="Select * from user where id ='" + Uid + "'";
            ResultSet Rs = St.executeQuery(mysql);
            if(Rs.next()) {
                  U1.setuid(Rs.getInt("id"));
            }
       Statement St2;
       St2= Con.createStatement();
            String mysql2 = "SELECT request.id,request.user_location,request.Date,request_status.statu,hospital.name,hospital.phone,hospital.location FROM request JOIN user ON user.id = request.User_ID JOIN hospital ON hospital.id=request.Hospital_ID JOIN request_status ON request_status.id = request.Statu_id where User_ID = '" + U1.getuid() + "'";
            ResultSet Rs2 = St2.executeQuery(mysql2);
            while (Rs2.next()) {
                Request R1 = new Request();
                //R1.setfname(Rs.getString("Fname"));
                //R1.setphone(Rs.getString("UserPhone"));
                //R1.setmail(Rs.getString("Mail"));
                R1.setReqID(Rs.getInt("id"));
                R1.setUserLocation(Rs.getString("user_location"));
                R1.setDate(Rs.getString("Date"));
                R1.setStatus(Rs.getString("statu"));
                //R1.setStatus(Rs.getString("Statu_id"));
                R1.setHosName(Rs.getString("name"));
                R1.setHosPhone(Rs.getInt("phone"));
                R1.setHosLocation(Rs.getString("location"));
                AllMyRequest.add(R1);
            }
       } catch (SQLException ex) {
        }
        return AllMyRequest;
    }
     
    /*
    public boolean AddComments(String content, String name, String email) {
        int count = 0;
        //int maxid = 0;
        boolean check = false;
        try {
            DbConnection C = new DbConnection();
            Connection Con = C.getconnect();
            Statement St;
            St=Con.createStatement();
            Message SetObject = new Message();
            SetObject.setContent(content);
            SetObject.setName(name);
            SetObject.setEmail(email);
            
          
            String Mysql = "INSERT INTO message (content,name,email)" + "VALUES(?,?,?)";
            PreparedStatement statement = Con.prepareStatement(Mysql);
            statement.setString(1, SetObject.getContent());
            statement.setString(2, SetObject.getName());
            statement.setString(3, SetObject.getEmail());
    
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
    
    */
       
      
      public boolean AddComments(String content, String name, String email) {
        boolean check = false;
        int count;
        count = 0;
        //User U1 = new User() ;
        Message M1 = new Message();
        DbConnection C = new DbConnection();
        Connection Con = C.getconnect();
        Statement St;
        try {
            St = Con.createStatement();
            String Sql = " INSERT INTO message (content,name,email) VALUES ('" + content + "' , '" + name + "' , '" + email + "') ";
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
      
    
}
