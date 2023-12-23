package Util.Classes;

import Users.*;
import Util.Enums.UserType;

public class UserFactory {
	
	public static User createUser(UserType u, String userName, String password) {
		if(u == UserType.ADMIN){
			return new Admin(userName, password);
		}
        return null;
    };
}
