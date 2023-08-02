package lab1;

import java.util.Scanner;

public class BMICalculator {
    public static final double INCH_CONST = 0.3937;
    public static final double POUND_CONST = 2.2046;

    public double height;
    public double weight;
    public double bmi;


    public static void printIntroduction(){
        System.out.println("This is BMI Calculator");
    }

    public double getBMI(Scanner scanner){
        this.height = Double.parseDouble(scanner.nextLine()) / INCH_CONST;
        this.weight = Double.parseDouble(scanner.nextLine()) * POUND_CONST;

        return bimFor(height, weight);
    }

    public static double bimFor(double height, double weight){
        return weight*703/(height*height);
    }

    public String getStatus(){
        if(this.bmi <= 18.5){
            return "underweight";
        } else if (this.bmi <= 25) {
            return "normal";
        } else if (this.bmi <= 30) {
            return "overweight";
        }else {
            return "obese";
        }
    }

    public void ReportResult(String x, double bmi, String status){
        System.out.println(x + ": BMI "+Math.round(bmi) +"; Status: "+ status);
    }
}
