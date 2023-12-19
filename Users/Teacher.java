package Users;

import Academic.Course;
import Academic.Lesson;
import Users.Enums.Title;

import java.util.List;


public class Teacher extends Employee {
    
    private List<Course> coursesTaught;
    
    private Title title;
    private Boolean isResearcher = false;
    private Double rating = null;

    public Teacher() {
    }

    protected void putMarks(Lesson l){
    }

    @Override
    public void update() {

    }
}
