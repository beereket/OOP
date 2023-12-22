package Users;

import Messages.Request;

import java.io.Serializable;
import java.util.List;


public class Rector extends Employee implements Serializable {
    
    private static Rector INSTANCE;
    protected static List<Request> requests;
    protected static List<Request> signedRequests;

    private Rector(){
    }
    public static Rector getINSTANCE() {
        if(INSTANCE == null) INSTANCE = new Rector();
        return INSTANCE;
    }


    public void signRequest(Request r){
        requests.remove(r);
        signedRequests.add(r);
    }


    public List<Request> getRequests() {
        return requests;
    }

    private  void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<Request> getSignedRequests() {
        return signedRequests;
    }

    private void setSignedRequests(List<Request> signedRequests) {
        this.signedRequests = signedRequests;
    }
    protected void addRequest(Request r){
        requests.add(r);
    }

    //MENU
    @Override
    protected void displayRussianMenu() {

    }

    @Override
    protected void displayKazakhMenu() {

    }

    @Override
    protected void displayEnglishMenu() {

    }


    @Override
    public void update() {

    }
}
