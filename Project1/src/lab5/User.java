package lab5;

//import lab_exercises.lab_5.exceptions.WrongPasswordException;
//import lab_exercises.lab_5.exceptions.WrongPhoneNumberException;
//import lab_exercises.lab_5.exceptions.WrongUserException;
//import lab_exercises.lab_5.validate.ValidatePassword;
//import lab_exercises.lab_5.validate.ValidatePhone;
//import lab_exercises.lab_5.validate.ValidateUsername;

public class User {
    private String name;
    private String password;
    private String phone;

    public User(String name, String password, String phone) throws WrongPhoneNumberException, WrongPasswordException, WrongUserException {
        this.setName(name);
        this.setPassword(password);
        this.setPhone(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws WrongUserException {
        ValidateUsername validateUsername = new ValidateUsername();
        if (validateUsername.validate(name)) {
            this.name = name;
        } else {
            throw new WrongUserException();
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws WrongPasswordException {
        ValidatePassword validatePassword = new ValidatePassword();
        if (validatePassword.validate(password)) {
            this.password = password;
        } else {
            throw new WrongPasswordException();
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws WrongPhoneNumberException {
        ValidatePhone validatePhone = new ValidatePhone();
        if (validatePhone.validate(phone)) {
            this.phone = phone;
        } else {
            throw new WrongPhoneNumberException();
        }
    }
}