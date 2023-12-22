package Users;

import Research.ResearchPaper;
import Research.Researcher;
import Util.Enums.UserType;

import java.io.Serializable;
import java.util.List;


public class GraduateStudent extends Student implements Serializable {

    
    private Researcher researchSupervisor;

    public GraduateStudent(String username, String password) {
        super(username, password, UserType.GS);
    }


    public boolean registerForCourse() {
        return false;
    }


    public List<ResearchPaper> viewPublishedPapers() {
        return null;
    }
    
    
}
