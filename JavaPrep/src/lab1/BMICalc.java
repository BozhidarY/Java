package lab1;

import java.util.Scanner;

public class BMI2 {

    public static final double INCH_CONST = 0.3937;
    public static final double POUND_CONST= 2.2046;

    public double height;
    public double weight;

    public double body_index;

    public int count = 1;

    public static void printIntroduction() {
        System.out.println("THis is BMI Calculator");
    }

    public double getBMI(Scanner scanner){
        System.out.println("Enter your height in inches");
        this.height = scanner.nextDouble();
        height = height / INCH_CONST;
        System.out.println("Enter your weight in pounds");
        this.weight = scanner.nextDouble();
        weight = weight * POUND_CONST;

        return bmiFor(height,weight);
    }
    public double bmiFor(double height, double weight){
        this.body_index = weight*703/ (height*height);
        return body_index;
    }
//    underweight, normal, overweight, obese. По статистики на център за здраве, тези 4 характеристики
//    се дават съответно ако: индексът е не повече от 18,5, ако индексът е не повече от 25, ако индексът
//    е не повече от 30 и ако е над 30.

    public String getStatus(){
        if(this.body_index <= 18.5){
            return "underweight";
        } else if (this.body_index <= 25) {
            return "normal";
        } else if (this.body_index <= 30) {
            return "overweight";
        }else {
            return "obese";
        }
    }

    public void reportResults(int count, double body_index,String status){
        System.out.println(count + ": BMI "+Math.round(body_index) +"; Status: "+ status);
        this.count ++;
    }

}
