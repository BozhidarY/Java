package Tests;

import java.util.*;

public class zad3 {
    public static List<String> solution(String[][] laps) {
        List<String> eliminated = new ArrayList<>();
        Map<String, Integer> entries = new HashMap<>();

        for (String[] lap : laps) {
            List<String> eliminatedThisRound = new ArrayList<>();
            int maxTime = -1;

            for (String entry : lap) {
                String[] parts = entry.split(" ");
                String name = parts[0];
                int time = Integer.parseInt(parts[1]);

                entries.put(name, time);
                maxTime = Math.max(maxTime, time);
            }

            for (String racerName : entries.keySet()) {
                if (entries.get(racerName) == maxTime) {
                    eliminatedThisRound.add(racerName);
                }
            }

            if (eliminatedThisRound.size() > 1) {
                Collections.sort(eliminatedThisRound);
            }
            for (String racer : eliminatedThisRound) {
                if (!eliminated.contains(racer)) {
                    eliminated.add(racer);
                }
            }
        }

        String[] checkLap = laps[0];
        for (String entry : checkLap) {
            String[] parts = entry.split(" ");
            String name = parts[0];
            if (!eliminated.contains(name)) {
                eliminated.add(name);
            }
        }

        return eliminated;
    }

    public static void main(String[] args) {
        String[][] laps1 = {
                {"Harold 154", "Gina 155", "Juan 160"},
                {"Juan 152", "Gina 153", "Harold 160"},
                {"Harold 148", "Gina 150", "Juan 151"}
        };

        List<String> result1 = solution(laps1);
        System.out.println(result1);

        String[][] laps2 = {
                {"Gina 155", "Eddie 160", "Joy 161", "Harold 163"},
                {"Harold 151", "Gina 153", "Joy 160", "Eddie 160"},
                {"Harold 149", "Joy 150", "Gina 152", "Eddie 154"},
                {"Harold 148", "Gina 150", "Eddie 151", "Joy 155"}
        };

        List<String> result2 = solution(laps2);
        System.out.println(result2);
    }
}
