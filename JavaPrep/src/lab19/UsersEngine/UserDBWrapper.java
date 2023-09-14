package lab19.UsersEngine;


import lab19.Users.Users;

import java.util.List;

public class UserDBWrapper {

    private List<Users> usersList;

    public UserDBWrapper(List<Users> usersList) {
        this.usersList = usersList;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }
}
