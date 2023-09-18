package lab19.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lab5.User;

//@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Users {
    private String username;
    private String password;
    private UserType userType;

    public static final String USERS_JSON_PATH = System.getProperty("user.dir")+"\\src\\lab19\\Users\\users.json";
    public static final String DELETEDUSERS_JSON_PATH = System.getProperty("user.dir")+"\\src\\lab19\\Users\\deletedProfiles.json";

    public Users(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}