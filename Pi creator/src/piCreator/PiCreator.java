package piCreator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class PiCreator {
    public static BigDecimal getMath_PI() {
        return Math_PI;
    }

    private static BigDecimal Math_PI = new BigDecimal(3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706);

    public static boolean validateInput(double precision , int decimalPlaces) {
        return precision > 0 && decimalPlaces <= 100 && decimalPlaces >= 0;
    }

    public static boolean isErrorValueGraterThanPrecision(BigDecimal currentPi , double precision) {
        final BigDecimal absDifference = currentPi.subtract(Math_PI).abs();
        return absDifference.compareTo(BigDecimal.valueOf(precision)) > 0;
    }

    /**
     * This method generates a sequence using Leibniz formula (4 * (+/- 1)^(n-1) / (2 * n - 1))
     */
    private static BigDecimal generateSequenceLeibnizFormula(int n) {
        final BigDecimal numerator = BigDecimal.valueOf(4).multiply(BigDecimal.valueOf((n % 2 == 0 ? -1 : 1)));
        final BigDecimal denominator = BigDecimal.valueOf(2 * n - 1);
        return numerator.divide(denominator, 100, RoundingMode.CEILING);
    }


    public static BigDecimal createPiNumber(double precision , int decimalPlaces) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal currentPiApproximation = new BigDecimal(0);
        int n = 1;

        if(validateInput(precision, decimalPlaces)) {
            while (isErrorValueGraterThanPrecision(currentPiApproximation, precision)) {
                currentPiApproximation = currentPiApproximation.add(generateSequenceLeibnizFormula(n));
                //System.out.println(currentPiApproximation.round(new MathContext(decimalPlaces)));
                n++;
            }
        }

        scanner.close();
        return currentPiApproximation.round(new MathContext(decimalPlaces));
    }
}