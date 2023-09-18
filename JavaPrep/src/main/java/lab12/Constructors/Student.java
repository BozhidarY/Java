package lab12.Constructors;

public class Student extends User {


    public Student(String username, String password) {
        super(username, password);
    }


    @Override
    public UserType getUserType() {
        return UserType.STUDENT;
    }


}
