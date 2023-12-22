package Users;

import Academic.Course;
import Users.Enums.Title;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import static Util.Enums.Language.*;
import static Util.Enums.Language.KZ;


public class Teacher extends Employee implements Serializable {
    
    private List<Course> coursesTaught;
    
    private Title title;
    protected Double rating = null;
    protected int rated = 0;

    public Teacher() {
    }


    protected void putMarks(){

    }

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(List<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
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

    public void run() throws IOException {
        try {
            if (language == KZ) System.out.println("Қош келдіңіз!");
            else if (language == RUS) System.out.println("Добро пожаловать!");
            else System.out.println("Welcome!");

            while (true) {
                displayMenu();
                int choice = in.nextInt();
            }
        } catch (Exception e) {
            handleError(e);
        }
    }

    @Override
    protected void displayRussianMenu() {
        System.out.println("Меню:");
        System.out.println("1. Просмотр курсов");
        System.out.println("2. Управление курсами");
        System.out.println("3. Просмотр студентов");
        System.out.println("4. Ввод оценок");
        System.out.println("5. Отправить сообщения");
        System.out.println("6. Отправить жалобы");
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
        System.out.println("0. Exit");
    }


}
