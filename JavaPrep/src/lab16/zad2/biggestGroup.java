package lab16.zad2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class biggestGroup {
    public static void main(String[] args) {
        List<String> groups = new ArrayList<>();
        int maxSum = 0;
        int tempMaxSum = 0;
        int result = 0;

        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();

        while(!numbers.equals("End")){
            groups.add(numbers);
            if(numbers.isEmpty()){
                groups.remove(groups.size() - 1);
                result = maxNumber(maxSum,tempMaxSum,groups);
                groups.clear();
            }
            numbers = scanner.nextLine();
        }
       System.out.println(result);
    }
    public static int maxNumber(int maxSum, int tempMaxSum, List<String> groups){
        for(String number: groups) {
            maxSum += Integer.parseInt(number);
        }
        if(maxSum > tempMaxSum){
            tempMaxSum = maxSum;
        }
        return tempMaxSum;
    }
}
