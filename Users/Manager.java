package Users;

import Academic.Course;
import Messages.Request;
import News.*;
import Utils.classes.Data;

import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Manager extends Employee {
    
    private Integer id;
    
    private ManagerType managerType;

    private static List<News> news;
    
    private List<News> getNews() {
        return this.news;
    }

    {
        Data data = Data.getInstance();
        data.addUser(this);
    }
    
    private List<News> setNews(List<News> news) {
        this.news = news;
    }

    
    public void addCoursesForRegistration(Course c) {
        Data data = Data.getInstance();
        data.addCourse(c);
    }

    public List<Request> viewRequests() {
        Rector r = Rector.getINSTANCE();
        return r.getSignedRequests();
    }

    public void viewInfo(User u) {
        System.out.println(u);
    }

    public List<Student> createStatisticalReport() {
        Data data = Data.getInstance();
        return data.getUsers().stream().filter(obj -> obj instanceof Student).map(obj -> (Student)obj).collect(toList());
    }

    public void enrollStudent() {

    }

    public void addNews(News n){
        news.add(n);
    }
    public void deleteNews(News n){
        news.remove(n);
    }


    @Override
    public void update() {

    }
}
