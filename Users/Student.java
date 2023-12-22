package Users;


import Academic.Course;
import Users.Enums.Degree;
import Users.Enums.Faculty;
import Util.Classes.Data;
import Util.Enums.UserType;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class Student extends User implements Serializable {
    
    protected Integer id;
    protected double GPA = 0;
    protected Faculty faculty;
    protected Integer yearOfStudy = 1;
    protected Vector<Course> coursesRegistered = new Vector<Course>();
    protected Degree degree;
    protected StudentOrganization studentOrganization = null;
    protected Integer credits = 0;
    public Student(String username, String password, UserType userType) {
        super(username, password, userType);
    }


    public Student(String username, String password, UserType userType, Faculty faculty) {
        super(username, password, userType);
        this.id = Data.getInstance().getStudents().size() + 1;
        this.faculty = faculty;
    }

    public double getGPA() {
        return GPA;
    }

    protected List<Course> getCoursesRegistered(){
        return coursesRegistered;
    }
    protected void rateTeacher(Teacher t, int rate){
    }
    private void viewInfoAboutTeacher(Teacher t){
        System.out.println(t);
    }

    // MENU METHODS
    @Override
    public void update() {

    }
    @Override
    public void run() throws IOException {

    }

    @Override
    protected void displayRussianMenu() {

    }

    @Override
    protected void displayKazakhMenu() {

    }

    @Override
    protected void displayEnglishMenu() {

    }
}
