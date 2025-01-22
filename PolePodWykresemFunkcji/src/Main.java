import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Obliczanie pola pod wykresem funkcji\nMetoda prostokątów");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj początek, koniec przedziału");
        double start = scanner.nextDouble();
        double stop = scanner.nextDouble();
        System.out.println("Podaj liczbę przedziałów\nZwiekszenie liczby poprawia dokladność, lecz wydłuża czas");
        int parts = scanner.nextInt();
//        double[] coefficicients = {1, 1, -2};
        double area = calculateArea(start, stop, parts);
        System.out.printf("Pole pod wykresem funkcji wynosi: %.3f", area);
    }

    public static double calculateArea(double start, double stop, int parts) {
        double interval = (stop - start) / parts;
        double area = 0;
        double x;
        for (int i = 0; i < parts; i++) {
            x = start + interval * i + interval / 2;
//          f(x) = x^2 + x - 2
            area += Math.abs(Math.pow(x, 2) + x -2);
        }
        return area * interval;
    }
}
