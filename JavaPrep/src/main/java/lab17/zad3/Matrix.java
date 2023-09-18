package lab17.zad3;

import java.util.*;

public class Matrix {
    public static void main(String[] args) {
        String[][] laps = {
                {"Harold 154", "Juan 158", "Gina 155"},
                {"Juan 152", "Gina 153", "Harold 160"},
                {"Harold 148", "Gina 150", "Juan 151"}
        };
        String removedName = null;
        HashMap<String, Integer> lapMap = new HashMap<>();
        HashMap<String, Integer> lapMap2 = new LinkedHashMap<>();
        String[] part = null;
        int slowes = 0;

        int tempMax = 0;
        String tempKey = null;
        String key = null;
        int value = 0;
        int time = 0;

        for (int j = 0; j < laps.length; j++) {
            for (int i = 0; i < laps.length; i++) {
                part = laps[j][i].split(" ");
                String name = part[0];
                time = Integer.parseInt(part[1]);
                lapMap.put(name, Math.max(tempMax, time));
            }
            for (Map.Entry<String, Integer> entry : lapMap.entrySet()) {
//                if () {
//                    tempMax = entry.getValue();
//                    key = entry.getKey();
//                    value = entry.getValue();
//                }
                if (!lapMap2.containsKey(key)) {
                    lapMap2.put(key, value);
                }

                tempMax = 0;

            }
            for (String keyPrint : lapMap2.keySet()) {
                System.out.println(keyPrint);
            }
        }
    }
}
