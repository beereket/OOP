package Users;

import News.News;

import java.io.Serializable;
import java.util.List;

public class StudentOrganization implements Serializable {
    
    private List<Student> subscribers;
    
    private String name;
    
    private  List<News> news;
    
    private Student president;

    public void manageNews() {

    }

    public StudentOrganization(String name,  Student president) {
        this.name = name;
        this.president = president;
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
