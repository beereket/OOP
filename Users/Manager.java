package Users;

import Academic.Course;
import Messages.Request;
import News.News;
import Users.Enums.ManagerType;
import Util.Classes.Data;
import Util.Enums.Language;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import static Util.Enums.Language.*;

public class Manager extends Employee implements Serializable {

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

    public void run() throws IOException {
        try{
            if(language == KZ) System.out.println("Қош келдіңіз!");
            else if(language == RUS) System.out.println("Добро пожаловать!");
            else System.out.println("Welcome!");

            menu : while (true){

            }
        } catch (Exception e) {
            if(language == KZ)System.out.println("Ойбай, қате...");
            else if(language == RUS) System.out.println("Ошибка....");
            else System.out.println("Error... ");
            e.printStackTrace();
            save();
        }
    }

    private void save() throws IOException {
        Data.write();
    }
    private void exit(Language language) {
        if(language == ENG) System.out.println("Bye bye!");
        else if(language == KZ) System.out.println("Сауболыңыз!");
        else System.out.println("До свидания!");
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @Override
    public void update() {

    }
}
