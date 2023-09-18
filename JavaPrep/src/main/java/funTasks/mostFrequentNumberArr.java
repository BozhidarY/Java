package funTasks;

public class mostFrequentNumberArr {
    public static int mostFrequentNumberArr(int[] arr){
        int n = arr.length;
        int max_count = 0;
        int mFrequent = 0;

        for(int i=0; i < n; i++){
            int count = 0;
            for(int j=0; j < n; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count > max_count){
                max_count = count;
                mFrequent = arr[i];
            }
        }
        return mFrequent;
    }

}
