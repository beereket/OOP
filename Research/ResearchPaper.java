package unite;


/**
* @generated
*/
public class ResearchPaper {
    
    /**
    * @generated
    */
    private String title;
    
    /**
    * @generated
    */
    private String authors;
    
    /**
    * @generated
    */
    private String citations;
    
    /**
    * @generated
    */
    private String doi;
    
    /**
    * @generated
    */
    private int pages;
    
    /**
    * @generated
    */
    private int publicationYear;
    
    /**
    * @generated
    */
    private String link;
    
    /**
    * @generated
    */
    private String publisher;
    
    /**
    * @generated
    */
    private int accessionNumber;
    
    
    /**
    * @generated
    */
    private ResearchProject researchProject;
    
    /**
    * @generated
    */
    private Set<ResearchJournal> researchJournal;
    
    

    /**
    * @generated
    */
    private String getTitle() {
        return this.title;
    }
    
    /**
    * @generated
    */
    private String setTitle(String title) {
        this.title = title;
    }
    
    
    /**
    * @generated
    */
    private String getAuthors() {
        return this.authors;
    }
    
    /**
    * @generated
    */
    private String setAuthors(String authors) {
        this.authors = authors;
    }
    
    
    /**
    * @generated
    */
    private String getCitations() {
        return this.citations;
    }
    
    /**
    * @generated
    */
    private String setCitations(String citations) {
        this.citations = citations;
    }
    
    
    /**
    * @generated
    */
    private String getDoi() {
        return this.doi;
    }
    
    /**
    * @generated
    */
    private String setDoi(String doi) {
        this.doi = doi;
    }
    
    
    /**
    * @generated
    */
    private int getPages() {
        return this.pages;
    }
    
    /**
    * @generated
    */
    private int setPages(Integer pages) {
        this.pages = pages;
    }
    
    
    /**
    * @generated
    */
    private int getPublicationYear() {
        return this.publicationYear;
    }
    
    /**
    * @generated
    */
    private int setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }
    
    
    /**
    * @generated
    */
    private String getLink() {
        return this.link;
    }
    
    /**
    * @generated
    */
    private String setLink(String link) {
        this.link = link;
    }
    
    
    /**
    * @generated
    */
    private String getPublisher() {
        return this.publisher;
    }
    
    /**
    * @generated
    */
    private String setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    
    /**
    * @generated
    */
    private int getAccessionNumber() {
        return this.accessionNumber;
    }
    
    /**
    * @generated
    */
    private int setAccessionNumber(Integer accessionNumber) {
        this.accessionNumber = accessionNumber;
    }
    
    
    
    /**
    * @generated
    */
    public Set<ResearchJournal> getResearchJournal() {
        if (this.researchJournal == null) {
            this.researchJournal = new HashSet<ResearchJournal>();
        }
        return this.researchJournal;
    }
    
    /**
    * @generated
    */
    public Set<ResearchJournal> setResearchJournal(ResearchJournal researchJournal) {
        this.researchJournal = researchJournal;
    }
    
    
    /**
    * @generated
    */
    public ResearchProject getResearchProject() {
        return this.researchProject;
    }
    
    /**
    * @generated
    */
    public ResearchProject setResearchProject(ResearchProject researchProject) {
        this.researchProject = researchProject;
    }
    
    
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public String getCitation() {
        //TODO
        return "";
    }
    
    
}
