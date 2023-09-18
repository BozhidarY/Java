package lab5;

public class User {
    private String name;
    private String password;

    public User(String name, String password) throws nameException, passwordException{
        this.setName(name);
        this.password = password;
    }
    Validation validation = new Validation();

    public String getName(){
        return name;
    }
    public void setName(String name) throws nameException {
        if(validation.validateUsername(name)){
            this.name = name;
        }else{
            throw new nameException();
        }
    }
    public String getPassword(){
        return password;
    }
    public void checkPassword() throws passwordException{
        if(!validation.validatePassword(getPassword())){
            throw new passwordException();
        }
    }

    public void setPassword(String password){
            this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
