package lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePassword implements Validateable{
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z]{11,}$");

    @Override
    public boolean validate(String value) {
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
