package Users;

import Academic.Course;
import Academic.Enums.typeOfAttestation;
import Academic.Journal;
import Academic.Lesson;
import Messages.Complaint;
import Messages.Request;
import Messages.enums.UrgencyLevel;
import Users.Enums.Title;
import Util.Data.DB;
import Util.Enums.UserType;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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

        DB.getInstance().addUser(this, UserType.TEACHER);
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
                        for (Course c : coursesTaught) {
                            System.out.println(c);
                            c.viewStudents();
                        }
                        break;
                    case 4:
                        Course selected = chooseCourseFromList();
                        System.out.println("Student id or username:");
                        String identifier = in.nextLine();

                        int mark = in.nextInt();

                        System.out.println("Choose type of attestation:");
                        for (typeOfAttestation attestation : typeOfAttestation.values()) {
                            System.out.println(attestation.ordinal() + 1 + ". " + attestation.toString());
                        }

                        int c = in.nextInt();
                        in.nextLine();

                        typeOfAttestation selectedAttestation = null;
                        if (c >= 1 && choice <= typeOfAttestation.values().length) {
                            selectedAttestation = typeOfAttestation.values()[c - 1];
                            System.out.println("You selected: " + selectedAttestation.toString());
                        } else {
                            System.out.println("Invalid choice.");
                        }

                        putMarks(selected.findStudentByIdentifier(identifier), selected, mark, selectedAttestation);
                        break;
                    case 5:
                        sendMessage();
                        break;
                    case 6:
                        System.out.println("Print username of Student");
                        String name = in.nextLine();

                        System.out.println("Description:");
                        String description = in.nextLine();


                        System.out.println("Choose urgency level:");
                        for (UrgencyLevel level : UrgencyLevel.values()) {
                            System.out.println(level.ordinal() + 1 + ". " + level.toString());
                        }

                        // Get user input
                        int index = in.nextInt();
                        in.nextLine();

                        if (choice >= 1 && choice <= UrgencyLevel.values().length) {
                            UrgencyLevel selectedLevel = UrgencyLevel.values()[index - 1];
                            System.out.println("You selected: " + selectedLevel.toString());
                            Rector.getINSTANCE().addComplaint(new Complaint((Student) DB.getInstance().getUserByUsername(name), description, selectedLevel, this));
                        } else {
                            System.out.println("Invalid choice.");
                        }

                        break;
                    case 7:
                        changeLanguage();
                        break;
                    case 8:
                        viewAllNews();
                        break;
                    case 9:
                        System.out.println("CHOOSING COURSE:");
                        Course COURSE = chooseCourseFromList();

                        System.out.println("Student id or username:");
                        String IDENTIFIER = in.nextLine();

                        System.out.println("MARK:");
                        int MARK = in.nextInt();

                        Student selectedStudent = COURSE.findStudentByIdentifier(IDENTIFIER);
                        putMark(selectedStudent, selectedStudent.getLesson(COURSE), MARK);
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
    /**
     * Manages courses for the teacher, allowing actions such as grading, adding content, etc.
     */
    private void manageCourse() throws IOException {
        try {

            System.out.println("Courses Taught:");
            for (Course course : coursesTaught) {
                System.out.println(course.getTitle());
            }

            System.out.print("Enter the course number to manage (or 0 to go back): ");
            int courseChoice = in.nextInt();
            in.nextLine();

            if (courseChoice == 0) {
                return;
            }
            if (courseChoice < 1 || courseChoice > coursesTaught.size()) {
                System.out.println("Invalid course selection.");
                return;
            }


            Course selectedCourse = coursesTaught.get(courseChoice - 1);

            while (true) {
                displayCourseManagementMenu();
                int actionChoice = in.nextInt();
                in.nextLine();

                switch (actionChoice) {
                    case 1:
                        setDescription(selectedCourse);
                        break;
                    case 2:
                        setTitle(selectedCourse);
                        break;
                    case 3:
                        selectedCourse.viewStudents();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a valid action.");
                }
            }
        } catch (Exception e) {
            handleError(e);
        }
    }

    /**
     * Displays the submenu for course management options.
     */
    private void displayCourseManagementMenu() {
        System.out.println("Course Management Menu:\n" +
                "1. Set description\n" +
                "2. Set title\n" +
                "3. View Enrolled Students\n" +
                "4. Go Back");
    }

    private void setDescription(Course course) {
        System.out.print("Enter the new description for the course: ");
        String newDescription = in.nextLine();
        course.setDescription(newDescription);
        DB.getInstance().updateCourseDescription(course.getCode(), newDescription);
    }

    private void setTitle(Course course) {
        System.out.print("Enter the new title for the course: ");
        String newTitle = in.nextLine();
        DB.getInstance().updateCourseTitle(course.getCode(), newTitle);
        course.setTitle(newTitle);
        System.out.println("Title updated successfully.");
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
                "8. View All News\n" +
                "9. Put mark" +
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

    private Course chooseCourseFromList() {
        List<Course> courses = getCoursesTaught();
        System.out.println("Courses Taught:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + 1 + ". " + courses.get(i).getTitle());
        }

        int selectedIndex = in.nextInt();
        in.nextLine();

        if (selectedIndex >= 1 && selectedIndex <= courses.size()) {
            return courses.get(selectedIndex - 1);
        } else {
            System.out.println("Invalid course index.");
            return null;
        }
    }

    public void addCourse(Course courseToAssign) {
        coursesTaught.add(courseToAssign);
    }

}
