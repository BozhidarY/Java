package Tests;

import java.util.Scanner;

public class stopwatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the duration in seconds: ");
        long durationInSeconds = scanner.nextLong();

        long startTime = System.currentTimeMillis();
        long endTime = startTime + (durationInSeconds * 1000); // Convert seconds to milliseconds

        while (System.currentTimeMillis() < endTime) {
            long remainingTime = (endTime - System.currentTimeMillis()) / 1000; // Convert milliseconds to seconds
            System.out.print("\rTime remaining: " + remainingTime + " seconds");
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nTime's up! " + durationInSeconds + " seconds have passed.");

        scanner.close();
    }
}
