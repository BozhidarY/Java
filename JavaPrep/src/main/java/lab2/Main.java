package lab2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter key letter");
        char keyLetter = scanner.next().charAt(0);
        Car.setKeyLetter(keyLetter);
        Car car1 = new Car("BMW", "red", "rer", 2000);
        Car car2 = new Car("Mercedes", "red", "rer", 2000);
        Car car3 = new Car("Bugatti", "red", "rer", 2000);
        Car car4 = new Car("BMW", "white", "rer", 2000);


//        String[] carArray = {car1.getModel(), car2.getModel(), car3.getModel()};
        Car[] carArray = {car1, car2, car3, car4};

        Car[] filteredModels = Car.filterModels(carArray,Car.getKeyLetter());

        Car[] sortedModels = Car.sortCarsByModel(filteredModels);

        Car[] dublicateModels = Car.dublicateModels(sortedModels);
        for (Car model: dublicateModels){
            System.out.println(model.getModel());
        }
    }
}
