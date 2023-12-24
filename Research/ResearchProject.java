package Research;

import java.io.Serializable;
import java.util.*;

public class ResearchProject implements Serializable {
    private String topic;
    private ResearchPaper publishedPapers;
    private List<Researcher> projectParticipants = new ArrayList<>();

    public ResearchProject(String topic, ResearchPaper publishedPapers) {
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
    
    public String toString() {
    	return topic + "\n" + publishedPapers + "\n" + projectParticipants; 
    }

}
