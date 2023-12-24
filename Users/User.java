package Users;

import Messages.Order;
import Research.*;
import Research.ResearchProjectJoinException;
import Research.ResearchSupervisorException;
import Util.Classes.Data;
import Util.Enums.Language;
import Util.Enums.UserType;
import Util.Exception.UserNotFound;
import Util.Observer;

import java.io.IOException;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Collectors;

import static Util.Enums.Language.*;

public abstract class User implements Observer, Serializable, Researcher {
    
    private String username;
    private String password;
    protected UserType userType;
    protected Language language = ENG;
    protected Scanner in = new Scanner(System.in);

    private List<ResearchPaper> publications;

    public User(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        Data.getInstance().getUsers().add(this);
    }

    public User() {
    }
    {

    }
    public void reportIssue(String description) {
        TechSupportSpecialist.orders.add(new Order(description));
    }

    //getter and setter
    public UserType getUserType() {
        return userType;
    }

    protected void setUserType(UserType userType) {
        this.userType = userType;
    }
    public String getUsername() {
        return username;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

    protected String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    protected Language getLanguage() {
        return language;
    }

    protected void setLanguage(Language language) {
        this.language = language;
    }


    //MENU METHODS
    public abstract void run() throws IOException;
    protected void displayMenu() {
        if (language == ENG) displayEnglishMenu();
        else if (language == KZ) displayKazakhMenu();
        else if (language == RUS) displayRussianMenu();
    }

    protected abstract void displayRussianMenu();

    protected abstract void displayKazakhMenu();

    protected abstract void displayEnglishMenu();

    public static User authenticate(String username, String password) throws UserNotFound {
        Vector<User> users = Data.getInstance().getUsers();
        for (User user: users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        throw new UserNotFound();
    }

    protected void save() throws IOException {
        Data.write();
    }
    protected void exit() {
        if(language == ENG) System.out.println("Bye bye!");
        else if(language == KZ) System.out.println("Сауболыңыз!");
        else System.out.println("До свидания!");
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void handleError(Exception e) throws IOException {
        if (language == KZ) System.out.println("Ойбай, қате...");
        else if (language == RUS) System.out.println("Ошибка....");
        else System.out.println("Error... ");
        e.printStackTrace();
        save();
    }

    protected void getWelcomeMessage(){
        if(language == KZ) System.out.println("Қош келдіңіз!");
        else if(language == RUS) System.out.println("Добро пожаловать!");
        else System.out.println("Welcome!");
    }

    //LANGUAGE
    protected void changeLanguage(){
        System.out.println("1. Қазақша \n 2. Руский \n 3. English");

        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        } while (choice < 1 || choice > 3);

        if (choice == 1) {
            setLanguage(Language.KZ);
        } else if (choice == 2) {
            setLanguage(Language.RUS);
        } else if (choice == 3) {
            setLanguage(Language.ENG);
        }
    }

    public void update(String journalName, String paperTitle) {
        System.out.println(username + "!\nA new scientific work entitled " + paperTitle + "  was published in the journal " + journalName);
    };

    @Override
    public void printPapers() {

    }

    @Override
    public int calculateHIndex() {
        // Фильтруем публикации, оставляя только те, в которых пользователь является автором
        List<ResearchPaper> userPublications = publications.stream()
                .filter(paper -> paper.getAuthors().contains(this))
                .collect(Collectors.toList());

        // Сортируем отфильтрованные публикации по убыванию цитирований
        userPublications.sort(Comparator.comparingInt(paper -> paper.getAllCitations().size()).reversed());



        int hIndex = 0;
        for (int i = 0; i < userPublications.size(); i++) {
            int citations = userPublications.get(i).getAllCitations().size();
            if (citations >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }

        return hIndex;
    }

    @Override
    public String getResearcherName() {
        return getUsername();
    }

    @Override
    public void setSupervisor(Researcher supervisor) throws ResearchSupervisorException {

    }

    @Override
    public void joinResearchProject(ResearchProject project) throws ResearchProjectJoinException {

    }

    @Override
    public void notify(String message) {

    }

}
