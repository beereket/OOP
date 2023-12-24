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
    protected Faculty faculty;
    protected Integer yearOfStudy = 1;
    protected Vector<Course> coursesRegistered = new Vector<Course>();
    protected Degree degree;
    protected StudentOrganization studentOrganization = null;
    protected Integer credits = 0;
    public Student(String username, String password, UserType userType) {
        super(username, password, userType);
    }


    public Student(String username, String password, Faculty faculty, Degree degree) {
        super(username, password, UserType.STUDENT);
        this.id = Data.getInstance().getStudents().size() + 1;
        this.faculty = faculty;
        this.degree = degree;

        Data.getInstance().getStudents().add(this);
    }

    public double getGPA() {
        return 0.0;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", faculty=" + faculty +
                ", yearOfStudy=" + yearOfStudy +
                ", coursesRegistered=" + coursesRegistered +
                ", degree=" + degree +
                ", studentOrganization=" + studentOrganization +
                ", credits=" + credits +
                '}';
    }
}
