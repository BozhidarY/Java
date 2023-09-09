package Patterns;

public class Patterns {
    public static void SquareHollowPattern(int n){
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                for (int j = 0; j < n; j++) {
                    System.out.print("* ");
                }
            } else {
                System.out.print("*");
                for (int j = 0; j < n + 2; j++)
                    System.out.print(" ");
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void NumberTriangular(int n){
        for(int i=0; i < n;i++){
            for(int j = 0; j < n - i;j++){
                System.out.print(" ");
            }
            for(int j = 0; j < i + 1; j++){
                System.out.print(i + 1 + " ");
            }
            System.out.println();
        }
    }
    public static void NumberIncreasingPyramid(int n){
        int k = 1;

        for(int i = 0; i < n; i++){
            for (int j = 0; j<=i; j++){
                System.out.print(k + " ");
                k++;
            }
            k = 1;
            System.out.println();
        }
    }
    public static void ZeroOneTriangle(int n){
        boolean flag = true;

        for(int i = 0; i < n; i++){
            for (int j = 0; j<=i; j++){
                if(flag){
                    System.out.print("0 ");
                    flag = false;
                }
                else{
                    System.out.print("1 ");
                    flag =true;
                }

            }
            System.out.println();
        }
    }

    public static void PallindromeTriangular(int n){
        int k;
        int t;
        for(int i = 0; i < n;i++){
            for (int j =0; j < n - i; j++){
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                k = i + 1 - j;
                System.out.print(k);
            }
            for (int j =0; j < i; j++){
                t = j + 2;
                System.out.print(t);
            }
            System.out.println();
        }
    }

    public static void RombusPattern(int n){
        for(int i=0; i < n ;i++){
            for(int j = 0; j < i ;j++){
                System.out.print(" ");
            }
            for(int j = 0; j < n; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void DiamondPattern(int n){
        for(int i=0; i < n ;i++){
            for(int j = 0; j < n - i;j++){
                System.out.print(" ");
            }
            for(int j = 0; j < i + 1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < i + 2;j++){
                System.out.print(" ");
            }
            for(int j = 0; j < n - i - 1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void ButterflyStarPattern(int n){
        int i, j;
        int num = 1;

        // outer loop to handle upper part
        for (i = 1; i <= n; i++) {
            // inner loop to print stars
            for (j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // outer loop to handle lower part
        for (i = n-1; i >= 1; i--) {
            // inner loop to print stars
            for (j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
