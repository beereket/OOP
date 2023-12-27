package Users;

import Messages.Complaint;
import Messages.Request;

import java.io.*;
import java.util.List;
import java.util.Vector;

/**
 * Represents the Rector of an institution. This class extends Employee and is responsible for
 * handling requests, signing documents, and viewing complaints.
 * Implements Singleton pattern to ensure only one instance of Rector exists.
 */
public class Rector extends Employee implements Serializable {
    
    private static Rector INSTANCE = null;
    protected static Vector<Request> requests = new Vector<Request>();
    protected static Vector<Request> signedRequests = new Vector<Request>();
    protected static Vector<Complaint> complaints = new Vector<Complaint>();

    private Rector(){
    }
    static{

    }
    /**
     * Provides access to the single instance of Rector, creating it if necessary.
     *
     * @return The singleton instance of Rector.
     */
    public static Rector getINSTANCE() {
        if(INSTANCE == null) return new Rector();
        return INSTANCE;
    }
    static {
        String filename = "rector.dat";
        File file = new File(filename);
        if (file.exists()) {
            deserializeStaticData(filename);
        } else {
            requests = new Vector<>();
            complaints = new Vector<>();
            signedRequests = new Vector<>();
        }
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
                        viewAllNews();
                        break;
                    case 5:
                        changeLanguage(); // Change the menu language
                        break;
                    case 0:
                        serializeStaticData("rector.dat");
                        exit();
                        break menu;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            handleError(e);
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

    public void signRequest() {
        viewRequests();
        if (requests.isEmpty()) {
            return;
        }

        System.out.println("Enter the number of the request to sign:");
        int index = in.nextInt() - 1;
        in.nextLine();

        if (index >= 0 && index < requests.size()) {
            Request reqToSign = requests.remove(index);
            signedRequests.add(reqToSign);
            System.out.println("Request signed.");
        } else {
            System.out.println("Invalid request number.");
        }
    }

    /**
     * Serializes static data related to the Rector, such as requests and complaints, to a file.
     *
     * @param filename The name of the file where data will be serialized.
     */
    public static void serializeStaticData(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(requests);
            out.writeObject(complaints);
            out.writeObject(signedRequests);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Deserializes static data related to the Rector from a file, restoring requests and complaints.
     *
     * @param filename The name of the file from which data will be deserialized.
     */
    public static void deserializeStaticData(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            requests = (Vector<Request>) in.readObject();
            complaints = (Vector<Complaint>) in.readObject();
            signedRequests = (Vector<Request>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addComplaint(Complaint c){
        complaints.add(c);
    }



}
