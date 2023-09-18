package lab20;

public class Authors extends Users{

    private String egn;


    public Authors(String username, String egn) {
        super(username);
        this.egn = egn;
        setUserType(UserType.AUTHORS);
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }
}
