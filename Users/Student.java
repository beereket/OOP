package Users;


import Academic.Course;
import Research.ResearchProjectJoinException;
import Research.ResearchSupervisorException;
import Research.Researcher;
import Users.Enums.Degree;
import Users.Enums.Faculty;
import Util.Observer;
import Research.*;
import java.util.List;

public class Student extends User implements Observer, Researcher {
    
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
