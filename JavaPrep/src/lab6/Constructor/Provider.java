package lab6.Constructor;

import lab6.Exceptions.WrongPhoneNumberException;
import lab6.Interfaces.ValidatePhone;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Provider implements ValidatePhone {
    private static String name;
    private static String phoneNumber;

    public static final Pattern pattern = Pattern.compile("^[0-9]{5}$");

    public Provider(String name, String phoneNumber) throws WrongPhoneNumberException {
        this.name = name;
        this.setPhoneNumber(phoneNumber);
    }

    @Override
    public boolean validatePhoneNumber(String phoneNumber) {
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static  String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws WrongPhoneNumberException {
        if(validatePhoneNumber(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }
        else{
            throw new WrongPhoneNumberException();
        }
    }
}
