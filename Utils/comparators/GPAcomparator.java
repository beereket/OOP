package Utils.comparators;
import Users.Student;

import java.util.Comparator;

public class GPAcomparator implements Comparator <Student>{
	
	public int compare(Student s1, Student s2) {
        //TODO
        return Double.compare(s1.getGPA(), s2.getGPA());
    }

}
