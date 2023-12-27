package Users;

import Messages.Order;
import News.News;
import Research.Exceptions.CannotBecomeResearcherException;
import Research.ResearchPaper;
import Research.Exceptions.ResearchSupervisorException;
import Research.Researcher;
import Util.Data.DB;
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

import static Util.Enums.Language.*;


public abstract class User implements Observer, Serializable, Researcher {
    
    private String username;
    private String password;
    protected UserType userType;
    protected Language language = ENG;
    protected static Scanner in = new Scanner(System.in);
    private boolean isResearcher;
    private List<ResearchPaper> allResearchPapers = ResearchPaper.loadAllResearchPapers();
    private static final String RESEARCHER_FILE_PATH = "researchersDB.dat";

    /**
     * Constructs a User with specified username, password, and user type.
     * Adds the user to the database and initializes the researcher status based on the user type.
     *
     * @param username the username for the user.
     * @param password the password for the user.
     * @param ut the type of the user (e.g., STUDENT, TEACHER).
     */
    public User(String username, String password, UserType ut) {
        this.username = username;
        this.password = password;
        this.userType = ut;
        DB.getInstance().addUser(this, UserType.USER);

        if (this instanceof GraduateStudent) {
            isResearcher = true;
        }
        isResearcher = false;
    }

    public User() {
    }
    {

    }
    /**
     * Reports an issue to the system.
     *
     * @param description a description of the issue to be reported.
     */
    public void reportIssue(String description) {
        DB.getInstance().addOrder(new Order(description));
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
    /**
     * MENU methodtars
     *
     * @throws IOException if an I/O error occurs.
     */
    public abstract void run() throws IOException;
    /**
     * Displays the menu based on the user's selected language.
     */
    protected void displayMenu() {
        if (language == ENG) displayEnglishMenu();
        else if (language == KZ) displayKazakhMenu();
        else if (language == RUS) displayRussianMenu();
    }

    protected abstract void displayRussianMenu();

    protected abstract void displayKazakhMenu();

    protected abstract void displayEnglishMenu();
    /**
     * Authenticates a user based on username and password.
     *
     * @return the authenticated User object.
     * @throws UserNotFound if no user is found with the given credentials.
     */
    public static User authenticate() throws UserNotFound {
        System.out.println("Enter username: ");
        String username = in.nextLine();

        System.out.println("Enter password: ");
        String password = in.nextLine();
        List<User> users = DB.getInstance().getUsersByUserType(UserType.USER);
        for (User user: users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        throw new UserNotFound();
    }
    /**
     * Saves the current state of the application.
     *
     * @throws IOException if an I/O error occurs during saving.
     */
    protected void save() throws IOException {
        DB.serializeAll();
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
    /**
     * Handles exceptions by printing an error message and saving the state of the application.
     *
     * @param e the exception to be handled.
     * @throws IOException if an I/O error occurs during saving.
     */

    protected void handleError(Exception e) throws IOException {
        if (language == KZ) System.out.println("Ойбай, қате...");
        else if (language == RUS) System.out.println("Ошибка....");
        else System.out.println("Error... ");
        e.printStackTrace();
        save();
    }
    /**
     * Displays a welcome message based on the user's selected language.
     */

    protected void getWelcomeMessage(){
        if(language == KZ) System.out.println("Қош келдіңіз!");
        else if(language == RUS) System.out.println("Добро пожаловать!");
        else System.out.println("Welcome!");
    }

    //NEWS
    /**
     * Displays a list of all news articles available in the system and allows the user to view a selected article.
     * After displaying the list, the user can select a news article by its index to view it in detail.
     * The user also has an option to add a comment to the selected news article.
     */
    public void viewAllNews() {
        List<News> newsList = DB.getInstance().getNews();

        if (newsList.isEmpty()) {
            System.out.println("No news articles available.");
            return;
        }

        System.out.println("List of News Articles:");
        for (int i = 0; i < newsList.size(); i++) {
            News news = newsList.get(i);
            System.out.println("Index " + i + ": " + news.getTitle());
        }

        System.out.print("Enter the index of the news article to view (or -1 to exit): ");
        int selectedIndex = in.nextInt();

        if (selectedIndex >= 0 && selectedIndex < newsList.size()) {
            News selectedNews = newsList.get(selectedIndex);
            System.out.println(selectedNews);

            System.out.print("Would you like to add a comment (yes/no)? ");
            in.nextLine();
            String response = in.nextLine().toLowerCase();

            if (response.equals("yes")) {
                System.out.print("Enter your comment: ");
                String comment = in.nextLine();
                selectedNews.addComment(comment);
                System.out.println("Comment added successfully.");
            } else {
                System.out.println("No comment added.");
            }
        } else if (selectedIndex == -1) {
            System.out.println("Exiting.");
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    //LANGUAGE
    /**
     * Provides an interface for the user to change their preferred language.
     * The method displays language options (Kazakh, Russian, English) and sets the user's language based on their choice.
     * The user must enter a valid choice number to change the language setting.
     */
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

    /**
     * Notifies the researcher about the publication of a new scientific work.
     *
     * @param journalName The name of the journal where the paper was published.
     * @param paperTitle  The title of the published scientific work.
     */
    @Override
    public void update(String journalName, String paperTitle) {
        System.out.println(username + "!\nA new scientific work entitled " + paperTitle + "  was published in the journal " + journalName);
    };

    /**
     * Sets the researcher status for the user.
     * Throws CannotBecomeResearcherException if the user is not eligible to be a researcher.
     *
     * @throws CannotBecomeResearcherException If the user cannot become a researcher.
     */
    public void setIsResearcher() throws CannotBecomeResearcherException {
        if (this instanceof Student || this instanceof Teacher || (this instanceof Employee && this.getClass()==Employee.class)) {
            this.isResearcher = true;
        } else {
            throw new CannotBecomeResearcherException("This User cannot be a Researcher!");
        }
    }
    /**
     * Checks if User is Researcher.
     *
     * @return True if Researcher, otherwise False.
     */
    public boolean isUserResearcher() {
        return isResearcher;
    }

    /**
     * Prints the research papers for the researcher, sorted based on the provided comparator.
     *
     * @param comparator The comparator to determine the sorting order of research papers.
     */
    @Override
    public void printPapers(Comparator<ResearchPaper> comparator) {
        allResearchPapers.sort(comparator);

        System.out.println("Research Papers for " + getResearcherName() + ":");
        for (ResearchPaper paper : allResearchPapers) {
            System.out.println(paper);
        }
    }

    /**
     * Gets the list of all research papers associated with the researcher.
     *
     * @return The list of all research papers.
     */
    public List<ResearchPaper> getAllResearchPapers() {
        return allResearchPapers;
    }

    /**
     * Calculates the H-index of the researcher based on their authored papers and citations.
     *
     * @return The calculated H-index.
     */
    @Override
    public int calculateHIndex() {
        if (!isResearcher) {
            System.out.println("User is not a researcher. Error");
            return 404;
        }

        List<Integer> citationsList = allResearchPapers.stream()
                .filter(paper -> paper.getAuthors().contains(this))
                .map(paper -> paper.getCitations().size())
                .sorted(Comparator.reverseOrder())
                .toList();

        int hIndex = 0;
        for (int i = 0; i < citationsList.size(); i++) {
            int citations = citationsList.get(i);
            if (citations >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }

        return hIndex;
    }

    /**
     * Gets the name of the researcher.
     *
     * @return The name of the researcher or a message indicating that the user is not a researcher.
     */
    @Override
    public String getResearcherName() {
        if (isResearcher) {
            return username;
        }
        return "This User is not a Researcher";
    }
    /**
     * Sets the supervisor for the graduate student.
     * Throws ResearchSupervisorException if the supervisor's H-index is less than 3.
     *
     * @param supervisor The supervisor to be set.
     * @throws ResearchSupervisorException If the supervisor's H-index is less than 3.
     */
    @Override
    public void setSupervisor(Researcher supervisor) throws ResearchSupervisorException {
        if (isResearcher && this instanceof GraduateStudent graduateStudent) {

            if (supervisor.calculateHIndex() < 3) {
                throw new Research.Exceptions.ResearchSupervisorException("Supervisor must have an h-index of 3 or higher");
            }

            graduateStudent.researchSupervisor = supervisor;
        }
    }


}
