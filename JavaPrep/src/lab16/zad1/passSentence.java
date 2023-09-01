package lab16.zad1;

import java.util.*;

public class passSentence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        int count = 0;
        for(int i = 0; i < 2; i ++){
            line = scanner.nextLine().toLowerCase();
            String[] parts = line.split(" ");
            if(!hasDuplicates(parts)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean hasDuplicates(String[] arr) {
        Set<String> set = new HashSet<>();
        for (String num : arr) {
            if (!set.add(num)) {
                return true; // Duplicate found
            }
        }
        return false; // No duplicates found
    }}
