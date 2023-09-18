package lab16.zad4;

import java.util.Scanner;

public class Summing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        int maxPart = 0;
        int minPart = 0;
        int diffference = 0;

        for(int i = 0; i < 3; i++){
            line = scanner.nextLine();
            String[] parts = line.split(" ");
            for(String part: parts) {
                if (Integer.parseInt(part) > maxPart) {
                    maxPart = Integer.parseInt(part);
                    minPart = maxPart;
                }
            }
            for(String part: parts){
                if (minPart > Integer.parseInt(part)) {
                    minPart = Integer.parseInt(part);
                }
            }
            diffference += maxPart - minPart;
            maxPart = 0;
            minPart = 0;
        }
        System.out.println(diffference);
    }
}
