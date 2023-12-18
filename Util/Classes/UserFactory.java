package Util.Classes;

import Users.*;
import Util.Enums.UserType;

public class UserFactory {
	
	public static User createUser(UserType u, String userName, String password) {
		if(u == UserType.ADMIN){
			return new Admin(userName, password);
		} else if (u == UserType.MANAGER) {
			return new Manager(userName, password);
		}
        return null;
    };
}
