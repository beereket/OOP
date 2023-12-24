package Users;


import Util.Classes.Data;
import Util.Classes.UserFactory;
import Util.Enums.UserType;
import Util.Exception.UserNotFound;

import java.io.IOException;
import java.io.Serializable;

public class Admin extends User implements Serializable {


    public Admin(String username, String password){
        super(username, password, UserType.ADMIN);
    }

    private String viewLogFiles() {
        return Data.getInstance().getLogFiles();
    }

    private void createUser() throws UserNotFound {
        UserFactory.createUser(in);
    }

    public boolean deleteUser(String username) {
        boolean isRemovedFromUsers = Data.getInstance().getUsers().removeIf(user -> user.getUsername().equals(username));

        boolean isRemovedFromEmployees = Data.getInstance().getEmployees().removeIf(employee -> employee.getUsername().equals(username));
        boolean isRemovedFromGraduateStudents = Data.getInstance().getGSs().removeIf(gs -> gs.getUsername().equals(username));
        boolean isRemovedFromManagers = Data.getInstance().getManagers().removeIf(manager -> manager.getUsername().equals(username));
        boolean isRemovedFromStudents = Data.getInstance().getStudents().removeIf(student -> student.getUsername().equals(username));
        boolean isRemovedFromTeachers = Data.getInstance().getTeachers().removeIf(teacher -> teacher.getUsername().equals(username));
        boolean isRemovedFromTechSupport = Data.getInstance().getTSSs().removeIf(tss -> tss.getUsername().equals(username));

        return isRemovedFromEmployees || isRemovedFromGraduateStudents ||
                isRemovedFromManagers || isRemovedFromStudents || isRemovedFromTeachers ||
                isRemovedFromTechSupport;
    }

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

                        break;
                    case 2:
                        System.out.println(viewLogFiles());
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

    @Override
    public void update() {

    }
}
