package Users;

import Messages.Order;
import Util.Classes.Data;
import Util.Enums.UserType;

import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;


public class TechSupportSpecialist extends Employee implements Serializable {
    protected static Vector<Order> orders = new Vector<Order>();
    protected static Vector<Order> accepted_orders = new Vector<Order>();


    public void acceptOrder(Order o){
        orders.remove(o);
        accepted_orders.add(o);
    }

    //CONSTRUCTOR
    public TechSupportSpecialist(String username, String password) {
        super(username, password, UserType.TSS);
        Data.getInstance().getTSSs().add(this);
    }

    //MENU
    @Override
    public void run() throws IOException {
        try{
            getWelcomeMessage();
            displayMenu();

            int choice = in.nextInt();
            switch (choice){
                case 1:

                case 2:

                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }

        } catch (Exception e) {
            handleError(e);
        }

    }
    @Override
    protected void displayRussianMenu() {
        System.out.println("Меню:");
        System.out.println("1. Просмотр и принятие новых обращений");
        System.out.println("2. Просмотр и обработка открытых обращений");
        System.out.println("3. Просмотр закрытых обращений");
        System.out.println("4. Просмотр новостей");
        System.out.println("5. Изменить язык");
        System.out.println("6. Выход");
    }
    @Override
    protected void displayKazakhMenu() {
        System.out.println("Мәзір:");
        System.out.println("1. Жаңа сұрауларды көру және қабылдау");
        System.out.println("2. Ашық сұрауларды көру және өңдеу");
        System.out.println("3. Жабық сұрауларды көру");
        System.out.println("4. Жаңалықтарды көру");
        System.out.println("5. Тілді өзгерту");
        System.out.println("6. Шығу");
    }

    @Override
    protected void displayEnglishMenu() {
        System.out.println("Menu:");
        System.out.println("1. View and Accept New Support Orders");
        System.out.println("2. View and Process Open Support Orders");
        System.out.println("3. View Closed Support Orders");
        System.out.println("4. View News");
        System.out.println("5. Change Language");
        System.out.println("6. Exit");
    }

}
