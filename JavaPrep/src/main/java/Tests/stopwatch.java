package Tests;

import java.util.Scanner;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class stopwatch {
    private static final AtomicBoolean skipSong = new AtomicBoolean(false);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Start playing a song in a separate thread
        Thread songThread = new Thread(() -> playSong(scanner));
        songThread.start();

        // Listen for "skip" input in the main thread
        while (!skipSong.get()) {
            String userInput = scanner.nextLine().trim();
            if (userInput.equalsIgnoreCase("skip")) {
                skipSong.set(true);
            }
        }

        scanner.close();
    }

    public static void playSong(Scanner scanner) {
        System.out.println("Song is playing...");
        System.out.println("Type 'skip' and press Enter to skip the song.");

        long startTime = System.currentTimeMillis();
        long durationInMillis = 10000; // Example: 10 seconds

        while (!skipSong.get() && (System.currentTimeMillis() - startTime) < durationInMillis) {
            // Update the progress (you can print remaining time or a progress bar here)
            long remainingTime = (durationInMillis - (System.currentTimeMillis() - startTime)) / 1000;
            System.out.print("\rRemaining time: " + remainingTime + " seconds");

            // Sleep for a short interval to avoid busy-waiting
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (skipSong.get()) {
            System.out.println("\nSong has been skipped.");
        } else {
            System.out.println("\nSong has ended.");
        }
    }
}

