package lab17.zad1;

import java.util.Scanner;

public class Pivot {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 0, -1, 1, 4, 3};
        Scanner scanner = new Scanner(System.in);
        int greaterCount = 0;
        int smallerCount = 0;
        int tieCount = 0;

        int pivot = scanner.nextInt();

        for(Integer number: numbers){
            if(number > pivot ){
                greaterCount++;
            }
            else if(number < pivot){
                smallerCount++;
            }
        }
        if(greaterCount > smallerCount){
            System.out.println("Greater");
        } else if (greaterCount == smallerCount) {
            System.out.println("Tie");
        }else{
            System.out.println("Smaller");
        }
    }

}
