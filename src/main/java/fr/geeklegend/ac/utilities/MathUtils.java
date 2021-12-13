package fr.geeklegend.ac.utilities;

import java.util.Collection;

public class MathUtils {

    public final double EXPANDER = Math.pow(2, 24);

    public static int floor(final double var0) {
        final int var2 = (int) var0;
        return var0 < var2 ? var2 - 1 : var2;
    }

    public double getStandardDeviation(final Collection<? extends Number> data) {
        final double variance = getVariance(data);

        // The standard deviation is the square root of variance. (sqrt(s^2))
        return Math.sqrt(variance);
    }

    public double getVariance(final Collection<? extends Number> data) {
        int count = 0;
        double sum = 0.0;
        double variance = 0.0;
        final double average;

        // Increase the sum and the count to find the average and the standard deviation
        for (final Number number : data) {
            sum += number.doubleValue();
            ++count;
        }

        average = sum / count;

        // Run the standard deviation formula
        for (final Number number : data) {
            variance += Math.pow(number.doubleValue() - average, 2.0);
        }

        return variance;
    }

    public double gcd(final double limit, final double a, final double b) {
        return b <= limit ? a : gcd(limit, b, a % b);
    }


}