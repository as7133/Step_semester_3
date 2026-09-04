package string.class_problems;

import java.util.Random;
public class BMICalculator {

    static String getBMIStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("\n========== WELLNESS REPORT ==========");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBMIStatus(bmi);
            System.out.println("\nPerson " + (i + 1));
            System.out.println("Height: " + heights[i] + " m");
            System.out.println("Weight: " + weights[i] + " kg");
            System.out.println("BMI: " + bmi);
            System.out.println("Status: " + status);
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        int n = 10;
        double[] heights = new double[n];
        double[] weights = new double[n];

        for (int i = 0; i < n; i++)
        {
            heights[i] = 1.50 + random.nextDouble() * 0.50;
            weights[i] = 40 + random.nextDouble() * 60;
        }

        printWellnessReport(heights, weights);
    }
}
