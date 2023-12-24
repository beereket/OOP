package Messages;

import Users.Employee;

import java.io.Serializable;


public class Request implements Serializable {
    private Employee requester;
    private String content;
    public Request(Employee requester, String content) {
        this.requester = requester;
        this.content = content;
    }
    public Employee getRequester() {
        return requester;
    }
    public void setRequester(Employee requester) {
        this.requester = requester;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
