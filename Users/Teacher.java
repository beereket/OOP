package unite-4;


public class Teacher extends Employee implements Researcher {
    
    private List<Course> coursesTaught;
    
    private invalid ;
    
    private Title title;
    
    private Boolean isResearcher;
    
    private invalid journals;
    
    private List<Message> messages;
    
    private Double rating;
    
    
    private Message message;
    
    
    
    private List<Course> getCoursesTaught() {
        return this.coursesTaught;
    }
    
    
    private List<Course> setCoursesTaught(List<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }
    
    
    public invalid get() {
        return this.;
    }
    
    
    public invalid set(invalid ) {
        this. = ;
    }
    
    
    private Title getTitle() {
        return this.title;
    }
    
    
    private Title setTitle(Title title) {
        this.title = title;
    }
    
    
    private Boolean getIsResearcher() {
        return this.isResearcher;
    }
    
    
    private Boolean setIsResearcher(Boolean isResearcher) {
        this.isResearcher = isResearcher;
    }
    
    
    private invalid getJournals() {
        return this.journals;
    }
    
    
    private invalid setJournals(invalid journals) {
        this.journals = journals;
    }
    
    
    private List<Message> getMessages() {
        return this.messages;
    }
    
    
    private List<Message> setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    
    private Double getRating() {
        return this.rating;
    }
    
    
    private Double setRating(Double rating) {
        this.rating = rating;
    }
    

    //                          Operations                                  
    
    
    public void viewCources() {
        //TODO
    }
    
    
    public void viewStudents() {
        //TODO
    }
    
    
    private void putMarks() {
        //TODO
    }
    
    
}
