package Users;

import Academic.Course;
import Messages.Request;
import News.News;
import Users.Enums.ManagerType;
import Util.Classes.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class Manager extends Employee implements Serializable {
    private Integer id;
    private ManagerType managerType;

    public Manager(String userName, String password) {

    }

    public void addCoursesForRegistration(Course c) {
        Data.getInstance().addCourse(c);
    }

    public List<Request> viewRequests() {
        Rector r = Rector.getINSTANCE();
        return r.getSignedRequests();
    }

    public void viewInfo(User u) {
        System.out.println(u);
    }

    public Vector<Student> createStatisticalReport() {
        return Data.getInstance().getStudents();
    }

    public void enrollStudent() {

    }

    public void addNews(News n){
        Data.getInstance().addNews(n);
    }
    public void deleteNews(News n){
        Data.getInstance().removeNews(n);
    }

    @Override
    public void update() {

    }
}
