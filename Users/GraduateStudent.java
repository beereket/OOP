package Users;

import Research.ResearchPaper;
import Research.Researcher;
import Util.Classes.Data;

import java.util.List;


public class GraduateStudent extends Student {

    
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
