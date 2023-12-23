package Users;

import Messages.Order;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;


public class TechSupportSpecialist extends Employee implements Serializable {
    protected static List<Order> orders;
    protected static List<Order> accepted_orders;


    public void acceptOrder(Order o){
        orders.remove(o);
        accepted_orders.add(o);
    }

    //MENU
    @Override
    public void run() throws IOException {
        try{
            getWelcomeMessage();
            displayMenu();

            int choice = in.nextInt();


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

    @Override
    public void update() {

    }
}
