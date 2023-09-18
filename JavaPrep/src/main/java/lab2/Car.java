package lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Car{
    private String model;
    private String color;
    private String engine;
    private int yearOfManufacture;
    private static char keyLetter;

    public Car(String model, String color, String engine, int yearOfManufacture){
        this.model = model;
        this.color= color;
        this.engine = engine;
        this.yearOfManufacture = yearOfManufacture;
    }

//    public static String[] filterModels(String[] modelArray, char keyLetter){
//        ArrayList<String> filteredNames = new ArrayList<>();
//
//        for (String name : modelArray) {
//            if (name.toLowerCase().charAt(0) == Character.toLowerCase(keyLetter)) {
//                filteredNames.add(name);
//            }
//        }
//        return filteredNames.toArray(new String[0]);
//    }

    public static Car[] filterModels(Car[] cars, char keyLetter){
        int count = 0;

        for (Car car : cars) {
            if (car.getModel().charAt(0) == keyLetter) {
                count++;
            }
        }

        Car[] filteredCars = new Car[count];
        int index = 0;

        for (Car car : cars) {
            if (car.getModel().charAt(0) == keyLetter) {
                filteredCars[index] = car;
                index++;
            }
        }

        return filteredCars;
    }

    public static Car[] dublicateModels(Car[] cars){
        HashSet<Car> uniqueCars = new HashSet<>();
        for (Car car : cars) {
            uniqueCars.add(car);
        }

        return uniqueCars.toArray(new Car[uniqueCars.size()]);
    }

    public static Car[] sortCarsByModel(Car[] cars) {
        Arrays.sort(cars, Comparator.comparing(Car::getModel).reversed());
        return cars;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }



    public static char getKeyLetter() {
        return keyLetter;
    }

    public static void setKeyLetter(char keyLetter) {
        Car.keyLetter = keyLetter;
    }
}