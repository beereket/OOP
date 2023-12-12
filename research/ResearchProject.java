package research;

import java.util.*;

public class ResearchProject {
    private String topic;
    private ResearchPaper publishedPapers;
    private List<Researcher> projectParticipants = new ArrayList<>();

    public ResearchProject(String topic, ResearchPaper publishedPapers) {
        this.topic = topic;
        this.publishedPapers = publishedPapers;
    }

    public void addParticipant(Researcher researcher) throws ResearchProjectJoinException {
        if (!projectParticipants.contains(researcher)) {
            projectParticipants.add(researcher);
            researcher.joinResearchProject(this); // Notify researcher about joining the project
        } else {
            throw new ResearchProjectJoinException("Researcher is already a participant in the project");
        }
    }
    
    public String toString() {
    	return topic + "\n" + publishedPapers + "\n" + projectParticipants; 
    }

}
