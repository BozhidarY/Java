package lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final Pattern pattern = Pattern.compile("^[a-z0-9_\\-]{3,15}$");


}
