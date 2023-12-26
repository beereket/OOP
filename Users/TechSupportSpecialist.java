package Users;

import Messages.Order;
import Util.Data.DB;
import Util.Enums.UserType;

import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;


public class TechSupportSpecialist extends Employee implements Serializable {
    //CONSTRUCTOR
    public TechSupportSpecialist(String username, String password) {
        super(username, password, UserType.TSS);
        DB.getInstance().addUser(this, UserType.TSS);
    }

    //MENU
    @Override
    public void run() throws IOException {
        try{
            while(true) {
                getWelcomeMessage();
                displayMenu();

                int choice = in.nextInt();
                switch (choice) {
                    case 1:
                        viewAndAcceptNewSupportOrders();
                        break;
                    case 2:
                        for (Order o : DB.getAcceptedOrders()) {
                            System.out.println(o.getOrderId() + " : " + o.getDescription());
                        }
                        break;
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
        System.out.println("Меню:");
        System.out.println("1. Просмотр и принятие новых обращений");
        System.out.println("2. Просмотр  принятых обращений");
        System.out.println("4. Просмотр новостей");
        System.out.println("5. Изменить язык");
        System.out.println("6. Выход");
    }
    @Override
    protected void displayKazakhMenu() {
        System.out.println("Мәзір:");
        System.out.println("1. Жаңа сұрауларды көру және қабылдау");
        System.out.println("2. Кабылданган сұрауларды көру");
        System.out.println("4. Жаңалықтарды көру");
        System.out.println("5. Тілді өзгерту");
        System.out.println("6. Шығу");
    }

    @Override
    protected void displayEnglishMenu() {
        System.out.println("Menu:");
        System.out.println("1. View and Accept New Support Orders");
        System.out.println("2. View Accepted Orders");
        System.out.println("4. View News");
        System.out.println("5. Change Language");
        System.out.println("6. Exit");
    }

    public void viewAndAcceptNewSupportOrders() {
        Vector<Order> orders = DB.getInstance().getOrders();
        System.out.println("New Support Orders:");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + ". " + orders.get(i).getDescription());
        }
        System.out.println("Enter the number of the order to accept or 0 to go back:");
        int choice = in.nextInt();
        in.nextLine();
        if (choice > 0 && choice <= orders.size()) {
            Order selectedOrder = orders.remove(choice - 1);
            DB.getInstance().getAcceptedOrders().add(selectedOrder);
            System.out.println("Order accepted.");
        }
    }

}
