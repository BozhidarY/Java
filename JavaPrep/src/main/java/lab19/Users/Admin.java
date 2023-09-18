package lab19.Users;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lab5.User;

public class Admin extends Users {

    private Admin(String username, String password){
        super(username,password);
        setUserType(UserType.ADMIN);
    }

    private final static Admin admin = new Admin("admin", "admin");

    public static Admin getAdmin() {
        return admin;
    }

}
