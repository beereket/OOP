package Research;

import Research.Exceptions.ResearchProjectLeaveException;

import java.io.Serializable;
import java.util.*;
/**
 * A class representing a research project in the university system.
 * Research projects involve a specific topic and may have multiple participants.
 */
public class ResearchProject implements Serializable {
    private String topic;
    private List<ResearchPaper> publishedPapers;
    private List<Researcher> projectParticipants = new ArrayList<>();

    /**
     * Constructs a new ResearchProject with the specified topic and associated published papers.
     *
     * @param topic           The topic of the research project.
     * @param publishedPapers The list of research papers associated with the project.
     */
    public ResearchProject(String topic, List<ResearchPaper> publishedPapers) {
        this.topic = topic;
        this.publishedPapers = publishedPapers;
    }

    /**
     * Adds a researcher as a participant to the research project.
     *
     * @param researcher The researcher to be added.
     * @throws Research.Exceptions.ResearchProjectJoinException If the researcher is already a participant.
     */
    public void addParticipant(Researcher researcher) throws Research.Exceptions.ResearchProjectJoinException {
        if (!projectParticipants.contains(researcher)) {
            projectParticipants.add(researcher);
        } else {
            throw new Research.Exceptions.ResearchProjectJoinException("Researcher is already a participant in the project");
        }
    }
    /**
     * Removes a researcher from the project participants.
     *
     * @param researcher The researcher to be removed from the project.
     * @throws ResearchProjectLeaveException If the researcher is not a participant in the project.
     */
    public void removeParticipant(Researcher researcher) throws ResearchProjectLeaveException {
        if (projectParticipants.contains(researcher)) {
            projectParticipants.remove(researcher);
        } else {
            throw new ResearchProjectLeaveException("Researcher is not a participant in the project");
        }
    }

    /**
     * Publishes a research paper associated with the project.
     *
     * @param paper The research paper to be published.
     */
    public void publishPaper(ResearchPaper paper) {
        if (!publishedPapers.contains(paper)) {
            publishedPapers.add(paper);
        }
    }

    /**
     * Indicates whether some other object is "equal to" this one. Two ResearchProjects are considered equal if they
     * have the same topic and identical lists of published papers.
     *
     * @param obj The reference object with which to compare.
     * @return {@code true} if this object is equal to the obj argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ResearchProject that = (ResearchProject) obj;

        return Objects.equals(topic, that.topic) && Objects.equals(publishedPapers, that.publishedPapers);
    }
    /**
     * Returns a hash code value for the object. This method is supported for the benefit of hash tables
     * such as those provided by {@link HashMap}.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(topic, publishedPapers);
    }

    /**
     * Returns a string representation of the research project.
     *
     * @return A string containing the topic, published papers, and project participants.
     */
    public String toString() {
    	return topic + "\n" + publishedPapers + "\n" + projectParticipants; 
    }
}
