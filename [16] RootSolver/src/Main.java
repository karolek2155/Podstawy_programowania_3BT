import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rozwiązywanie równania kwadratowego");
        System.out.println("Wpisz odpowiednio współczynniki a, b, c równania kwadratowego:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        calculateRoots(a, b, c);
    }

    public static void calculateRoots(double a, double b, double c) {
        if (a != 0) {
            double delta = Math.pow(b, 2) - 4 * a * c;

            if (delta == 0) {
                double x = -b / (2 * a);
                System.out.printf("Rozwiązaniem tego równania jest: x = %.3f\n", x);
            } else if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.printf("Rozwiązaniami tego równania są: x1 = %.3f, x2 = %.3f\n", x1, x2);
            } else {
                System.out.println("To równanie nie ma rzeczywistych rozwiązań.");
            }
        } else {
            System.out.println("Jest to równanie liniowe.");
            if (b != 0) {
                double x = -c / b;
                System.out.printf("Ma jedno rozwiązanie: x = %.3f\n", x);
            } else if (c == 0) {
                System.out.println("Ma nieskończenie wiele rozwiązań.");
            } else {
                System.out.println("Jest sprzeczne i nie ma rozwiązań.");
            }
        }
    }
}
