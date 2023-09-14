package lab19.Users;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private List<Users> usersList;

    public UserDB(){
        this.usersList = new ArrayList<>();
    }

    public void addAdmins(){
        usersList.add(Admin.getAdmin());
    }

    public void merge(UserDB loadedUserDB) {
        // Assuming you have a method to add users to your list
        this.usersList.addAll(loadedUserDB.getUsersList());
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    @Override
    public String toString() {
        return "UserDB{" +
                "usersList=" + usersList +
                '}';
    }
}
