package Users;

import Academic.Course;
import Messages.Request;
import News.News;
import Users.Enums.ManagerType;
import Util.Classes.Data;

import java.util.List;
import java.util.Vector;

public class Manager extends Employee {
    
    private Integer id;
    
    private ManagerType managerType;

    public void addCoursesForRegistration(Course c) {
        Data.courses.add(c);
    }

    public List<Request> viewRequests() {
        Rector r = Rector.getINSTANCE();
        return r.getSignedRequests();
    }

    public void viewInfo(User u) {
        System.out.println(u);
    }

    public Vector<Student> createStatisticalReport() {
        return Data.INSTANCE.getStudents();
    }

    public void enrollStudent() {

    }

    public void addNews(News n){
        Data.INSTANCE.news.add(n);
    }
    public void deleteNews(News n){
        Data.INSTANCE.news.remove(n);
    }


    @Override
    public void update() {

    }
}
