package Users;

import Academic.Course;
import Academic.Lesson;
import Users.Enums.Title;

import java.util.List;


public class Teacher extends Employee {
    
    private List<Course> coursesTaught;
    
    private Title title;
    private Boolean isResearcher;
    private Double rating = null;
    private int rated = 0; // to calculate;

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
