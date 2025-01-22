import java.util.Scanner;

public class Main1 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Obliczanie pola pod wykresem funkcji\nMetoda prostokątów");
        System.out.println("Podaj początek, koniec przedziału");
        double start = scanner.nextDouble();
        double stop = scanner.nextDouble();
        System.out.println("Podaj liczbę przedziałów\nZwiekszenie liczby poprawia dokladność, lecz wydłuża czas");
        int parts = scanner.nextInt();
        double[] coefficicients = getCoefficicients();
        double area = calculateArea(coefficicients, start, stop, parts);
        printFunction(coefficicients);
        System.out.printf("Pole pod wykresem funkcji wynosi: %.3f", area);
    }

    public static double[] getCoefficicients() {
        System.out.println("Podaj stopień wielomianu");
        int size = scanner.nextInt();
        double[] coefficicients = new double[size + 1];
        System.out.printf("Podaj kolejno %d współczynników\n", size+1);
        for (int i = 0; i <= size; i++) {
            coefficicients[i] = scanner.nextDouble();
        }
        return coefficicients;
    }

    public static double calculateValueFunction(double[] coefficients, double x) {
        double value = 0;
        for (int i = 0; i < coefficients.length; i++) {
            value += coefficients[i] * Math.pow(x, coefficients.length - 1 - i);
        }
        return Math.abs(value);
    }

    public static double calculateArea(double[] coefficients, double start, double stop, int parts) {
        double interval = (stop - start) / parts;
        double area = 0;
        double x;
        for (int i = 0; i < parts; i++) {
            x = start + interval * i + interval / 2;
            area += calculateValueFunction(coefficients, x);
        }
        return area * interval;
    }

    public static void printFunction(double[] coefficients) {
        String function = "f(x) = ";
        for (int i = 0; i < coefficients.length; i++) {
            if (i == 0 && coefficients[i] != 0) {
                function += (coefficients[i] + "x^" + (coefficients.length - 1 - i));
            }
            else if (i == coefficients.length - 1) {
                if (coefficients[i] > 0){
                    function += (" + " + coefficients[i]);
                } else if (coefficients[i] < 0) {
                    function += (" - " + Math.abs(coefficients[i]));
                }
            }
            else if (coefficients[i] > 0){
                function += (" + " + coefficients[i] + "x^" + (coefficients.length - 1 - i));
            }
            else if (coefficients[i] < 0){
                function += (" - " + Math.abs(coefficients[i]) + "x^" + (coefficients.length - 1 - i));
            }
        }
        System.out.println(function);
    }
}
