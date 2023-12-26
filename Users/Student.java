package Users;


import Academic.Course;
import Users.Enums.Degree;
import Users.Enums.Faculty;
import Util.Classes.Data;
import Util.Enums.UserType;
import Util.Exception.UserNotFound;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class Student extends User implements Serializable {
    
    protected Integer id;
    protected Faculty faculty;
    protected Integer yearOfStudy = 1;
    protected Vector<Course> coursesRegistered = new Vector<Course>();
    protected Degree degree;
    protected StudentOrganization studentOrganization = null;
    protected Integer credits = 0;
    public Student(String username, String password, UserType userType) {
        super(username, password, userType);
    }

    public Student(String username, String password, Faculty faculty, Degree degree) {
        super(username, password, UserType.STUDENT);
        this.id = Data.getInstance().getStudents().size() + 1;
        this.faculty = faculty;
        this.degree = degree;

    }

    public double getGPA() {
        return 0.0;
    }//null

    protected List<Course> getCoursesRegistered(){
        return coursesRegistered;
    }
    protected void rateTeacher(Teacher t, int rate){
    }
    private void viewInfoAboutTeacher(Teacher t){
        System.out.println(t);
    }

    // MENU METHODS
    @Override
    public void update() {

    }

    public void viewTranscript(){

    }

    public void viewInfoAbTeacher(){

    }

    public void viewMarks(){
        Course c = new Course();
        System.out.print(c.getStudentMark(this);
    }

    public void viewCourses(){

    }

    public void rateTeacher(){

    }

    public void getTranscript(){

    }

    public void studentOrganizations(){

    }

    protected void operations(){
        System.out.print("Enter your choice: ");
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
                viewAllNews();
                break;

            case 4:
                viewMarks();
                break;
            case 5:
                viewTranscript();
                break;
            case 6:
                rateTeacher();
                break;
            case 7:
                studentOrganizations();
            case 8:
                changeLanguage();
                break;
            case 0:
                exit();
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
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

    public void run()  {
        while (true) {
            changeLanguage();
        }
    }

    @Override
    protected void displayEnglishMenu() {
        System.out.println("User student:\n" +
                "1. View Courses\n" +
                "2. View information about teacher of a specific course\n" +
                "3. View marks\n" +
                "4. View Transcript\n" +
                "5. Rate teacher\n" +
                "6. Get Transcript\n" +
                "7. Student organizations\n" +
                "8. Change laguage"+
                "0. Back to Main Menu");

        operations();
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

        operations();
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

        operations();
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", faculty=" + faculty +
                ", yearOfStudy=" + yearOfStudy +
                ", coursesRegistered=" + coursesRegistered +
                ", degree=" + degree +
                ", studentOrganization=" + studentOrganization +
                ", credits=" + credits +
                '}';
    }



}
