package Users;


import Academic.Course;
import Academic.Lesson;
import Users.Enums.Degree;
import Users.Enums.Faculty;
import Util.Data.DB;
import Util.Enums.UserType;
import Util.Exception.UserNotFound;
import Users.Teacher;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * The Student class represents a user with the role of a student in the educational system.
 * It extends the User class and includes specific attributes and methods related to students.
 */

public class Student extends User implements Serializable {

    // Attributes specific to the Student class
    protected Integer id;
    protected Faculty faculty;
    protected Integer yearOfStudy = 1;
    protected Set<Course> coursesRegistered = new HashSet<>();
    protected Degree degree;
    protected StudentOrganization studentOrganization = null;
    protected Integer credits = 0;


    public Student(String username, String password, UserType userType) {
        super(username, password, userType);
    }
    /**
     * Constructor for creating a new Student with the specified username, password, faculty, and degree.
     *
     * @param username The username of the student.
     * @param password The password of the student.
     * @param faculty  The faculty to which the student belongs.
     * @param degree   The degree level of the student.
     */

    public Student(String username, String password, Faculty faculty, Degree degree) {
        super(username, password, UserType.STUDENT);
        this.id = DB.users.get(UserType.STUDENT).size() +1;
        this.faculty = faculty;
        this.degree = degree;


        DB.getInstance().addUser(this, UserType.STUDENT);
    }

    public double getGPA() {
        return 0.0;
    }//null

    protected Set<Course> getCoursesRegistered(){
        return this.coursesRegistered;
    }


    // MENU METHODS
    @Override
    public void update() {

    }

    public void viewTranscript(){
        for (Course c : this.coursesRegistered){
            System.out.println(c.getStudentMark(this));
        }
    }

    public void viewInfoAbTeacher(){
        int i = 1;
        System.out.println("Choose course which teachers you are interested in");
        for (Course c : DB.instance.getCourses()){
            System.out.println(i + " " + c.getTitle());
        }
        int choice = in.nextInt();
        in.nextLine();

        for(Teacher t : DB.instance.getCourses().get(i-1).getInstructors()){
            System.out.println(t.toString());
        }
    }

    public void viewMarks(){
        Course c = new Course();
        System.out.println(c.getStudentMark(this));
    }

    public void viewCourses(){
        for (Course element : this.coursesRegistered) {
            System.out.println(element.toString());
        }
    }

    public void rateTeacher(){
        System.out.println("Choose teacher");
        int i = 1;

        Vector<Teacher> studentsTeachers = new Vector<>();
        for (Course element : this.coursesRegistered) {
            for (Teacher t:element.getTeachers(this)){
                studentsTeachers.add(t);
                System.out.println(i + " " + t.getUsername());
            }
        }
        int choice = in.nextInt();
        in.nextLine();
        System.out.println(studentsTeachers.elementAt(choice) + " is chosen, give rating");
        int rating = in.nextInt();
        in.nextLine();

        studentsTeachers.elementAt(choice).setRating(rating);
        System.out.println(studentsTeachers.elementAt(choice).getRating());
    }

    public void getTranscript(){
        for (Course c : coursesRegistered){
            System.out.println(c.getStudentMark(this));
        }
    }

    protected void studentOrganizations(){
        for(StudentOrganization sd: DB.getInstance().getOrganizations()){
            System.out.println(sd.toString());
        }
    }

    // Other methods and menu-related functionality...

    /**
     * Checks if a student is registered for a given course based on its prerequisites.
     *
     * @param c The course to check for registration.
     * @return True if the student meets all prerequisites; false otherwise.
     */
    protected boolean isIn(Course c) {
        if (c.getPrerequisites() == null) {
            return true; // No prerequisites, so it's always considered as "in"
        }

        for (Course prereq : c.getPrerequisites()) {
            if (!this.coursesRegistered.contains(prereq)) {
                return false; // At least one prerequisite is not in coursesRegistered
            }
        }

        return true; // All prerequisites are in coursesRegistered
    }

    protected boolean isNotRegistered(Course c) {
        return !this.coursesRegistered.contains(c);
    }

