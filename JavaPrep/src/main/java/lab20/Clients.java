package lab20;

import lab5.User;

public class Clients extends Users {

    private String password;
    public Clients(String username, String password) {
        super(username);
        this.password = password;
        setUserType(UserType.CLIENTS);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
