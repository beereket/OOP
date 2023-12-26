package Research;

import Research.Exceptions.ResearchSupervisorException;

import java.util.Comparator;

public interface Researcher {
    void printPapers(Comparator<ResearchPaper> comparator);

    int calculateHIndex();

    String getResearcherName();

    void setSupervisor(Researcher supervisor) throws ResearchSupervisorException;

}
