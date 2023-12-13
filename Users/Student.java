package Users;


import Academic.Course;
import Utils.*;
import Utils.classes.Data;

import java.util.Calendar;
import java.util.List;

public class Student extends User implements Observer {
    
    private Integer id;
    private double GPA;
    
    private Faculty faculty;
    
    private Integer yearOfStudy;
    private List<Course> coursesRegistered;
    
    private String transcript;
    private Degree degree;
    private Boolean isResearcher;
    private StudentOrganization studentOrganization;
    private Integer credits;

    {
        Data data = Data.getInstance();
        data.addUser(this);
    }

    public Student(String username, String password) {
        super(username, password);
    }


    @Override
    public void update() {

    }

    public double getGPA() {
        return GPA;
    }

    public List<Course> getCoursesRegistered(){
        return coursesRegistered;
    }
    public void rateTeacher(Teacher t, int rate){
        t.getRated(rate);
    }
    public void viewInfoAboutTeacher(Teacher t){
        System.out.println(t);
    }
}
