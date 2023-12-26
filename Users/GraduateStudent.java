package Users;

import Research.ResearchPaper;
import Research.Researcher;
import Users.Enums.Degree;
import Users.Enums.Faculty;
import Util.Enums.UserType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GraduateStudent extends Student implements Serializable {
    protected Researcher researchSupervisor;
    List<ResearchPaper> diplomaProjects = getAllResearchPapers().stream()
            .filter(paper -> paper.getAuthors().contains(this))
            .collect(Collectors.toList());;

    public GraduateStudent(String username, String password) {
        super(username, password, UserType.GS);
    }
    public GraduateStudent(String username, String password, Faculty faculty, Degree degree, Researcher researchSupervisor) {
        super(username, password, faculty, degree);
        this.researchSupervisor = researchSupervisor;
    }

    public void registerForCourse() {
        super.registerCourse();
    }

    public List<ResearchPaper> viewDiplomaProjects() {
        return diplomaProjects;
    }
}
