package Users;

import News.News;
import Util.Data.DB;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class StudentOrganization implements Serializable {
    

    private String name;

    private Student president;
    private  Vector<News> news;

    private Vector<Student> students;

    public void manageNews() {

    }

    public StudentOrganization(String name,  Student president) {
        this.name = name;
        this.president = president;
        news = new Vector<News>();
        students = new Vector<Student>();

        DB.getInstance().getOrganizations().add(this);
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

    public void setNews(Vector<News> news) {
        this.news = news;
    }

    public Student getPresident() {
        return president;
    }

    public void setPresident(Student president) {
        this.president = president;
    }
}