    protected void registerCourse(){
        //get set of available courses by name
        Vector<Course> coursesAvailable = new Vector<>();

        for (Course ele : DB.getInstance().getCourses()){
            if (isIn(ele) && isNotRegistered(ele)){
                coursesAvailable.add(ele);
            }
        }
        //student enters indeces of course
        if (!coursesAvailable.isEmpty()){
            int i = 1;
            System.out.println("Enter your choice by int or 0 to go back");
            for (Course avCourse : coursesAvailable){
                System.out.println(i +" "+ avCourse.getTitle());
                i++;
            }

            int sumcredits = 0;
            while (true){
                int choice = in.nextInt();
                in.nextLine();
                if (choice == 0){
                    break;
                }
                if(coursesAvailable.elementAt(choice-1).getCredits() + sumcredits < 21 ){
                    sumcredits = sumcredits + coursesAvailable.elementAt(choice-1).getCredits();
                    this.coursesRegistered.add(coursesAvailable.elementAt(choice-1));
                    System.out.println(coursesAvailable.elementAt(choice-1).getTitle()+" is added succesfully");
                }
                else {
                    System.out.println("Sum of credits would be more than 21");
                }
            }
        }
        else{
            System.out.println("No available courses");
        }
        //check if credit <21
    }

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
                        viewCourses();
                        break;
                    case 2:
                        viewInfoAbTeacher();
                        break;
                    case 3:
                        viewMarks();
                        break;

                    case 4:
                        viewTranscript();
                        break;
                    case 5:
                        rateTeacher();
                        break;
                    case 6:
                        getTranscript();
                        break;
                    case 7:
                        studentOrganizations();
                    case 8:
                        changeLanguage();
                        break;
                    case 9:
                        registerCourse();
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

    protected void changeLanguage(){
        System.out.println("Choose language:\n" +
                "1. ENG\n" +
                "2. RUS\n" +
                "3. KAZ");

        System.out.print("Enter your choice: ");
        int choice = in.nextInt();
        in.nextLine(); // Consume the newline left-over

        switch (choice){
            case 1:
                displayEnglishMenu();
                break;
            case 2:
                displayRussianMenu();
                break;
            case 3:
                displayKazakhMenu();
                break;
        }
    }

    // Other methods and menu-related functionality...

    /**
     * Displays the menu in English for the student user.
     */
    @Override
    protected void displayEnglishMenu() {
        System.out.println("User student:\n" +
                "1. View Courses\n" +
                "2. View information about teacher of a specific course\n" +
                "3. View marks\n" +
                "4. View Transcript\n" +
                "5. Rate teacher on scale 1-10 (first enter id)\n" +
                "6. Get Transcript\n" +
                "7. Student organizations\n" +
                "8. Change language"+
                "9. Register for courses"+
                "0. Back to Main Menu");


    }
    @Override
    protected void displayRussianMenu() {
        System.out.println("User student:\n" +
                "1. Просмотр курсы\n" +
                "2. Просмотр информацию про педагога определенного предмета\n" +
                "3. Просмотр оценки\n" +
                "4. Просмотр Транскрипта\n" +
                "5. Оценить педагога\n" +
                "6. Получить транскрипт\n" +
                "7. Студенческие организации\n" +
                "0. Вернуться в Главное Меню");

    }

    @Override
    protected void displayKazakhMenu() {
        System.out.println("User student:\n" +
                "1. Курстарды көру\n" +
                "2. Белгілі бір пәннің мұғалімі туралы ақпаратты көру\n" +
                "3. Бағаны көру\n" +
                "4. Транскрипты көру\n" +
                "5. Мұғалімді бағалау\n" +
                "6. Транскриптты алу\n" +
                "7. Студенттік организациялар\n" +
                "0. Негізгі мәзірге қайту");

    }

    // Other methods and menu-related functionality...

    /**
     * Returns a string representation of the Student object.
     *
     * @return A string representation of the Student object.
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + this.id +
                ", faculty=" + this.faculty +
                ", yearOfStudy=" + this.yearOfStudy +
                ", coursesRegistered=" + this.coursesRegistered +
                ", degree=" + this.degree +
                ", studentOrganization=" + this.studentOrganization.toString() +
                ", credits=" + this.credits +
                '}';
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Integer getId() {
        return id;
    }
    public Lesson getLesson(Course c){
        for(Lesson l : c.getLessons()){
            if (l.contains(this)){
                return l;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && faculty == student.faculty && Objects.equals(yearOfStudy, student.yearOfStudy) && degree == student.degree && Objects.equals(credits, student.credits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, faculty, yearOfStudy, degree, credits);
    }
}
