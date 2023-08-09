package lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final Pattern patternUsername = Pattern.compile("^[a-z0-9_\\-]{3,15}$");

    private static final Pattern patternPassword = Pattern.compile("^[a-zA-Z]{3,15}$");

    public boolean validateUsername(String value){
        Matcher matcher = patternUsername.matcher(value);
        return matcher.matches();
    }
    public boolean validatePassword(String value){
        Matcher matcher = patternPassword.matcher(value);
        return matcher.matches();
    }

}
