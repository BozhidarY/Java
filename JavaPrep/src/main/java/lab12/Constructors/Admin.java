package lab12.Constructors;

import lab12.Validators.WrongCredentialsException;
import lab12.UsersDB;
import lab12.Validators.Validator;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public UserType getUserType() {
        return UserType.ADMIN;
    }

    public static String registerAdmin(String username, String password){
        for(Admin admins : UsersDB.admins){
            if(username.equals(admins.getUsername()) || password.equals(admins.getPassword())){
                return "In use";
            }
        }
        try{
            UsersDB.admins.add(new Admin(username,password));
            return "Succesfull Register";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static User createUser(UserType userType, String username, String password) throws WrongCredentialsException {
        switch(userType){
            case TEACHER -> {
                Teacher teacher = new Teacher(username,password);
                if(Validator.validateTeacherUsername(username) && Validator.validateTeacherPassword(password)){
                    UsersDB.teachers.add(teacher);
                    UsersDB.saveToFile(UsersDB.filePath);
                    return teacher;
                }
                else{
                    throw new WrongCredentialsException();
                }

            }
            case STUDENT -> {
                Student student = new Student(username,password);
                if(Validator.validateStudentUsername(username) && Validator.validateStudentPassword(password)) {
                    UsersDB.students.add(student);
                    UsersDB.saveToFile(UsersDB.filePath);
                    return student;
                }
                else{
                    throw new WrongCredentialsException();
                }
            }
            default -> {
                return null;
            }
        }
    }
}
