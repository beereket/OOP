package unite;


/**
* @generated
*/
public class ResearchJournal implements Observer {
    
    /**
    * @generated
    */
    private List<Researcher> subscribers;
    
    /**
    * @generated
    */
    private String name;
    
    
    /**
    * @generated
    */
    private ResearchPaper researchPaper;
    
    

    /**
    * @generated
    */
    private List<Researcher> getSubscribers() {
        return this.subscribers;
    }
    
    /**
    * @generated
    */
    private List<Researcher> setSubscribers(List<Researcher> subscribers) {
        this.subscribers = subscribers;
    }
    
    
    /**
    * @generated
    */
    protected String getName() {
        return this.name;
    }
    
    /**
    * @generated
    */
    protected String setName(String name) {
        this.name = name;
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
    
    
    

    //                          Operations                                  
    
    
}
