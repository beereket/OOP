package Research;

import Research.Exceptions.ResearchSupervisorException;

import java.util.Comparator;

/**
 * An interface representing a researcher in a university system.
 * Researchers are individuals engaged in academic research activities.
 * Researchers can be a Student/Teacher/Employee.
 * Graduate Students are always researchers.
 */
public interface Researcher {
    /**
     * Prints the research papers of the researcher.
     *
     * @param comparator The comparator to determine the sorting order of the papers.
     */
    void printPapers(Comparator<ResearchPaper> comparator);

    /**
     * Calculates the H-index of the researcher based on their research papers.
     *
     * @return The calculated H-index.
     */
    int calculateHIndex();

    /**
     * Gets the name of the researcher.
     *
     * @return The name of the researcher.
     */
    String getResearcherName();

    /**
     * Sets the supervisor for the researcher.
     *
     * @param supervisor The supervisor to be set for the researcher.
     * @throws Research.Exceptions.ResearchSupervisorException If an error occurs while setting the supervisor.
     */
    void setSupervisor(Researcher supervisor) throws ResearchSupervisorException;
}
