package lab17.zad2;

import java.util.Scanner;

public class interestingWord {
    public static void main(String[] args) {
        String[] words = {"aalll", "cook", "llama"};
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = 0;
        int count = 0;
        int count2 = 0;
        int result = 0;

//        int criteria = scanner.nextInt();

        for(int i = 0; i < words.length; i++){
//            String substring = words[i].substring(i, i + n);
//            for(int j =0; j<substring.length(); j++){
//                if(substring[0] == substring[j]){
//
//                }
//            }
            char[] wordParts = words[i].toCharArray();
            for(int j = 0; j < n && j < wordParts.length - 1; j++){
                if(wordParts[k] == wordParts[j + 1]){
                    count++;
                    if(count == n - 1){
                        count2++;
                    }
                    count++;
                }
            }
            if(count2 > 0){
                result++;
            }
            count = 0;
        }
        System.out.println(result);
    }
}
