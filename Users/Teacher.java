package unite;


/**
* @generated
*/
public class Teacher extends Employee implements Supervisor, Researcher {
    
    /**
    * @generated
    */
    private List coursesTaught;
    
    /**
    * @generated
    */
    private  ;
    
    /**
    * @generated
    */
    private Title title;
    
    /**
    * @generated
    */
    private boolean isResearcher;
    
    /**
    * @generated
    */
    private HashMap<Lesson, List<Journal>> journals;
    
    /**
    * @generated
    */
    private List<Message> messages;
    
    /**
    * @generated
    */
    private double rating;
    
    
    /**
    * @generated
    */
    private Message message;
    
    

    /**
    * @generated
    */
    private List getCoursesTaught() {
        return this.coursesTaught;
    }
    
    /**
    * @generated
    */
    private List setCoursesTaught(List coursesTaught) {
        this.coursesTaught = coursesTaught;
    }
    
    
    /**
    * @generated
    */
    public  get() {
        return this.;
    }
    
    /**
    * @generated
    */
    public  set(invalid ) {
        this. = ;
    }
    
    
    /**
    * @generated
    */
    private Title getTitle() {
        return this.title;
    }
    
    /**
    * @generated
    */
    private Title setTitle(Title title) {
        this.title = title;
    }
    
    
    /**
    * @generated
    */
    private boolean getIsResearcher() {
        return this.isResearcher;
    }
    
    /**
    * @generated
    */
    private boolean setIsResearcher(Boolean isResearcher) {
        this.isResearcher = isResearcher;
    }
    
    
    /**
    * @generated
    */
    private HashMap<Lesson, List<Journal>> getJournals() {
        return this.journals;
    }
    
    /**
    * @generated
    */
    private HashMap<Lesson, List<Journal>> setJournals(HashMap<Lesson, List<Journal>> journals) {
        this.journals = journals;
    }
    
    
    /**
    * @generated
    */
    private List<Message> getMessages() {
        return this.messages;
    }
    
    /**
    * @generated
    */
    private List<Message> setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    
    /**
    * @generated
    */
    private double getRating() {
        return this.rating;
    }
    
    /**
    * @generated
    */
    private double setRating(Double rating) {
        this.rating = rating;
    }
    
    
    
    /**
    * @generated
    */
    public Message getMessage() {
        return this.message;
    }
    
    /**
    * @generated
    */
    public Message setMessage(Message message) {
        this.message = message;
    }
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public List viewCources() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    public List viewStudents() {
        //TODO
        return null;
    }
    
    /**
    * @generated
    */
    private void putMarks() {
        //TODO
    }
    
    
}
