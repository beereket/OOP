package Util.Classes;
import News.News;
import Academic.Course;
import Users.Student;
import Users.StudentOrganization;
import Users.User;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Data implements Serializable {

    private static Data INSTANCE;
    private static String logFiles = "";
    private static HashMap<Course, List<Student>> enrollments = new HashMap<Course, List<Student>>();
    private static Vector<User> users = new Vector<User>();
    private static Vector<StudentOrganization> organizations = new Vector<StudentOrganization>();
    private static Vector<Course> courses = new Vector<Course>();;
    private static Vector<Student> students  = new Vector<Student>();;
    private static Vector<News> news = new Vector<News>();

    private Data() {
        // TODO: Initialize your fields or perform any other necessary setup
    }

    static {
        if(new File("data.bin").exists()) {
            try {
                INSTANCE = read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else INSTANCE = new Data();
    }
    public static Data read() throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("data.bin");
        ObjectInputStream oin = new ObjectInputStream(fis);
        return (Data) oin.readObject();
    }
    public static void write()throws IOException{
        FileOutputStream fos = new FileOutputStream("data.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(INSTANCE);
        oos.close();
    }

    public static Data getInstance(){
        if(Data.INSTANCE == null){
            INSTANCE = new Data();
        }
        return INSTANCE;
    }

    public String getLogFiles() {
        return logFiles;
    }

    private void setLogFiles(String logFiles) {
        this.logFiles = logFiles;
    }

    public HashMap<Course, List<Student>> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(HashMap<Course, List<Student>> enrollments) {
        this.enrollments = enrollments;
    }

    public Vector<User> getUsers() {
        return users;
    }

    public void setUsers(Vector<User> users) {
        this.users = users;
    }

    public Vector<StudentOrganization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Vector<StudentOrganization> organizations) {
        this.organizations = organizations;
    }

    public Vector<Course> getCourses() {
        return courses;
    }

    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }

    public Vector<Student> getStudents() {
        return students;
    }

    public void setStudents(Vector<Student> students) {
        this.students = students;
    }
}
