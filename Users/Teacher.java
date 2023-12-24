package Users;

import Academic.Course;
import Users.Enums.Title;
import Util.Classes.Data;
import Util.Enums.UserType;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;


public class Teacher extends Employee implements Serializable {
    private List<Course> coursesTaught;
    private Title title;
    protected Double rating = null;
    protected int rated = 0;
    public Teacher() {
    }

    public Teacher(String username, String password,  Title title) {
        super(username, password, UserType.TEACHER);
        this.title = title;

        Data.getInstance().getTeachers().add(this);
    }


    //getter and setter
    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }
    public Title getTitle() {
        return title;
    }
    public void setTitle(Title title) {
        this.title = title;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }

    // MENY LOOP
    public void run() throws IOException {
        try {
            getWelcomeMessage();
            menu: while (true) {
                displayMenu();
                int choice = in.nextInt();
                in.nextLine();
                switch (choice){
                    case 1:
                        for(Course c : coursesTaught){
                            System.out.println(c);
                        }
                        break;
                    case 2:
                        manageCourse();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        changeLanguage();
                        break;
                    case 8:
                        break;
                    case 0:
                        exit();
                        break menu;
                    default:
                        throw new IllegalStateException("Unexpected value: " + choice);
                }
            }
        } catch (Exception e) {
            handleError(e);
        }
    }
    //manage course
    private void manageCourse() {
    }
    //
    protected void putMarks(){

    }

    //MENU DISPLAY
    @Override
    protected void displayRussianMenu() {
        System.out.println("Меню:");
        System.out.println("1. Просмотр курсов");
        System.out.println("2. Управление курсами");
        System.out.println("3. Просмотр студентов");
        System.out.println("4. Ввод оценок");
        System.out.println("5. Отправить сообщения");
        System.out.println("6. Отправить жалобы");
        System.out.println("7. Изменит язык");
        System.out.println("0. Выход");
    }

    @Override
    protected void displayKazakhMenu() {
        System.out.println("Мәзір:");
        System.out.println("1. Курстарды көру");
        System.out.println("2. Курстарды басқару");
        System.out.println("3. Студенттерді көру");
        System.out.println("4. Бағаларды енгізу");
        System.out.println("5. Хабарламаларды жіберу");
        System.out.println("6. Шағымдарды жіберу");
        System.out.println("7. Тіл өзгерту");
        System.out.println("0. Шығу");
    }

    @Override
    protected void displayEnglishMenu() {
        System.out.println("Menu:");
        System.out.println("1. View Courses");
        System.out.println("2. Manage Course");
        System.out.println("3. View Students");
        System.out.println("4. Put Marks");
        System.out.println("5. Send Messages");
        System.out.println("6. Send Complaints");
        System.out.println("7. Change language");
        System.out.println("0. Exit");
    }


}
