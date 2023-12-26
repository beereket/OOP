package Users;

import Academic.Course;
import Academic.Enums.SemesterType;
import Messages.Request;
import News.News;
import Users.Enums.Faculty;
import Users.Enums.ManagerType;
import Util.Classes.Data;
import Util.Data.DB;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import static Util.Enums.UserType.MANAGER;


public class Manager extends Employee implements Serializable {
    private ManagerType managerType;

    public Manager(String username, String password, ManagerType managerType) {
        super(username, password, MANAGER);
        this.managerType = managerType;

        DB.getInstance().addUser(this, MANAGER);
    }

    public Manager() {
    }

    //METHODS
    public void approveRegistration() {

    }

    public List<Request> viewRequests() {
        Rector r = Rector.getINSTANCE();
        return r.getSignedRequests();
    }

    public Vector<Student> createStatisticalReport() {
        return Data.getInstance().getStudents();
    }

    protected void assignCoursesToTeacher() {
    }


    //Manage NEWS
    public void createNews() {
        System.out.print("Enter the title of the news: ");
        String title = in.nextLine();

        System.out.print("Enter the content of the news: ");
        String content = in.nextLine();

        News news = new News(title, content);
        DB.getInstance().addNews(news);
        System.out.println("News created and added to the system.");
    }

    public void deleteNews() {
        System.out.println("Select the news to delete by entering its index:");
        viewAllNews();

        int indexToDelete = in.nextInt();
        in.nextLine(); // Consume newline

        if (indexToDelete >= 0 && indexToDelete < DB.getInstance().getNews().size()) {
            News deletedNews = DB.getInstance().getNews().remove(indexToDelete);
            System.out.println("News deleted: " + deletedNews.getTitle());
        } else {
            System.out.println("Invalid index. News not deleted.");
        }
    }

