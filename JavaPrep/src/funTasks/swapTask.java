package funTasks;

public class swapTask{

    public static void swapPositions(int arr[], int position1, int position2){
        int temp = arr[position1];
        arr[position1] = arr[position2];
        arr[position2] = temp;
    }
}
