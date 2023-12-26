package Users;

import Academic.Course;
import Academic.Enums.typeOfAttestation;
import Academic.Journal;
import Academic.Lesson;
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
//    protected int rated = 0;

    public Teacher() {
    }

    public Teacher(String username, String password, Title title) {
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
            menu:
            while (true) {
                displayMenu();
                int choice = in.nextInt();
                in.nextLine();
                switch (choice) {
                    case 1:
                        for (Course c : coursesTaught) {
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
    protected void putMarks(Student student , Course course , int mark , typeOfAttestation type) {
        Journal j = new Journal();
        j.putMark(student , course , mark , type);
    }

    public void putMark(Student student , Lesson lesson , int mark){
        Journal j = new Journal();
        j.putMark(student, lesson, mark);
    }

    private void operations() {
        int choice = in.nextInt();
        in.nextLine();
        switch (choice) {
            case 1:
                for (Course c : coursesTaught) {
                    System.out.println(c);
                }
                break;
            case 2:
                manageCourse();
                break;
            case 3:
                viewCourses();
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
        @Override
        protected void displayEnglishMenu() {
            System.out.println("Menu:\n" +
                    "1. View Courses\n" +
                    "2. Manage Course\n" +
                    "3. View Students\n" +
                    "4. Put Marks\n5. Send Messages\n" +
                    "6. Send Complaints\n" +
                    "7. Change Language\n" +
                    "0. Exit");

        }
        //MENU DISPLAY
        @Override
        protected void displayRussianMenu () {
            System.out.println("Меню:\n" +
                    "1. Просмотр курсов\n" +
                    "2. Управление курсами\n" +
                    "3. Просмотр студентов\n" +
                    "4. Ввод оценок\n" +
                    "5. Отправить сообщения\n" +
                    "6. Отправить жалобы\n" +
                    "7. Изменить язык\n" +
                    "0. Выход");

        }

        @Override
        protected void displayKazakhMenu () {
            System.out.println("Мәзір:\n" +
                    "1. Курстарды көру\n" +
                    "2. Курстарды басқару\n" +
                    "3. Студенттерді көру\n" +
                    "4. Бағаларды енгізу\n" +
                    "5. Хабарламаларды жіберу\n" +
                    "6. Шағымдарды жіберу\n" +
                    "7. Тіл өзгерту\n" +
                    "0. Шығу");

        }
    }

    private void viewCourses() {
    }
}
