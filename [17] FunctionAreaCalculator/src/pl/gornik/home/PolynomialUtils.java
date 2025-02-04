package pl.gornik.home;

import java.util.Scanner;

class PolynomialUtils {
    static Scanner scanner = new Scanner(System.in);

    public static double[] getCoefficients() {
        System.out.println("Podaj stopień wielomianu");
        int size = scanner.nextInt();
        double[] coefficients = new double[size + 1];
        System.out.printf("Podaj kolejno %d współczynników\n", size + 1);
        for (int i = 0; i <= size; i++) {
            coefficients[i] = scanner.nextDouble();
        }
        return coefficients;
    }

    public static double calculateValueFunction(double[] coefficients, double x) {
        double value = 0;
        for (int i = 0; i < coefficients.length; i++) {
            value += coefficients[i] * Math.pow(x, coefficients.length - 1 - i);
        }
        return Math.abs(value);
    }

    public static void printFunction(double[] coefficients) {
        StringBuilder function = new StringBuilder("f(x) = ");
        for (int i = 0; i < coefficients.length; i++) {
            if (coefficients[i] != 0) {
                if (i > 0 && coefficients[i] > 0) {
                    function.append(" + ");
                } else if (coefficients[i] < 0) {
                    function.append(" - ");
                }
                function.append(Math.abs(coefficients[i]));
                if (i < coefficients.length - 1) {
                    function.append("x^").append(coefficients.length - 1 - i);
                }
            }
        }
        System.out.println(function);
    }
}