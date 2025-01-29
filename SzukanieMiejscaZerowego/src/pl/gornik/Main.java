package pl.gornik;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Algorytm obliczania miejsca zerowego funkcji przez połowienie");
        System.out.println("Wpisz początek i koniec przedziału (p, q)");
        double start = scanner.nextDouble();
        double stop = scanner.nextDouble();
        System.out.println("Podaj dokładność obliczeń (np. 0,001)");
        double accuracy = scanner.nextDouble();

        System.out.println("Podaj stopień wielomianu");
        int size = scanner.nextInt();
        System.out.printf("Podaj %d współczyników wielomianu\n", size+1);
        double[] coefficients = new double[size+1];
        for (int i = 0; i < size + 1; i++) {
            coefficients[i] = scanner.nextDouble();
        }

        Function function = new Function(coefficients);
        function.printFunction();

        double root = function.calculateRoot(start, stop, accuracy);
        if (function.calculateValueFunction(root) < Math.abs(function.calculateValueFunction(accuracy))) {
            System.out.printf("Miejscem zerowym funkcji jest %.3f\n", root);
        } else {
            System.out.println("W podanym przediale nie ma miejsca zerowego funcji");
        }
    }
}
