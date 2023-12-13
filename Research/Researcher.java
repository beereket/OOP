package Research;

public interface Researcher {
    void printPapers();

    int calculateHIndex();

    void setSupervisor(Researcher supervisor) throws ResearchSupervisorException;

    void joinResearchProject(ResearchProject project) throws ResearchProjectJoinException;
    
    void notify(String message);

}
