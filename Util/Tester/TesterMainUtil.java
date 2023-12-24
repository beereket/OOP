package Util.Tester;

import Util.Classes.Data;

import java.io.IOException;

public class TesterMainUtil {
    public static void main(String[] args) throws IOException  {
        Data data = Data.read();
        System.out.println(data.getStudents());

    }
}
