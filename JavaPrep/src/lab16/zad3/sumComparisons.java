package lab16.zad3;

import java.util.ArrayList;
import java.util.List;

public class sumComparisons {
    public static void main(String[] args) {
        int[] numbers = {199, 200, 208, 210, 200, 207, 240, 269, 260, 263};
        List<Integer> groups = new ArrayList<>();
        int totalSum = 0;
        int maxSum = 0;
        int count = 0;

        for(int i = 0;i < numbers.length - 2;i++){
            for(int j = 0; j <= 2; j++){
                groups.add(numbers[i + j]);
            }
            for(Integer number:groups){
                totalSum += number;
            }
            if(totalSum > maxSum){
                maxSum = totalSum;
                count++;
            }
            else{
                maxSum = totalSum;
            }
            totalSum = 0;
            groups.clear();
        }
        System.out.println(count - 1);
    }


}
