package unite-4;


public class News  {
    
    private String title;
    
    private String content;
    
    private List<Observers> subscribers;
    private Date date;
    
    private String comments;
    

    
    
    
    private String getTitle() {
        return this.title;
    }
    
    
    private String setTitle(String title) {
        this.title = title;
    }
    
    
    private String getContent() {
        return this.content;
    }
    
    
    private String setContent(String content) {
        this.content = content;
    }
    
    
    private invalid getSubscribers() {
        return this.subscribers;
    }
    
    
    private invalid setSubscribers(invalid subscribers) {
        this.subscribers = subscribers;
    }
    
    
    private Date getDate() {
        return this.date;
    }
    
    
    private Date setDate(Date date) {
        this.date = date;
    }
    
    

    
}
