package lab20;

import java.util.ArrayList;
import java.util.List;

public class DataB {
    private List<Users> listUsers;

    public DataB(){
        this.listUsers = new ArrayList<>();
    }

    public List<Users> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<Users> listUsers) {
        this.listUsers = listUsers;
    }
}
