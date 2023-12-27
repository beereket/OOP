package Util.Data;


import Util.Enums.UserType;

public class DBtest {
    public static void main(String[] args) {
        DB.getInstance();
        System.out.println(DB.getInstance().getUserByUsername("manager"));
    }
}
