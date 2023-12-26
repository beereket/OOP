package Users;


import Academic.Course;
import Academic.Mark;
import Users.Enums.Degree;
import Users.Enums.Faculty;
import Util.Data.DB;
import Util.Enums.UserType;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;


public class Student extends User implements Serializable {
    
    protected Integer id;
    protected Faculty faculty;
    protected Integer yearOfStudy = 1;
    protected Vector<Course> coursesRegistered = new Vector<>();
    protected Degree degree;
    protected StudentOrganization studentOrganization = null;
    protected Integer credits = 0;
    public Student(String username, String password, UserType userType) {
        super(username, password, userType);
    }

    public Student(String username, String password, Faculty faculty, Degree degree) {
        super(username, password, UserType.STUDENT);
        DB.getInstance();
        this.id = DB.users.get(UserType.STUDENT).size() +1;
        this.faculty = faculty;
        this.degree = degree;

    }

    public double getGPA() {
        double totalGpa = 0;
        double totalCredits = 0;

        for(Course course: coursesRegistered){
            totalGpa += course.getStudentMark(this).getGpa();
            totalCredits += course.getCredits();
        }

        return (totalGpa / totalCredits);
    }//null

    protected List<Course> getCoursesRegistered(){
        return coursesRegistered;
    }

    private void viewInfoAboutTeacher(Teacher t){
        System.out.println(t);
    }

    // MENU METHODS
    @Override
    public void update() {

    }

    public Vector<Teacher> getTeachers(){
        Vector<Teacher> teachers = new Vector<Teacher>();

        for(Course course: coursesRegistered){
            teachers.addAll(course.getTeachers(this));
        }

        return teachers;
    }

    public void viewTranscript(){
        System.out.println(getTranscript());
    }

    public String getTranscript(){
        String result = "code|name : credits, total, literalMark, gpa\n";

        double totalGPA = 0;
        double totalCredits = 0;

        for(Course course: coursesRegistered){
            Mark currMark = course.getStudentMark(this);

            double currGPA = currMark.getGpa();
            double currCredits = course.getCredits();

            totalGPA += currGPA * currCredits;
            totalCredits += currCredits;

            String courseInfo = "%s|%s: %s, %s, %s, %s".formatted(course.getCode(), course.getTitle()
                    ,currCredits, currMark.getTotal(), currMark.getLiteralMark(), currGPA);

            result += courseInfo + "\n";
        }

        result += "Overall gpa: %s".formatted(totalGPA / totalCredits);

        return result;
    }


    public void viewInfoAbTeacher(){

    }

    public void viewMarks(){
        for(Course course: coursesRegistered){
            System.out.println(course.getTitle() + " : " + course.getStudentMark(this));
        }
    }

    public void viewCourses(){
        for (Course course : this.coursesRegistered) {
            System.out.println(course);
        }
    }

    public void rateTeacher(){

    }

    protected void studentOrganizations(){

    }
    protected boolean isIn(Course c) {
        if (c.getPrerequisites() == null) {
            return true; // No prerequisites, so it's always considered as "in"
        }

        for (Course prereq : c.getPrerequisites()) {
            boolean prereqMet = false;

            for (Course studC : this.coursesRegistered) {
                if (prereq.equals(studC)) {
                    prereqMet = true;
                    break; // Found a match for this prerequisite, no need to continue searching
                }
            }

            if (!prereqMet) {
                return false; // At least one prerequisite is not in coursesRegistered
            }
        }

        return true; // All prerequisites are in coursesRegistered
    }

    protected boolean isNotRegistered(Course c){
        for(Course element : this.coursesRegistered){
            if (element==c){
                return false;
            }
        }

        return true;
    }

    protected void registerCourse(){
        Vector<Course> coursesAvailable = new Vector<Course>();

        for (Course ele : DB.getInstance().getCourses()){
            if (isIn(ele) && isNotRegistered(ele)){
                coursesAvailable.add(ele);
            }
        }

        if (!coursesAvailable.isEmpty()){
            int i = 1;
            System.out.println(i + "Enter your choice by int or 0 to go back");
            for (Course avCourse : coursesAvailable){
                System.out.println(i +" "+ avCourse.getTitle());
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
                    coursesRegistered.add(coursesAvailable.elementAt(choice-1));
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
        in.nextLine();

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
                "8. Change laguange"+
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

    public Faculty getFaculty() {
        return faculty;
    }
}
