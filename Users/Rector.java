package Users;

import Messages.Complaint;
import Messages.Request;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;


public class Rector extends Employee implements Serializable {
    
    private static Rector INSTANCE;
    protected static Vector<Request> requests = new Vector<Request>();
    protected static Vector<Request> signedRequests = new Vector<Request>();
    protected static Vector<Complaint> complaints = new Vector<Complaint>();

    private Rector(){
    }
    public static Rector getINSTANCE() {
        if(INSTANCE == null) return new Rector();
        return INSTANCE;
    }


    //getter and setters
    public List<Request> getRequests() {
        return requests;
    }

    private  void setRequests(Vector<Request> requests) {
        this.requests = requests;
    }

    public List<Request> getSignedRequests() {
        return signedRequests;
    }

    private void setSignedRequests(Vector<Request> signedRequests) {
        this.signedRequests = signedRequests;
    }

    //methods
    protected void addRequest(Request r){
        requests.add(r);
    }

    //MENU
    @Override
    public void run() throws IOException {
        try {
            getWelcomeMessage(); // Method to display a welcome message
            menu:
            while (true) {
                displayMenu(); // Displays the current language menu
                int choice = in.nextInt();
                in.nextLine(); // Consume the newline left-over
                switch (choice) {
                    case 1:
                        viewRequests(); // View requests
                        break;
                    case 2:
                        signRequest(); // Sign a specific request
                        break;
                    case 3:
                        viewComplaints(); // View complaints
                        break;
                    case 4:
                        viewAllNews(); // Add news items
                        break;
                    case 5:
                        changeLanguage(); // Change the menu language
                        break;
                    case 0:
                        exit(); // Exit the menu
                        break menu;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            handleError(e); // Method to handle exceptions
        }
    }
    @Override
    protected void displayEnglishMenu() {
        System.out.println("Rector Menu:\n" +
                "1. View Requests\n" +
                "2. Sign a Request\n" +
                "3. View Complaints\n" +
                "4. Add News\n" +
                "5. Change Language\n" +
                "0. Exit");
    }

    @Override
    protected void displayRussianMenu() {
        System.out.println("Меню Ректора:\n" +
                "1. Просмотреть Запросы\n" +
                "2. Подписать Запрос\n" +
                "3. Просмотреть Жалобы\n" +
                "4. Добавить Новости\n" +
                "5. Изменить Язык\n" +
                "0. Выход");
    }

    @Override
    protected void displayKazakhMenu() {
        System.out.println("Ректор Мәзірі:\n" +
                "1. Сұрауларды Қарау\n" +
                "2. Сұрауға Қол Қою\n" +
                "3. Шағымдарды Қарау\n" +
                "4. Жаңалықтар Қосу\n" +
                "5. Тілді Өзгерту\n" +
                "0. Шығу");
    }

    public void viewRequests() {
        if (requests.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        System.out.println("Pending Requests:");
        for (int i = 0; i < requests.size(); i++) {
            System.out.println((i + 1) + ". " + requests.get(i));
        }
    }

    public void viewComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints.");
            return;
        }

        System.out.println("Complaints:");
        for (int i = 0; i < complaints.size(); i++) {
            System.out.println((i + 1) + ". " + complaints.get(i));
        }
    }

    // Method to sign a specific request
    public void signRequest() {
        viewRequests();
        if (requests.isEmpty()) {
            return;
        }

        System.out.println("Enter the number of the request to sign:");
        int index = in.nextInt() - 1;
        in.nextLine(); // Consume the newline

        if (index >= 0 && index < requests.size()) {
            Request reqToSign = requests.remove(index);
            signedRequests.add(reqToSign);
            System.out.println("Request signed.");
        } else {
            System.out.println("Invalid request number.");
        }
    }






}
