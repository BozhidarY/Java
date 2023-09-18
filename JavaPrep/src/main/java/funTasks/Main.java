package funTasks;

//    Write a function that takes an array and 2 positions and swaps the elements
//    Write a function that raises a number n to a power m
//    Write a function that takes an array of numbers and returns the most common element
//    Write a function that provides a recommended gear for the speed of a car, at given speed and revolution
//    Write a function that returns an array of the elements along the main/minor diagonal of the matrix
//    Write a function that sorts the array, finds the maximum and minimum element and the sum of them
//    Write a function that filters an array of data /turns it into set/ | /deletes 'forbidden' data given in another array
//    Hangman
//    TicTacToe
//    Turing machine for a lamp switch
//    Task 7. from 'Functions' to be applied to an array of objects
//    Generate with random function array with numbers in range [0, n] with n elements, all must be unique

import java.util.Arrays;
import java.util.Scanner;

import static funTasks.swapTask.swapPositions;
import static funTasks.raisePower.raisePower;
import static funTasks.mostFrequentNumberArr.mostFrequentNumberArr;
import static funTasks.extractDiagonals.extractMainDiagonal;
import static funTasks.extractDiagonals.extractMinorDiagonal;

public class Main {
    public static void main(String[] args){
//  Swap Task ---------------------------------------------------
        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter the number of elements in the array");
//        int n = scanner.nextInt();
//
//        int[] arr = new int[n];
//
//        System.out.println("Enter the elements:");
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//
//        System.out.println("Enter the first position");
//        int position1 = scanner.nextInt();
//        System.out.println("Enter the swap position");
//        int position2 = scanner.nextInt();
//
//        System.out.println("Original Array" + Arrays.toString(arr));
//        swapPositions(arr,position1,position2);
//        System.out.println("New Array" + Arrays.toString(arr));

//  RaiseToPower---------------------------------------------------------------
//        int n = 2;
//        int m = 5;
//        long result = raisePower(n, m);
//        System.out.println(n + " raised to the power " + m + " is: " + result);

//  Most Frequent Element ---------------------------------------------------
//        int[] arr = { 1, 2, 4, 4, 4, 7, 5, 5, 9 };
//        int result = mostFrequentNumberArr(arr);
//        System.out.println("My arr is" + Arrays.toString(arr));
//        System.out.println("The most common number is " +result);

//   Diagonals-------------------------------------------------------
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] mainDiagonal = extractMainDiagonal(matrix);
        int[] minorDiagonal = extractMinorDiagonal(matrix);

        System.out.println("Main Diagonal: " + Arrays.toString(mainDiagonal));
        System.out.println("Minor Diagonal: " + Arrays.toString(minorDiagonal));
    }


}
