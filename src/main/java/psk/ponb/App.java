package psk.ponb;

public class App {

    public static double computeUsingLibrary(final double x) {
        return Math.sin(x);
    }

    public static double computeUsingTaylorSeries(final double x) {
        double result = 0.0;
        double term = x;
        int n = 1;

        for (int i = 1; i <= 10; i++) {
            result += term;
            term *= -1 * x * x / ((2 * n) * (2 * n + 1));
            n++;
        }

        return result;
    }

    public static double computeUsingRectangles(final double x) {
        double result = 0.0;
        int intervals = 1000;
        double step = x / intervals;

        for (int i = 0; i < intervals; i++) {
            double midpoint = step * (i + 0.5);
            result += midpoint;
        }

        return result * step;
    }

    public static double majorityVote(final double first, final double second, final double third) {
        if (first == second || first == third) {
            return first;
        } else if (second == third) {
            return second;
        } else {
            System.out.println("Votes are incompatible!");
            return Double.NaN;
        }
    }

    public static void main(final String[] args) {
        double[] testValues = { 0.0, Math.PI / 6, Math.PI / 4, Math.PI / 2, Math.PI };

        for (double x : testValues) {
            double libResult = computeUsingLibrary(x);
            double taylorResult = computeUsingTaylorSeries(x);
            double rectangleResult = computeUsingRectangles(x);

            System.out.printf("\nEntry value: %.5f\n", x);
            System.out.printf("Library version: %.5f\n", libResult);
            System.out.printf("Taylor version: %.5f\n", taylorResult);
            System.out.printf("Rectangle version with error: %.5f\n", rectangleResult);

            double majorityResult = majorityVote(libResult, taylorResult, rectangleResult);

            if (!Double.isNaN(majorityResult)) {
                System.out.printf("Majority result: %.5f\n", majorityResult);
            }
        }
    }
}
