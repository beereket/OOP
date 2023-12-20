package Users;

import Academic.Course;
import Messages.Request;
import News.News;
import Users.Enums.ManagerType;
import Util.Classes.Data;

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
                int choice = in.nextInt();
                displayMenu();

            }
        } catch (Exception e) {
            if(language == KZ)System.out.println("Ойбай, қате...");
            else if(language == RUS) System.out.println("Ошибка....");
            else System.out.println("Error... ");
            e.printStackTrace();
            save();
        }
    }
    private void displayMenu(){
        if(language == ENG) displayEnglishMenu();
        else if (language == KZ) displayKazakhMenu();
        else displayRussianMenu();
    }
    private void displayEnglishMenu() {
        System.out.println("Manager Terminal Menu:");
        System.out.println("1. Approve students registration");
        System.out.println("2. Add courses for registration");
        System.out.println("3. Assign courses to teachers");
        System.out.println("4. View info about students and teachers");
        System.out.println("5. Create statistical reports on academic performance");
        System.out.println("6. Manage news");
        System.out.println("7. View requests from employees");
        System.out.println("8. Change language");
        System.out.println("9. Exit");
    }

    private void displayRussianMenu() {
        System.out.println("Меню Менеджера:");
        System.out.println("1. Подтвердить регистрацию студентов");
        System.out.println("2. Добавить курсы для регистрации");
        System.out.println("3. Назначить курсы преподавателям");
        System.out.println("4. Просмотреть информацию о студентах и преподавателях");
        System.out.println("5. Создать статистические отчеты об успеваемости");
        System.out.println("6. Управлять новостями");
        System.out.println("7. Просмотреть запросы от сотрудников");
        System.out.println("8. Изменить язык");
        System.out.println("9. Выйти");
    }

    private void displayKazakhMenu() {
        System.out.println("Менеджер меню:");
        System.out.println("1. Студенттердің тіркеуін растау");
        System.out.println("2. Тіркелу үшін пәндерді қосу");
        System.out.println("3. Пәндерді оқытушыларға арнаулау");
        System.out.println("4. Студенттер мен оқытушылар туралы ақпарат көру");
        System.out.println("5. Академиялық жетімділік туралы статистикалық есептер жасау");
        System.out.println("6. Жаңалықтарды басқару");
        System.out.println("7. Жұмысшылардан сұрауларды қарау");
        System.out.println("8. Тіл өзгерту");
        System.out.println("9. Шығу");
    }



    @Override
    public void update() {

    }
}
