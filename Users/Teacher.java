package Users;

import Academic.Course;
import Academic.Lesson;
import Messages.Message;
import Users.Enums.Title;

import java.util.List;


public class Teacher extends Employee {
    
    private List<Course> coursesTaught;
    
    private Title title;
    
    private Boolean isResearcher;
    private List<Message> messages;
    private Double rating = null;
    private int rated = 0; // to calculate;
    private Message message;

    public Teacher(String username, String password, List<Course> coursesTaught, Title title, Boolean isResearcher, List<Message> messages, Double rating, Message message) {
        super(username, password);
        this.coursesTaught = coursesTaught;
        this.title = title;
        this.isResearcher = isResearcher;
        this.messages = messages;
        this.rating = rating;
        this.message = message;
    }

    public Teacher(String username, String password, Integer id, String position, List<Course> coursesTaught, Title title, Boolean isResearcher, List<Message> messages, Double rating, Message message) {
        super(username, password, id, position);
        this.coursesTaught = coursesTaught;
        this.title = title;
        this.isResearcher = isResearcher;
        this.messages = messages;
        this.rating = rating;
        this.message = message;
    }

    public Teacher(List<Course> coursesTaught, Title title, Boolean isResearcher, List<Message> messages, Double rating, Message message) {
        this.coursesTaught = coursesTaught;
        this.title = title;
        this.isResearcher = isResearcher;
        this.messages = messages;
        this.rating = rating;
        this.message = message;
    }

    public Teacher(String username, String password) {
        super(username, password);
    }


    public Teacher(String username, String password, Integer id, String position) {
        super(username, password, id, position);
    }

    public Teacher() {
    }

    public void putMarks(Lesson l){

    }

    public void getRated(int rate){
        rating = (rating*rated + rate)/(rated + 1);
        rated += 1;
    }


    @Override
    public void update() {

    }
}
