package unite-4;


public class StudentOrganization {
    
    private List<Student> subscribers;
    
    private String name;
    
    private List<News> news;
    
    private Student president;
    
    
    private Student student;
    
    
    
    private List<Student> getSubscribers() {
        return this.subscribers;
    }
    
    
    private List<Student> setSubscribers(List<Student> subscribers) {
        this.subscribers = subscribers;
    }
    
    
    private String getName() {
        return this.name;
    }
    
    
    private String setName(String name) {
        this.name = name;
    }
    
    
    private List<News> getNews() {
        return this.news;
    }
    
    
    private List<News> setNews(List<News> news) {
        this.news = news;
    }
    
    
    private Student getPresident() {
        return this.president;
    }
    
    
    private Student setPresident(Student president) {
        this.president = president;
    }
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public News manageNews() {
        //TODO
        return null;
    }
    
    
}