    public void manageNews() {
        while (true) {
            System.out.println("News Management Menu:");
            System.out.println("1. Create News");
            System.out.println("2. View All News");
            System.out.println("3. Delete News");
            System.out.println("4. Exit News Management");

            int choice = in.nextInt();
            in.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createNews();
                    break;
                case 2:
                    viewAllNews();
                    break;
                case 3:
                    deleteNews();
                    break;
                case 4:
                    return; // Exit u
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    //----------------------
    public void addCoursesForRegistration() {
        System.out.println("Enter Course Details:");
        System.out.print("Code: ");
        String code = in.nextLine();

        System.out.print("Title: ");
        String title = in.nextLine();

        System.out.print("Description: ");
        String description = in.nextLine();

        System.out.print("Credits: ");
        int credits = in.nextInt();

        System.out.print("Course Type: "); // like 2/0/2
        String courseType = in.nextLine();
        in.nextLine();

        System.out.print("Semester Type: ");
        String semesterTypeInput = in.next();

        SemesterType semesterType = getSemesterTypeFromInput(semesterTypeInput);
        System.out.print("Faculty: ");
        String facultyInput = in.next();
        Faculty faculty = getFacultyFromInput(facultyInput);

        Course newCourse = new Course(code, title, description, credits, courseType, semesterType, faculty);
    }


    //MENU METHODS
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
                        approveRegistration();
                        break;
                    case 2:
                        addCoursesForRegistration();
                        break;
                    case 3:
                        assignCoursesToTeacher();
                        break;
                    case 4:
                        viewInfo();
                        break;
                    case 5:
                        createStatisticalReport();
                        break;
                    case 6:
                        manageNews();
                        break;
                    case 7:
                        viewRequests();
                        break;
                    case 8:
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
    protected void displayEnglishMenu() {
        System.out.println("Manager Terminal Menu:");
        System.out.println("1. Approve students registration");
        System.out.println("2. Add courses for registration");
        System.out.println("3. Assign courses to teachers");
        System.out.println("4. View info about students and teachers");
        System.out.println("5. Create statistical reports on academic performance");
        System.out.println("6. Manage news");
        System.out.println("7. View requests from employees");
        System.out.println("8. Change language");
        System.out.println("0. Exit");
    }

    @Override
    protected void displayRussianMenu() {
        System.out.println("Меню Менеджера:");
        System.out.println("1. Подтвердить регистрацию студентов");
        System.out.println("2. Добавить курсы для регистрации");
        System.out.println("3. Назначить курсы преподавателям");
        System.out.println("4. Просмотреть информацию о студентах и преподавателях");
        System.out.println("5. Создать статистические отчеты об успеваемости");
        System.out.println("6. Управлять новостями");
        System.out.println("7. Просмотреть запросы от сотрудников");
        System.out.println("8. Изменить язык");
        System.out.println("0. Выйти");
    }

    @Override
    protected void displayKazakhMenu() {
        System.out.println("Менеджер меню:");
        System.out.println("1. Студенттердің тіркеуін растау");
        System.out.println("2. Тіркелу үшін пәндерді қосу");
        System.out.println("3. Пәндерді оқытушыларға арнаулау");
        System.out.println("4. Студенттер мен оқытушылар туралы ақпарат көру");
        System.out.println("5. Академиялық жетімділік туралы статистикалық есептер жасау");
        System.out.println("6. Жаңалықтарды басқару");
        System.out.println("7. Жұмысшылардан сұрауларды қарау");
        System.out.println("8. Тіл өзгерту");
        System.out.println("0. Шығу");
    }

    //methods for input
    // Utility method to convert a string input to Faculty enum
    private static Faculty getFacultyFromInput(String input) {
        try {
            return Faculty.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid faculty: " + input);
        }
    }

    private static SemesterType getSemesterTypeFromInput(String input) {
        switch (input.toUpperCase()) {
            case "SPRING":
                return SemesterType.SPRING;
            case "SUMMER":
                return SemesterType.SUMMER;
            case "FALL":
                return SemesterType.FALL;
            default:
                throw new IllegalArgumentException("Invalid semester type: " + input);
        }
    }

    //-----------------------------------view info)))))))))))))
    public void viewInfo() {
        System.out.println("Choose who you want to view:");
        System.out.println("1. Students");
        System.out.println("2. Teachers");

        int userChoice = in.nextInt();
        in.nextLine(); // Consume newline

        switch (userChoice) {
            case 1:
                viewUsersInfo(Data.getInstance().getStudents(), "students");
                break;
            case 2:
                viewUsersInfo(Data.getInstance().getTeachers(), "teachers");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }


    private void viewUsersInfo(List<? extends User> users, String userType) {
        if (users.isEmpty()) {
            System.out.println("No " + userType + " found.");
            return;
        }

        System.out.println("Choose sorting option for " + userType + ":");
        System.out.println("1. Alphabetical");
        System.out.println("2. By GPA (for students)");

        int choice = in.nextInt();
        in.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                viewUsersAlphabetically(users);
                break;
            case 2:
                if (userType.equals("students")) {
                    viewUsersByGpa(users);
                } else {
                    System.out.println("Invalid choice for " + userType + ".");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Method to view information about users alphabetically
    private void viewUsersAlphabetically(List<? extends User> users) {
        List<? extends User> sortedUsers = new ArrayList<>(users);
        Collections.sort(sortedUsers, Comparator.comparing(User::getUsername));

        System.out.println("List of Users (Alphabetically):");
        for (User user : sortedUsers) {
            System.out.println(user.getUsername());
        }
    }

    // Method to view information about students by GPA
    private void viewUsersByGpa(List<? extends User> users) {
        List<Student> students = (List<Student>) users;
        students.sort(Comparator.comparingDouble(Student::getGPA).reversed());

        System.out.println("List of Students (Sorted by GPA):");
        for (Student student : students) {
            System.out.println("Name: " + student.getUsername());
            System.out.println("GPA: " + student.getGPA());
            System.out.println("------------------------------");
        }
    }



}
