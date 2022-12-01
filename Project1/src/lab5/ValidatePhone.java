package lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone implements Validateable{
    private static final Pattern pattern = Pattern.compile("^0[7-9]{2}[0-9]{3}[0-9]{4}$");

    @Override
    public boolean validate(String value) {
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}