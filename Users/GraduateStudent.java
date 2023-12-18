package Users;

import Research.ResearchPaper;
import Research.Researcher;
import Util.Observer;

import java.util.List;


public class GraduateStudent extends Student implements Observer, Researcher {

    
    private Researcher researchSupervisor;

    public GraduateStudent(String username, String password) {
        super(username, password);
    }


    public boolean registerForCourse() {
        return false;
    }


    public List<ResearchPaper> viewPublishedPapers() {
        return null;
    }
    
    
}
