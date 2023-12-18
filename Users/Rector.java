package Users;

import Messages.Request;

import java.util.List;


public class Rector extends Employee {
    
    private static Rector INSTANCE;
    
    private static List<Request> requests;
    private static List<Request> signedRequests;

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
    public void addRequest(Request r){
        requests.add(r);
    }

    @Override
    public void update() {

    }
}
