package Users;

import Messages.Complaint;
import Messages.Request;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;


public class Rector extends Employee implements Serializable {
    
    private static Rector INSTANCE;
    protected static Vector<Request> requests = new Vector<Request>();
    protected static Vector<Request> signedRequests = new Vector<Request>();
    protected static Vector<Complaint> complaints = new Vector<Complaint>();

    private Rector(){
    }
    public static Rector getINSTANCE() {
        if(INSTANCE == null) return new Rector();
        return INSTANCE;
    }


    //getter and setters
    public List<Request> getRequests() {
        return requests;
    }

    private  void setRequests(Vector<Request> requests) {
        this.requests = requests;
    }

    public List<Request> getSignedRequests() {
        return signedRequests;
    }

    private void setSignedRequests(Vector<Request> signedRequests) {
        this.signedRequests = signedRequests;
    }

    //methods
    protected void addRequest(Request r){
        requests.add(r);
    }
    public void signRequest(Request r){
        requests.remove(r);
        signedRequests.add(r);
    }

    //MENU
    @Override
    public void run(){

    }
    @Override
    protected void displayRussianMenu() {

    }

    @Override
    protected void displayKazakhMenu() {

    }

    @Override
    protected void displayEnglishMenu() {

    }
}
