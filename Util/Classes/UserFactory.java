package Util.Classes;

import Users.*;
import Util.Enums.UserType;

import java.io.Serializable;

public class UserFactory implements Serializable {
	
	public static User createUser(UserType u, String userName, String password) {
		if(u == UserType.ADMIN){
			return new Admin(userName, password);
		}
        return null;
    };
}
