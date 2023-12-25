package Research;

import java.io.Serializable;
import java.util.*;

public class ResearchProject implements Serializable {
    private String topic;
    private List<ResearchPaper> publishedPapers;
    private List<Researcher> projectParticipants = new ArrayList<>();

    public ResearchProject(String topic, List<ResearchPaper> publishedPapers) {
        this.topic = topic;
        this.publishedPapers = publishedPapers;
    }

    public void addParticipant(Researcher researcher) throws Research.ResearchProjectJoinException {
        if (!projectParticipants.contains(researcher)) {
            projectParticipants.add(researcher);
            researcher.joinResearchProject(this); // Notify researcher about joining the project
        } else {
            throw new Research.ResearchProjectJoinException("Researcher is already a participant in the project");
        }
    }

    public void addPaper(ResearchPaper paper) {
        if (!publishedPapers.contains(paper)) {
            publishedPapers.add(paper);
        }
    }
    
    public String toString() {
    	return topic + "\n" + publishedPapers + "\n" + projectParticipants; 
    }

}
