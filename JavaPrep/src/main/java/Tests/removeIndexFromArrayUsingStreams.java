package Tests;

// Java program to remove an element
// from a specific index from an array

import java.util.Arrays;
import java.util.stream.IntStream;

class removeIndexFromArrayUsingStreams {

    // Function to remove the element
    public static int[] removeTheElement(int[] arr, int index)
    {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        // return the resultant array
        return IntStream.range(0, arr.length).filter(i -> i != index).map(i -> arr[i]).toArray();
    }
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5 };

        System.out.println("Original Array: " + Arrays.toString(arr));
        int index = 2;
        System.out.println("Index to be removed: " + index);

        arr = removeTheElement(arr, index);

        System.out.println("Resultant Array: " + Arrays.toString(arr));
    }
}

