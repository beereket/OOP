package Util.Classes;

import Academic.Course;
import News.News;
import Users.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Data implements Serializable {
    private static final long serialVersionUID = 8338215883727460797L;
    private static Data INSTANCE = null;
    private static String filename = "DATA.bin";
    private static String logFiles = "";
    private static HashMap<Course, List<Student>> enrollments = new HashMap<Course, List<Student>>();
    private static Vector<User> users = new Vector<User>();
    private static Vector<Employee> employees = new Vector<Employee>();
    private static Vector<StudentOrganization> organizations = new Vector<StudentOrganization>();
    private static Vector<Course> courses = new Vector<Course>();;
    private static Vector<Manager> managers = new Vector<Manager>();
    private static Vector<Student> students  = new Vector<Student>();
    private static Vector<GraduateStudent> GSs = new Vector<GraduateStudent>();
    private static Vector<Teacher> teachers = new Vector<Teacher>();
    private static Vector<TechSupportSpecialist> TSSs = new Vector<TechSupportSpecialist>();
    private static Vector<News> news = new Vector<News>();

    //RECTOR
    private static Rector rector = null;

//    static {
//        if(new File("data.ser").exists()) {
//            try {
//                INSTANCE = read();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            INSTANCE = new Data();
//        }
//    }
//
//    // Method to read the serialized data
//    public static Data read() throws IOException, ClassNotFoundException {
//        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream("data.ser"))) {
//            return (Data) oin.readObject();
//        }
//    }
//
//    // Method to write the current instance to a file
//    public static void write() throws IOException {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
//            oos.writeObject(INSTANCE);
//        }
//    }


    public static Data getInstance(){
        if(Data.INSTANCE == null){
            INSTANCE = new Data();
        }
        return INSTANCE;
    }

    // GETTER AND SETTER


    public static String getLogFiles() {
        return logFiles;
    }

    public static void setLogFiles(String logFiles) {
        Data.logFiles = logFiles;
    }

    public static HashMap<Course, List<Student>> getEnrollments() {
        return enrollments;
    }

    public static void setEnrollments(HashMap<Course, List<Student>> enrollments) {
        Data.enrollments = enrollments;
    }

    public static Vector<User> getUsers() {
        return users;
    }

    public static void setUsers(Vector<User> users) {
        Data.users = users;
    }

    public static Vector<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(Vector<Employee> employees) {
        Data.employees = employees;
    }

    public static Vector<StudentOrganization> getOrganizations() {
        return organizations;
    }

    public static void setOrganizations(Vector<StudentOrganization> organizations) {
        Data.organizations = organizations;
    }

    public static Vector<Course> getCourses() {
        return courses;
    }

    public static void setCourses(Vector<Course> courses) {
        Data.courses = courses;
    }

    public static Vector<Manager> getManagers() {
        return managers;
    }

    public static void setManagers(Vector<Manager> managers) {
        Data.managers = managers;
    }

    public static Vector<Student> getStudents() {
        return students;
    }

    public static void setStudents(Vector<Student> students) {
        Data.students = students;
    }

    public static Vector<GraduateStudent> getGSs() {
        return GSs;
    }

    public static void setGSs(Vector<GraduateStudent> GSs) {
        Data.GSs = GSs;
    }

    public static Vector<Teacher> getTeachers() {
        return teachers;
    }

    public static void setTeachers(Vector<Teacher> teachers) {
        Data.teachers = teachers;
    }

    public static Vector<TechSupportSpecialist> getTSSs() {
        return TSSs;
    }

    public static void setTSSs(Vector<TechSupportSpecialist> TSSs) {
        Data.TSSs = TSSs;
    }

    public static Vector<News> getNews() {
        return news;
    }

    public static void setNews(Vector<News> news) {
        Data.news = news;
    }

    public static Rector getRector() {
        return rector;
    }

    public static void setRector(Rector rector) {
        Data.rector = rector;
    }

    public static void addCourse(Course e){
        courses.add(e);
    }

    public void addNews(News n) {
        news.add(n);
    }

    public void addUser(User user) {
        users.add(user);
    }
}
