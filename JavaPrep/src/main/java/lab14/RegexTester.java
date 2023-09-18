package lab14;

import lab14.Consctructors.Regex;

import java.util.ArrayList;
import java.util.List;

public class RegexTester {
    public static List<Boolean> test(Regex regex, String[] strings){
        List<Boolean> results = new ArrayList<>();
        for(String string: strings){
            results.add(regex.getPattern().equals(string));
        }
        return results;
    }
}
