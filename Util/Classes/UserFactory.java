package Util.Classes;

import Users.*;
import Users.Enums.Degree;
import Users.Enums.Faculty;
import Users.Enums.ManagerType;
import Users.Enums.Title;
import Util.Data.DB;
import Util.Enums.UserType;
import Util.Exception.UserNotFound;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class UserFactory implements Serializable {

    /**
     * Creates a new user of a specific type based on user input.
     * It prompts the user for necessary information and creates an instance of the selected user type.
     *
     * @param scanner The Scanner object to read input from the user.
     * @throws UserNotFound if the username provided for a supervisor or researcher does not exist.
     */
    public static void createUser(Scanner scanner) throws UserNotFound {
        System.out.println("Select user type to create:");
        System.out.println("1. Employee");
        System.out.println("2. Graduate Student");
        System.out.println("3. Manager");
        System.out.println("4. Student");
        System.out.println("5. Teacher");
        System.out.println("6. Tech Support Specialist");

        int userType = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        switch (userType) {
            case 1:
                Employee employee = new Employee(username, password, UserType.EMPLOYEE);
                break;
            case 2:
                System.out.println("Enter Faculty:");
                Faculty faculty = Faculty.valueOf(scanner.nextLine());
                System.out.println("Enter Degree:");
                Degree degree = Degree.valueOf(scanner.nextLine());
                // Assuming Researcher is a predefined list we can select from
                System.out.println("Enter Research username:");
                String supervisorname= scanner.nextLine();

                GraduateStudent graduateStudent = new GraduateStudent(username, password, faculty, degree, getUserByUsername(supervisorname));
                break;
            case 3:
                System.out.println("Enter Manager Type:");
                ManagerType managerType = ManagerType.valueOf(scanner.nextLine());
                Manager manager = new Manager(username, password, managerType);
                break;
            case 4:
                System.out.println("Enter Faculty:");
                Faculty studentFaculty = Faculty.valueOf(scanner.nextLine());
                System.out.println("Enter Degree:");
                Degree studentDegree = Degree.valueOf(scanner.nextLine());
                Student student = new Student(username, password, studentFaculty, studentDegree);
                break;
            case 5:
                System.out.println("Enter Title:");
                Title title = Title.valueOf(scanner.nextLine());
                Teacher teacher = new Teacher(username, password, title);
                break;
            case 6:
                TechSupportSpecialist techSupportSpecialist = new TechSupportSpecialist(username, password);
                break;
            default:
                System.out.println("Invalid user type selected.");
                break;
        }
    };
    /**
     * Retrieves a User object by its username.
     * Searches through all users and returns the user with the specified username.
     *
     * @param username The username of the user to be retrieved.
     * @return The User object with the specified username.
     * @throws UserNotFound if no user with the specified username is found.
     */
    public static User getUserByUsername(String username) throws UserNotFound {
        List<User> users = DB.getUsersByUserType(UserType.USER);
        for(User user : users) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new UserNotFound();
    }
}
