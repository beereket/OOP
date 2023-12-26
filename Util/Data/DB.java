package Util.Data;

import Academic.Course;
import News.News;
import Users.StudentOrganization;
import Users.User;
import Util.Enums.UserType;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DB {
    static public DB instance = null;
    static public HashMap<UserType, List<User>> users = new HashMap<>();
    static public List<Course> courses = new ArrayList<>();
    static public List<News> news = new ArrayList<>();
    static public List<StudentOrganization> organizations = new ArrayList<>();

    private DB() {
    }

    static {
        if(new File("coursesDB.dat").exists() && new File("usersDB.dat").exists()) {
            try {
                deserializeAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else instance = new DB();
    }

    public static DB getInstance(){
        if(instance == null) instance = new DB();
        return instance;
    }

    public static void serializeAll() {
        serializeUsers();
        serializeCourses();
        serializeNews();
    }

    public static void deserializeAll() {
        deserializeUsers();
        deserializeCourses();
        deserializeNews();
    }

    private static void serializeUsers() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usersDB.dat"))) {
            out.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializeUsers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("usersDB.dat"))) {
            users = (HashMap<UserType, List<User>>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void serializeCourses() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("coursesDB.dat"))) {
            out.writeObject(courses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializeCourses() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("coursesDB.dat"))) {
            courses = (List<Course>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void serializeNews() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("newsDB.dat"))) {
            out.writeObject(news);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializeNews() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("newsDB.dat"))) {
            news = (List<News>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public HashMap<UserType, List<User>> getUsers() {
        return users;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<News> getNews() {
        return news;
    }

    public void addNews(News e){
        news.add(e);
    }

}
