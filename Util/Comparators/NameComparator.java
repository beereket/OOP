package Util.Comparators;
import Users.User;

import java.util.Comparator;

public class NameComparator implements Comparator <User>{
	
	public int compare(User u1, User u2) {
        //TODO
		return u1.getUsername().compareTo(u2.getUsername());
    }
	
}
