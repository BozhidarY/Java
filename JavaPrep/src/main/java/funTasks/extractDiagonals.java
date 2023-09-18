package funTasks;

public class extractDiagonals {
    public static int[] extractMainDiagonal(int[][] matrix) {
        int n = matrix.length;
        int[] mainDiagonal = new int[n];
        for (int i = 0; i < n; i++) {
            mainDiagonal[i] = matrix[i][i];
        }
        return mainDiagonal;
    }

    public static int[] extractMinorDiagonal(int[][] matrix) {
        int n = matrix.length;
        int[] minorDiagonal = new int[n];
        for (int i = 0; i < n; i++) {
            minorDiagonal[i] = matrix[i][n - 1 - i];
        }
        return minorDiagonal;
    }
}
