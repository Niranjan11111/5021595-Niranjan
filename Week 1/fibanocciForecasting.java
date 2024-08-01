import java.util.HashMap;
import java.util.Map;


class FinancialForecasting {
    // Recursive method to calculate future value
    public static double predictFutureValue(double initialValue, double growthRate, int periods) {
        if (periods == 0) {
            return initialValue;
        }
        return (1 + growthRate) * predictFutureValue(initialValue, growthRate, periods - 1);
    }

    // Main method to test the prediction
    public static void main(String[] args) {
        double initialValue = 1000.0;
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // Forecast for 10 periods

        double futureValue = predictFutureValue(initialValue, growthRate, periods);
        System.out.println("Predicted future value: " + futureValue);
    }
}

class FinancialForecastingWithMemoization {
    private static Map<Integer, Double> memo = new HashMap<>();

    // Recursive method with memoization to calculate future value
    public static double predictFutureValue(double initialValue, double growthRate, int periods) {
        if (periods == 0) {
            return initialValue;
        }
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }
        double futureValue = (1 + growthRate) * predictFutureValue(initialValue, growthRate, periods - 1);
        memo.put(periods, futureValue);
        return futureValue;
    }

    // Main method to test the prediction
    public static void main(String[] args) {
        double initialValue = 1000.0;
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // Forecast for 10 periods

        double futureValue = predictFutureValue(initialValue, growthRate, periods);
        System.out.println("Predicted future value with memoization: " + futureValue);
    }
}
