package Users;


import Research.ResearchPaper;
import Research.Comparators.*;
import Util.Classes.UserFactory;
import Util.Data.DB;
import Util.Enums.UserType;
import Util.Exception.UserNotFound;

import java.io.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static Util.Enums.UserType.USER;

/**
 * Represents an administrator in the system. The Admin class extends User and is responsible for
 * administrative tasks such as managing users, viewing logs, and handling research papers.
 */
public class Admin extends User implements Serializable {
    private static final String FILE_PATH = "researchPapers.dat";
    /**
     * Constructs an Admin with specified username and password.
     *
     * @param username The username for the admin.
     * @param password The password for the admin.
     */
    public Admin(String username, String password){
        super(username, password, UserType.ADMIN);
    }

    /**
     * Views log files of all users. Displays usernames and passwords for each user.
     */

    private void viewLogFiles() {
        for(User u: DB.getUsersByUserType(USER)){
            System.out.println(u.getUsername() + ' ' + u.getPassword());
        }
    }
    /**
     * Facilitates the creation of a new user through the UserFactory.
     *
     * @throws UserNotFound If user creation fails.
     */
    private void createUser() throws UserNotFound {
        UserFactory.createUser(in);
    }
    /**
     * Deletes a user with the specified username from the system.
     *
     * @param username The username of the user to delete.
     * @return true if the user was successfully removed; false otherwise.
     */
    public boolean deleteUser(String username) {
        boolean isRemoved = false;

        for (UserType userType : UserType.values()) {
            boolean removedFromCurrentType = DB.getInstance().getUsersByUserType(userType)
                    .removeIf(user -> user.getUsername().equals(username));
            if (removedFromCurrentType) {
                isRemoved = true;
            }
        }

        return isRemoved;
    }

    /**
     * Provides an interface for managing users. Includes options to create and delete users.
     *
     * @throws UserNotFound If the user management process encounters an error.
     */
    public void manageUser() throws UserNotFound {
        while (true) {
            System.out.println("User Management:");
            System.out.println("1. Create User");
            System.out.println("2. Delete User");
            System.out.println("0. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            in.nextLine(); // Consume the newline left-over

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    System.out.println("Enter username of user: ");
                    String username = in.nextLine();
                    deleteUser(username);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //MENU METHODS
    // Menu methods...

    /**
     * Runs the administrative interface, providing various management options.
     *
     * @throws IOException If an I/O error occurs.
     */
    @Override
    public void run() throws IOException {
        try {
            getWelcomeMessage();
            menu: while (true) {
                displayMenu();
                int choice = in.nextInt();
                in.nextLine(); // Consume the newline left-over
                switch (choice) {
                    case 1:
                        manageUser();
                        break;
                    case 2:
                        viewLogFiles();
                        break;
                    case 3:
                        viewAllNews();
                        break;
                    case 4:
                        changeLanguage();
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

    @Override
    protected void displayRussianMenu() {
        System.out.println("Административное меню:");
        System.out.println("1. Управление пользователями (Добавить, удалить, обновить)");
        System.out.println("2. Просмотреть логи действий пользователей");
        System.out.println("3. Просмотр новостей");
        System.out.println("4. Изменить язык");
        System.out.println("0. Выход");
    }

    @Override
    protected void displayKazakhMenu() {
        System.out.println("Әкімшілік мәзір:");
        System.out.println("1. Пайдаланушыларды басқару (Қосу, жою, жаңарту)");
        System.out.println("2. Пайдаланушы әрекеттерінің журналын көру");
        System.out.println("3. Жаңалықтарды көру");
        System.out.println("4. Тілді өзгерту");
        System.out.println("0. Шығу");
    }

    @Override
    protected void displayEnglishMenu() {
        System.out.println("Admin Menu:");
        System.out.println("1. Manage Users (Add, Remove, Update)");
        System.out.println("2. View User Action Logs");
        System.out.println("3. View News");
        System.out.println("4. Change Language");
        System.out.println("0. Exit");
    }

    /**
     * Prints all research papers sorted by date of publication.
     * Uses the DatePublishedComparator for sorting.
     */
    public void printAllResearchPapersByDatePublished() {
        List<ResearchPaper> allResearchPapers = loadAllResearchPapers();
        printAllResearchPapers(allResearchPapers, new DatePublishedComparator());
    }

    /**
     * Prints all research papers sorted by the number of citations.
     * Uses the CitationsComparator for sorting.
     */
    public void printAllResearchPapersByCitations() {
        List<ResearchPaper> allResearchPapers = loadAllResearchPapers();
        printAllResearchPapers(allResearchPapers, new CitationsComparator());
    }

    /**
     * Prints all research papers sorted by article length.
     * Uses the ArticleLengthComparator for sorting.
     */
    public void printAllResearchPapersByArticleLength() {
        List<ResearchPaper> allResearchPapers = loadAllResearchPapers();
        printAllResearchPapers(allResearchPapers, new ArticleLengthComparator());
    }

    /**
     * Prints a list of research papers sorted using the provided comparator.
     *
     * @param researchPapers The list of research papers to be printed.
     * @param comparator     The comparator for sorting the research papers.
     */
    private void printAllResearchPapers(List<ResearchPaper> researchPapers, Comparator<ResearchPaper> comparator) {
        List<ResearchPaper> sortedPapers = new ArrayList<>(researchPapers);
        Collections.sort(sortedPapers, comparator);

        for (ResearchPaper paper : sortedPapers) {
            System.out.println(paper);
        }
    }

    /**
     * Loads all research papers from the file.
     *
     * @return The list of loaded research papers.
     */
    private List<ResearchPaper> loadAllResearchPapers() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<ResearchPaper>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Saves a list of research papers to the file.
     *
     * @param researchPapers The list of research papers to be saved.
     */
    public void saveAllResearchPapers(List<ResearchPaper> researchPapers) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(researchPapers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {

    }
}
