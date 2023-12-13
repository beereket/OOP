package Users;

import Research.*;
import Utils.classes.Data;

import java.util.List;


public class GraduateStudent extends Student {

    
    private Researcher researchSupervisor;

    public GraduateStudent(String username, String password) {
        super(username, password);
    }


    public boolean registerForCourse() {
        return false;
    }

    {
        Data data = Data.getInstance();
        data.addUser(this);
    }

    public List<ResearchPaper> viewPublishedPapers() {
        return null;
    }
    
    
}
