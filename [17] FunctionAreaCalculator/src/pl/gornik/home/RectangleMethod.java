package pl.gornik.home;

public class RectangleMethod {
    public static void main(String[] args) {
        System.out.println("Obliczanie pola pod wykresem funkcji\nMetoda prostokątów");
        System.out.println("Podaj początek, koniec przedziału");
        double start = PolynomialUtils.scanner.nextDouble();
        double stop = PolynomialUtils.scanner.nextDouble();
        System.out.println("Podaj liczbę przedziałów\nZwiększenie liczby poprawia dokładność, lecz wydłuża czas");
        int parts = PolynomialUtils.scanner.nextInt();
        double[] coefficients = PolynomialUtils.getCoefficients();
        double area = calculateArea(coefficients, start, stop, parts);
        PolynomialUtils.printFunction(coefficients);
        System.out.printf("Pole pod wykresem funkcji wynosi: %.3f\n", area);
    }

    public static double calculateArea(double[] coefficients, double start, double stop, int parts) {
        double interval = (stop - start) / parts;
        double area = 0;
        for (int i = 0; i < parts; i++) {
            double x = start + interval * i + interval / 2;
            area += PolynomialUtils.calculateValueFunction(coefficients, x);
        }
        return area * interval;
    }
}