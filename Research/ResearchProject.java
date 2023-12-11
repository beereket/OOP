package unite;


/**
* @generated
*/
public class ResearchProject {
    
    /**
    * @generated
    */
    private String topic;
    
    /**
    * @generated
    */
    private int publishedPapers;
    
    /**
    * @generated
    */
    private list projectParticipants;
    
    /**
    * @generated
    */
    private ResearchPaper publishedPapers;
    
    /**
    * @generated
    */
    private  projectParticipants;
    
    
    /**
    * @generated
    */
    private Set<Researcher> researcher;
    
    /**
    * @generated
    */
    private ResearchPaper researchPaper;
    
    

    /**
    * @generated
    */
    private String getTopic() {
        return this.topic;
    }
    
    /**
    * @generated
    */
    private String setTopic(String topic) {
        this.topic = topic;
    }
    
    
    /**
    * @generated
    */
    private int getPublishedPapers() {
        return this.publishedPapers;
    }
    
    /**
    * @generated
    */
    private int setPublishedPapers(Integer publishedPapers) {
        this.publishedPapers = publishedPapers;
    }
    
    
    /**
    * @generated
    */
    private list getProjectParticipants() {
        return this.projectParticipants;
    }
    
    /**
    * @generated
    */
    private list setProjectParticipants(list projectParticipants) {
        this.projectParticipants = projectParticipants;
    }
    
    
    /**
    * @generated
    */
    private ResearchPaper getPublishedPapers() {
        return this.publishedPapers;
    }
    
    /**
    * @generated
    */
    private ResearchPaper setPublishedPapers(ResearchPaper publishedPapers) {
        this.publishedPapers = publishedPapers;
    }
    
    
    /**
    * @generated
    */
    private  getProjectParticipants() {
        return this.projectParticipants;
    }
    
    /**
    * @generated
    */
    private  setProjectParticipants(invalid projectParticipants) {
        this.projectParticipants = projectParticipants;
    }
    
    
    
    /**
    * @generated
    */
    public ResearchPaper getResearchPaper() {
        return this.researchPaper;
    }
    
    /**
    * @generated
    */
    public ResearchPaper setResearchPaper(ResearchPaper researchPaper) {
        this.researchPaper = researchPaper;
    }
    
    
    /**
    * @generated
    */
    public Set<Researcher> getResearcher() {
        if (this.researcher == null) {
            this.researcher = new HashSet<Researcher>();
        }
        return this.researcher;
    }
    
    /**
    * @generated
    */
    public Set<Researcher> setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public void addParticipant() {
        //TODO
    }
    
    
}
