package lab17.zad4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int countConsecativeHouses(List<Integer> arr){
        int count = 1;
        if(arr.isEmpty()){
            count = 0;
        }
        for (int i = 0; i < arr.size() - 1; i++) {
            if (!(arr.get(i) == arr.get(i + 1) - 1)) {
                count++;
            }
        }
        return count;
    }
    public static void addToList(int[] arr, List<Integer> intList){
        for(Integer arrIndex: arr){
            intList.add(arrIndex);
        }
    }
    public static void main(String[] args) {
        int[] houseArray = {2, 4, 5, 6, 7};
        int[] deleteHouseArray = {5, 6, 2};
        List<Integer> housesList = new ArrayList<>();
        List<Integer> deleteHousesList = new ArrayList<>();
        List<Integer> housesAfterDeletionList = new ArrayList<>();

        addToList(houseArray, housesList);
        addToList(deleteHouseArray, deleteHousesList);

        for(int i = 0; i < deleteHousesList.size(); i++){
            for(int j = 0; j < housesList.size(); j++){
                if(!deleteHousesList.get(i).equals(housesList.get(j))){
                    housesAfterDeletionList.add(housesList.get(j));
                }
            }
            housesList.remove(deleteHousesList.get(i));
            System.out.println(countConsecativeHouses(housesAfterDeletionList));
            housesAfterDeletionList.clear();
        }
    }
}
