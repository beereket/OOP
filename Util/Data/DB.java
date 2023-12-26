package Util.Data;

import Academic.Course;
import Messages.Order;
import News.News;
import Users.StudentOrganization;
import Users.User;
import Util.Enums.UserType;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * This class represents a database for managing users, courses, and news.
 */
public class DB {
    static public DB instance = null;
    // Example of a field JavaDoc
    /**
     * A map of users categorized by user type.
     */
    static public HashMap<UserType, List<User>> users = new HashMap<>();
    static public List<Course> courses = new ArrayList<>();
    static public List<News> news = new ArrayList<>();
    static public List<StudentOrganization> organizations = new ArrayList<>();
    protected static Vector<Order> orders = new Vector<Order>();
    protected static Vector<Order> accepted_orders = new Vector<Order>();


    /**
     * Private constructor to prevent instantiation.
     */
    private DB() {
        initializeUsersMap();
    }
    /**
     * Returns the singleton instance of the DB class.
     *
     * @return The single instance of the DB class.
     */
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

    private void initializeUsersMap() {
        for (UserType userType : UserType.values()) {
            users.put(userType, new ArrayList<>());
        }
    }

    public static void serializeAll() {
        serializeUsers();
        serializeCourses();
        serializeNews();
        serializeOrganizations();
        serialize();
    }

    public static void deserializeAll() {
        deserializeUsers();
        deserializeCourses();
        deserializeNews();
        deserializeOrganizations();
        deserialize();
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
    private static void serializeOrganizations() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("organizationsDB.dat"))) {
            out.writeObject(organizations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializeOrganizations() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("organizationsDB.dat"))) {
            organizations = (List<StudentOrganization>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void serialize() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("orders.dat"))) {
            out.writeObject(orders);
            out.writeObject(accepted_orders);
            // Serialize other fields...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserialize() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("orders.dat"))) {
            orders = (Vector<Order>) in.readObject();
            accepted_orders = (Vector<Order>) in.readObject();
            // Deserialize other fields...
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public List<Course> getCourses() {
        return courses;
    }

    public List<News> getNews() {
        return news;
    }

    public void addNews(News e){
        if(e.getTitle() == "Researcher") news.add(0, e);
        else news.add(e);
    }
    public static List<User> getUsersByUserType(UserType userType) {
        return users.getOrDefault(userType, new ArrayList<>());
    }

    public void addUser(User u, UserType ut){
        users.get(ut).add(u);
    }

    public static HashMap<UserType, List<User>> getUsers() {
        return users;
    }

    public static List<StudentOrganization> getOrganizations() {
        return organizations;
    }

    public static Vector<Order> getOrders() {
        return orders;
    }

    public static Vector<Order> getAcceptedOrders() {
        return accepted_orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

}
