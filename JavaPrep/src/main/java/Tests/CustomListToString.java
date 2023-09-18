package Tests;

import java.util.List;

public class CustomListToString {
    public static void main(String[] args) {
        List<Integer> myList = List.of(1, 2, 3, 4, 5);

        // Use a custom function to convert the List to a string
        String customString = listToString(myList);

        System.out.println(customString); // Output: 12345
    }

    public static String listToString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object item : list) {
            sb.append(item.toString());
        }
        return sb.toString();
    }
}