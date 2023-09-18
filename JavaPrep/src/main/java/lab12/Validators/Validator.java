package lab12.Validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static final Pattern studentUsername = Pattern.compile("^[a-z0-9_\\-]{3,15}$");
    public static final Pattern studentPassword = Pattern.compile("^[a-z0-9_\\-]{3,15}$");
    public static final Pattern teacherUsername = Pattern.compile("^[a-z0-9_\\-]{3,15}$");
    public static final Pattern teacherPassword = Pattern.compile("^[a-z0-9_\\-]{3,15}$");

    public static boolean validateStudentUsername(String username){
        Matcher mathcher = studentUsername.matcher(username);
        return mathcher.matches();
    }

    public static boolean validateStudentPassword(String password){
        Matcher mathcher = studentPassword.matcher(password);
        return mathcher.matches();
    }
    public static boolean validateTeacherUsername(String username){
        Matcher mathcher = teacherUsername.matcher(username);
        return mathcher.matches();
    }
    public static boolean validateTeacherPassword(String username){
        Matcher mathcher = teacherPassword.matcher(username);
        return mathcher.matches();
    }
}
