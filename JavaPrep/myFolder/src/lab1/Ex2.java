package lab1;

import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        // z1
        printName("Bojidar");
        // z2
        int[] arr = {1,2,3};
        modifyMethod(arr);
        System.out.println(Arrays.toString(arr));
        // z3
        int a = 2;
        modifyMethod(a);
        System.out.println();

    }

    private static void modifyMethod(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
        }
    }

    private static void modifyMethod(int a) {
        a++;
    }
    public static void printName(String s) {
        System.out.println(s);
    }
}
