package Users;


import java.util.List;
import News.*;
import Utils.classes.Data;


public class StudentOrganization {
    
    private List<Student> subscribers;
    
    private String name;
    
    private  List<News> news;
    
    private Student president;

    public News manageNews() {
        //TODO
        return null;
    }

    public StudentOrganization(String name,  Student president) {
        this.name = name;
        this.president = president;
    }
    {
        Data data = Data.getInstance();
        data.addSO(this);
    }

    public List<Student> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Student> subscribers) {
        this.subscribers = subscribers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public Student getPresident() {
        return president;
    }

    public void setPresident(Student president) {
        this.president = president;
    }
}
