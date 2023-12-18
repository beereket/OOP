package Research;

public interface Researcher {
    void printPapers();

    int calculateHIndex();

    void setSupervisor(Researcher supervisor) throws Research.ResearchSupervisorException;

    void joinResearchProject(ResearchProject project) throws Research.ResearchProjectJoinException;
    
    void notify(String message);

}
