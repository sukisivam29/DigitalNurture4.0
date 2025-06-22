package FinancialForecasting;

import java.util.*;

public class FinancialForecast {

    // Recursive function to calculate future value
    public static double futureValueRecursive(double initialAmount, double growthRate, int years) {
        // Base Case
        if (years == 0)
            return initialAmount;

        // Recursive Case
        return futureValueRecursive(initialAmount, growthRate, years - 1) * (1 + growthRate);
    }

    // Optimized using Memoization (Dynamic Programming)
    public static double futureValueMemo(double initialAmount, double growthRate, int years, double[] memo) {
        if (years == 0)
            return initialAmount;

        if (memo[years] != 0)
            return memo[years];

        memo[years] = futureValueMemo(initialAmount, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter the Inital Amount: ");
        double initialAmount = sc.nextDouble();
        double growthRate = 0.08;       
        int years = 5;
        double result = futureValueRecursive(initialAmount, growthRate, years);
        System.out.println("Future Value (Recursive): ₹" + result);

        // Optimized with memoization
        double[] memo = new double[years + 1];
        double optimizedResult = futureValueMemo(initialAmount, growthRate, years, memo);
        System.out.println("Future Value (Memoized): ₹" + optimizedResult);
    }
}
