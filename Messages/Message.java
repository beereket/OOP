package unite-4;


public class Message{
    
    private User sender;
    private User receiver;
    private String content;

    
    
    
    private User getSender() {
        return this.sender;
    }
    
    
    private User setSender(User sender) {
        this.sender = sender;
    }
    
    
    private User getReceiver() {
        return this.receiver;
    }
    
    
    private User setReceiver(User receiver) {
        this.receiver = receiver;
    }
    
    
    private String getContent() {
        return this.content;
    }
    
    
    private String setContent(String content) {
        this.content = content;
    }

    
}
