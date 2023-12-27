package Util.Tester;

import Academic.Course;
import Research.Exceptions.CannotBecomeResearcherException;
import Users.Enums.Degree;
import Users.Enums.Faculty;
import Users.Enums.ManagerType;
import Users.Enums.Title;
import Users.Manager;
import Users.Student;
import Users.Teacher;
import Users.User;
import Util.Data.DB;
import Util.Enums.UserType;
import Util.Exception.UserNotFound;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TesterMainUtil {
    public static void main(String[] args) throws IOException, UserNotFound, CannotBecomeResearcherException {
        Student student1 = new Student("john_doe", "password123", Faculty.SEPI, Degree.BACHELOR);
        Student student2 = new Student("jane_smith", "pass456", Faculty.KMA, Degree.BACHELOR);
        Student student3 = new Student("alice_johnson", "securePwd", Faculty.BS, Degree.BACHELOR);
        Student student4 = new Student("peter_parker", "spider123", Faculty.SITE, Degree.BACHELOR);
        Student student5 = new Student("clark_kent", "superman123", Faculty.SEPI, Degree.BACHELOR);
        Student student6 = new Student("barry_allen", "flashPwd", Faculty.KMA, Degree.BACHELOR);
        Teacher t1 = new Teacher("teacher", "teacher", Title.SENIOR);
        Manager m = new Manager("manager", "manager", ManagerType.OR);


//        System.out.println(student6.getResearcherName());

        student4.run();
        DB.serialize();
//        System.out.println(DB.getInstance().getCourses().size());
    }
}
