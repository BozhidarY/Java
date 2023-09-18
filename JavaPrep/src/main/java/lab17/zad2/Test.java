package lab17.zad2;

public class Test {
    public static int solution(String[] words, int n) {
        int count = 0;

        for (String word : words) {
            for (int i = 0; i <= word.length() - n; i++) {
                String substring = word.substring(i, i + n);
                if (isInteresting(substring)) {
                    count++;
                    break; // Once an interesting substring is found, we can move to the next word.
                }
            }
        }

        return count;
    }

    private static boolean isInteresting(String substring) {
        if (substring.length() < 3) {
            return false; // Substring length must be at least 3 to have a character repeated at least three times.
        }

        char firstChar = substring.charAt(0);
        char lastChar = substring.charAt(substring.length() - 1);

        if (firstChar != lastChar) {
            return false; // The substring should not have the same character before and after it.
        }

        for (int i = 1; i < substring.length() - 1; i++) {
            if (substring.charAt(i) != firstChar) {
                return false; // The substring should consist of the same character repeated at least three times.
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"all", "cook", "llama"};
        int n = 2;
        int result = solution(words, n);
        System.out.println(result); // Output should be 3
    }
}

