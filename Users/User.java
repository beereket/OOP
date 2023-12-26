package Users;

import Messages.Order;
import News.News;
import Research.ResearchPaper;
import Research.ResearchSupervisorException;
import Research.Researcher;
import Util.Classes.Data;
import Util.Enums.Language;
import Util.Enums.UserType;
import Util.Exception.UserNotFound;
import Util.Observer;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import static Util.Enums.Language.*;

public abstract class User implements Observer, Serializable, Researcher {
    
    private String username;
    private String password;
    protected UserType userType;
    protected Language language = ENG;
    protected static Scanner in = new Scanner(System.in);
    protected boolean isResearcher = false;
    private List<ResearchPaper> researchPapers = new ArrayList<>();

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

    public static User authenticate() throws UserNotFound {
        System.out.println("Enter username: ");
        String username = in.nextLine();

        System.out.println("Enter password: ");
        String password = in.nextLine();
        Vector<User> users = Data.getInstance().getUsers();
        for (User user: users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        throw new UserNotFound();
    }

    protected void save() throws IOException {
        Data.getInstance().write();
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

    //NEWS
    public void viewAllNews() {
        Vector<News> newsList = Data.getInstance().getNews();

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

    @Override
    public void update(String journalName, String paperTitle) {
        System.out.println(username + "!\nA new scientific work entitled " + paperTitle + "  was published in the journal " + journalName);
    };

    public void setIsResearcher() {
        if (this instanceof Student || this instanceof Employee || this instanceof Teacher || this instanceof GraduateStudent) {
            this.isResearcher = true;
        }
    }
    @Override
    public void printPapers(Comparator<ResearchPaper> comparator) {
        researchPapers.sort(comparator);

        System.out.println("Research Papers for " + getResearcherName() + ":");
        for (ResearchPaper paper : researchPapers) {
            System.out.println(paper);
        }
    }

    public void addResearchPaper(ResearchPaper researchPaper) {
        if (researchPaper.getAuthors().contains(this)) {
            researchPapers.add(researchPaper);
        } else {
            System.out.println("User is not an author of the research paper.");
        }
    }

    @Override
    public int calculateHIndex() {
        if (!isResearcher) {
            System.out.println("User is not a researcher. Error");
            return 404;
        }

        List<Integer> citationsList = new ArrayList<>();
        for (ResearchPaper paper : researchPapers) {
            citationsList.add(paper.getCitations().size());
        }

        citationsList.sort(Comparator.reverseOrder());

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

    @Override
    public String getResearcherName() {
        if (isResearcher) {
            return username;
        }
        return "This User is not a Researcher";
    }

    @Override
    public void setSupervisor(Researcher supervisor) throws ResearchSupervisorException {
        if (isResearcher && this instanceof GraduateStudent graduateStudent) {

            if (supervisor.calculateHIndex() < 3) {
                throw new Research.ResearchSupervisorException("Supervisor must have an h-index of 3 or higher");
            }

            graduateStudent.researchSupervisor = supervisor;
        }
    }

}
