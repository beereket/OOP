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

public class Manager extends Employee implements Serializable {
    //FIELDS
    private ManagerType managerType;

    //CONSTUCTORS
    public Manager(String userName, String password) {

    }

    //METHODS
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


    //MENU METHODS
    public void run() throws IOException {
        try{
            getWelcomeMessage();
            menu : while (true){
                int choice = in.nextInt();
                displayMenu();

            }
        } catch (Exception e) {
            handleError(e);
        }
    }

    @Override
    protected void displayEnglishMenu() {
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

    @Override
    protected void displayRussianMenu() {
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

    @Override
    protected void displayKazakhMenu() {
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
