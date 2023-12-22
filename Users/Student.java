package Users;


import Academic.Course;
import Research.ResearchProject;
import Research.ResearchProjectJoinException;
import Research.ResearchSupervisorException;
import Research.Researcher;
import Users.Enums.Degree;
import Users.Enums.Faculty;
import Util.Classes.Data;
import Util.Enums.UserType;
import Util.Observer;

import java.util.List;
import java.util.Vector;

public class Student extends User implements Observer, Researcher {
    
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

    @Override
    public void update() {

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

    @Override
    public void printPapers() {

    }

    @Override
    public int calculateHIndex() {
        return 0;
    }

    @Override
    public void setSupervisor(Researcher supervisor) throws ResearchSupervisorException {

    }

    @Override
    public void joinResearchProject(ResearchProject project) throws ResearchProjectJoinException {

    }

    @Override
    public void notify(String message) {

    }
}
