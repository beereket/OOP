package Util.Classes;

import Academic.Course;
import Users.Student;
import Users.StudentOrganization;
import Users.User;

import java.util.HashMap;
import java.util.List;

public class Data {

    private static Data INSTANCE;
    private static String logFiles;
    private static HashMap<Course, List<Student>> enrollments;
    private static List<User> users;
    private static List<Course> courses;
    private static List<StudentOrganization> organizations;

    private Data() {
        // TODO: Initialize your fields or perform any other necessary setup
    }

    public static Data getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Data();
        }
        return INSTANCE;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addUser(User u){
        users.add(u);
    }
    public void addCourse(Course c){
        courses.add(c);
    }
    public void addSO(StudentOrganization so){
        organizations.add(so);
    }
}
