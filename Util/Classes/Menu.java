package Util.Classes;

import Users.User;
import Util.Exception.UserNotFound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Menu {
    public void run() throws IOException, UserNotFound {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter username: ");
        String username = bf.readLine();
        System.out.println("Enter password: ");
        String password = bf.readLine();

        User user = User.authenticate(username, password);
        //менюшканы класстын озине жазамыз
        //мынак пока тура турсын
    }


}
