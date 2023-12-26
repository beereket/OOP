package Users;

import Academic.Course;
import Academic.Enums.typeOfAttestation;
import Academic.Journal;
import Academic.Lesson;
import Users.Enums.Title;
import Util.Data.DB;
import Util.Enums.UserType;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * The Teacher class represents a user with the role of a teacher in the educational system.
 * It extends the Employee class and includes specific attributes and methods related to teachers.
 */
public class Teacher extends Employee implements Serializable {

    // Attributes specific to the Teacher class
    private List<Course> coursesTaught;
    private Title title;
    protected Double rating = null;

    protected int rates = 0;
    protected int sumOfRatings = 0;
//    protected int rated = 0;
    /**
     * Default constructor for the Teacher class.
     */
    public Teacher() {
    }
    /**
     * Constructor for creating a new Teacher with the specified username, password, and title.
     *
     * @param username The username of the teacher.
     * @param password The password of the teacher.
     * @param title    The title or position of the teacher.
     */
    public Teacher(String username, String password, Title title) {
        super(username, password, UserType.TEACHER);
        this.title = title;

        DB.getInstance().getUsersByUserType(UserType.EMPLOYEE).add(this);
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

    public void setRating(int rating) {
        this.rates++;
        this.sumOfRatings = this.sumOfRatings + rating;
        this.rating = (double) (this.sumOfRatings / this.rates);
    }

    // Getter and setter methods...

    /**
     * Runs the main menu for the teacher user, allowing interaction with various features.
     *
     * @throws IOException If an I/O error occurs.
     */
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
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }

    }
    // Other methods...

    /**
     * Displays the menu in English for the teacher user.
     */
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

    /**
     * Displays information about the courses taught by the teacher.
     */

    private void viewCourses() {
        for (Course c: coursesTaught){
            System.out.println(c.getTitle());
        }
    }

    public void addCourse(Course courseToAssign) {
        coursesTaught.add(courseToAssign);
    }
}
