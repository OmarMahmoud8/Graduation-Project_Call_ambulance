
package AnotherPackage;

/**
 *
 * @author GIG
 */
public class RequestStatus extends Request{
     private int ReqStID;
     private String Status;
     
     
    public int getReqStID() {
        return ReqStID;
    }
    public void setReqStID(int ReqStID) {
        this.ReqStID = ReqStID;
    }
    
    public String GetStatus() {
        return Status;
    }
    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}
