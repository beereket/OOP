package Users;

import Academic.Course;
import Users.Enums.Title;

import java.util.List;


public class Teacher extends Employee {
    
    private List<Course> coursesTaught;
    
    private Title title;
    protected Double rating = null;
    protected int rated = 0;

    public Teacher() {
    }


    protected void putMarks(){
    }

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(List<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public void update() {

    }
}
