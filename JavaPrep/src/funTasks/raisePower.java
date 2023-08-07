package funTasks;

public class raisePower {
    public static long raisePower(int n, int m){
        long result = 1;
        for (int i = 0; i < m; i++) {
            result *= n;
        }
        return result;

    }
}
