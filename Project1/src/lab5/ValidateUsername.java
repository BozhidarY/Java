package lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUsername implements Validateable {
    private static final Pattern pattern = Pattern.compile("^[a-z0-9_\\-]{3,15}$");

    @Override
    public boolean validate(String value) {
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}