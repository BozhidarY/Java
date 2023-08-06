package lab1;

import java.util.Scanner;

public class BMIMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BMICalc bmi2 = new BMICalc();
        String msg = scanner.nextLine();
        while(msg.equals("Start")) {
            System.out.println("If you want to end the programm type end");
            bmi2.printIntroduction();
            bmi2.getBMI(new Scanner(System.in));
            bmi2.getStatus();
            bmi2.reportResults(bmi2.count, bmi2.body_index, bmi2.getStatus());
            System.out.println(bmi2.body_index);
            msg = scanner.nextLine();

// bmiCalculator.ReportResult(new Scanner(System.in).next(), bmiCalculator.bmi, bmiCalculator.getStatus());
        }
    }
}
